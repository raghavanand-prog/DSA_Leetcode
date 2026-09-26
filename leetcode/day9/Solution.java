import java.util.*;

/**
 * Problem: Evaluate the Bracket Pairs of a String (LeetCode Medium)
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s consisting of lowercase English letters and brackets '(' and ')'.
 * Given a knowledge base as a list of pairs [key, value].
 * 
 * Replace every occurrence of "(key)" in s with the corresponding value from knowledge base.
 * If a key doesn't exist in knowledge base, replace "(key)" with "?".
 * 
 * Rules:
 * 1. Each bracket pair contains exactly one key
 * 2. Keys are lowercase English letters
 * 3. If key exists in knowledge base, use its value
 * 4. If key doesn't exist, replace with single "?"
 * 5. No nested brackets in the input
 *
 * Examples:
 * - s = "hi(name)", knowledge = [["name","bob"]] → "hibob"
 * - s = "(a)bc(bc)", knowledge = [["a","hello"],["bc","world"]] → "helloworld"
 * - s = "(a)bc(d)", knowledge = [["a","hello"]] → "hello?c?"
 *
 * Key Insight: Use HashMap for O(1) lookups, StringBuilder for efficient string building
 */

public class Solution {

    /**
     * Evaluates bracket pairs in a string using a knowledge base.
     * 
     * Algorithm:
     * 1. Build HashMap from knowledge list for O(1) key lookups
     * 2. Iterate through string character by character
     * 3. When encountering '(':
     *    - Extract everything until matching ')'
     *    - Look up in HashMap
     *    - Append value if exists, else append '?'
     * 4. For regular characters, append directly
     * 5. Return final string
     *
     * @param s String with brackets to evaluate
     * @param knowledge List of [key, value] pairs
     * @return String with bracket pairs replaced according to knowledge base
     *
     * Time Complexity: O(n + m) where n = string length, m = total key length
     * Space Complexity: O(k) where k = size of knowledge base HashMap
     */
    public String evaluate(String s, List<List<String>> knowledge) {

        // Step 1: Build HashMap for O(1) lookups
        HashMap<String, String> map = new HashMap<>();

        for (List<String> x : knowledge) {
            map.put(x.get(0), x.get(1));
        }

        // Step 2: Build result string with replacements
        StringBuilder ans = new StringBuilder();

        // Iterate through each character
        for (int i = 0; i < s.length(); i++) {

            // Case 1: Found opening bracket
            if (s.charAt(i) == '(') {
                // Extract key between brackets
                StringBuilder key = new StringBuilder();
                i++;

                // Accumulate characters until closing bracket
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                // Look up key in HashMap
                if (map.containsKey(key.toString()))
                    ans.append(map.get(key.toString()));
                else
                    ans.append('?');
            }
            // Case 2: Regular character (not bracket)
            else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}
