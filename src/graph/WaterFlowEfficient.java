package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WaterFlowEfficient {
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
        int[][] result = new int[row][col];
        boolean[][] visited1 = new boolean[row][col];
        boolean[][] visited2 = new boolean[row][col];
        for(int i=0;i<col;i++) {
            bfs(matrix, 0, i, result, true, visited1);
        }
        for(int i=0;i<row;i++) {
            bfs(matrix, i, 0, result, true, visited1);
        }
        for(int i=0;i<col;i++) {
            bfs(matrix, row-1, i, result, false, visited2);
        }
        for(int i=0;i<row;i++) {
            bfs(matrix, i, col-1, result, false, visited2);
        }
        for(int i =0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(result[i][j]==2) ans +=1;
            }
        }
        return ans;
    }
    public static boolean isSafe(int[][] matrix, int i, int j, boolean[][] visited) {
        int row = matrix.length;
        int col = matrix[0].length;
        return i>=0 && i <row && j >= 0 && j < col && !visited[i][j];
    }
    public static void bfs(int[][] matrix, int i, int j, int[][] result, boolean topLeft, boolean[][] visited) {
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(i, j));
        while(!q.isEmpty()) {
            Cell cur = q.poll();
            if(visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            result[cur.x][cur.y] += 1;
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};
            int startIndex = topLeft ? 0 : 2;
            int endIndex = topLeft ? 2 : 4;
            for (int index = startIndex; index < endIndex; index++) {
                int nextI = cur.x + x[index];
                int nextJ = cur.y + y[index];
                if (isSafe(matrix, nextI, nextJ, visited) && matrix[nextI][nextJ] >= matrix[cur.x][cur.y]) {
                    q.offer(new Cell(nextI, nextJ));
                }
            }
        }
    }
}
