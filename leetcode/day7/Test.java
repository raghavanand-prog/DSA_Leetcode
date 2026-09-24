/**
 * Test Suite for Day 7: Smallest Index with Digit Sum Equal to Index
 * 12 comprehensive test cases
 */

public class Test {
    static class TestCase {
        int[] nums;
        int expected;
        String description;
        
        TestCase(int[] nums, int expected, String description) {
            this.nums = nums;
            this.expected = expected;
            this.description = description;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            new TestCase(new int[]{4, 3, 2, 1}, 2, "Basic: nums[2]=2, digit_sum(2)=2"),
            new TestCase(new int[]{1, 2, 3, 4}, -1, "No match: no index matches digit sum"),
            new TestCase(new int[]{0}, 0, "Edge: Index 0, nums[0]=0"),
            new TestCase(new int[]{10}, -1, "Edge: nums[0]=10, digit_sum=1, not 0"),
            new TestCase(new int[]{5}, -1, "Edge: Single element, digit_sum(5)=5, not 0"),
            new TestCase(new int[]{0, 1, 2}, 0, "Multiple: nums[0]=0 matches index 0"),
            new TestCase(new int[]{1, 1, 3}, 1, "Multiple: nums[1]=1 matches index 1"),
            new TestCase(new int[]{10, 20, 30}, -1, "Larger: No matches"),
            new TestCase(new int[]{11, 22, 33}, -1, "Two-digit: No matches"),
            new TestCase(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, -1, "Complex: 9 elements, no matches"),
            new TestCase(new int[]{100, 100, 15}, 1, "Complex: nums[1]=100, digit_sum=1"),
            new TestCase(new int[]{50, 40, 30, 20, 10}, -1, "Complex: No matches"),
        };
        
        System.out.println("=== Day 7: Smallest Index with Digit Sum Equal to Index ===\n");
        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            TestCase tc = testCases[i];
            int result = solution.smallestIndex(tc.nums);
            boolean isPass = result == tc.expected;
            if (isPass) passed++;
            System.out.println((isPass ? "✓" : "✗") + " Test " + (i + 1) + ": " + tc.description);
            System.out.println("  Expected: " + tc.expected + ", Got: " + result + "\n");
        }
        System.out.println("Passed: " + passed + "/12");
    }
}
