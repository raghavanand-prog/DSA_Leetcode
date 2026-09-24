# 60-Day LeetCode DSA Challenge

A comprehensive 60-day Data Structures and Algorithms (DSA) challenge using Java, designed for **Cloud Security Engineer interview preparation**. This repository contains complete solutions with detailed problem explanations, comprehensive test suites, and complexity analysis.

## 📊 Progress

| Phase | Days | Status | Focus Area |
|-------|------|--------|-----------|
| Foundations | 1-15 | 🔄 In Progress | Arrays, Strings, Basic DSA |
| Core Structures | 16-30 | ⏳ Upcoming | Trees, Graphs, Sorting |
| Advanced Patterns | 31-45 | ⏳ Upcoming | DP, Greedy, Backtracking |
| Final Push | 46-60 | ⏳ Upcoming | Mixed, Interview-style |

**Completed:** 7/60 days ✓

## 📁 Repository Structure

```
leetcode/
├── day1/     # Problem solutions
│   ├── Solution.java      # Optimized implementation
│   ├── Test.java         # Comprehensive test cases (12+)
│   └── README.md         # Problem explanation & analysis
├── day2/
├── day3/
...
└── day60/
```

Each day contains:
- **Solution.java** - Full problem solution with inline comments
- **Test.java** - 12+ test cases covering all scenarios (basic, edge cases, complex)
- **README.md** - Problem statement, algorithm explanation, examples, complexity analysis

## ✅ Completed Solutions

### Day 1-5 (Previous Structure)
Earlier solutions created with detailed documentation.

### Day 6: Minimum Operations to Reduce X to Zero
- **LeetCode:** #1658 (Medium)
- **Concept:** Sliding window with problem transformation
- **Algorithm:** Find longest subarray with sum = (total_sum - x), answer = n - longest_length
- **Complexity:** O(n) time, O(1) space
- **Tests:** 12/12 passing ✓

### Day 7: Smallest Index with Digit Sum Equal to Index
- **LeetCode:** Daily Question (Easy)
- **Concept:** Array iteration with digit manipulation
- **Algorithm:** Simple iteration, calculate digit sum for each element, return smallest matching index
- **Complexity:** O(n*d) ≈ O(n) time (d = avg digits), O(1) space
- **Tests:** 12/12 passing ✓

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Git

### Run All Tests for a Day
```bash
cd leetcode/dayX/
javac *.java
java Test
```

Example:
```bash
cd leetcode/day7/
javac *.java
java Test
```

### Expected Output
```
=== Day 7: Smallest Index with Digit Sum Equal to Index ===

✓ Test 1 PASSED
  Description: Basic: nums[2]=2, digit_sum(2)=2, equals index 2
  Expected: 2, Got: 2

✓ Test 2 PASSED
  Description: No match: nums[0]=1 (sum=1, not 0), nums[1]=2 (sum=2, equals 1? no)
  Expected: -1, Got: -1

... (12 total tests)

=== Test Summary ===
Passed: 12/12
Failed: 0/12
Success Rate: 100%
```

## 📚 Problem Categories & Patterns

### Array & String (Days 1-10)
- ✓ Two pointers / Sliding window
- ✓ Digit manipulation & modular arithmetic
- ⏳ String manipulation
- ⏳ Prefix/suffix arrays
- ⏳ Sorting and searching

### Trees & Graphs (Days 11-25)
- ⏳ DFS / BFS
- ⏳ Tree traversals
- ⏳ Graph problems
- ⏳ Heap operations

### Dynamic Programming (Days 26-40)
- ⏳ 1D DP
- ⏳ 2D DP
- ⏳ State machines

### Advanced Topics (Days 41-60)
- ⏳ Greedy algorithms
- ⏳ Backtracking
- ⏳ Interview-style mixed problems

## 🎯 Key Features

✓ **Comprehensive Test Suites** - Each day has 12+ test cases covering:
  - Basic/example cases from problem statement
  - Edge cases (empty, single element, boundary values)
  - Complex scenarios (large arrays, special patterns)

✓ **Detailed Documentation** - Each README includes:
  - Full problem statement
  - Algorithm explanation with step-by-step walkthroughs
  - Complexity analysis (Time & Space)
  - Interview tips & common mistakes
  - Problem variations & related problems

✓ **Learning-Focused** - Solutions emphasize:
  - Why the algorithm works (not just how)
  - Trade-offs between approaches
  - Optimization techniques
  - Pattern recognition for interview prep

## 📖 Interview Preparation Benefits

This challenge covers fundamental DSA concepts essential for:
- **Cloud Security Engineer** interviews
- Technical screening questions
- System design foundations
- Optimization problem-solving
- Real-world algorithm applications

## 🔗 Resources

- [LeetCode Problems](https://leetcode.com)
- Java Documentation: [docs.oracle.com](https://docs.oracle.com/javase/docs/)
- Algorithm Visualization: [visualgo.net](https://visualgo.net)

## 📝 Notes

- All solutions are optimized for clarity AND efficiency
- Test cases are designed to catch common mistakes
- Each README explains WHY the solution works, not just implementation
- Solutions use only Java standard library (no external dependencies)

## 🎓 Study Approach

1. **Understand** - Read problem statement and examples thoroughly
2. **Think** - Identify the pattern and optimal approach
3. **Implement** - Write solution from scratch
4. **Test** - Verify with provided test suite
5. **Review** - Study complexity analysis and edge cases
6. **Learn** - Read interview tips and problem variations

## 🤝 Contributing

This is a personal learning repository for the 60-day DSA challenge. Solutions are being added progressively.

## 📊 Challenge Timeline

- **Start Date:** September 2026
- **Target Completion:** November 2026
- **Goal:** Master fundamental DSA for Cloud Security Engineer interviews

---

**Last Updated:** September 24, 2026  
**Days Completed:** 7/60  
**Status:** 🔄 In Progress — Keep building! 💪
