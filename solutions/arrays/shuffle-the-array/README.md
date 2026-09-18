# Shuffle the Array

**LeetCode Problem:** [1470. Shuffle the Array](https://leetcode.com/problems/shuffle-the-array/)

**Difficulty:** Easy

**Topic:** Array

---

## Problem

Given an array `nums` of length `2n` consisting of `[x₁,x₂,...,xₙ,y₁,y₂,...,yₙ]`, return the shuffled array `[x₁,y₁,x₂,y₂,...,xₙ,yₙ]`.

## Examples

### Example 1
- **Input:** `nums = [2,5,1,3,4,7], n = 3`
- **Output:** `[2,3,5,4,1,7]`
- **Explanation:** 
  - First n elements: `x = [2,5,1]`
  - Next n elements: `y = [3,4,7]`
  - Interleaved: `[2,3,5,4,1,7]`

### Example 2
- **Input:** `nums = [1,2,3,4,4,3,2,1], n = 4`
- **Output:** `[1,4,2,3,3,2,4,1]`

### Example 3
- **Input:** `nums = [1,1,2,2], n = 2`
- **Output:** `[1,2,1,2]`

## Constraints

- `1 <= n <= 500`
- `nums.length == 2n`
- `1 <= nums[i] <= 10³`

---

## Approach

**Algorithm:** Two-pointer interleaving

1. Create a result array of size `2n`
2. Iterate through indices `0` to `n-1`
3. Place `nums[i]` at even index `2*i` in result
4. Place `nums[n+i]` at odd index `2*i+1` in result
5. Return result

## Complexity Analysis

- **Time Complexity:** O(n)
  - Single loop through n elements
  - Each element is placed exactly once

- **Space Complexity:** O(1)
  - Only constant extra space used
  - Output array doesn't count toward space complexity

## Edge Cases

1. **Single pair:** `n=1, [1,2]` → `[1,2]` ✅
2. **Duplicates:** `[1,1,2,2]` → `[1,2,1,2]` ✅
3. **Large values:** `n=500` with max values works ✅
4. **Already shuffled:** Still produces correct result ✅

## Key Insights

- **Two-pointer pattern:** Perfect for interleaving operations
- **Index calculation:** `2*i` and `2*i+1` naturally map to even/odd positions
- **No sorting needed:** Direct index mapping is most efficient
- **In-place impossible:** Need new array due to interleaving nature
