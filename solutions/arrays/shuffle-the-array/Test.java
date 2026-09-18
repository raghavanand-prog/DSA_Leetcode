import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Example 1
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        int[] expected1 = {2, 3, 5, 4, 1, 7};
        int[] result1 = solution.shuffle(nums1, n1);
        assert Arrays.equals(result1, expected1) : "Test 1 failed";
        System.out.println("✅ Test 1 passed: " + Arrays.toString(result1));

        // Test Case 2: Example 2
        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        int[] expected2 = {1, 4, 2, 3, 3, 2, 4, 1};
        int[] result2 = solution.shuffle(nums2, n2);
        assert Arrays.equals(result2, expected2) : "Test 2 failed";
        System.out.println("✅ Test 2 passed: " + Arrays.toString(result2));

        // Test Case 3: Single pair
        int[] nums3 = {1, 2};
        int n3 = 1;
        int[] expected3 = {1, 2};
        int[] result3 = solution.shuffle(nums3, n3);
        assert Arrays.equals(result3, expected3) : "Test 3 failed";
        System.out.println("✅ Test 3 passed: " + Arrays.toString(result3));

        // Test Case 4: Large values
        int[] nums4 = {1000, 2000, 3000, 100, 200, 300};
        int n4 = 3;
        int[] expected4 = {1000, 100, 2000, 200, 3000, 300};
        int[] result4 = solution.shuffle(nums4, n4);
        assert Arrays.equals(result4, expected4) : "Test 4 failed";
        System.out.println("✅ Test 4 passed: " + Arrays.toString(result4));

        // Test Case 5: Duplicates
        int[] nums5 = {5, 5, 5, 5, 5, 5};
        int n5 = 3;
        int[] expected5 = {5, 5, 5, 5, 5, 5};
        int[] result5 = solution.shuffle(nums5, n5);
        assert Arrays.equals(result5, expected5) : "Test 5 failed";
        System.out.println("✅ Test 5 passed: " + Arrays.toString(result5));

        // Test Case 6: Alternating pattern
        int[] nums6 = {1, 3, 5, 2, 4, 6};
        int n6 = 3;
        int[] expected6 = {1, 2, 3, 4, 5, 6};
        int[] result6 = solution.shuffle(nums6, n6);
        assert Arrays.equals(result6, expected6) : "Test 6 failed";
        System.out.println("✅ Test 6 passed: " + Arrays.toString(result6));

        System.out.println("\n✅ All validation tests passed!");
    }
}
