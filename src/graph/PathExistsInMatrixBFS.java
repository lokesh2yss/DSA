package graph;

import java.util.LinkedList;
import java.util.Queue;

public class PathExistsInMatrixBFS {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,3,1,0},
                {3,0,3,3},
                {2,3,0,3},
                {0,3,3,3}
        };
        System.out.println(doesPathExistBFS(matrix));
    }
    public static boolean doesPathExistBFS(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Cell> q = new LinkedList<>();
        boolean breakLoop = false;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(matrix[i][j] == 1) {
                    q.offer(new Cell(i,j));
                    breakLoop = true;
                    break;
                }
            }
            if(breakLoop) break;
        }
        while(!q.isEmpty()) {
            Cell cur = q.poll();
            visited[cur.x][cur.y] = true;
            if(matrix[cur.x][cur.y] == 2) return true;
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};
            for(int index =0; index < 4; index++) {
                int nextI = cur.x + x[index];
                int nextJ = cur.y + y[index];
                if(isSafe(matrix, nextI, nextJ, visited)) {
                    q.offer(new Cell(nextI, nextJ));
                }
            }

        }
        return false;
    }
    public static boolean isSafe(int[][] matrix, int i, int j, boolean[][] visited) {
        int row = matrix.length;
        int col = matrix[0].length;
        return i>=0 && j>= 0 && i<row && j < col && matrix[i][j] != 0 && !visited[i][j];
    }
}
class Cell {
    int x, y;
    public Cell(int i, int j) {
        this.x = i;
        this.y = j;
    }
}
