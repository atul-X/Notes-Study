# PostgreSQL Deep Dive — Schema Design & Normalization

## Tags
`#postgresql` `#schema-design` `#normalization` `#database` `#interview-prep`

---

## 1. Core Schema Design Principles

### Principle 1 — One Table, One Thing
Each table represents exactly one entity or one relationship. If you see columns like `phone_home`, `phone_work`, `phone_mobile` — that's a signal to extract a child table.

```sql
-- ❌ Bad
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name TEXT,
  phone_home TEXT,
  phone_work TEXT
);

-- ✅ Good
CREATE TABLE user_phones (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id) ON DELETE CASCADE,
  type TEXT CHECK (type IN ('home', 'work', 'mobile')),
  number TEXT NOT NULL
);
```

### Principle 2 — Enforce Integrity at the DB Level
Never rely on application logic alone. Use constraints as the real safety net.

```sql
CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  status TEXT NOT NULL DEFAULT 'pending'
    CHECK (status IN ('pending', 'paid', 'shipped', 'cancelled')),
  total_amount NUMERIC(10,2) NOT NULL CHECK (total_amount >= 0),
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
```

**Key constraints to always consider:**
- `NOT NULL` — if it must exist, enforce it
- `CHECK` — validate values at DB level
- `UNIQUE` — for business keys (email, slug)
- `FOREIGN KEY` — always link related tables

### Principle 3 — Surrogate vs Natural Keys

| | Surrogate (`BIGSERIAL`) | Natural (`email`) |
|---|---|---|
| Stable? | ✅ Yes | ❌ Can change |
| Meaningful? | ❌ No | ✅ Yes |
| Join performance | ✅ Fast (int) | ⚠️ Slower (string) |

> **Rule:** Use `BIGSERIAL` or `UUID` as PK. Use natural keys as `UNIQUE` constraints, not PKs.

```sql
CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  email TEXT NOT NULL UNIQUE,
  created_at TIMESTAMPTZ DEFAULT NOW()
);
```

---

## 2. Normalization

### 1NF — Atomicity
Every column holds a single, indivisible value. No comma-separated lists in a cell.

```sql
-- ❌ Violates 1NF
items TEXT  -- "pen,book,laptop"

-- ✅ 1NF compliant — separate table
CREATE TABLE order_items (
  id SERIAL PRIMARY KEY,
  order_id INT REFERENCES orders(id),
  product_name TEXT NOT NULL
);
```

### 2NF — No Partial Dependencies
Applies to composite PKs. Every non-key column must depend on the **entire** key, not just part of it.

```sql
-- ❌ Violates 2NF — product_name depends only on product_id
CREATE TABLE order_items (
  order_id INT,
  product_id INT,
  product_name TEXT,   -- partial dependency!
  quantity INT,
  PRIMARY KEY (order_id, product_id)
);

-- ✅ 2NF compliant
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

CREATE TABLE order_items (
  order_id INT REFERENCES orders(id),
  product_id INT REFERENCES products(id),
  quantity INT NOT NULL,
  PRIMARY KEY (order_id, product_id)
);
```

### 3NF — No Transitive Dependencies
No non-key column should depend on another non-key column.

```sql
-- ❌ Violates 3NF — city depends on zip_code, not on user id
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name TEXT,
  zip_code TEXT,
  city TEXT   -- transitive dependency!
);

-- ✅ 3NF compliant
CREATE TABLE zip_codes (
  zip_code TEXT PRIMARY KEY,
  city TEXT NOT NULL
);
```

---

## 3. Relationship Patterns

### One-to-Many (most common)
```sql
CREATE TABLE posts (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  title TEXT NOT NULL
);
```

### Many-to-Many (junction table)
```sql
CREATE TABLE enrollments (
  student_id BIGINT REFERENCES students(id) ON DELETE CASCADE,
  course_id  BIGINT REFERENCES courses(id)  ON DELETE CASCADE,
  enrolled_at TIMESTAMPTZ DEFAULT NOW(),
  PRIMARY KEY (student_id, course_id)  -- prevents duplicates
);
```

### One-to-One (extension tables)
```sql
CREATE TABLE user_profiles (
  user_id BIGINT PRIMARY KEY REFERENCES users(id) ON DELETE CASCADE,
  bio TEXT,
  avatar_url TEXT
);
```

---

## 4. When to Denormalize

| Scenario | Technique |
|---|---|
| Expensive COUNT queries | Store `comment_count` on posts table |
| Deep joins slow reads | Duplicate `user_name` in posts |
| Reporting/analytics | Materialized views |

> Always add a comment explaining **why** you denormalized.

---

## 5. Offer System — Freebies & Coupons

### Entity Hierarchy
```
offers (parent)
  ├── coupons          (1:1, offer_type = 'coupon')
  ├── freebies         (1:1, offer_type = 'freebie')
  ├── offer_redemption_policies  (1:1, rules)
  ├── offer_user_targets         (1:many, targeting)
  ├── offer_category_targets     (1:many, targeting)
  ├── offer_reservations         (1:many, checkout holds)
  └── offer_redemptions          (1:many, audit log)
```

