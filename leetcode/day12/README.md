# Day 12: Check if There is a Valid Parentheses String Path

**Problem Link:** https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/

**Difficulty:** Hard

**Topics:** Dynamic Programming, Grid Traversal, Parentheses Validation

## Problem Summary

Given an `m × n` grid where each cell contains either `'('` or `')'`, determine if there exists a valid path from the top-left corner `(0, 0)` to the bottom-right corner `(m-1, n-1)` such that the string formed by concatenating characters along the path represents **valid parentheses**.

A valid parentheses string:
- Has equal numbers of `'('` and `')'`
- Never has more `')'` than `'('` at any prefix

Movement is restricted to **right** and **down** only.

## Algorithm Explanation

### Why 3D DP?

The key insight is that we need to track:
1. **Position:** `(i, j)` in the grid
2. **Balance:** Count of `'('` minus count of `')'` at that position

This gives us a 3D state: `dp[i][j][balance]`

### State Definition

`dp[i][j][bal] = true` if we can reach position `(i, j)` with a running balance of `bal`.

- **Balance** = number of unmatched `'('` characters
- Balance must always be ≥ 0 (never more `)` than `(`)
- Final balance must be 0 at `(m-1, n-1)` for valid parentheses

### Algorithm Steps

1. **Validation Checks:**
   - Path length = `m + n - 1` (cells visited)
   - For valid parentheses, path length must be **even**
   - Start must be `'('` and end must be `')'`

2. **DP Initialization:**
   - `dp[0][0][1] = true` (start with one unmatched `'('`)

3. **State Transitions:**
   - From `(i, j)` with balance `bal`:
     - Move **right** to `(i, j+1)`: Update balance based on new character
     - Move **down** to `(i+1, j)`: Update balance based on new character
   - Only proceed if new balance ≥ 0

4. **Answer:**
   - `dp[m-1][n-1][0]` = Can we reach bottom-right with balance 0?

### Example Walkthrough

Grid:
```
(  )
(  )
```

Path length = 2 + 2 - 1 = 3 (odd) → Return **false**

Grid:
```
(  )
)  (
```

Path: `(` → `)` → `)` → `(`
- Start: balance = 1
- After `)`: balance = 0
- After `)`: balance = -1 (invalid!)

Result: **false**

## Complexity Analysis

- **Time Complexity:** O(m × n × (m + n))
  - Three nested loops: position (m × n) and balance (0 to m+n)
  - Each state transition is O(1)

- **Space Complexity:** O(m × n × (m + n))
  - 3D DP table stores states for all positions and possible balances

## Key Insights

1. **Balance Tracking:** Track unmatched opening brackets to validate parentheses efficiently
2. **Early Termination:** Reject invalid balances immediately (when balance < 0)
3. **Impossible Cases:** Odd path length can never form valid parentheses
4. **Path Constraint:** Must move only right/down, cannot backtrack or skip cells

## Code Complexity

- Readable three nested loops with clear state transitions
- Early exit conditions reduce unnecessary computation
- Clean balance calculation: `bal + (char == '(' ? 1 : -1)`

## Test Coverage

12 test cases covering:
- Single cell and small grids
- Odd/even path length validation
- Invalid starting character
- Invalid ending character
- Balance overflow prevention
- Multiple paths with different balances
