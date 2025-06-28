Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
  The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

  class Trie{
        Trie[] child;
        boolean eow;
        Trie(){
            child = new Trie[52]; 
            eow = false;
        }
    }
class Solution {    
    char[][] board; String word;
    Trie root = new Trie();
    private void constructTrie(String word){
        Trie curr = root;
        for(char c : word.toCharArray()){
            int idx = c - 'A';
            if (Character.isUpperCase(c)) {
                idx = c - 'A';         // 0 to 25
            } else {
                idx = 26 + (c - 'a');  // 26 to 51
            }
            if(curr.child[idx] == null){
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx]; 
        }
        curr.eow = true;
    }
    private boolean search(int i, int j, int idx, Trie root){
        if(idx == word.length() ) return root.eow;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return false;

        char c = board[i][j];
        int index = 0;
        if (Character.isUpperCase(c)) {
            index = c - 'A';         // 0 to 25
        } else {
            index = 26 + (c - 'a');  // 26 to 51
        }
        
        if(root.child[index] == null) return false;

        board[i][j] = '#';
        Trie curr = root.child[index];

        boolean found = search(i+1, j, idx+1, curr) || search(i, j+1, idx+1, curr) || search(i-1, j, idx+1, curr) || search(i, j-1, idx+1, curr);

        board[i][j] = c;

        return found;         
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        constructTrie(word);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(search(i, j, 0, root)) return true;
            }
        }
        return false;
    }
}
