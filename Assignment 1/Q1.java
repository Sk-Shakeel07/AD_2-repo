package assignment2aad2;
import java.util.*;
public class Q1 {

    static class Graph {
        private int count; 
        private List<List<Edge>> adj;

        static class Edge {
            int src, dest;

            Edge(int src, int dest) {
                this.src = src;
                this.dest = dest;
            }
        }

        public Graph(int count) {
            this.count = count;
            adj = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                adj.add(new LinkedList<>());
            }
        }

        public void addUndirectedEdge(int src, int dest) {
            adj.get(src).add(new Edge(src, dest));
            adj.get(dest).add(new Edge(dest, src));
        }

        // 1. Searching Reachability
        public boolean isReachable(int source, int target) {
            boolean[] visited = new boolean[count];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[source] = true;
            queue.add(source);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (curr == target) {
                    return true;
                }

                for (Edge edge : adj.get(curr)) {
                    if (!visited[edge.dest]) {
                        visited[edge.dest] = true;
                        queue.add(edge.dest);
                    }
                }
            }

            return false;
        }

        // 2. Checking Graph Connectedness
        public boolean isConnected() {
            boolean[] visited = new boolean[count];
            bfs(0, visited);

            for (boolean visit : visited) {
                if (!visit) {
                    return false;
                }
            }
            return true; 
        }

        private void bfs(int node, boolean[] visited) {
            visited[node] = true;
            for (Edge edge : adj.get(node)) {
                if (!visited[edge.dest]) {
                    bfs(edge.dest, visited);
                }
            }
        }

        // 3. Testing if a Graph is Bipartite
        public boolean isBipartite() {
            int[] colors = new int[count];
            Arrays.fill(colors, -1); // -1 means uncolored

            for (int i = 0; i < count; i++) {
                if (colors[i] == -1) {
                    if (!bipartiteBFS(i, colors)) {
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean bipartiteBFS(int source, int[] colors) {
            Queue<Integer> queue = new LinkedList<>();
            colors[source] = 0;
            queue.add(source);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (Edge edge : adj.get(curr)) {
                    if (colors[edge.dest] == -1) {
                        colors[edge.dest] = 1 - colors[curr];
                        queue.add(edge.dest);
                    } else if (colors[edge.dest] == colors[curr]) {
                        return false;
                    }
                }
            }

            return true;
        }

        // 4. Finding the Shortest Path
        public List<Integer> shortestPath(int source, int target) {
            boolean[] visited = new boolean[count];
            int[] parent = new int[count];
            Arrays.fill(parent, -1);

            LinkedList<Integer> queue = new LinkedList<>();
            visited[source] = true;
            queue.add(source);

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                if (curr == target) {
                    break;
                }

                for (Edge edge : adj.get(curr)) {
                    if (!visited[edge.dest]) {
                        visited[edge.dest] = true;
                        parent[edge.dest] = curr;
                        queue.add(edge.dest);
                    }
                }
            }

            List<Integer> path = new ArrayList<>();
            for (int at = target; at != -1; at = parent[at]) {
                path.add(at);
            }

            Collections.reverse(path);

            if (path.get(0) != source) {
                return Collections.emptyList(); // No path exists
            }

            return path;
        }
    }

    public static void main(String[] args) {
        Graph gph = new Graph(7);

        gph.addUndirectedEdge(0, 1);
        gph.addUndirectedEdge(0, 2);
        gph.addUndirectedEdge(0, 4);
        gph.addUndirectedEdge(1, 2);
        gph.addUndirectedEdge(2, 5);
        gph.addUndirectedEdge(3, 4);
        gph.addUndirectedEdge(4, 5);
        gph.addUndirectedEdge(4, 6);

        // Test Reachability
        System.out.println("Reachability (1 to 6): " + gph.isReachable(1, 6));

        // Test Connectedness
        System.out.println("Is Graph Connected: " + gph.isConnected());

        // Test Bipartiteness
        System.out.println("Is Graph Bipartite: " + gph.isBipartite());

        // Test Shortest Path
        System.out.println("Shortest Path (1 to 6): " + gph.shortestPath(1, 6));
    }
}