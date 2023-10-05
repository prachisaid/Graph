package Graphs;

public class SurroundedRegions {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        int[][] visited = new int[n][m];

        for(int j = 0; j < m; j++){
            if(visited[0][j] == 0 && board[0][j] == 'O')
                dfs(0, j, visited, board, delRow, delCol);

            if(visited[n-1][j] == 0 && board[n-1][j] == 'O')
                dfs(n-1, j, visited, board, delRow, delCol);
        }

        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && board[i][0] == 'O')
                dfs(i, 0, visited, board, delRow, delCol);

            if(visited[m-1][0] == 0 && board[m-1][0] == 'O')
                dfs(i, m-1, visited, board, delRow, delCol);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] != 1 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] visited, char[][] board, int[] delRow, int[] delCol) {
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(nrow, ncol, visited, board, delRow, delCol);
            }
        }
    }
}
