# Maximum Nesting Depth of the Parentheses

**Problem ID:** LeetCode Easy  
**Difficulty:** Easy  
**Category:** String, Parentheses Depth Tracking  

## Problem Statement

A string is a valid parentheses string if:
1. It is an empty string `""`, or
2. It can be written as `AB` where `A` and `B` are valid parentheses strings, or
3. It can be written as `(A)` where `A` is a valid parentheses string

The **nesting depth** of a string is defined as the maximum number of nested parentheses at any point.

Given a valid parentheses string `s` that may contain lowercase English letters and parentheses, return its nesting depth.

### Constraints
- `1 <= s.length <= 100`
- `s` consists of lowercase English letters and parentheses `(` and `)`
- All parentheses in `s` are properly matched

## Examples

### Example 1
```
Input: s = "a(bc)d"
Output: 1

Explanation:
- 'a': depth 0
- '(': depth becomes 1
- 'b', 'c': depth is 1
- ')': depth becomes 0
- 'd': depth 0
Maximum depth reached: 1
```

### Example 2
```
Input: s = "a(b(c)d)e"
Output: 2

Explanation:
- 'a': depth 0
- '(': depth becomes 1
- 'b': depth 1
- '(': depth becomes 2  ← Maximum here
- 'c': depth 2
- ')': depth becomes 1
- 'd': depth 1
- ')': depth becomes 0
- 'e': depth 0
Maximum depth reached: 2
```

### Example 3
```
Input: s = "(a(b(c)d)e)f(g(h))"
Output: 3

Explanation:
Position by position:
- '(': depth 1
- 'a': depth 1
- '(': depth 2
- 'b': depth 2
- '(': depth 3  ← Maximum here
- 'c': depth 3
- ')': depth 2
- 'd': depth 2
- ')': depth 1
- 'e': depth 1
- ')': depth 0
- 'f': depth 0
- '(': depth 1
- 'g': depth 1
- '(': depth 2
- 'h': depth 2
- ')': depth 1
- ')': depth 0
Maximum depth reached: 3
```

## Algorithm: Simple Counter Tracking

### Approach

The key insight is **simplicity itself**:

1. **Track two values:**
   - `depth`: Current nesting level
   - `ans`: Maximum depth seen

2. **For each character:**
   - `'('`: Increment depth, update max
   - `')'`: Decrement depth
   - Other characters: Ignore

3. **Return the maximum depth**

Why this works:
- Parentheses are properly matched (guaranteed by problem)
- Maximum depth occurs immediately after an opening parenthesis
- We only care about the maximum, not tracking positions
- Single pass through string suffices

### Step-by-Step Example

**Input:** `s = "a(b(c)d)e"`

```
Index 0: 'a'
  depth = 0, ans = 0

Index 1: '('
  depth = 0 + 1 = 1
  ans = max(0, 1) = 1

Index 2: 'b'
  No change: depth = 1, ans = 1

Index 3: '('
  depth = 1 + 1 = 2
  ans = max(1, 2) = 2  ← Update maximum

Index 4: 'c'
  No change: depth = 2, ans = 2

Index 5: ')'
  depth = 2 - 1 = 1
  No update to ans

Index 6: 'd'
  No change: depth = 1, ans = 2

Index 7: ')'
  depth = 1 - 1 = 0
  No update to ans

Index 8: 'e'
  No change: depth = 0, ans = 2

Final result: ans = 2
```

### Code Walkthrough

```java
public int maxDepth(String s) {
    int depth = 0;  // Current nesting level
    int ans = 0;    // Maximum depth seen

    for (char c : s.toCharArray()) {
        if (c == '(') {
            depth++;
            ans = Math.max(ans, depth);
        } else if (c == ')') {
            depth--;
        }
    }

    return ans;
}
```

Key points:
- Update `ans` **right after** incrementing (not before)
- Only check on `'('`, not on `')'`
- Ignore non-parenthesis characters
- No need to validate - input is guaranteed valid

## Complexity Analysis

### Time Complexity: O(n)
- **n** = length of string
- Single pass through all characters
- Each operation (increment, decrement, max) is O(1)
- Total: O(n)

### Space Complexity: O(1)
- Only using two integer variables: `depth` and `ans`
- No additional data structures
- No recursion stack
- Constant space regardless of input size

## Key Concepts

