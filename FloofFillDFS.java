package Graphs;

public class FloofFillDFS {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {2, 2, 0},
                {2, 2, 2}
        };

        int[][] ans = floodFill(image, 2, 0, 3);

        for(int[] i : ans){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int[][] ans = image;
        int inital = ans[sr][sc];

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        dfs(sr, sc, image, ans, color, inital, delRow, delCol);
        return ans;
    }

    private static void dfs(int row, int col, int[][] image, int[][] ans, int newColor, int inColor, int[] delRow, int[] delCol){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i = 0; i < delRow.length; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == inColor && ans[nrow][ncol] != newColor){
                dfs(nrow, ncol, image, ans, newColor, inColor, delRow, delCol);
            }
        }
    }
}
