package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MSTPrimsAlgo {
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
        System.out.println(MinimumSpanningTreePrimsAlgorithm(graph));
    }
    public static int MinimumSpanningTreePrimsAlgorithm(ArrayList<ArrayList<Pair>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int V = graph.size();
        boolean[] visited = new boolean[V];
        int ans = 0;
        int count = 0;
        pq.offer(new Edge(-1,0,0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            //if(count == V-1) break;
            if(!visited[cur.dst]) {
                ans += cur.wt;
                count++;
                visited[cur.dst] = true;
                for(Pair neighbor: graph.get(cur.dst)) {
                    if(!visited[neighbor.v]) {
                        pq.offer(new Edge(cur.dst, neighbor.v, neighbor.wt));
                    }
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
