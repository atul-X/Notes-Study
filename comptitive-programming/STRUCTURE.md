# Competitive Programming Repository Structure

This repository contains competitive programming solutions organized by difficulty, algorithm type, and contest platform.

## 📁 Directory Structure

```
src/
├── algorithms/              # Algorithm implementations
│   ├── array/              # Array manipulation problems (26 files)
│   ├── bitmanipulation/    # Bit manipulation algorithms
│   ├── dp/                 # Dynamic programming
│   ├── greedy/             # Greedy algorithms (7 files)
│   ├── graph/              # Graph algorithms
│   ├── linkedlist/         # Linked list problems (8 files)
│   ├── math/               # Mathematical algorithms
│   ├── queue/              # Queue-based problems
│   ├── search/             # Search algorithms
│   ├── sorting/            # Sorting algorithms
│   ├── stack/              # Stack-based problems (2 files)
│   ├── string/             # String manipulation (5 files)
│   └── tree/               # Tree algorithms
├── datastructures/         # Data structure implementations (5 files)
│   ├── CircularQueue.java
│   ├── LinkedList.java
│   ├── Queue.java
│   ├── QueueArrayImplementation.java
│   └── QueueTest.java
├── practice/               # Practice problems by difficulty
│   ├── beginner/           # Easy problems
│   ├── intermediate/       # Medium problems
│   └── advanced/           # Hard problems
└── contest/                # Contest-specific solutions
    ├── leetcode/           # LeetCode solutions
    ├── hackerrank/         # HackerRank solutions
    ├── codeforces/         # Codeforces solutions
    └── geeksforgeeks/      # GeeksforGeeks solutions
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- An IDE like IntelliJ IDEA, Eclipse, or VS Code

### Running a Solution
1. Navigate to the desired algorithm or problem directory
2. Compile the Java file:
   ```bash
   javac FileName.java
   ```
3. Run the compiled class:
   ```bash
   java FileName
   ```

## 📚 Categories

### Algorithms
- **Array**: Problems involving array manipulation, traversal, and operations
- **Sorting**: Various sorting algorithms and related problems
- **Searching**: Binary search, linear search, and other search techniques
- **String**: String manipulation, pattern matching, and processing
- **Graph**: Graph traversal, shortest path, and other graph algorithms
- **Dynamic Programming**: DP problems with memoization and tabulation
- **Greedy**: Greedy algorithm implementations
- **Math**: Mathematical problems and number theory
- **Bit Manipulation**: Bitwise operations and tricks

### Data Structures
- **Linked List**: Singly, doubly, and circular linked lists
- **Queue**: Array and linked list based queue implementations
- **Stack**: Stack implementations and applications
- **Tree**: Binary trees, BST, and other tree structures

### Practice Levels
- **Beginner**: Basic problems for learning fundamentals
- **Intermediate**: Medium difficulty problems
- **Advanced**: Complex problems requiring advanced techniques

### Contest Platforms
- **LeetCode**: Solutions organized by problem number
- **HackerRank**: Practice and contest solutions
- **Codeforces**: Competitive programming contest solutions
- **GeeksforGeeks**: Interview preparation problems

## 📝 File Naming Convention

- Use descriptive names that indicate the problem or algorithm
- Use PascalCase for class names (e.g., `BinarySearch.java`)
- Include the platform name for contest problems (e.g., `LeetCode_TwoSum.java`)

## 🛠️ Contributing

1. Create a new file in the appropriate directory
2. Follow the existing code style and package naming
3. Add comments explaining the approach
4. Test your solution before committing

## 📖 Learning Path

1. Start with `practice/beginner` problems
2. Move to specific algorithm categories
3. Practice with contest problems
4. Explore advanced techniques

## 🏆 Problem Solving Strategy

1. Understand the problem requirements
2. Think about the appropriate algorithm/data structure
3. Implement the solution
4. Test with edge cases
5. Optimize if necessary
