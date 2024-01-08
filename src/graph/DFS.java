package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 1,5);
        addEdge(graph, 2,5);
        addEdge(graph, 5,7);
        addEdge(graph, 7,4);
        addEdge(graph, 7,6);
        addEdge(graph, 6,3);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        /*for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(graph, i, ans, visited);
            }
        }*/
        System.out.println(dfsIterative(graph, 0, visited));
        //System.out.println(ans);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if(!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    public static ArrayList<Integer> dfsIterative(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        int V = graph.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(src);
        visited[src] = true;
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            ans.add(cur);
            for(int neighbor: graph.get(cur)) {
                if(!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, ArrayList<Integer> ans, boolean[] visited)  {
        int V = graph.size();
        if(ans.size() == V) return;
        visited[src] = true;
        ans.add(src);
        for(int neighbor: graph.get(src)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor, ans, visited);
            }
        }
    }
}
