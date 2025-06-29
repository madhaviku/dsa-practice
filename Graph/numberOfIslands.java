Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Solution 
  
class Solution {
    int[][] dir = {{0,1},{1,0}, {0,-1}, {-1,0}};
    private void map(char[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return;
        }

        visited[i][j] = true;
        grid[i][j] = '0';

        for(int[] d : dir){
            int r = i + d[0];
            int c = j + d[1];
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visited[r][c] && grid[r][c] == '1'){
                map(grid, r, c, visited);
            }
        } 
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    map(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
}
