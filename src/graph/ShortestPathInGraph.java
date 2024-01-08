package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGraph {
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
        //System.out.println(shortestPathLength(graph, 3, 0));
        System.out.println(shortestPath(graph, 4, 2));
    }
    public static ArrayList<Integer> shortestPath(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        int V = graph.size();
        int[] predecessor = new int[V];
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        predecessor[src] = -1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int neighbor: graph.get(cur)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                    predecessor[neighbor] = cur;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(dest != -1) {
            ans.add(0,dest);
            dest = predecessor[dest];
        }
        return ans;
    }
    public static int shortestPathLength(ArrayList<ArrayList<Integer>> graph, int src, int dest) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        dist[src] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int neighbor: graph.get(cur)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                    dist[neighbor] = dist[cur] + 1;
                    if(neighbor == dest) return dist[neighbor];
                }
            }
        }
        return dist[src];
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if(!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
}
