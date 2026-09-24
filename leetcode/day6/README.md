# Day 6: Minimum Operations to Reduce X to Zero

**Problem ID:** LeetCode #1658  
**Difficulty:** Medium  
**Category:** Array, Sliding Window, Two Pointers  

## Problem Statement

Given an integer array `nums` and an integer `x`, remove elements from left or right to make x equal to zero. Return the minimum number of operations needed, or -1 if impossible.

## Solution Approach

**Key Insight:** Transform the problem - find the longest subarray with sum = (total_sum - x). Answer = n - longest_length.

**Algorithm:** Sliding window with two pointers
- Calculate total sum
- If total < x, return -1 (impossible)
- If total == x, return n (remove all)
- Use two pointers to find longest subarray with sum = (total - x)
- Return n - longest_length

**Complexity:**
- Time: O(n) - single pass with two pointers
- Space: O(1) - constant extra space

## Examples

1. nums = [1,1,4,2,3], x = 5 → Output: 2
   - Remove 3 (x = 2), remove 2 (x = 0)

2. nums = [5,6,7,8,9], x = 4 → Output: -1
   - Total sum = 35, impossible

3. nums = [3,2,20,1,1,3], x = 10 → Output: 5
   - Remove 3, 2 from left (5 removed) + remove 3, 1, 1 from right (5 removed)

## Test Coverage

✓ All 12 tests passing
- Example cases (3)
- Edge cases (6)
- Complex scenarios (3)

