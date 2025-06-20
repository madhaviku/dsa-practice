There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, 
  nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such 
  that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Approach : Binary Search

class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                if(nums[mid+1] <= target && target < nums[j]) i = mid+1;
                else j = mid-1;
            }else{
                if(nums[i] <= target && target < nums[mid]){
                    j = mid-1;
                }else i = mid+1; 
            }
        }
        return -1;
    }
}

Time Complexity : O(Log N)
