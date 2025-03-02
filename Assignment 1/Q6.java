package assignment2aad2;

import java.util.*;

class Graph6 {
    private int vertices;
    private List<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public Graph6(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public int count() {
        return vertices;
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjList[vertex];
    }
}

public class Q6 {
    
    
    public static int countAllPaths(Graph6 gph, int source, int dest) {
        boolean[] visited = new boolean[gph.count()];
        return dfsCountPaths(gph, source, dest, visited);
    }

    private static int dfsCountPaths(Graph6 gph, int node, int dest, boolean[] visited) {
        if (node == dest) {
            return 1; 
        }

        visited[node] = true;
        int count = 0;
        
        for (int neighbor : gph.getNeighbors(node)) {
            if (!visited[neighbor]) {
                count += dfsCountPaths(gph, neighbor, dest, visited);
            }
        }

        visited[node] = false; 
        return count;
    }

    
    public static List<List<Integer>> findAllPaths(Graph6 gph, int source, int dest) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        boolean[] visited = new boolean[gph.count()];
        dfsFindPaths(gph, source, dest, visited, currentPath, allPaths);
        return allPaths;
    }

    private static void dfsFindPaths(Graph6 gph, int node, int dest, boolean[] visited, 
                                     List<Integer> currentPath, List<List<Integer>> allPaths) {
        currentPath.add(node);
        if (node == dest) {
            allPaths.add(new ArrayList<>(currentPath)); 
        } else {
            visited[node] = true;
            for (int neighbor : gph.getNeighbors(node)) {
                if (!visited[neighbor]) {
                    dfsFindPaths(gph, neighbor, dest, visited, currentPath, allPaths);
                }
            }
            visited[node] = false; 
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        Graph6 graph = new Graph6(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4); 

        int source = 0, destination = 5;

        
        int totalPaths = countAllPaths(graph, source, destination);
        System.out.println("Total paths: " + totalPaths);

        
        List<List<Integer>> allPaths = findAllPaths(graph, source, destination);
        System.out.println("All paths:");
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }
    }
}
