package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CaptureRegionsOnBoard {
    public static void main(String[] args) {
        char[][] A = {
                {'X','X','O','X'},
                {'X','O','O','O'},
                {'X','X','O','X'},
                {'X','O','O','X'}
        };
        char[][] B = captureRegionsOnBoard(A);
        for(int i=0;i<B.length;i++) {
            for(int j=0;j<B[0].length;j++) {
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.println(Arrays.toString());
    }
    public static char[][] captureRegionsOnBoard(char[][] A) {
        int row = A.length;
        int col = A[0].length;
        for(int i=0;i<col;i++) {
            if(A[0][i] == 'O') {
                bfs(A, 0, i);
            }
        }
        for(int i=1;i<row;i++) {
            if(A[i][col-1] == 'O') {
                bfs(A, i, col-1);
            }
        }
        for(int i=col-2;i >0;i--) {
            if(A[row-1][i] == 'O') {
                bfs(A, row-1, i);
            }
        }
        for(int i=row-1;i>0;i--) {
            if(A[i][0] == 'O') {
                bfs(A, i, 0);
            }
        }
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(A[i][j] == 'A') A[i][j] = 'O';
                else if(A[i][j] =='O') A[i][j] = 'X';
            }
        }
        return A;
    }
    public static boolean isSafe(char[][] A, int i, int j, boolean[][] visited) {
        int row = A.length;
        int col  = A[0].length;
        return i>=0 && i < row && j >= 0 && j < col && A[i][j] == 'O' && !visited[i][j];
    }
    public static void bfs(char[][] A, int i, int j) {
        Queue<Cell> q = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        q.offer(new Cell(i, j));
        while(!q.isEmpty()) {
            Cell cur = q.poll();
            visited[cur.x][cur.y] = true;
            A[cur.x][cur.y] = 'A';
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};
            for(int index = 0; index < 4; index++) {
                int nextI = cur.x + x[index];
                int nextJ = cur.y + y[index];
                if(isSafe(A, nextI, nextJ, visited)) {
                    q.offer(new Cell(nextI, nextJ));
                }
            }
        }
    }
}
