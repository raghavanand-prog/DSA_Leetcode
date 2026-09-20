class Solution {
    /**
     * Find the duplicate and missing number in an array containing 1 to n.
     *
     * Algorithm: Use a boolean array to track presence of each number
     * - Create a seen array of size n+1
     * - Iterate through nums:
     *   - If nums[i] already marked, it's the duplicate
     *   - Mark nums[i] as seen
     * - Find which number from 1 to n is not marked (missing)
     * - Return [duplicate, missing]
     *
     * Example: nums = [1,2,2,4] → ans = [2,3]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        int duplicate = 0;
        int missing = 0;

        // Find the duplicate number
        for (int num : nums) {
            if (seen[num]) {
                duplicate = num;
            }
            seen[num] = true;
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
