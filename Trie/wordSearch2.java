Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
  The same letter cell may not be used more than once in a word.

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
  words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

class Trie{
    Trie[] child;
    boolean eow;
    String str;
    Trie(){
        child = new Trie[26];
        str = "";
    }
}

class Solution {
    Trie root = new Trie();
    List<String> all = new ArrayList<>();
    char[][] board; String[] words;
    private void constructTrie(String word){
        Trie curr = root;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new Trie();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
        curr.str = word;
    }
    private void search(int i, int j, int idx, Trie root){
        if(root.eow == true && !all.contains(root.str)){
            all.add(root.str); 
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') return;

        char c = board[i][j];
        int index = c - 'a';

        if(root.child[index] == null) return;

        Trie curr = root.child[index];
        board[i][j] = '#';

        search(i+1, j, idx+1, curr);
        search(i, j+1, idx+1, curr);
        search(i-1, j, idx+1, curr);
        search(i, j-1, idx+1, curr);

        board[i][j] = c;

    }
    public List<String> findWords(char[][] board, String[] words) { 
        this.board = board;
        this.words = words;
        for(String word : words){
            constructTrie(word);
        }
        for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[0].length; j++){
               search(i, j, 0, root);
           }
        } 
        return all;
    }
}
