package graph;

import heapanddisjointset.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;

public class MSTKruksalAlgo {
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
        System.out.println(MinimumSpanningTreeKruksal(graph));

    }
    public static int MinimumSpanningTreeKruksal(ArrayList<ArrayList<Pair>> graph) {
        int V = graph.size();
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<V;i++) {
            ArrayList<Pair> list = graph.get(i);
            for(Pair p: list) {
                edges.add(new Edge(i, p.v, p.wt));
            }
        }
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        int ans = 0;
        int count = 0;
        for(Edge cur: edges) {
            int findSrc = ds.find(cur.src);
            int findDst = ds.find(cur.dst);
            if(findSrc != findDst) {
                ans += cur.wt;
                count++;
                if(count == V-1) break;
                ds.union(cur.src, cur.dst);
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

class Edge implements Comparable<Edge> {
    int src, dst, wt;
    public Edge(int s, int d, int w) {
        this.src = s;
        this.dst = d;
        this.wt = w;
    }
    public int compareTo(Edge that) {
        return this.wt - that.wt;
    }
}
class Pair implements Comparable<Pair> {
    int v, wt;
    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
    public int compareTo(Pair that) {
        return this.wt - that.wt;
    }
}
