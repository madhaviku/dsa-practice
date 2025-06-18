You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.

Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:

The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2

Output: [[1,1,3],[3,4,5],[7,8,9]]

Explanation:

The difference between any two elements in each array is less than or equal to 2.

Example 2:

Input: nums = [2,4,2,2,5,2], k = 2

Output: []

Approach : Sort the array and follow greedy 
  
class Solution {
    public int[][] divideArray(int[] nums, int k) {
       Arrays.sort(nums);
       // [1,1,3,3,4,5,7,8,9]
       int n = nums.length;
       int idx = 0;
       int[][] ans = new int[n/3][3];
       for(int i = 0; i < n; i+= 3){
        if(nums[i+2] - nums[i] <= k){
            ans[idx][0] = nums[i];
            ans[idx][1] = nums[i+1];
            ans[idx][2] = nums[i+2]; 
            idx++;
        }else return new int[0][];
       }
        return ans;
    }
}

Time Complexity : O(n log n)
