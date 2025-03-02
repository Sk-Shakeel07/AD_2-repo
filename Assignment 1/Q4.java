package assignment2aad2;

import java.util.*;

class Edge4 {
    int dest;
    
    public Edge4(int dest) {
        this.dest = dest;
    }
}

class Graph4 {
    int count;  
    ArrayList<LinkedList<Edge4>> Adj;  

    public Graph4(int count) {
        this.count = count;
        Adj = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        Adj.get(src).add(new Edge4(dest)); 
        Adj.get(dest).add(new Edge4(src)); 
    }
}

public class Q4 {
    public static boolean dfs(Graph4 gph, int source, int target) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        dfsUtil(gph, source, visited);
        return visited[target];
    }

    public static void dfsUtil(Graph4 gph, int index, boolean[] visited) {
        visited[index] = true;
        LinkedList<Edge4> adl = gph.Adj.get(index);
        for (Edge4 adn : adl) {
            if (!visited[adn.dest]) {
                dfsUtil(gph, adn.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        Graph4 graph = new Graph4(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges (source destination): ");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(src, dest);
        }        
        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();
        System.out.print("Enter target vertex: ");
        int target = sc.nextInt();         
        boolean pathExists = dfs(graph, source, target);
        System.out.println("Path exists from " + source + " to " + target + ": " + pathExists);      
    }
}