### 1. **Counter-Based Tracking**
Instead of storing all states, just track current and maximum:
```java
if (c == '(') {
    depth++;
    ans = Math.max(ans, depth);
}
```

### 2. **Single Pass Solution**
No need for multiple passes or preprocessing:
- Visit each character exactly once
- Update maximum as we go
- Return result immediately

### 3. **Valid String Guarantee**
The problem guarantees valid parentheses:
- No need to validate balance
- No need to check for mismatches
- Can rely on depth never going negative

### 4. **Ignoring Non-Parentheses**
Other characters don't affect depth:
```java
} else if (c != ')') {
    // Character is a letter, ignore it
}
```

## Edge Cases Covered

| Case | Input | Output | Notes |
|------|-------|--------|-------|
| No parentheses | `"abc"` | 0 | Depth remains 0 throughout |
| Single level | `"(a)"` | 1 | One pair of parentheses |
| Multiple pairs | `"(a)(b)"` | 1 | Sequential, not nested |
| Deep nesting | `"((((a))))"` | 4 | Four levels of nesting |
| Mixed nesting | `"(a(b)c)"` | 2 | Varying depths |
| Empty-like | `"()"` | 1 | Just parentheses, minimal |
| Start with letter | `"a(b)"` | 1 | Non-parenthesis first |
| End with letter | `"(a)b"` | 1 | Non-parenthesis last |

## Test Coverage

All 12 test cases passing:

1. ✓ Basic: Single level of nesting
2. ✓ Two levels: Nested parentheses
3. ✓ Complex: Three levels of nesting
4. ✓ Edge: No parentheses, depth 0
5. ✓ Edge: Only letters, no parentheses
6. ✓ Single: Simplest non-zero nesting
7. ✓ Multiple pairs: All at same depth
8. ✓ Deep nesting: Four levels deep
9. ✓ Mixed: Varying depths throughout
10. ✓ Maximum in middle: Deeper level before simpler
11. ✓ Two peaks: Multiple maximum depths
12. ✓ Minimal: Just two parentheses

## Common Mistakes to Avoid

- ❌ **Updating ans on close parenthesis**: Should update on open only
- ❌ **Not ignoring non-parenthesis characters**: They don't affect depth
- ❌ **Using a stack unnecessarily**: Single counter is enough
- ❌ **Checking before incrementing**: Update after incrementing
- ❌ **Forgetting to update maximum**: Must track max after each open
- ❌ **Assuming letters affect nesting**: Only parentheses matter

## Interview Tips

### 1. **Problem Classification**
This is an **Easy depth-tracking** problem:
- Tests string iteration ability
- Tests understanding of nesting
- Shows optimization sense (no stack needed)

### 2. **Why It's Easy**
- No complex data structures
- Single pass algorithm
- No edge cases to worry about (input is valid)
- Direct problem statement

### 3. **Variations & Follow-ups**
- Find all depths (track position and depth)
- Remove parentheses with max depth (track which pairs)
- Count sub-expressions at each depth
- Find range of max depth occurrence

### 4. **Why This Problem Matters**
- Foundation for more complex parenthesis problems
- Tests clean algorithmic thinking
- Shows when NOT to over-engineer (no stack needed)
- Real-world application: parsing, formatting

## Related Problems

- **LeetCode #20 (Valid Parentheses):** Validation with stack
- **LeetCode #32 (Longest Valid Parentheses):** Finding valid substrings
- **LeetCode #1249 (Minimum Remove to Make Valid Parentheses):** Removal logic
- **LeetCode #1190 (Reverse Substrings Between Each Pair):** Nesting with operations

## Key Learnings

1. **Sometimes simple is best** - don't over-engineer with stacks
2. **Tracking current and max** is a powerful pattern
3. **Single pass** is often optimal for sequence problems
4. **Constraints matter** - guaranteed valid input simplifies solution
5. **Clarity** - the simplest code is often the fastest to write and debug

## Why Not Use a Stack?

You might think "use a stack like other parenthesis problems":
- ❌ Stack complexity: O(n) space, O(n) time
- ✅ Counter approach: O(1) space, O(n) time
- Better trade-off when we only need depth, not structure

Stack would be needed if we had to:
- Track which parentheses match
- Validate the string
- Perform operations on matched pairs
- Return positions, not just depth

For pure depth tracking, counting is optimal.

---

**Created:** Day 11 of 60-Day LeetCode Challenge  
**Status:** ✓ Complete (12/12 tests passing, ready for submission)
