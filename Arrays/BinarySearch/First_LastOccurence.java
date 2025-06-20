Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Approach : Binary Search

class Solution {
    public int firstPos(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int idx = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] >= target){
                if(nums[mid] == target) idx = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return idx;
    }
    public int lastPos(int[] nums, int target){
        int start = 0, end = nums.length-1; 
        int idx = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] <= target){
                 if(nums[mid] == target) idx = mid;
                start = mid+1;
            }else end = mid-1;
        }

        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];

        pos[0] = firstPos(nums, target);
        pos[1] = lastPos(nums, target);

        return pos;
    }
}

Time Complexity : O(Log N);
