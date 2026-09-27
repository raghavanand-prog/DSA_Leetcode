import java.util.*;

/**
 * Problem: Reverse Substrings Between Each Pair of Parentheses (LeetCode Medium)
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a string s that you need to process. The string contains lowercase 
 * letters and parentheses. Every time you encounter an opening parenthesis '(',
 * you need to reverse the substring between it and the matching closing parenthesis ')'.
 * 
 * Rules:
 * 1. Process pairs of parentheses from innermost to outermost
 * 2. Reverse content between each pair
 * 3. Parentheses can be nested
 * 4. After reversing, parentheses are removed from result
 * 5. Continue with remaining string
 *
 * Examples:
 * - "a(bc)de" → reverse "bc" → "acbde"
 * - "a(bc(cd)de)f" → reverse "cd" first → "a(bcdc de)f" → reverse "bcdcde" → "acddcbf"
 * - "x(y(z)w)" → reverse "z" → "x(yzw)" → reverse "yzw" → "xwzy"
 *
 * Key Insight: Use Stack to handle nested parentheses elegantly
 * - Stack stores string states before each '('
 * - When encountering ')', reverse current and pop from stack
 * - This naturally handles nested reversals
 */

public class Solution {

    /**
     * Reverses substrings between each pair of parentheses.
     * 
     * Algorithm:
     * 1. Use Stack<String> to track string states at each nesting level
     * 2. Maintain current string (cur) being built
     * 3. For each character:
     *    - '(': Push current to stack, reset cur
     *    - ')': Reverse cur, pop from stack, concatenate
     *    - Letter: Append to cur
     * 4. Return final cur
     *
     * Key Observation:
     * - When we see '(', we're starting a new level that will be reversed
     * - Stack saves context from outer levels
     * - When we see ')', we reverse current level and merge with outer context
     *
     * @param s String with lowercase letters and parentheses
     * @return String with all parentheses reversed and removed
     *
     * Time Complexity: O(n²) worst case - reverse operations cost O(n) each
     * Space Complexity: O(n) for stack and string storage
     */
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        String cur = "";

        for (char c : s.toCharArray()) {
            // Case 1: Opening parenthesis - start new nesting level
            if (c == '(') {
                st.push(cur);  // Save current state to stack
                cur = "";      // Reset for new level
            }
            // Case 2: Closing parenthesis - reverse and merge
            else if (c == ')') {
                cur = new StringBuilder(cur).reverse().toString();
                cur = st.pop() + cur;  // Merge with outer level
            }
            // Case 3: Regular character - append to current
            else {
                cur += c;
            }
        }

        return cur;
    }
}
