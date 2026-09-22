/**
 * LeetCode Problem #3525: Find X Value of Array II
 * Difficulty: Hard
 * 
 * Problem: Given an array of integers, a positive integer k, and a 2D queries array,
 * for each query, update an element and then count the number of ways to remove
 * a prefix and suffix such that the product of remaining elements mod k equals x,
 * and the remaining array is non-empty.
 */
public class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int[] result = new int[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];
            
            // Step 1: Update nums[index] = value (persists for remaining queries)
            nums[index] = value;
            
            // Step 2: Remove prefix [0..start-1], leaving [start..n-1]
            // Step 3: Count ways to remove suffixes such that product % k == x
            
            int count = 0;
            
            // Try all possible suffix removals
            // suf_len = 0 means remove empty suffix (keep all)
            // suf_len < (nums.length - start) ensures remaining array is non-empty
            for (int suf_len = 0; suf_len < nums.length - start; suf_len++) {
                // Remaining array: [start .. nums.length - 1 - suf_len]
                int end = nums.length - suf_len;
                
                // Calculate product of elements from start to end-1
                long product = 1;
                for (int i = start; i < end; i++) {
                    product *= nums[i];
                }
                
                // Check if product % k equals x
                if (product % k == x) {
                    count++;
                }
            }
            
            result[q] = count;
        }
        
        return result;
    }
}
