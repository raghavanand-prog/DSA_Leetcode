/**
 * Problem: Minimum Operations to Reduce X to Zero
 * LeetCode: #1658
 * Difficulty: Medium
 * 
 * Problem Statement:
 * You are given an integer array nums and an integer x. In one operation, you can either 
 * remove the leftmost or the rightmost element from the array and subtract its value from x.
 * Your goal is to make x equal to zero using the minimum number of operations.
 * Return the minimum number of operations needed to reduce x to zero. 
 * If it is impossible, return -1.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 * - 1 <= x <= 10^9
 */

public class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        
        long target = total - x;
        
        if (target < 0) {
            return -1;
        }
        
        if (target == 0) {
            return n;
        }
        
        int left = 0;
        long sum = 0;
        int maxLen = -1;
        
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            
            while (sum > target && left <= right) {
                sum -= nums[left++];
            }
            
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen == -1 ? -1 : n - maxLen;
    }
}
