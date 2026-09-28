/**
 * Comprehensive test suite for Maximum Nesting Depth of the Parentheses
 * 12 test cases covering all scenarios: examples, edge cases, and complex scenarios
 */

public class Test {

    static class TestCase {
        String s;
        int expected;
        String description;

        TestCase(String s, int expected, String description) {
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
                "a(bc)d",
                1,
                "Basic: Single level of nesting"),

            new TestCase(
                "a(b(c)d)e",
                2,
                "Two levels: Nested parentheses"),

            new TestCase(
                "(a(b(c)d)e)f(g(h))",
                3,
                "Complex: Three levels of nesting"),

            // Edge cases: No parentheses
            new TestCase(
                "a1b2c3",
                0,
                "Edge: No parentheses, depth 0"),

            new TestCase(
                "abcdefg",
                0,
                "Edge: Only letters, no parentheses"),

            // Single level variations
            new TestCase(
                "(a)",
                1,
                "Single: Simplest non-zero nesting"),

            new TestCase(
                "(a)(b)(c)",
                1,
                "Multiple pairs: All at same depth"),

            // Multiple consecutive nesting
            new TestCase(
                "((((a))))",
                4,
                "Deep nesting: Four levels deep"),

            // Mixed nesting patterns
            new TestCase(
                "(a)(b(c)d)(e(f(g)h)i)j",
                3,
                "Mixed: Varying depths throughout"),

            // Maximum in middle
            new TestCase(
                "a(b(c(d(e)f)g)h)i(j)",
                4,
                "Maximum in middle: Deeper level before simpler level"),

            // Two equivalent depths
            new TestCase(
                "(a(b)c)(d(e)f)",
                2,
                "Two peaks: Multiple maximum depths"),

            // Empty and minimal
            new TestCase(
                "()",
                1,
                "Minimal: Just two parentheses")
        };

        System.out.println("=== Day 11: Maximum Nesting Depth of the Parentheses ===\n");

        int passed = 0;
        int failed = 0;

        for (int i = 0; i < testCases.length; i++) {
            TestCase tc = testCases[i];
            int result = solution.maxDepth(tc.s);
            boolean isPass = result == tc.expected;

            if (isPass) {
                passed++;
                System.out.println("✓ Test " + (i + 1) + " PASSED");
            } else {
                failed++;
                System.out.println("✗ Test " + (i + 1) + " FAILED");
            }

            System.out.println("  Description: " + tc.description);
            System.out.println("  Input:    \"" + tc.s + "\"");
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
