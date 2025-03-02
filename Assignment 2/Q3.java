package assignment2;
import java.util.*;  

class Graph2 {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph2(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void primMST() {
        boolean[] inMST = new boolean[vertices];
        int[] key = new int[vertices];
        int[] parent = new int[vertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;  

        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, inMST);
            inMST[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (adjacencyMatrix[u][v] != 0 && !inMST[v] && adjacencyMatrix[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = adjacencyMatrix[u][v];
                }
            }
        }

        printMST(parent);
    }

    private int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t  " + adjacencyMatrix[i][parent[i]]);
        }
    }
}

public class Q3 {
    public static void main(String[] args) {
        Graph2 graph = new Graph2(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5); 
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();
    }
}
