package graph;

public class PathExistsInMatrixDFS {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,3,1,0},
                {3,0,3,3},
                {2,3,0,3},
                {0,3,3,3}
        };
        System.out.println(doesPathExist(matrix));
    }
    public static boolean doesPathExist(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length ;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    return dfs(matrix, i, j, visited);
                }
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] matrix, int i, int j, boolean[][] visited) {
        int row  = matrix.length;
        int col = matrix[0].length;
        return i>=0 && i < row && j >=0 && j<col && matrix[i][j] != 0 && !visited[i][j];
    }
    public static boolean dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if(!isSafe(matrix, i, j, visited)) return false;
        if(matrix[i][j] == 2) {
            return true; //found path;
        }
        visited[i][j] = true;
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        for(int index = 0; index<4;index++) {
            int nextI = i + x[index];
            int nextJ = j + y[index];
            if(dfs(matrix, nextI, nextJ, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
