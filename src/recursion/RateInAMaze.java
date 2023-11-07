package recursion;
import java.util.*;
public class RateInAMaze {
        public static ArrayList < String > findPath(int[][] arr, int n) {
            if(arr[0][0] ==0) return new ArrayList<String>();
            boolean[][] visited = new boolean[n][n];
            ArrayList<String> ans = new ArrayList<String>();
            visited[0][0] = true;
            ratInMaze(arr,n,visited,"", ans, 0,0);
            return ans;
        }

        public static void ratInMaze(int[][] arr, int n, boolean[][] visited, String  path, ArrayList<String> ans, int i, int j) {
            if(i==n-1 && j == n-1) {
                ans.add(path);
                return;
            }
            //move D,L,R,U
            //move down
            if(isValid(arr,n,i+1,j,visited)) {
                visited[i+1][j] = true;
                ratInMaze(arr,n,visited,path+"D",ans,i+1,j);
                visited[i+1][j] = false; //backtracking step
            }
            //move Left
            if(isValid(arr,n,i,j-1,visited)) {
                visited[i][j-1] = true;
                ratInMaze(arr,n,visited,path+"L",ans,i,j-1);
                visited[i][j-1] = false; //backtracking step
            }
            //move Right
            if(isValid(arr,n,i,j+1,visited)) {
                visited[i][j+1] = true;
                ratInMaze(arr,n,visited,path+"R",ans,i,j+1);
                visited[i][j+1] = false; //backtracking step
            }
            //move Up
            if(isValid(arr,n,i-1,j,visited)) {
                visited[i-1][j] = true;
                ratInMaze(arr,n,visited,path+"U",ans,i-1,j);
                visited[i-1][j] = false; //backtracking step
            }
        }
        public static boolean isValid(int[][] arr, int n, int i, int j, boolean[][] visited) {
            return i>=0 && j >=0 && i < n && j < n && arr[i][j] == 1 && !visited[i][j];
        }
    }