### offers (parent table)
```sql
CREATE TABLE offers (
  id            BIGSERIAL PRIMARY KEY,
  name          TEXT        NOT NULL,
  offer_type    TEXT        NOT NULL CHECK (offer_type IN ('coupon', 'freebie')),
  starts_at     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  expires_at    TIMESTAMPTZ,
  max_uses      INT,
  used_count    INT         NOT NULL DEFAULT 0,
  reserved_count INT        NOT NULL DEFAULT 0,
  is_active     BOOLEAN     NOT NULL DEFAULT TRUE,
  created_at    TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  CONSTRAINT valid_date_range CHECK (expires_at IS NULL OR expires_at > starts_at)
);
```

### coupons (child)
```sql
CREATE TABLE coupons (
  offer_id        BIGINT PRIMARY KEY REFERENCES offers(id) ON DELETE CASCADE,
  code            TEXT   NOT NULL UNIQUE,
  discount_type   TEXT   NOT NULL CHECK (discount_type IN ('percentage', 'fixed_amount', 'free_shipping')),
  discount_value  NUMERIC(10,2),
  min_order_value NUMERIC(10,2),
  max_discount_cap NUMERIC(10,2),
  CONSTRAINT value_required CHECK (discount_type = 'free_shipping' OR discount_value IS NOT NULL),
  CONSTRAINT valid_percentage CHECK (discount_type != 'percentage' OR discount_value <= 100)
);
```

### freebies (child)
```sql
CREATE TABLE freebies (
  offer_id              BIGINT PRIMARY KEY REFERENCES offers(id) ON DELETE CASCADE,
  free_product_id       BIGINT NOT NULL REFERENCES products(id),
  free_quantity         INT    NOT NULL DEFAULT 1,
  requires_product_id   BIGINT REFERENCES products(id),
  requires_min_quantity INT,
  requires_min_order_value NUMERIC(10,2),
  CONSTRAINT freebie_not_self CHECK (free_product_id != requires_product_id)
);
```

### Redemption Policies
```sql
CREATE TABLE offer_redemption_policies (
  id                  BIGSERIAL PRIMARY KEY,
  offer_id            BIGINT    NOT NULL REFERENCES offers(id) ON DELETE CASCADE,
  max_uses_per_user   INT       NOT NULL DEFAULT 1,
  max_total_uses      INT,
  cooldown_hours      INT,
  new_users_only      BOOLEAN   NOT NULL DEFAULT FALSE,
  verified_users_only BOOLEAN   NOT NULL DEFAULT FALSE,
  min_order_value     NUMERIC(10,2),
  CONSTRAINT one_policy_per_offer UNIQUE (offer_id)
);
```

### Reservation System (Anti-Abandonment)

**State Machine:**
```
AVAILABLE → RESERVED → CONFIRMED
               ↓
           EXPIRED (cart abandoned, cron releases slot)
           CANCELLED (order refunded/failed)
```

```sql
CREATE TYPE reservation_status AS ENUM ('reserved','confirmed','expired','cancelled');

CREATE TABLE offer_reservations (
  id                BIGSERIAL          PRIMARY KEY,
  offer_id          BIGINT             NOT NULL REFERENCES offers(id),
  user_id           BIGINT             NOT NULL REFERENCES users(id),
  order_id          BIGINT             REFERENCES orders(id),   -- NULL until placed
  status            reservation_status NOT NULL DEFAULT 'reserved',
  reserved_at       TIMESTAMPTZ        NOT NULL DEFAULT NOW(),
  expires_at        TIMESTAMPTZ        NOT NULL DEFAULT NOW() + INTERVAL '15 minutes',
  confirmed_at      TIMESTAMPTZ,
  discount_snapshot NUMERIC(10,2)
);
```

**Effective availability check:**
```sql
-- available slots = max_uses - used_count - reserved_count
```

**Auto-expire via pg_cron:**
```sql
SELECT cron.schedule('expire-offer-reservations', '* * * * *', $$
  UPDATE offer_reservations
  SET status = 'expired'
  WHERE status = 'reserved' AND expires_at < NOW();
$$);
```

### Redemptions (Audit Log)
```sql
CREATE TABLE offer_redemptions (
  id               BIGSERIAL   PRIMARY KEY,
  offer_id         BIGINT      NOT NULL REFERENCES offers(id),
  user_id          BIGINT      NOT NULL REFERENCES users(id),
  order_id         BIGINT      NOT NULL REFERENCES orders(id),
  redeemed_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
  discount_applied NUMERIC(10,2),
  free_product_id  BIGINT      REFERENCES products(id),
  UNIQUE (offer_id, order_id)  -- one offer per order
);
```

> **Why snapshot discount_applied?** If the offer is edited later, the historical record still shows what was actually applied.

---

## 6. Race Condition & Locking

### The Problem
Two users hit "apply coupon" simultaneously on the last slot. Both read `used_count = 99`, both think a slot is free, both insert → 101 redemptions on a max_uses=100 offer.

