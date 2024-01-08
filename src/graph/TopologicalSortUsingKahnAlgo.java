package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingKahnAlgo {
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
        boolean[] visited = new boolean[V];
        System.out.println(topologicalSortUsingKahnAlgo(graph));
    }
    public static ArrayList<Integer> topologicalSortUsingKahnAlgo(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++) {
            for(int a: graph.get(i)) {
                inDegree[a]++;
            }
        }
        for(int i=0;i<V;i++) {
            if(inDegree[i] ==0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for(int neighbor: graph.get(cur)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return ans;
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b) {
        if(!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            //graph.get(b).add(a);
        }
    }
}
