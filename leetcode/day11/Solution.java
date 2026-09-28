/**
 * Problem: Maximum Nesting Depth of the Parentheses (LeetCode Easy)
 * Difficulty: Easy
 *
 * Problem Statement:
 * A string is a valid parentheses string if:
 * 1. It is an empty string, or
 * 2. It can be written as AB where A and B are valid parentheses strings, or
 * 3. It can be written as (A) where A is a valid parentheses string
 *
 * The nesting depth of a string is defined as the maximum number of nested
 * parentheses at any point in the string.
 *
 * Given a valid parentheses string s, return its nesting depth.
 *
 * Examples:
 * - "a(bc)d" → depth 1 (one level of nesting)
 * - "a(b(c)d)e" → depth 2 (two levels of nesting)
 * - "(a(b(c)d)e)f(g(h))" → depth 3 (maximum three levels)
 * - "a1b2c3" → depth 0 (no parentheses)
 *
 * Key Insight: Track current depth and maximum depth seen
 * - Increment on '(', decrement on ')'
 * - Update max whenever we increment
 * - Return max at the end
 */

public class Solution {

    /**
     * Finds the maximum nesting depth of parentheses in a string.
     * 
     * Algorithm:
     * 1. Maintain two counters:
     *    - depth: current nesting level
     *    - ans: maximum depth seen so far
     * 2. For each character:
     *    - '(': increment depth, update max
     *    - ')': decrement depth
     *    - Other: ignore
     * 3. Return maximum depth
     *
     * Observation:
     * - We only care about parentheses, not other characters
     * - Maximum is found right after an opening parenthesis
     * - String is guaranteed to be valid, so no need to validate
     *
     * @param s Valid parentheses string with other characters
     * @return Maximum nesting depth of parentheses
     *
     * Time Complexity: O(n) - single pass through string
     * Space Complexity: O(1) - only using two integer counters
     */
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
}
