You have n coins and you want to build a staircase with these coins. 
  The staircase consists of k rows where the ith row has exactly i coins. 
  The last row of the staircase may be incomplete.
Given the integer n, return the number of complete rows of the staircase you will build.

class Solution {
    private int getLevels(int level, int coins){
        if(level > coins) return level -1;
        return getLevels(level+1, coins - level);
    }
    public int arrangeCoins(int n) {
        return getLevels(1, n);
    }
}

Time Complexity : O(Log N)
