package Graphs;

public class ReplaceOWithX {
    public static void main(String[] args) {

    }

    public void solve (char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];
        int [] delRow = {-1, 0, 1, 0};
        int [] delCol = {0, 1, 0, -1};

        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O' && visited[0][i] == 0) {
                dfs(0, i, visited, board, delRow, delCol);
            }

            if(board[n-1][i] == 'O' && visited[n-1][i] == 0) {
                dfs(n-1, i, visited, board, delRow, delCol);
            }
        }

        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(i, 0, visited, board, delRow, delCol);
            }

            if(board[m-1][i] == 'O' && visited[m-1][i] == 0) {
                dfs(m-1, i, visited, board, delRow, delCol);
            }
        }

        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int row, int col, int[][] visited, char[][] board, int[] delRow, int[] delCol) {
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, visited, board, delRow, delCol);
            }
        }
    }

}
