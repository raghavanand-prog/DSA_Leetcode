# Smallest Index with Digit Sum Equal to Index

**Problem ID:** LeetCode Daily Question (2026-09-24)  
**Difficulty:** Easy  
**Category:** Array, Digit Manipulation  

## Problem Statement

Given an array `nums`, find the smallest index `i` such that the sum of the digits of `nums[i]` equals `i`. If no such index exists, return `-1`.

### Constraints
- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 10^9`

## Examples

### Example 1
```
Input: nums = [4, 3, 2, 1]
Output: 2
Explanation:
- Index 0: digit_sum(4) = 4, not equal to 0
- Index 1: digit_sum(3) = 3, not equal to 1
- Index 2: digit_sum(2) = 2, equals 2 ✓
Return 2 (smallest such index)
```

### Example 2
```
Input: nums = [1, 2, 3, 4]
Output: -1
Explanation:
- Index 0: digit_sum(1) = 1, not equal to 0
- Index 1: digit_sum(2) = 2, not equal to 1
- Index 2: digit_sum(3) = 3, not equal to 2
- Index 3: digit_sum(4) = 4, not equal to 3
No match found, return -1
```

### Example 3
```
Input: nums = [0]
Output: 0
Explanation:
- Index 0: digit_sum(0) = 0, equals 0 ✓
Return 0
```

## Algorithm: Simple Iteration

### Approach
1. Iterate through each index `i` from 0 to n-1
2. For each element `nums[i]`, calculate its digit sum
3. If digit sum equals `i`, return `i` immediately (this is the smallest such index)
4. If no match found after complete iteration, return `-1`

### Code Walkthrough

```java
public int smallestIndex(int[] nums) {
    // Iterate through each index
    for (int i = 0; i < nums.length; i++) {
        int n = nums[i];
        int sum = 0;
        
        // Calculate digit sum of nums[i]
        while (n > 0) {
            sum += n % 10;  // Add last digit
            n /= 10;        // Remove last digit
        }
        
        // Check if digit sum equals index
        if (sum == i) {
            return i;  // Return immediately (smallest index)
        }
    }
    
    // No matching index found
    return -1;
}
```

### Step-by-Step Example
Array: `[4, 3, 2, 1]`

1. **i = 0:** nums[0] = 4, digit_sum(4) = 4, is 4 == 0? No
2. **i = 1:** nums[1] = 3, digit_sum(3) = 3, is 3 == 1? No
3. **i = 2:** nums[2] = 2, digit_sum(2) = 2, is 2 == 2? **Yes** → Return 2

### Digit Sum Calculation
For a number like 456:
```
456 % 10 = 6  (last digit)  → sum = 6
45 % 10 = 5   (last digit)  → sum = 11
4 % 10 = 4    (last digit)  → sum = 15
0 % 10 = 0    (stop)
```
Digit sum of 456 = 4 + 5 + 6 = 15

## Complexity Analysis

### Time Complexity: O(n * d)
- **n** = length of array (iterate through each index)
- **d** = average number of digits in each element
- For each element, we perform digit sum calculation which takes O(d) time
- Since integers are at most 10^9 (≤10 digits), d ≤ 10, so effectively **O(n)**

### Space Complexity: O(1)
- Only using constant extra space for variables (i, n, sum)
- No additional data structures needed

## Edge Cases Covered

| Case | Input | Output | Explanation |
|------|-------|--------|-------------|
| Single zero | `[0]` | 0 | digit_sum(0) = 0, equals index 0 |
| Single non-zero | `[5]` | -1 | digit_sum(5) = 5, not equal to index 0 |
| No match | `[1,2,3,4]` | -1 | No index matches its digit sum |
| Match at start | `[0, 1, 2]` | 0 | First index matches immediately |
| Match at middle | `[1, 1, 3]` | 1 | nums[1]=1, digit_sum(1)=1 |
| Multi-digit numbers | `[10, 20, 30]` | -1 | digit_sum(10)=1, digit_sum(20)=2, digit_sum(30)=3 |
| Leading zeros effect | `[100, 100, 15]` | 1 | nums[1]=100, digit_sum=1, equals 1 |

## Test Coverage

All 12 test cases passing:

1. ✓ Basic: Single digit at matching index
2. ✓ No match: Multiple elements, none match
3. ✓ Edge: Zero at index 0
4. ✓ Edge: Two-digit number not matching
5. ✓ Edge: Single element array (no match)
6. ✓ Multiple: Zero at start (first match)
7. ✓ Multiple: One at middle index
8. ✓ Larger: Multi-digit numbers (no match)
9. ✓ Complex: Two-digit numbers (no match)
10. ✓ Complex: Array with indices 0-8
11. ✓ Complex: Digit sum of 100 equals 1
12. ✓ Complex: Round numbers (no match)

## Interview Tips

### 1. **Straightforward Problem Recognition**
This is an easy problem designed to test:
- Ability to iterate through arrays
- Understanding of digit manipulation
- Edge case handling
- Simple loop optimization (return early when found)

### 2. **Digit Sum Calculation Pattern**
The digit extraction pattern is fundamental:
```java
while (n > 0) {
    digit = n % 10;  // Extract last digit
    n /= 10;         // Remove last digit
}
```
This pattern appears in many problems:
- Reverse integer
- Check palindrome
- Digit frequency counting

### 3. **Early Return Optimization**
Since we want the **smallest** index:
- Return immediately when found (no need to check remaining elements)
- This is optimal because we iterate from index 0 upward
- Cannot do better than O(n) worst case

### 4. **Common Mistakes to Avoid**
- ❌ Not handling zero correctly (digit_sum(0) = 0)
- ❌ Off-by-one errors in loop indices
- ❌ Incorrect digit extraction (using string conversion unnecessarily)
- ❌ Not returning -1 when no match found

### 5. **Why This Easy Problem Matters**
- Tests fundamental array iteration skills
- Tests understanding of digit manipulation
- Good warm-up before complex problems
- Often asked as a quick screening question

## Problem Variations

### Variation 1: Index of Last Matching Element
**Problem:** Return the largest index where digit_sum(nums[i]) == i  
**Solution:** Iterate from end to start, return first match

### Variation 2: Count Matching Indices
**Problem:** Count how many indices have digit_sum(nums[i]) == i  
**Solution:** Count instead of returning early

### Variation 3: Sum of Values at Matching Indices
**Problem:** Return the sum of all nums[i] where digit_sum(nums[i]) == i  
**Solution:** Accumulate instead of returning early

## Related Problems

- **LeetCode #9 (Palindrome Number):** Digit extraction
- **LeetCode #7 (Reverse Integer):** Digit manipulation
- **LeetCode #1165 (Single-Row Keyboard):** Index-based array problems
- **LeetCode #2011 (Final Value of Variable After Operations):** Array iteration

## Key Learnings

1. **Digit manipulation** is a fundamental technique in DSA
2. **Early return** optimization is important for performance
3. **Edge cases** like zero and single elements need special attention
4. **Simple iteration** is often sufficient for straightforward problems
5. **Pattern recognition** helps identify similar problem variations

---

**Created:** Day 7 of 60-Day LeetCode Challenge  
**Status:** ✓ Complete (12/12 tests passing, ready for submission)
