package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class TopologicalSortingUsingDFS {
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
        topologicalSortDfs(graph);

    }
    public static void topologicalSortDfs(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        ArrayDeque<Integer> ansStack = new ArrayDeque<>();
        for(int i=0;i< V;i++) {
            if(!visited[i]) {
                dfs(graph, i, ansStack, visited);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!ansStack.isEmpty()) {
            res.add(ansStack.pop());
        }
        System.out.println(res);

    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int cur, ArrayDeque<Integer> ansStack, boolean[] visited) {
        visited[cur] = true;
        for(int neighbor: graph.get(cur)) {
            if(!visited[neighbor]) {
                dfs(graph,neighbor,ansStack,visited);
            }
        }
        ansStack.push(cur);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if(!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            //graph.get(b).add(a);
        }
    }
}
