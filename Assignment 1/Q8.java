package assignment2aad2;
import java.util.*;

class Edge8 {
    int dest;

    public Edge8(int dest) {
        this.dest = dest;
    }
}

class Graph8 {
    int count;
    ArrayList<LinkedList<Edge8>> Adj;

    public Graph8(int count) {
        this.count = count;
        Adj = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        Adj.get(src).add(new Edge8(dest));
    }
}

public class Q8 { 
    
    public static boolean isCyclePresentDFSColor(Graph8 graph, int index, int[] visited) {
        visited[index] = 1; 
        LinkedList<Edge8> adl = graph.Adj.get(index);

        for (Edge8 adn : adl) {
            int dest = adn.dest;

            if (visited[dest] == 1) 
                return true;

            if (visited[dest] == 0) 
                if (isCyclePresentDFSColor(graph, dest, visited))
                    return true;
        }
        
        visited[index] = 2; 
        return false;
    }

    public static boolean isCyclePresentColor(Graph8 graph) {
        int count = graph.count;
        int[] visited = new int[count]; 

        for (int i = 0; i < count; i++) {
            if (visited[i] == 0) { 
                if (isCyclePresentDFSColor(graph, i, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph8 graph = new Graph8(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1); 

        if (isCyclePresentColor(graph)) {
            System.out.println("Cycle detected in the graph!");
        }
        else {
            System.out.println("No cycle detected in the graph.");
        }
    }
}
