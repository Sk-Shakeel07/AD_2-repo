package assignment2;
import java.util.*;

class Graph {
    private int numVertices; 
    private List<List<Node>> adjList;    

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
  
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }   
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Node(dest, weight));
        adjList.get(dest).add(new Node(src, weight));
    }  
    public void dijkstra(int startVertex) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices]; 
        PriorityQueue<Node> pq = new PriorityQueue<>();        
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;
        pq.add(new Node(startVertex, 0));
        
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;  
            
            for (Node neighbor : adjList.get(currentVertex)) {
                int newDist = distances[currentVertex] + neighbor.weight; 
                if (newDist < distances[neighbor.vertex]) { 
                    distances[neighbor.vertex] = newDist; 
                    pq.add(new Node(neighbor.vertex, newDist)); 
                }
            }
        }    
        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Graph graph = new Graph(6);        
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 5, 14);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 11);
        graph.addEdge(3, 4, 6);
        graph.addEdge(5, 4, 9);       
        graph.dijkstra(0);
    }
}
