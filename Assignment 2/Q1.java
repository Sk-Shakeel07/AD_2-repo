package assignment2;
import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
   
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class DisjointSet {
    private int[] parent, rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
           
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}


public class Q1 {
	 public static List<Edge> kruskal(int numVertices, List<Edge> edges) {
	        Collections.sort(edges);
	        DisjointSet ds = new DisjointSet(numVertices);
	        List<Edge> mst = new ArrayList<>();

	        for (Edge edge : edges) {
	            int u = edge.src;
	            int v = edge.dest;

	            if (ds.find(u) != ds.find(v)) {
	                ds.union(u, v);
	                mst.add(edge);
	            }
	        }
	        return mst;
	    }
	public static void main(String[] args) {
		  int numVertices = 4;
	        List<Edge> edges = new ArrayList<>();
	        edges.add(new Edge(0, 1, 10));
	        edges.add(new Edge(0, 2, 6));
	        edges.add(new Edge(0, 3, 5));
	        edges.add(new Edge(1, 3, 15));
	        edges.add(new Edge(2, 3, 4));

	        List<Edge> mst = kruskal(numVertices, edges);

	        System.out.println("Edges in the Minimum Spanning Tree:");
	        for (Edge edge : mst) {
	            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
	        }


	}

}
