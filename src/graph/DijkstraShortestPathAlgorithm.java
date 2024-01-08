package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraShortestPathAlgorithm {
    public static void main(String[] args) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int V = 6;
        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1,1);
        addEdge(graph,1,2,2);
        addEdge(graph,3,4,2);
        addEdge(graph,2,3,3);
        addEdge(graph,3,5,6);
        addEdge(graph,5,0,9);
        addEdge(graph,0,4,1);
        addEdge(graph,4,1,2);
        addEdge(graph,3,1,3);
        addEdge(graph,5,1,5);
        addEdge(graph,5,4,6);
        System.out.println(Arrays.toString(dijkstraShortestPathAlgo(graph,0)));
    }
    public static int[] dijkstraShortestPathAlgo(ArrayList<ArrayList<Pair>> graph, int src) {
        int V = graph.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        pq.offer(new Pair(src, 0));
        for(int i=0;i<V;i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        ans[src] = 0;
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(visited[cur.v]) continue;
            visited[cur.v] = true;
            ArrayList<Pair> neighbors = graph.get(cur.v);
            for(Pair neighbor: neighbors) {
                if(!visited[neighbor.v]) {
                    ans[neighbor.v] = Math.min(ans[neighbor.v], ans[cur.v] + neighbor.wt);
                    pq.offer(new Pair(neighbor.v, ans[neighbor.v]));
                }
            }
        }
        return ans;
    }
    public static void addEdge(ArrayList<ArrayList<Pair>> graph, int src, int dst, int weight) {
        if(!graph.get(src).contains(dst)) {
            graph.get(src).add(new Pair(dst, weight));
            graph.get(dst).add(new Pair(src, weight));
        }
    }
}
