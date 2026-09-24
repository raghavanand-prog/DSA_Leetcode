/**
 * Problem: Smallest Index with Digit Sum Equal to Index
 * LeetCode: Daily Question (2026-09-24)
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given an array nums, find the smallest index i such that the sum of the digits 
 * of nums[i] equals i. If no such index exists, return -1.
 * 
 * The digit sum is the sum of all digits in the decimal representation of a number.
 * For example: digit_sum(234) = 2 + 3 + 4 = 9
 * 
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 10^9
 */

public class Solution {
    public int smallestIndex(int[] nums) {
        // Iterate through each index
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = 0;
            
            // Calculate digit sum of nums[i]
            while (n > 0) {
                sum += n % 10;  // Add last digit
                n /= 10;        // Remove last digit
            }
            
            // Check if digit sum equals index
            if (sum == i) {
                return i;  // Return immediately (smallest index)
            }
        }
        
        // No matching index found
        return -1;
    }
}
