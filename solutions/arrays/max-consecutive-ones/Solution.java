class Solution {
    /**
     * Find the maximum number of consecutive 1's in a binary array.
     *
     * Algorithm: Single pass through array tracking current and max consecutive 1's count
     * - When we encounter 1: increment current count
     * - When we encounter 0: reset current count and update max
     * - Return the maximum count found
     *
     * Example: nums = [1,1,0,1,1,1] → ans = 3
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;      // Track maximum consecutive 1's
        int currentCount = 0;  // Track current consecutive 1's

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}
