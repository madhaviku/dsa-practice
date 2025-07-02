Palindromic Substrings

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

class Solution {
    String s;
    int count = 0;
    Set<String> visited = new HashSet<>();
    private boolean isPalindrome(int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    private void allPals(int start, int end){
        if(start > end) return;

        String key = start + "_" + end;
        if (visited.contains(key)) return;
        visited.add(key);

        if(isPalindrome(start, end)){
            count++;
        }

        allPals(start, end-1);
        allPals(start+1, end);
    }
    public int countSubstrings(String s) {
      this.s = s;
      if(s.length() == 1) return 1;
      allPals(0, s.length()-1);
      return count;  
    }
}
