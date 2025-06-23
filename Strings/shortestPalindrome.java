You are given a string s. You can convert s to a palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.

Example 
Input: s = "aacecaaa"
Output: "aaacecaaa"

Solution : Knuth-Morris-Pratt Algorithm

  class Solution {
    private int[] getLps(String s){
        int[] lps = new int[s.length()];
        int i = 1, len = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0) len = lps[len-1];
                else i++;
            }
        }
        return lps;
    }
    public String shortestPalindrome(String s) {        
        String combined = s + '#' + new StringBuilder(s).reverse().toString();
        int[] lps = getLps(combined);
        int n = lps.length;
        int len = lps[n-1];
        String suffix = new StringBuilder(s.substring(len)).reverse().toString();
        return  suffix + s;
    }
}

Time Complexity: O(N)

  
