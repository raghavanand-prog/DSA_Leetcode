# Set Mismatch

**LeetCode Problem:** [645. Set Mismatch](https://leetcode.com/problems/set-mismatch/)

**Difficulty:** Easy

**Topic:** Array, Hash Table, Bit Manipulation, Sorting

---

## Problem

You have a set of integers that originally contains all numbers from `1` to `n`. Unfortunately, due to data corruption:
- One number is **repeated** (appears twice)
- One number is **missing** (appears zero times)

Given an array `nums` representing the corrupted set, return `[duplicate, missing]`.

## Examples

### Example 1
- **Input:** `nums = [1,2,2,4]`
- **Output:** `[2,3]`
- **Explanation:** The set should be `[1,2,3,4]` but we have `[1,2,2,4]`. Number 2 is duplicate, 3 is missing.

### Example 2
- **Input:** `nums = [1,1]`
- **Output:** `[1,2]`
- **Explanation:** The set should be `[1,2]` but we have `[1,1]`. Number 1 is duplicate, 2 is missing.

## Constraints

- `2 <= nums.length <= 10^5`
- `1 <= nums[i] <= n` (where `n = nums.length`)

---

## Approach

**Algorithm:** Boolean array (Tracking approach)

1. Create a boolean array `seen` of size `n+1` to track which numbers we've encountered
2. Iterate through `nums`:
   - If `seen[nums[i]]` is true, we found the duplicate
   - Mark `seen[nums[i]]` as true
3. Iterate from `1` to `n`:
   - If `seen[i]` is false, we found the missing number
4. Return `[duplicate, missing]`

## Complexity Analysis

- **Time Complexity:** O(n)
  - First pass to find duplicate: O(n)
  - Second pass to find missing: O(n)
  - Total: O(2n) = O(n)
  
- **Space Complexity:** O(n)
  - Boolean array of size n+1

## Edge Cases

1. **Two elements:** `nums = [1,1]` → `[1,2]` ✅
2. **Duplicate at start, missing at end:** `nums = [1,1,2]` → `[1,3]` ✅
3. **Duplicate at end, missing at start:** `nums = [2,2]` → `[2,1]` ✅
4. **Large n:** `nums = [1,2,...,n-1,n,n]` → `[n,1]` ✅
5. **Unsorted:** `nums = [4,8,1,5,2,7,4,6]` → `[4,3]` ✅
6. **Duplicate 1:** `nums = [1,3,1,5,2,4]` → `[1,6]` ✅

## Key Insights

- **Range constraint:** Numbers are always in range [1, n] where n is array length
- **Deterministic:** Exactly one duplicate and one missing (guaranteed by problem)
- **Simple approach:** Boolean tracking is straightforward and efficient
- **Early detection:** We can identify duplicate in first pass
- **Order independent:** Works with sorted or unsorted arrays

## Alternative Approaches

### 1. Math approach (Sum)
- Calculate expected sum: `n * (n + 1) / 2`
- Actual sum - Expected sum = difference between duplicate and missing

### 2. Hash Set
- Same time/space complexity as boolean array
- Slightly more overhead from HashSet

### 3. Bit Manipulation (XOR)
- Uses O(1) extra space
- More complex logic

---

## Related Problems

- Find the Duplicate Number (Medium)
- Missing Number (Easy)
- First Missing Positive (Hard)
