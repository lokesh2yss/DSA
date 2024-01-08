package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 6;
        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0,1);
        addEdge(graph, 2,1);
        addEdge(graph, 2,3);
        addEdge(graph, 3,4);
        //addEdge(graph, 4,5);
        //addEdge(graph, 5,1);
        addEdge(graph, 4,2);

        System.out.println(isCyclePresent(graph));
    }
    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] recursionStack = new boolean[V];
        boolean[] visited = new boolean[V];
        for(int i=0;i< V;i++) {
            if(!visited[i]) {
                boolean isCyclePresent = dfs(graph, i,-1, recursionStack, visited);
                if(isCyclePresent) return true;
            }
        }
        return false;
    }
    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int parent, boolean[] recursionStack, boolean[] visited) {
        visited[src] = true;
        recursionStack[src] = true;
        boolean isCyclePresent = false;
        for(int neighbor: graph.get(src)) {
            if(!visited[neighbor]) {
                isCyclePresent = dfs(graph, neighbor, src, recursionStack, visited);
            }
            else {
                if(recursionStack[neighbor]) {
                    isCyclePresent = true;
                }
            }
        }
        recursionStack[src] = false;
        return isCyclePresent;
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        if(!graph.get(src).contains(dest)) {
            graph.get(src).add(dest);
        }
    }
}
