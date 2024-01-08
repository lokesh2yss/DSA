package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
        System.out.println(bfs(graph,0));
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if(!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph, int src) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
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
        return ans;
    }
}
