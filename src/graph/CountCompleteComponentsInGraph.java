package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteComponentsInGraph {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };
        System.out.println(countCompleteComponents(4, edges));
    }
    public static int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        System.out.println(graph);
        boolean[] visited = new boolean[n];
        int count = 0;
        int components = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                components++;
                if(bfs(graph, i, visited)) count++;
            }
        }
        System.out.println("AAAA"+components);
        return count;
    }
    public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        int nodeCountInThisComponent = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            nodeCountInThisComponent++;
            for(int neighbor: graph.get(cur)) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        //System.out.println(Arrays.toString(visited));
        //System.out.println(nodeCountInThisComponent);
        boolean[] visitedInSubGraph = new boolean[graph.size()]; //cannot take nodeCountInThisComponent as v may be any thing upto n and there may be indexOutOfBoundsException
        q.clear();
        q.offer(v);
        visitedInSubGraph[v] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(graph.get(cur).size() != nodeCountInThisComponent -1) return false;
            for(int neighbor: graph.get(cur)) {
                if(!visitedInSubGraph[neighbor]) {
                    q.offer(neighbor);
                    visitedInSubGraph[neighbor] = true;
                }
            }
        }
        return true;
    }
}
