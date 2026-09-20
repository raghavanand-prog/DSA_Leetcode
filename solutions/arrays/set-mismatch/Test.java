import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Example 1
        int[] nums1 = {1, 2, 2, 4};
        int[] expected1 = {2, 3};
        int[] result1 = solution.findErrorNums(nums1);
        assert Arrays.equals(result1, expected1) : "Test 1 failed";
        System.out.println("✅ Test 1 passed: " + Arrays.toString(result1));

        // Test Case 2: Example 2
        int[] nums2 = {1, 1};
        int[] expected2 = {1, 2};
        int[] result2 = solution.findErrorNums(nums2);
        assert Arrays.equals(result2, expected2) : "Test 2 failed";
        System.out.println("✅ Test 2 passed: " + Arrays.toString(result2));

        // Test Case 3: Duplicate at end, missing at start
        int[] nums3 = {2, 2};
        int[] expected3 = {2, 1};
        int[] result3 = solution.findErrorNums(nums3);
        assert Arrays.equals(result3, expected3) : "Test 3 failed";
        System.out.println("✅ Test 3 passed: " + Arrays.toString(result3));

        // Test Case 4: Large array
        int[] nums4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        int[] expected4 = {9, 10};
        int[] result4 = solution.findErrorNums(nums4);
        assert Arrays.equals(result4, expected4) : "Test 4 failed";
        System.out.println("✅ Test 4 passed: " + Arrays.toString(result4));

        // Test Case 5: Duplicate in middle
        int[] nums5 = {1, 2, 3, 4, 5, 3, 7, 8};
        int[] expected5 = {3, 6};
        int[] result5 = solution.findErrorNums(nums5);
        assert Arrays.equals(result5, expected5) : "Test 5 failed";
        System.out.println("✅ Test 5 passed: " + Arrays.toString(result5));

        // Test Case 6: Missing at end
        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 7};
        int[] expected6 = {7, 8};
        int[] result6 = solution.findErrorNums(nums6);
        assert Arrays.equals(result6, expected6) : "Test 6 failed";
        System.out.println("✅ Test 6 passed: " + Arrays.toString(result6));

        // Test Case 7: Unsorted array
        int[] nums7 = {4, 8, 1, 5, 2, 7, 4, 6};
        int[] expected7 = {4, 3};
        int[] result7 = solution.findErrorNums(nums7);
        assert Arrays.equals(result7, expected7) : "Test 7 failed";
        System.out.println("✅ Test 7 passed: " + Arrays.toString(result7));

        // Test Case 8: Duplicate 1, missing n
        int[] nums8 = {1, 3, 1, 5, 2, 4};
        int[] expected8 = {1, 6};
        int[] result8 = solution.findErrorNums(nums8);
        assert Arrays.equals(result8, expected8) : "Test 8 failed";
        System.out.println("✅ Test 8 passed: " + Arrays.toString(result8));

        System.out.println("\n✅ All validation tests passed!");
    }
}
