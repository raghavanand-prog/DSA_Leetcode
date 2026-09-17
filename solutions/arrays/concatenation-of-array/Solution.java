class Solution {
    /**
     * Create an array of length 2n where the first n elements are nums
     * and the next n elements are also nums (concatenation).
     * 
     * Example: nums = [1,2,1] → ans = [1,2,1,1,2,1]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) excluding output array
     */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        // Copy original array to first half
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        
        // Copy original array to second half
        for (int i = 0; i < n; i++) {
            ans[i + n] = nums[i];
        }
        
        return ans;
    }
}
