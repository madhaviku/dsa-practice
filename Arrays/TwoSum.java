Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Approach :  HashMap to store indices. (I could have used two pointer approach but since I need to return the index of the elements, I dont want to sort it)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
Time Complexity : O(N);

If I want to return the two numbers that sum up to target

Approach : Two Pointer (works when array is sorted.)
    
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum == target){
                return new int[]{nums[start], nums[end]};
            }else if(sum < target) start++;
            else end--;
        }
        return new int[0];
    }
}

Time Complexity : O(NLogN)
