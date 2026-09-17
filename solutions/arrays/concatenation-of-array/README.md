# Concatenation of Array

**LeetCode Problem:** [1929. Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/)

**Difficulty:** Easy

**Topic:** Array, Simulation

---

## Problem

Given an integer array `nums` of length `n`, create an array `ans` of length `2n` where:
- `ans[i] == nums[i]` for `0 <= i < n`
- `ans[i + n] == nums[i]` for `0 <= i < n`

In other words, concatenate the array `nums` with itself.

## Examples

### Example 1
- **Input:** `nums = [1,2,1]`
- **Output:** `[1,2,1,1,2,1]`
- **Explanation:** The array `ans` is formed as:
  - `ans = [nums[0], nums[1], nums[2], nums[0], nums[1], nums[2]]`

### Example 2
- **Input:** `nums = [1,3,2,1]`
- **Output:** `[1,3,2,1,1,3,2,1]`
- **Explanation:** The array `ans` is formed as:
  - `ans = [nums[0], nums[1], nums[2], nums[3], nums[0], nums[1], nums[2], nums[3]]`

## Constraints

- `n == nums.length`
- `1 <= n <= 1000`
- `1 <= nums[i] <= 1000`

---

## Approach

**Algorithm:** Simple concatenation via array copying.

1. Create a new array `ans` of size `2n`
2. Copy all elements from `nums` to indices `0` to `n-1` in `ans`
3. Copy all elements from `nums` to indices `n` to `2n-1` in `ans`
4. Return `ans`

## Complexity Analysis

- **Time Complexity:** O(n)
  - We iterate through the array twice (one for each copy operation)
  - Each operation is O(n), so total is O(2n) = O(n)

- **Space Complexity:** O(1)
  - We only use constant extra space (excluding the output array itself)
  - The output array of size `2n` is required by the problem

## Edge Cases

1. **Single element:** `nums = [1]` → `[1, 1]` ✅
2. **Large array:** `n = 1000` with max values → Works within constraints ✅
3. **Duplicate elements:** `nums = [1,1,1]` → `[1,1,1,1,1,1]` ✅

## Key Insights

- This is a **straightforward array manipulation problem**
- No complex data structures needed
- The most efficient solution is to simply copy the array twice
- Java's `System.arraycopy()` could also be used for even cleaner code
