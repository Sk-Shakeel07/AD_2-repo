package assignment2aad2;

import java.util.*;

class Edge5 {
    int src, dest, weight;

    public Edge5(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph5 {
    int count;
    List<List<Edge5>> Adj;

    public Graph5(int count) {
        this.count = count;
        Adj = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Adj.get(src).add(new Edge5(src, dest, weight));
        Adj.get(dest).add(new Edge5(dest, src, weight)); 
    }
}

public class Q5 {
    public static boolean bfs(Graph5 gph, int source, int target) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        Queue<Integer> que = new LinkedList<>();

        que.add(source);
        visited[source] = true;

        while (!que.isEmpty()) {
            int curr = que.poll();
            List<Edge5> adl = gph.Adj.get(curr);

            for (Edge5 edge : adl) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    que.add(edge.dest);

                    
                    if (edge.dest == target) {
                        return true;
                    }
                }
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        Graph5 graph = new Graph5(vertices);        
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        System.out.println("Enter edges in the format: src dest weight");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(src, dest, weight);
        }        
        System.out.print("Enter source node: ");
        int source = sc.nextInt();
        System.out.print("Enter target node: ");
        int target = sc.nextInt();        
        if (bfs(graph, source, target)) {
            System.out.println("Path exists between " + source + " and " + target);
        }
        else {
            System.out.println("No path exists between " + source + " and " + target);
        }      
    }
}
