Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
  The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, 
  she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, 
  she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
  
Input: piles = [3,6,7,11], h = 8
Output: 4

class Solution {
    private boolean canEat(int mid, int[] piles, int h){
        int total = 0;
        for(int pile : piles){
            total += Math.ceil((double)pile/mid);
        }
        return total <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1, j = 0;
        for(int pile : piles) j = Math.max(j, pile);

        while(i <= j){
            int mid = (i+j)/2;
            if(canEat(mid, piles, h)){
                j = mid-1;
            }else i = mid+1;
        }
        return i;
    }
}

Time Complexity : O(N Log N)
