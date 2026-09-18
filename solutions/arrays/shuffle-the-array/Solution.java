class Solution {
    /**
     * Shuffle array from form [x1,x2,...,xn,y1,y2,...,yn]
     * to form [x1,y1,x2,y2,...,xn,yn]
     * 
     * Example: [2,5,1,3,4,7], n=3 → [2,3,5,4,1,7]
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) excluding output array
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];           // Place x[i] at even index
            result[2 * i + 1] = nums[n + i];   // Place y[i] at odd index
        }
        
        return result;
    }
}
