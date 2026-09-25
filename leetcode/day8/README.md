# Brace Expansion II

**Problem ID:** LeetCode Hard  
**Difficulty:** Hard  
**Category:** String Parsing, Recursion, Cartesian Product  

## Problem Statement

Given a string that may contain letters, digits, and braces `{}`, expand all possible combinations according to the following rules:

### Rules
1. **Literals**: Characters outside braces are literal and appear in every result
2. **Alternatives**: Comma-separated sequences inside braces `{a,b,c}` represent alternatives
3. **Nesting**: Braces can be nested arbitrarily deep `{a,{b,c}}`
4. **Sorting**: Return results in lexicographical order
5. **Deduplication**: Duplicate results appear only once

### Constraints
- `1 <= expression.length <= 50`
- `expression[i]` is a character in `a-z`, `0-9`, or one of `{,}`
- All integers in expression range from `0` to `9`
- All combinations fit in a 32-bit integer when considered as bit strings

## Examples

### Example 1
```
Input: "a{b,c}d"
Output: ["abd", "acd"]
Explanation:
- Start with "a"
- Apply {b,c} → two paths: "ab", "ac"
- Append "d" → ["abd", "acd"]
```

### Example 2
```
Input: "{a,b}{c,d}"
Output: ["ac", "ad", "bc", "bd"]
Explanation:
- Cartesian product: 
  - {a,b} generates: "a", "b"
  - {c,d} generates: "c", "d"
  - Combine: "a" + "c"="ac", "a" + "d"="ad", "b" + "c"="bc", "b" + "d"="bd"
```

### Example 3
```
Input: "{a,{b,c}}"
Output: ["a", "b", "c"]
Explanation:
- Outer braces have two alternatives: "a" and nested "{b,c}"
- Nested "{b,c}" expands to "b", "c"
- Final: ["a", "b", "c"]
```

### Example 4
```
Input: "a{b,{c,d}}e"
Output: ["abe", "ace", "ade"]
Explanation:
- Literals: "a" at start, "e" at end
- Middle {b,{c,d}}: expands to "b", "c", "d"
- Combine: ["abe", "ace", "ade"]
```

## Algorithm: Recursive Parsing with State Management

### Approach

The key insight is to use **recursive descent parsing** where we process the expression character by character:

1. **Maintain a `current` set**: Tracks all possible strings built so far at this level
2. **Process three cases**:
   - **Literal character**: Add it to every string in `current`
   - **Comma**: Finalize the current sequence and start a new alternative
   - **Opening brace**: Recursively parse the nested expression, then cartesian product

3. **Use TreeSet**: Automatically maintains sorted order without explicit sorting
4. **Return combined results**: All sequences plus results from alternatives

### Step-by-Step Example

**Expression:** `"a{b,c}d"`

```
Position 0: Process 'a'
  current = {"a"}

Position 1: Process '{'
  Recursively parse inside braces: {b,c}
  - Process 'b': result = {"b"}
  - Process ',': Move to next alternative
  - Process 'c': result = {"b", "c"}
  - Return {"b", "c"}
  
  Cartesian product: "a" + {"b","c"} = {"ab", "ac"}
  current = {"ab", "ac"}

Position 4: Process 'd'
  Cartesian product: {"ab","ac"} + "d" = {"abd", "acd"}
  current = {"abd", "acd"}

Final result: ["abd", "acd"]
```

### Code Walkthrough

```java
Set<String> parse(String s, int[] i) {
    Set<String> result = new TreeSet<>();     // Final results
    Set<String> current = new TreeSet<>();    // Current combination
    current.add("");                          // Start with empty

    while (i[0] < s.length() && s.charAt(i[0]) != '}') {
        if (s.charAt(i[0]) == ',') {
            // End current sequence, start new alternative
            result.addAll(current);
            current = new TreeSet<>();
            current.add("");
            i[0]++;
        }
        else {
            // Get next part (literal or nested)
            Set<String> part = new TreeSet<>();
            
            if (s.charAt(i[0]) == '{') {
                i[0]++;
                part = parse(s, i);  // Recursive call
                i[0]++;
            }
            else {
                part.add(String.valueOf(s.charAt(i[0])));
                i[0]++;
            }

            // Cartesian product
            Set<String> next = new TreeSet<>();
            for (String a : current) {
                for (String b : part) {
                    next.add(a + b);
                }
            }
            current = next;
        }
    }

    result.addAll(current);
    return result;
}
```

## Key Concepts

### 1. **Cartesian Product**
Combining two sets A and B means creating all pairs (a, b):
```
A = {"a", "b"}, B = {"c", "d"}
Cartesian product: {a+c, a+d, b+c, b+d} = {"ac", "ad", "bc", "bd"}
```

### 2. **Recursive Descent Parsing**
Parse from left to right, handling nested structures through recursion:
- When we encounter `{`, we recursively parse until the matching `}`
- The recursive call handles that sub-expression completely
- Results bubble up to combine with surrounding context

