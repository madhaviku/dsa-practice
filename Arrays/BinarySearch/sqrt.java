Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
  The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 
Example 1:
Input: x = 4
Output: 2

  Approach : Binary Search
  class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2, right = (x/2)+1;
        while(left <= right){
            int mid = (left+right)/2;
            long sq = (long) mid*mid;
            if(sq == x) return mid;
            else if(sq < x){
                left = mid+1;
            }else right = mid-1;
        }
        return Math.round(right);
    }
}

Time Complexity : O(Log N);
