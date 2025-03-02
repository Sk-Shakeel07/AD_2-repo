package assignment2aad2;
import java.util.*;


class Edge3 {
    int dest;
 
    public Edge3(int dest) {
        this.dest = dest;
    }
}


class Graph3 {
    int count;
    List<LinkedList<Edge3>> Adj;

    public Graph3(int count) {
        this.count = count;
        Adj = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int src, int dest) {
        Adj.get(src).add(new Edge3(dest));
        
        Adj.get(dest).add(new Edge3(src));
    }
}

public class Q3 {
    public static boolean dfsStack(Graph3 gph, int source, int target) {
        if (source == target) return true; 

        int count = gph.count;
        boolean[] visited = new boolean[count];
        Stack<Integer> stk = new Stack<>();
        
        stk.push(source);
        visited[source] = true;
        
        while (!stk.isEmpty()) {
            int curr = stk.pop();
            LinkedList<Edge3> adl = gph.Adj.get(curr);
            
            for (Edge3 adn : adl) {
                if (!visited[adn.dest]) {
                    visited[adn.dest] = true;
                    stk.push(adn.dest);
                    if (adn.dest == target) return true; 
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph3 gph = new Graph3(6);
        gph.addEdge(0, 1);
        gph.addEdge(0, 2);
        gph.addEdge(1, 3);
        gph.addEdge(2, 4);
        gph.addEdge(3, 5);
        gph.addEdge(4, 5);

        int source = 0, target = 5;
        System.out.println("Path exists from " + source + " to " + target + ": " + dfsStack(gph, source, target));
    }
}