### The Fix — SELECT FOR UPDATE
```sql
BEGIN;
  SELECT id, used_count, reserved_count, max_uses
  FROM offers
  WHERE id = $offer_id
  FOR UPDATE;  -- 🔒 locks row, no other transaction can touch it

  INSERT INTO offer_reservations (offer_id, user_id, discount_snapshot, expires_at)
  VALUES ($offer_id, $user_id, $discount, NOW() + INTERVAL '15 minutes');
COMMIT;
```

### Full Checkout Flow
```
User applies coupon
      │
      ▼
BEGIN TRANSACTION
SELECT offer FOR UPDATE ← 🔒
      │
 available?
  NO → "Offer unavailable"
  YES → INSERT offer_reservations (status=reserved)
      │
      ▼
COMMIT (lock released)
      │
User places order + payment
      │
  FAIL → status = 'cancelled', slot released
  SUCCESS → status = 'confirmed', used_count + 1
      │
Cart abandoned → cron sets status = 'expired', slot released
```

---

## 7. JSONB — When to Use vs Avoid

| Use JSONB when | Use proper table when |
|---|---|
| Schema varies per row | Schema is same for all rows |
| Data read as a blob | You need to filter/sort on fields |
| External API payload storage | You own and control the structure |
| Sparse optional fields | Fields are required and validated |

**Decision rule:**
```
Does your query need to filter/sort on this data?
        YES → proper columns / table
        NO  → Does schema vary per row?
               YES → JSONB
               NO  → proper columns
```

**Good JSONB uses:**
```sql
-- Varies per restaurant (cuisine tags, awards)
ALTER TABLE restaurant_brands ADD COLUMN metadata JSONB;

-- Holiday overrides (sparse, date-keyed)
ALTER TABLE outlets ADD COLUMN holiday_overrides JSONB;
-- { "2024-12-25": { "open": "11:00", "close": "20:00" } }
```

---

## 8. Food Delivery App Schema (In Progress)

### Hierarchy
```
restaurant_brands → outlets → menus → items
                      └── outlet_timings (per day schedule)
```

### restaurant_brands
```sql
CREATE TABLE restaurant_brands (
  id       BIGSERIAL PRIMARY KEY,
  name     TEXT      NOT NULL,
  owner    TEXT      NOT NULL,   -- corporate owner
  logo_url TEXT,
  metadata JSONB                 -- cuisine_tags, awards etc
);
```

### outlets
```sql
CREATE TABLE outlets (
  id             BIGSERIAL PRIMARY KEY,
  brand_id       BIGINT    NOT NULL REFERENCES restaurant_brands(id),
  outlet_owner   TEXT,                    -- franchisee
  contact_number TEXT,
  address        TEXT,
  latitude       NUMERIC(9,6),            -- ⬅ PENDING: vs PostGIS GEOGRAPHY
  longitude      NUMERIC(9,6),
  is_active      BOOLEAN   NOT NULL DEFAULT TRUE,
  holiday_overrides JSONB
);
```

### outlet_timings
```sql
CREATE TABLE outlet_timings (
  id          BIGSERIAL PRIMARY KEY,
  outlet_id   BIGINT    NOT NULL REFERENCES outlets(id) ON DELETE CASCADE,
  day_of_week SMALLINT  NOT NULL CHECK (day_of_week BETWEEN 0 AND 6), -- 0=Sun
  open_time   TIME      NOT NULL,
  close_time  TIME      NOT NULL,
  is_closed   BOOLEAN   NOT NULL DEFAULT FALSE,
  CONSTRAINT valid_timing CHECK (close_time > open_time),
  UNIQUE (outlet_id, day_of_week)
);
```

**Query — find outlets open right now within 3km:**
```sql
SELECT o.*
FROM outlets o
JOIN outlet_timings t ON t.outlet_id = o.id
WHERE t.day_of_week = EXTRACT(DOW FROM NOW())
  AND t.open_time   <= NOW()::TIME
  AND t.close_time  >= NOW()::TIME
  AND t.is_closed   = FALSE;
  -- + geo filter pending lat/lng decision
```

---

## 9. Open Questions / TODO

- [ ] **outlets.location** — Two NUMERIC columns vs PostGIS `GEOGRAPHY(POINT, 4326)`?
- [ ] Design `menus` and `items` tables
- [ ] Design `users` and `addresses` tables
- [ ] Design `orders` and `order_items` tables
- [ ] Design `delivery` and `tracking` tables
- [ ] Design `payments` table
- [ ] WAL & storage internals deep dive (deferred)

---

## 10. Key Principles Summary

| Principle | Rule |
|---|---|
| 1NF | Atomic values only — no comma lists, no arrays in columns |
| 2NF | All columns depend on the full PK (matters for composite PKs) |
| 3NF | No column depends on another non-key column |
| Integrity | Enforce at DB level with CHECK, FK, UNIQUE — not just app code |
| Keys | Surrogate PK + natural key as UNIQUE constraint |
| JSONB | Only when schema varies per row or data is always read as blob |
| Locking | SELECT FOR UPDATE inside transaction for reservation/inventory |
| Timestamps | Always use TIMESTAMPTZ, never TIMESTAMP |
| Denormalize | Only intentionally, always with a comment explaining why |
