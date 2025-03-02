package assignment2aad2;

import java.util.*;

class Edge7 {
    int dest;

    Edge7(int dest) {
        this.dest = dest;
    }
}

class Graph7 {
    int count;
    ArrayList<LinkedList<Edge7>> Adj;

    Graph7(int count) {
        this.count = count;
        Adj = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Adj.add(new LinkedList<>());
        }
    }

    void addEdge(int src, int dest) {
        Adj.get(src).add(new Edge7(dest));
        Adj.get(dest).add(new Edge7(src)); 
    }
}

public class Q7 {
    public static int bfsDistance(Graph7 gph, int source, int dest) {
        if (source == dest) {
            return 0;
        }

        int count = gph.count;
        boolean[] visited = new boolean[count];
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        visited[source] = true;
        int[] level = new int[count];
        level[source] = 0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            int depth = level[curr];

            for (Edge7 adn : gph.Adj.get(curr)) {
                if (adn.dest == dest) {
                    return depth + 1; 
                }
                if (!visited[adn.dest]) {
                    visited[adn.dest] = true;
                    que.add(adn.dest);
                    level[adn.dest] = depth + 1;
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Graph7 g = new Graph7(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        System.out.print("The distance between source and destination vertex is: ");
        System.out.println(bfsDistance(g, 0, 5)); 
    }
}
