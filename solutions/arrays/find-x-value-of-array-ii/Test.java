import java.util.Arrays;

/**
 * Comprehensive test cases for Find X Value of Array II
 */
public class Test {
    
    static class TestCase {
        String name;
        int[] nums;
        int k;
        int[][] queries;
        int[] expected;
        
        TestCase(String name, int[] nums, int k, int[][] queries, int[] expected) {
            this.name = name;
            this.nums = nums;
            this.k = k;
            this.queries = queries;
            this.expected = expected;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCase[] testCases = {
            // Example 1 from problem
            new TestCase(
                "Example 1: Basic with prefix and suffix removals",
                new int[]{1, 2, 3, 4, 5},
                3,
                new int[][]{{2, 2, 0, 2}, {3, 3, 3, 0}, {0, 1, 0, 1}},
                new int[]{2, 2, 2}
            ),
            
            // Example 2 from problem
            new TestCase(
                "Example 2: Limited valid removals",
                new int[]{1, 2, 4, 8, 16, 32},
                4,
                new int[][]{{0, 2, 0, 2}, {0, 2, 0, 1}},
                new int[]{1, 0}
            ),
            
            // Example 3 from problem
            new TestCase(
                "Example 3: Multiple identical elements",
                new int[]{1, 1, 2, 1, 1},
                2,
                new int[][]{{2, 1, 0, 1}},
                new int[]{5}
            ),
            
            // Edge case: Single element
            new TestCase(
                "Edge: Single element array",
                new int[]{5},
                3,
                new int[][]{{0, 2, 0, 2}},
                new int[]{1}  // Only [2], product=2, 2%3=2 ✓
            ),
            
            // Edge case: All elements product is 0 mod k
            new TestCase(
                "Edge: Product divisible by k",
                new int[]{3, 3, 3},
                3,
                new int[][]{{0, 3, 0, 0}},
                new int[]{3}  // [3,3,3] (27%3=0), [3,3] (9%3=0), [3] (3%3=0)
            ),
            
            // Edge case: Start index reduces array significantly
            new TestCase(
                "Edge: Large start index",
                new int[]{1, 2, 3, 4, 5},
                2,
                new int[][]{{4, 6, 4, 0}},
                new int[]{1}  // After removing prefix [1,2,3,4], only [6] remains, 6%2=0
            ),
            
            // Edge case: Product with k=5
            new TestCase(
                "Edge: Different modulo k",
                new int[]{2, 3, 5},
                5,
                new int[][]{{1, 4, 0, 1}},  // nums becomes [2, 4, 5]
                new int[]{0}  // [2,4,5]=40%5=0, [2,4]=8%5=3, [2]=2%5=2 - no match for x=1
            ),
            
            // Multiple queries with persistent updates
            new TestCase(
                "Multiple queries: Persistent updates",
                new int[]{1, 2, 3},
                2,
                new int[][]{{0, 4, 0, 0}, {1, 5, 0, 1}},
                new int[]{3, 0}  // Query1: [4,2,3] all even, Query2: [4,5,3] all even
            ),
            
            // Edge case: Start at last valid index
            new TestCase(
                "Edge: Start near end",
                new int[]{2, 3, 7},
                4,
                new int[][]{{2, 5, 2, 1}},
                new int[]{1}  // Only [5] remains after removing [2,3], 5%4=1 ✓
            ),
            
            // Edge case: x equals 0
            new TestCase(
                "Edge: x equals 0",
                new int[]{2, 2, 2},
                2,
                new int[][]{{0, 6, 0, 0}},
                new int[]{3}  // [6,2,2]=24%2=0, [6,2]=12%2=0, [6]=6%2=0
            )
        };
        
        int passed = 0;
        int failed = 0;
        
        for (TestCase tc : testCases) {
            // Make a copy since solution modifies the array
            int[] numsCopy = tc.nums.clone();
            int[] result = solution.resultArray(numsCopy, tc.k, tc.queries);
            
            boolean success = Arrays.equals(result, tc.expected);
            
            if (success) {
                passed++;
                System.out.println("✓ PASS: " + tc.name);
            } else {
                failed++;
                System.out.println("✗ FAIL: " + tc.name);
                System.out.println("  Expected: " + Arrays.toString(tc.expected));
                System.out.println("  Got:      " + Arrays.toString(result));
            }
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Results: " + passed + " passed, " + failed + " failed");
        System.out.println("=".repeat(50));
    }
}
