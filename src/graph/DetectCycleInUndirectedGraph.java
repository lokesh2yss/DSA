package graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 6;
        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0,1);
        addEdge(graph, 1,2);
        addEdge(graph, 2,3);
        //addEdge(graph, 3,1);
        //addEdge(graph, 4,5);
        //addEdge(graph, 5,1);
        //addEdge(graph, 4,2);
        System.out.println(isCyclePresent(graph));
    }
    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            return dfs(graph, i, visited, -1);
        }
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, int parent) {
        visited[src] = true;
        boolean isCycle = false;
        for(int neighbor: graph.get(src)) {
            if(!visited[neighbor]) {
                isCycle = dfs(graph, neighbor, visited, src);
            }
            else if(parent != neighbor) {
                isCycle = true;
            }
            else {
                isCycle = false;
            }
        }
        return isCycle;
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        if(!graph.get(src).contains(dest)) {
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
    }
}
