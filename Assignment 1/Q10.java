package assignment2aad2;
import java.util.*;

class Graph10 {
    int count;
    List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Graph10(int count) {
        this.count = count;
        adj = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }
}

public class Q10 {
    public static boolean isStronglyConnected(Graph10 gph) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        
        // Step 1: Run DFS from first node
        dfsUtil(gph, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }

        // Step 2: Transpose the graph
        Graph10 gReversed = transposeGraph(gph);
        Arrays.fill(visited, false);

        // Step 3: Run DFS on transposed graph
        dfsUtil(gReversed, 0, visited);
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }

    private static void dfsUtil(Graph10 gph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : gph.adj[node]) {
            if (!visited[neighbor]) {
                dfsUtil(gph, neighbor, visited);
            }
        }
    }

    private static Graph10 transposeGraph(Graph10 gph) {
        Graph10 gReversed = new Graph10(gph.count);
        for (int i = 0; i < gph.count; i++) {
            for (int neighbor : gph.adj[i]) {
                gReversed.addEdge(neighbor, i);  // Reverse direction of edges
            }
        }
        return gReversed;
    }

    public static void main(String[] args) {
        Graph10 g = new Graph10(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 2);

        if (isStronglyConnected(g)) {
            System.out.println("The graph is strongly connected.");
        } 
        else {
            System.out.println("The graph is NOT strongly connected.");
        }
    }
}
