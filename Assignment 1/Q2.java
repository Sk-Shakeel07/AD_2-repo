package assignment2aad2;
import java.util.*;

class Edge {
    int dest;

    Edge(int dest) {
        this.dest = dest;
    }
}

class Graph {
    private final int count;
    private final LinkedList<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int count) {
        this.count = count;
        adj = new LinkedList[count];
        for (int i = 0; i < count; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addUndirectedEdge(int src, int dest) {
        adj[src].add(new Edge(dest));
        adj[dest].add(new Edge(src));
    }

    public boolean dfsStack(int source, int target) {
        if (source < 0 || source >= count || target < 0 || target >= count) {
            return false; 
        }

        boolean[] visited = new boolean[count];
        Stack<Integer> stk = new Stack<>();

        stk.push(source);
        visited[source] = true;

        while (!stk.isEmpty()) {
            int curr = stk.pop();

            LinkedList<Edge> neighbors = adj[curr];
            for (Edge edge : neighbors) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    stk.push(edge.dest);                    
                    if (edge.dest == target) {
                        return true;
                    }
                }
            }
        }
        return false; 
    }
}
public class Q2 {
    public static void main(String[] args) {
        Graph gph = new Graph(8);

        gph.addUndirectedEdge(0, 3);
        gph.addUndirectedEdge(0, 2);
        gph.addUndirectedEdge(0, 1);
        gph.addUndirectedEdge(1, 4);
        gph.addUndirectedEdge(2, 5);
        gph.addUndirectedEdge(3, 6);
        gph.addUndirectedEdge(6, 7);
        gph.addUndirectedEdge(5, 7);
        gph.addUndirectedEdge(4, 7);

        System.out.println("Path between 0 & 6: " + gph.dfsStack(0, 6));
        System.out.println("Path between 0 & 7: " + gph.dfsStack(0, 7)); 
        System.out.println("Path between 0 & 8: " + gph.dfsStack(0, 8)); 
    }
}