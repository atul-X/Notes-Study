package algorithms;

import java.util.*;

public class SolutionAB {

    public int solution(String S, int[] X, int[] Y) {
        int n = S.length();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long d2 = 1L * X[i] * X[i] + 1L * Y[i] * Y[i];
            points.add(new Point(d2, S.charAt(i)));
        }

        points.sort(Comparator.comparingLong(p -> p.dist2));

        Set<Character> used = new HashSet<>();
        int count = 0;
        int i = 0;

        while (i < n) {
            long d = points.get(i).dist2;
            Set<Character> group = new HashSet<>();
            int j = i;

            // Collect same-distance group
            while (j < n && points.get(j).dist2 == d) {
                char tag = points.get(j).tag;

                // Duplicate tag inside same distance
                if (group.contains(tag)) return count;

                group.add(tag);
                j++;
            }

            // Conflict with already used tags
            for (char tag : group) {
                if (used.contains(tag)) return count;
            }

            // Safe to include this distance group
            used.addAll(group);
            count += group.size();

            i = j;
        }

        return count;
    }
    public int solution1(String S, int[] X, int[] Y) {
        int n=S.length();
        List<Point> points=new ArrayList<>();
        for (int i=0;i<n;i++){
            long dist2=1L*X[i]*X[i]+1L*Y[i]*Y[i];
            points.add(new Point(dist2,S.charAt(i)));
        }
        Collections.sort(points,Comparator.comparingLong(p->p.dist2));
        Set<Character> used=new HashSet<>();
        int i=0;
        int count=0;
        while (i<n){
            int j=i;
            Set<Character> group=new HashSet<>();
            while (j<n&&points.get(j).dist2==points.get(i).dist2){
                if (group.contains(points.get(j).tag)){
                    return count++;
                }
                group.add(points.get(j).tag);
                j++;
            }
            for (Character tg:group){
                if (used.contains(tg)){
                    return count;
                }
            }
            used.addAll(group);
            count+=group.size();
            i=j;
        }
        return count;
    }
    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {
        SolutionAB sol = new SolutionAB();

        // ✅ Test Case 1
        String S1 = "ABDCA";
        int[] X1 = {2, -1, -4, -3, 3};
        int[] Y1 = {2, -2, 4, 1, -3};
        System.out.println("Test 1 Expected: 3 | Got: " + sol.solution(S1, X1, Y1));

        // ✅ Test Case 2
        String S2 = "ABB";
        int[] X2 = {1, -2, -2};
        int[] Y2 = {1, -2, 2};
        System.out.println("Test 2 Expected: 1 | Got: " + sol.solution(S2, X2, Y2));

        // ✅ Additional Test Case 3
        String S3 = "ABCDEF";
        int[] X3 = {1, 2, 3, 4, 5, 6};
        int[] Y3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Test 3 Expected: 6 | Got: " + sol.solution(S3, X3, Y3));

        // ✅ Additional Test Case 4 (same tag different distances)
        String S4 = "AABC";
        int[] X4 = {1, 10, 2, 3};
        int[] Y4 = {1, 10, 2, 3};
        System.out.println("Test 4 Expected: 3 | Got: " + sol.solution(S4, X4, Y4));
    }

    // ---------------- Helper Class ----------------
    static class Point {
        long dist2;
        char tag;
        Point(long d, char t) { dist2 = d; tag = t; }
    }
}

