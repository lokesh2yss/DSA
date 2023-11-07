package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> ans = new ArrayList<List<String>>();
        int[][] board = new int[n][n];
        int row = 0;
        solve(row, board, ans, n);
        return ans;
    }
    public boolean isSafe(int row, int col, int[][] board, int n) {
        //check up-column
        int x = row;
        int y = col;
        while(x >=0) {
            if(board[x][y] ==1) {
                return false;
            }
            x--;
        }
        //check upper left diagonal
        x = row;
        y = col;
        while(x >=0 && y>=0) {
            if(board[x][y] ==1) {
                return false;
            }
            x--;
            y--;
        }
        //check upper right diagonal
        x = row;
        y = col;
        while(x >=0 && y < n) {
            if(board[x][y] ==1) {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
    public void addSolution(int[][] board, List<List<String>> ans, int n ) {
        List<String> solution = new ArrayList<String>();
        for(int i=0; i<n; i++) {
            String temp = "";
            for(int j=0; j < n; j++) {
                if(board[i][j] ==1) {
                    temp += "Q";
                }
                else {
                    temp +=".";
                }
            }
            solution.add(temp);
        }
        ans.add(solution);
    }
    public boolean solve(int row, int[][] board, List<List<String>> ans, int n ) {
        if(row>=n) {
            addSolution(board, ans, n);
            return true;
        }
        for(int col=0; col < n ; col++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 1;
                solve(row+1, board, ans, n);
                board[row][col] = 0;
          /*if(solve(row+1, board, ans, n)) {
            return true;
          }
          else {
            board[row][col] = 0;
          }*/
            }
        }
        return false;
    }
}
