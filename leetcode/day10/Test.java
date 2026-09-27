import java.util.*;

/**
 * Comprehensive test suite for Reverse Substrings Between Each Pair of Parentheses
 * 12 test cases covering all scenarios: examples, edge cases, and complex scenarios
 */

public class Test {

    static class TestCase {
        String s;
        String expected;
        String description;

        TestCase(String s, String expected, String description) {
            this.s = s;
            this.expected = expected;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            // Basic examples from problem
            new TestCase(
                "a(bc)de",
                "acbde",
                "Basic: Reverse 'bc' between parentheses"),

            new TestCase(
                "a(bc(cd)de)f",
                "acddcbf",
                "Nested: Multiple levels of parentheses"),

            new TestCase(
                "x(y(z)w)",
                "xwzy",
                "Nested deep: Process inner, then outer"),

            // Edge cases: No parentheses, single character
            new TestCase(
                "abcd",
                "abcd",
                "Edge: No parentheses, just literal string"),

            new TestCase(
                "(a)",
                "a",
                "Edge: Single character in parentheses"),

            // More complex nesting
            new TestCase(
                "(abc)def(ghi)",
                "cbagdefihg",
                "Multiple pairs: Non-nested parenthesis groups"),

            new TestCase(
                "a((b)c)",
                "acb",
                "Nested: Parentheses inside parentheses"),

            // Triple nesting
            new TestCase(
                "a(b(c(d)e)f)g",
                "agfedcbg",
                "Triple nested: Three levels deep"),

            // Empty after reversal concept
            new TestCase(
                "(ab(ba))",
                "abab",
                "Reverse produces same: (ab(ab)) after inner reverse"),

            // Repeated characters with reversal
            new TestCase(
                "abcd(dcba)",
                "abcdabcd",
                "Mirror pattern: String and its reverse in parentheses"),

            // Many nested levels
            new TestCase(
                "(((a)))",
                "a",
                "Deep nesting: Character nested 3 levels deep"),

            // Mixed simple and complex
            new TestCase(
                "p(u(dcid)cj)pe",
                "pdujdcidcpe",
                "Mixed: Combination of nesting depths")
        };

        System.out.println("=== Day 10: Reverse Substrings Between Each Pair of Parentheses ===\n");

        int passed = 0;
        int failed = 0;

        for (int i = 0; i < testCases.length; i++) {
            TestCase tc = testCases[i];
            String result = solution.reverseParentheses(tc.s);
            boolean isPass = result.equals(tc.expected);

            if (isPass) {
                passed++;
                System.out.println("✓ Test " + (i + 1) + " PASSED");
            } else {
                failed++;
                System.out.println("✗ Test " + (i + 1) + " FAILED");
            }

            System.out.println("  Description: " + tc.description);
            System.out.println("  Input:    \"" + tc.s + "\"");
            System.out.println("  Expected: \"" + tc.expected + "\"");
            System.out.println("  Got:      \"" + result + "\"");
            System.out.println();
        }

        System.out.println("=== Test Summary ===");
        System.out.println("Passed: " + passed + "/" + testCases.length);
        System.out.println("Failed: " + failed + "/" + testCases.length);
        System.out.println("Success Rate: " + (100 * passed / testCases.length) + "%");
    }
}
