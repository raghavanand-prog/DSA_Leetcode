import java.util.*;

/**
 * Comprehensive test suite for Evaluate the Bracket Pairs of a String
 * 12 test cases covering all scenarios: examples, edge cases, and complex scenarios
 */

public class Test {

    static class TestCase {
        String s;
        List<List<String>> knowledge;
        String expected;
        String description;

        TestCase(String s, List<List<String>> knowledge, String expected, String description) {
            this.s = s;
            this.knowledge = knowledge;
            this.expected = expected;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            // Basic examples from problem
            new TestCase(
                "hi(name)",
                Arrays.asList(
                    Arrays.asList("name", "bob")
                ),
                "hibob",
                "Basic: Single bracket with existing key"),

            new TestCase(
                "(a)bc(bc)",
                Arrays.asList(
                    Arrays.asList("a", "hello"),
                    Arrays.asList("bc", "world")
                ),
                "hellobc",
                "Multiple: Two brackets, second key doesn't match fully"),

            new TestCase(
                "(a)bc(d)",
                Arrays.asList(
                    Arrays.asList("a", "hello")
                ),
                "hello?c?",
                "Missing keys: Only first key exists, others replaced with ?"),

            // Edge cases: Single bracket, no brackets
            new TestCase(
                "abc",
                Arrays.asList(),
                "abc",
                "Edge: No brackets, just literal string"),

            new TestCase(
                "(a)",
                Arrays.asList(
                    Arrays.asList("a", "x")
                ),
                "x",
                "Edge: Single bracket, entire string is bracket"),

            // Consecutive brackets
            new TestCase(
                "(a)(b)(c)",
                Arrays.asList(
                    Arrays.asList("a", "1"),
                    Arrays.asList("b", "2"),
                    Arrays.asList("c", "3")
                ),
                "123",
                "Consecutive: Three brackets back-to-back"),

            // All brackets missing
            new TestCase(
                "(x)(y)(z)",
                Arrays.asList(
                    Arrays.asList("a", "1")
                ),
                "???",
                "All missing: None of the keys exist in knowledge"),

            // Mixed found and not found
            new TestCase(
                "a(b)c(d)e(f)g",
                Arrays.asList(
                    Arrays.asList("b", "B"),
                    Arrays.asList("d", "D")
                ),
                "aBcD?e?g",
                "Mixed: Some keys exist, some don't"),

            // Longer values in knowledge
            new TestCase(
                "(greeting)(name)",
                Arrays.asList(
                    Arrays.asList("greeting", "Hello"),
                    Arrays.asList("name", "Alice")
                ),
                "HelloAlice",
                "Longer values: Multi-character replacement values"),

            // Many brackets
            new TestCase(
                "(a)(a)(a)",
                Arrays.asList(
                    Arrays.asList("a", "x")
                ),
                "xxx",
                "Repeated: Same key appears multiple times"),

            // Brackets at beginning and end
            new TestCase(
                "(start)middle(end)",
                Arrays.asList(
                    Arrays.asList("start", "BEGIN"),
                    Arrays.asList("end", "FINISH")
                ),
                "BEGINmiddleFINISH",
                "Positions: Brackets at start, middle, and end"),

            // Complex multi-letter keys
            new TestCase(
                "(ab)(cd)(ef)",
                Arrays.asList(
                    Arrays.asList("ab", "1"),
                    Arrays.asList("cd", "2"),
                    Arrays.asList("ef", "3")
                ),
                "123",
                "Multi-letter keys: Keys with multiple characters")
        };

        System.out.println("=== Day 9: Evaluate the Bracket Pairs of a String ===\n");

        int passed = 0;
        int failed = 0;

        for (int i = 0; i < testCases.length; i++) {
            TestCase tc = testCases[i];
            String result = solution.evaluate(tc.s, tc.knowledge);
            boolean isPass = result.equals(tc.expected);

            if (isPass) {
                passed++;
                System.out.println("✓ Test " + (i + 1) + " PASSED");
            } else {
                failed++;
                System.out.println("✗ Test " + (i + 1) + " FAILED");
            }

            System.out.println("  Description: " + tc.description);
            System.out.println("  Input: \"" + tc.s + "\"");
            System.out.println("  Knowledge: " + tc.knowledge);
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
