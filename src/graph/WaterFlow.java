package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WaterFlow {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(countCells(matrix));
    }
    public static int countCells(int[][] matrix) {
        int ans= 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(bfs(matrix, i, j)) ans += 1;
            }
        }
        return ans;
    }
    public static boolean isSafe(int[][] matrix, int i, int j, boolean[][] visited) {
        int row = matrix.length;
        int col = matrix[0].length;
        return i>=0 && i <row && j >= 0 && j < col && !visited[i][j];
    }
    public static boolean bfs(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(i, j));
        boolean leftTop = false;
        boolean rightBottom = false;
        while(!q.isEmpty()) {
            Cell cur = q.poll();
            visited[cur.x][cur.y] = true;
            if(cur.x == 0 || cur.y==0) leftTop = true;
            if(cur.x == row-1 || cur.y == col-1) rightBottom = true;
            if(leftTop && rightBottom) return true;
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};
            for(int index = 0; index<4;index++) {
                int nextI = cur.x + x[index];
                int nextJ = cur.y + y[index];
                if(isSafe(matrix, nextI, nextJ, visited) && matrix[nextI][nextJ] <= matrix[cur.x][cur.y]) {
                    q.offer(new Cell(nextI, nextJ));
                }
            }
        }
        return false;
    }
}
