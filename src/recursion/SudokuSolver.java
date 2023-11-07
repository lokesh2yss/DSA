package recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean isSafe(int row, int col, char[][] board, char val) {
        for(int i=0; i<9;i++) {
            //check row
            if(board[row][i] == val) {
                return false;
            }
            //check col
            if(board[i][col] == val) {
                return false;
            }
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] ==val) {
                return false;
            }
        }
        return true;
    }
    public boolean solve(char[][] board) {
        int n = board.length;
        for(int row=0; row < n; row++ ) {
            for(int col = 0; col < n; col++) {
                if(board[row][col] == '.') {
                    for(char val ='1';val<='9';val++) {
                        if(isSafe(row, col, board, val)) {
                            board[row][col] = val;
                            if(solve(board) == true) {
                                return true;
                            }
                            else {
                                //backtrack
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
