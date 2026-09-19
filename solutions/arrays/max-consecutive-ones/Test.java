public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Example 1
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int expected1 = 3;
        int result1 = solution.findMaxConsecutiveOnes(nums1);
        assert result1 == expected1 : "Test 1 failed: expected " + expected1 + ", got " + result1;
        System.out.println("✅ Test 1 passed: " + result1);

        // Test Case 2: Example 2
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        int expected2 = 2;
        int result2 = solution.findMaxConsecutiveOnes(nums2);
        assert result2 == expected2 : "Test 2 failed: expected " + expected2 + ", got " + result2;
        System.out.println("✅ Test 2 passed: " + result2);

        // Test Case 3: All 1's
        int[] nums3 = {1, 1, 1, 1, 1};
        int expected3 = 5;
        int result3 = solution.findMaxConsecutiveOnes(nums3);
        assert result3 == expected3 : "Test 3 failed: expected " + expected3 + ", got " + result3;
        System.out.println("✅ Test 3 passed: " + result3);

        // Test Case 4: Single 1
        int[] nums4 = {1};
        int expected4 = 1;
        int result4 = solution.findMaxConsecutiveOnes(nums4);
        assert result4 == expected4 : "Test 4 failed: expected " + expected4 + ", got " + result4;
        System.out.println("✅ Test 4 passed: " + result4);

        // Test Case 5: All 0's
        int[] nums5 = {0, 0, 0, 0};
        int expected5 = 0;
        int result5 = solution.findMaxConsecutiveOnes(nums5);
        assert result5 == expected5 : "Test 5 failed: expected " + expected5 + ", got " + result5;
        System.out.println("✅ Test 5 passed: " + result5);

        // Test Case 6: 1's at end
        int[] nums6 = {0, 0, 1, 1, 1, 1};
        int expected6 = 4;
        int result6 = solution.findMaxConsecutiveOnes(nums6);
        assert result6 == expected6 : "Test 6 failed: expected " + expected6 + ", got " + result6;
        System.out.println("✅ Test 6 passed: " + result6);

        // Test Case 7: 1's at start
        int[] nums7 = {1, 1, 1, 0, 0, 0};
        int expected7 = 3;
        int result7 = solution.findMaxConsecutiveOnes(nums7);
        assert result7 == expected7 : "Test 7 failed: expected " + expected7 + ", got " + result7;
        System.out.println("✅ Test 7 passed: " + result7);

        // Test Case 8: Multiple groups, max in middle
        int[] nums8 = {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1};
        int expected8 = 5;
        int result8 = solution.findMaxConsecutiveOnes(nums8);
        assert result8 == expected8 : "Test 8 failed: expected " + expected8 + ", got " + result8;
        System.out.println("✅ Test 8 passed: " + result8);

        System.out.println("\n✅ All validation tests passed!");
    }
}
