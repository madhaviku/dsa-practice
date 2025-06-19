Maximum Sum Circular Subarray
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:
Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

Solution 1 : Brute-force approach
  
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int curr = 0;
            for(int j = 0; j < n; j++){
                int idx = (i+j)%n;
                    curr = Math.max(nums[idx], curr+nums[idx]);
                    sum = Math.max(sum, curr);
            }
        }
        return sum;
    }
}

Time Complexity  : O(n^2)

Solution 2 : 

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
         int minSum = Integer.MAX_VALUE;
         int maxSum = Integer.MIN_VALUE;
         int total = 0;
         int currMin = 0;
         int currMax = 0;

         for(int i = 0; i < nums.length; i++){
            total += nums[i];
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(currMin, minSum);

            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(currMax, maxSum);
         }

         if(maxSum < 0) return maxSum;
         return Math.max(maxSum, total-minSum);        
    }
}
Time Complexity  : O(n)
