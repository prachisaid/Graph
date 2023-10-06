package Graphs;

public class NoOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}
        };

        System.out.println(new NoOfEnclaves().numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int enclaves = 0;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        int[][] visited = new int[n][m];

        for(int i = 0; i < m; i++){
            if(visited[0][i] == 0 && grid[0][i] == 1)
                dfs(0, i, visited, grid, delRow, delCol);

            if(visited[n-1][i] == 0 && grid[n-1][i] == 1)
                dfs(n-1, i, visited, grid, delRow, delCol);
        }

        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && grid[i][0] == 1)
                dfs(i, 0, visited, grid, delRow, delCol);

            if(visited[i][m-1] == 0 && grid[i][m-1] == 1)
                dfs(i, m-1, visited, grid, delRow, delCol);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] != 1 && grid[i][j] == 1){
                    enclaves += 1;
                }
            }
        }

        return enclaves;
    }

    private void dfs(int row, int col, int[][] visited, int[][] board, int[] delRow, int[] delCol) {
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 1){
                dfs(nrow, ncol, visited, board, delRow, delCol);
            }
        }
    }
}
