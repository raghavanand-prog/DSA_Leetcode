/**
 * Test Suite for Day 6: Minimum Operations to Reduce X to Zero
 * 12 comprehensive test cases covering all scenarios
 */

public class Test {
    static class TestCase {
        int[] nums;
        int x;
        int expected;
        String description;
        
        TestCase(int[] nums, int x, int expected, String description) {
            this.nums = nums;
            this.x = x;
            this.expected = expected;
            this.description = description;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            new TestCase(new int[]{1, 1, 4, 2, 3}, 5, 2, "Example 1: Remove from right"),
            new TestCase(new int[]{5, 6, 7, 8, 9}, 4, -1, "Example 2: Impossible"),
            new TestCase(new int[]{3, 2, 20, 1, 1, 3}, 10, 5, "Example 3: Remove from both ends"),
            new TestCase(new int[]{1, 2, 3}, 6, 3, "Edge: Remove all"),
            new TestCase(new int[]{1, 1, 1, 1}, 1, 1, "Edge: Single element"),
            new TestCase(new int[]{5}, 5, 1, "Edge: Single element = x"),
            new TestCase(new int[]{5}, 10, -1, "Edge: Single element < x"),
            new TestCase(new int[]{1, 1, 1, 1}, 1, 1, "Edge: Remove from left"),
            new TestCase(new int[]{1, 1, 1, 1}, 1, 1, "Edge: Remove from right"),
            new TestCase(new int[]{8, 7, 3, 5, 4}, 15, 2, "Complex: Multiple options"),
            new TestCase(new int[]{1, 2, 3, 4, 5}, 5, 1, "Complex: Remove from right"),
            new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 26, 4, "Complex: Large array"),
        };
        
        System.out.println("=== Day 6: Minimum Operations to Reduce X to Zero ===\n");
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            TestCase tc = testCases[i];
            int result = solution.minOperations(tc.nums, tc.x);
            boolean isPass = result == tc.expected;
            if (isPass) passed++;
            System.out.println((isPass ? "✓" : "✗") + " Test " + (i + 1) + ": " + tc.description);
            System.out.println("  Expected: " + tc.expected + ", Got: " + result + "\n");
        }
        System.out.println("Passed: " + passed + "/12");
    }
}
