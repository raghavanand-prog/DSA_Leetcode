import java.util.*;

/**
 * Comprehensive test suite for Brace Expansion II
 * 12 test cases covering all scenarios: examples, edge cases, and complex scenarios
 */

public class Test {

    static class TestCase {
        String expression;
        List<String> expected;
        String description;

        TestCase(String expression, List<String> expected, String description) {
            this.expression = expression;
            this.expected = expected;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            // Basic examples from problem
            new TestCase("a{b,c}d",
                Arrays.asList("abd", "acd"),
                "Basic: Two alternatives in braces, abc pattern"),

            new TestCase("{a,b}{c,d}",
                Arrays.asList("ac", "ad", "bc", "bd"),
                "Multiple: Consecutive brace groups, cartesian product"),

            new TestCase("{a,{b,c}}",
                Arrays.asList("a", "b", "c"),
                "Nested: Braces inside braces"),

            // Edge cases: Single characters and empty cases
            new TestCase("a",
                Arrays.asList("a"),
                "Edge: Single character, no braces"),

            new TestCase("{a}",
                Arrays.asList("a"),
                "Edge: Single element in braces"),

            // Complex nested scenarios
            new TestCase("a{b,{c,d}}e",
                Arrays.asList("abe", "ace", "ade"),
                "Nested with literals: a + (b or (c or d)) + e"),

            new TestCase("{a,b,c}",
                Arrays.asList("a", "b", "c"),
                "Multiple alternatives: Three-way choice"),

            new TestCase("a{b,c,d}e",
                Arrays.asList("abe", "ace", "ade"),
                "Three alternatives with context: a + choice + e"),

            // Deeper nesting
            new TestCase("{{a,b},{c,d}}",
                Arrays.asList("a", "b", "c", "d"),
                "Double nested braces: Alternative groups inside"),

            new TestCase("{a,{b,{c,d}}}",
                Arrays.asList("a", "b", "c", "d"),
                "Triple nested: Deep recursion"),

            // Mix of letters and numbers
            new TestCase("{a1,b2}",
                Arrays.asList("a1", "b2"),
                "Alphanumeric: Letters and digits in alternatives"),

            new TestCase("x{1,2,3}y",
                Arrays.asList("x1y", "x2y", "x3y"),
                "Numbers: Digit alternatives with surrounding literals")
        };

        System.out.println("=== Day 8: Brace Expansion II ===\n");

        int passed = 0;
        int failed = 0;

        for (int i = 0; i < testCases.length; i++) {
            TestCase tc = testCases[i];
            List<String> result = solution.braceExpansionII(tc.expression);
            boolean isPass = result.equals(tc.expected);

            if (isPass) {
                passed++;
                System.out.println("✓ Test " + (i + 1) + " PASSED");
            } else {
                failed++;
                System.out.println("✗ Test " + (i + 1) + " FAILED");
            }

            System.out.println("  Description: " + tc.description);
            System.out.println("  Input: \"" + tc.expression + "\"");
            System.out.println("  Expected: " + tc.expected);
            System.out.println("  Got:      " + result);
            System.out.println();
        }

        System.out.println("=== Test Summary ===");
        System.out.println("Passed: " + passed + "/" + testCases.length);
        System.out.println("Failed: " + failed + "/" + testCases.length);
        System.out.println("Success Rate: " + (100 * passed / testCases.length) + "%");
    }
}