### 3. **Index as Reference**
```java
int[] i = {0};  // Array for pass-by-reference
parse(s, i);    // Modifications to i[0] affect original
```
This allows us to track position across recursive calls without returning it.

### 4. **TreeSet for Ordering**
`TreeSet<String>` automatically keeps strings in lexicographical order, eliminating need for explicit sorting.

## Complexity Analysis

### Time Complexity: O(N * M log M)
- **N** = length of expression string
- **M** = number of result strings
- **N**: Each character processed once during parsing
- **M log M**: TreeSet operations (insert, search) are O(log M)
- **Total**: O(N) for parsing + O(M log M) for set operations

### Space Complexity: O(M)
- **M** = number of result strings
- Each result string is stored in the final set
- Recursion depth ≤ nesting depth (at most N/2 with proper brackets)

## Edge Cases Covered

| Case | Input | Output | Notes |
|------|-------|--------|-------|
| No braces | `"abc"` | `["abc"]` | Literal string, no expansion |
| Single alternative | `"{a}"` | `["a"]` | Single option in braces |
| Multiple alternatives | `"{a,b,c}"` | `["a","b","c"]` | Three or more choices |
| Nested once | `"{a,{b,c}}"` | `["a","b","c"]` | One level of nesting |
| Multiple braces | `"{a,b}{c,d}"` | `["ac","ad","bc","bd"]` | Sequential groups |
| Deep nesting | `"{{a,b},{c,d}}"` | `["a","b","c","d"]` | Multiple nested levels |
| Mixed content | `"x{1,2}y"` | `["x1y","x2y"]` | Numbers with letters |
| With context | `"a{b,{c,d}}e"` | `["abe","ace","ade"]` | Braces with surrounding literals |

## Test Coverage

All 12 test cases passing:

1. ✓ Basic: Simple two-alternative case with context
2. ✓ Multiple: Consecutive brace groups (cartesian product)
3. ✓ Nested: Braces inside braces
4. ✓ Edge: Single character without braces
5. ✓ Edge: Single element in braces
6. ✓ Nested with literals: Nested expansion surrounded by letters
7. ✓ Multiple alternatives: Three-way choice
8. ✓ Three alternatives with context: Multiple choices with surrounding text
9. ✓ Double nested braces: Nested alternative groups
10. ✓ Triple nested: Deep recursion test
11. ✓ Alphanumeric: Mixed letters and digits
12. ✓ Numbers: Digit alternatives

## Common Mistakes to Avoid

- ❌ **Not handling comma as sequence separator**: Treating comma as literal character
- ❌ **Forgetting to combine with current results**: Direct sum instead of cartesian product
- ❌ **Incorrect index management**: Not properly advancing past braces/commas
- ❌ **Forgetting to add final sequence**: Results after last comma
- ❌ **Not sorting results**: Returning in arbitrary order
- ❌ **Stack overflow**: Improper recursion termination conditions

## Interview Tips

### 1. **Problem Complexity Assessment**
This is a **Hard** problem because:
- Requires understanding of recursive descent parsing
- Need to handle cartesian products correctly
- Multiple edge cases (nested, commas, context)
- Index management across recursion is tricky

### 2. **Pattern Recognition**
This pattern appears in:
- Configuration file parsing (INI, YAML with alternatives)
- Template expansion systems
- Pattern matching and glob expansion
- Expression evaluation systems

### 3. **Implementation Strategy**
- **Start simple**: Handle literals first, then commas, then braces
- **Test incrementally**: Each feature added should not break previous tests
- **Use data structures well**: TreeSet saves manual sorting effort
- **Debug with tracing**: Print at each recursion level to visualize parse tree

### 4. **Why Recursion Works Here**
- Nested braces naturally map to recursive calls
- Each recursive call is independent (local state)
- Base cases are clear (literals, end of string)
- Combining results is straightforward (cartesian product)

### 5. **Alternative Approaches**
- **Stack-based parsing**: Use explicit stack instead of recursion
- **DFA/State machine**: More complex but useful for complex grammars
- **Regex splitting**: Preprocess to identify bracket pairs (less flexible)

## Related Problems

- **LeetCode #22 (Generate Parentheses):** Generating valid combinations with constraints
- **LeetCode #71 (Simplify Path):** Path parsing and reconstruction
- **LeetCode #224 (Basic Calculator):** Expression parsing and evaluation
- **LeetCode #1096 (Brace Expansion I):** Simpler version without nesting

## Key Learnings

1. **Recursive parsing** is powerful for handling nested structures
2. **Cartesian product** is fundamental in combinatorial problems
3. **TreeSet** saves effort when both insertion and sorting are needed
4. **Index arrays** allow tracking position across recursive calls
5. **Systematic testing** catches subtle edge cases in parsing problems

---

**Created:** Day 8 of 60-Day LeetCode Challenge  
**Status:** ✓ Complete (12/12 tests passing, ready for submission)
