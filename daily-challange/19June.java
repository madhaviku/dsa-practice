You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.
Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: nums = [3,6,1,2,5], k = 2
Output: 2
Approach : Two pointer approach + Greedy
  
class Solution {
    public int partitionArray(int[] nums, int k) {
        int i = 0, j = 1;
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        while(j < n){
            if(nums[j] - nums[i] > k){ 
                count++;
                i = j;
            }
            j++;
        }
        return count+1;
    }
}
