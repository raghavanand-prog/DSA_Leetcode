import java.util.*;

/**
 * Problem: Brace Expansion II (LeetCode Hard)
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given a string containing letters, digits, and braces {}, expand all possible 
 * combinations. Comma-separated sequences inside braces are alternatives.
 * 
 * Rules:
 * 1. Characters outside braces are literal
 * 2. Commas inside braces separate alternatives
 * 3. Braces can be nested
 * 4. Return results in sorted lexicographical order
 * 
 * Examples:
 * - "a{b,c}d" → ["abd", "acd"]
 * - "{a,b}{c,d}" → ["ac", "ad", "bc", "bd"]
 * - "{a,{b,c}}" → ["a", "b", "c"]
 *
 * Key Insight: Use recursive parsing with state management
 * - Track current position in string
 * - At each level, handle three cases: literal chars, nested braces, commas
 * - Use TreeSet to maintain sorted order automatically
 * - Cartesian product (combine all strings from current with all from part)
 */

public class Solution {

    /**
     * Recursive parser that processes the expression starting at index i.
     * Returns all possible expansions for the current level.
     * 
     * @param s Expression string
     * @param i Index pointer array (passed by reference to modify in recursive calls)
     * @return Set of all possible expansions at this level
     */
    Set<String> parse(String s, int[] i) {
        Set<String> result = new TreeSet<>();  // Final result for this level
        Set<String> current = new TreeSet<>();  // Current combination sequence
        current.add("");  // Start with empty string

        // Process characters until end of string or closing brace
        while (i[0] < s.length() && s.charAt(i[0]) != '}') {

            // Case 1: Comma - marks end of current sequence and start of alternative
            if (s.charAt(i[0]) == ',') {
                // Add all current combinations to result
                result.addAll(current);
                // Start fresh for next alternative
                current = new TreeSet<>();
                current.add("");
                i[0]++;
            }
            // Case 2: Nested braces or literal character
            else {
                Set<String> part = new TreeSet<>();

                // Case 2a: Opening brace - recursively parse nested expression
                if (s.charAt(i[0]) == '{') {
                    i[0]++;  // Skip the '{'
                    part = parse(s, i);  // Recursively parse inside braces
                    i[0]++;  // Skip the '}'
                }
                // Case 2b: Literal character (letter or digit)
                else {
                    part.add(String.valueOf(s.charAt(i[0])));
                    i[0]++;
                }

                // Cartesian Product: Combine each string in current with each in part
                Set<String> next = new TreeSet<>();
                for (String a : current) {
                    for (String b : part) {
                        next.add(a + b);
                    }
                }
                current = next;
            }
        }

        // Add final sequence to result
        result.addAll(current);

        return result;
    }

    /**
     * Main method: Expand brace expression into sorted list of all combinations.
     * 
     * Algorithm:
     * 1. Initialize index pointer at 0
     * 2. Call recursive parse function
     * 3. Convert TreeSet result to ArrayList (maintains sorted order)
     * 4. Return as List
     * 
     * @param expression Brace expression string
     * @return Sorted list of all possible expansions
     * 
     * Time Complexity: O(N * M log M) where N is expression length, M is number of results
     * Space Complexity: O(M) for storing all result strings
     */
    public List<String> braceExpansionII(String expression) {
        int[] i = {0};  // Index pointer as array for pass-by-reference
        Set<String> ans = parse(expression, i);
        return new ArrayList<>(ans);
    }
}
