package assignment2aad2;

import java.util.*;

class Edge9 {
    int dest;
    
    Edge9(int dest) {
        this.dest = dest;
    }
}

class Graph9 {
    int count;
    ArrayList<LinkedList<Edge9>> Adj; 

    Graph9(int count) {
        this.count = count;
        Adj = new ArrayList<>(count); 
        for (int i = 0; i < count; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    void addEdge(int src, int dest) {
        Adj.get(src).add(new Edge9(dest));
        Adj.get(dest).add(new Edge9(src)); 
    }
}

public class Q9 {
    public static boolean isCyclePresentUndirectedDFS(Graph9 graph, int index, int parentIndex, boolean[] visited) {
        visited[index] = true;

        for (Edge9 edge : graph.Adj.get(index)) {
            int dest = edge.dest;

            if (!visited[dest]) {
                if (isCyclePresentUndirectedDFS(graph, dest, index, visited)) {
                    return true;
                }
            }
            else if (dest != parentIndex) { 
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclePresentUndirected(Graph9 graph) {
        boolean[] visited = new boolean[graph.count];

        for (int i = 0; i < graph.count; i++) {
            if (!visited[i]) {
                if (isCyclePresentUndirectedDFS(graph, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph9 graph = new Graph9(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); 

        if (isCyclePresentUndirected(graph)) {
            System.out.println("Cycle is present in the graph");
        } 
        else {
            System.out.println("No cycle in the graph.");
        }
    }
}
