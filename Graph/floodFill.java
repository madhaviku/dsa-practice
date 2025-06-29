Flood Fill

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. 
You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:
Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.


Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

class Solution {
    int[][] image;
    int color;
    int[][] dir = {{0,1}, {1,0}, {-1, 0},{0,-1}};
    private void fillFlood(int r, int c){
        if(r < 0 || c < 0 || c >= image[0].length || r >= image.length) return;

        int clr = image[r][c];
        image[r][c] = color;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == clr){
                fillFlood(nr, nc);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.color = color;
        if(image[sr][sc] == color) return image;

        fillFlood(sr, sc);
        return image;
    }
}
