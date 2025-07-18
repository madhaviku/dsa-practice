Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Solution: Binary search approach

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start = 0, end = nums.length-1;
        // sorted array
        if(nums[start] < nums[end]) return nums[start];

        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            if(nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[start] < nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return Integer.MAX_VALUE;
    }
}

Time Complexity : O(log n)
