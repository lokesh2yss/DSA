package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfConnectedComponentsInGraph {
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
        int numConnectedComponents = 0;
        for(int i=0; i< V;i++) {
            if(!visited[i]) {
                numConnectedComponents++;
                dfs(graph, i, ans, visited);
            }
        }

        System.out.println(ans);
        System.out.println(numConnectedComponents);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if(!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph, int src, ArrayList<Integer> ans, boolean[] visited) {
        int V = graph.size();
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for(int neighbor: graph.get(cur)) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, ArrayList<Integer> ans, boolean[] visited) {
        visited[src] = true;
        ans.add(src);
        for(int neighbor: graph.get(src)) {
            if(!visited[neighbor]) {
                dfs(graph, neighbor,ans,visited);
            }
        }
    }
}
