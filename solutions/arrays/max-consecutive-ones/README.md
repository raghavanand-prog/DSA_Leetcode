# Max Consecutive Ones

**LeetCode Problem:** [485. Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)

**Difficulty:** Easy

**Topic:** Array, Simulation

---

## Problem

Given a binary array `nums`, return the maximum number of consecutive `1`'s in the array.

## Examples

### Example 1
- **Input:** `nums = [1,1,0,1,1,1]`
- **Output:** `3`
- **Explanation:** The first two 1's or the last three 1's are consecutive. The maximum is 3.

### Example 2
- **Input:** `nums = [1,0,1,1,0,1]`
- **Output:** `2`
- **Explanation:** The maximum number of consecutive 1's is 2.

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is either `0` or `1`

---

## Approach

**Algorithm:** Single-pass counter approach

1. Maintain two counters:
   - `maxCount`: Track the maximum consecutive 1's seen so far
   - `currentCount`: Track current consecutive 1's in progress
2. Iterate through the array once:
   - If `nums[i] == 1`: increment `currentCount` and update `maxCount`
   - If `nums[i] == 0`: reset `currentCount` to 0
3. Return `maxCount`

## Complexity Analysis

- **Time Complexity:** O(n)
  - Single pass through the array
  - Each element is processed once
  
- **Space Complexity:** O(1)
  - Only two integer variables used
  - Constant extra space regardless of input size

## Edge Cases

1. **All 1's:** `nums = [1,1,1,1]` → `4` ✅
2. **All 0's:** `nums = [0,0,0]` → `0` ✅
3. **Single element:** `nums = [1]` → `1` ✅
4. **1's at start:** `nums = [1,1,1,0,0]` → `3` ✅
5. **1's at end:** `nums = [0,0,1,1,1]` → `3` ✅
6. **Multiple groups:** `nums = [1,1,0,1,1,1,1,1,0,1]` → `5` ✅

## Key Insights

- **No extra space needed**: Unlike some problems, we don't need to store intermediate results
- **Single pass required**: We must see all elements to find the global maximum
- **Counter reset pattern**: This is a common pattern for counting consecutive elements
- **Simplicity**: The optimal solution is both time and space efficient with minimal complexity

## Related Problems

- Max Consecutive Ones II (Medium) — with one flip allowed
- Max Consecutive Ones III (Medium) — with k flips allowed
- Consecutive Characters (Easy) — similar logic with characters
