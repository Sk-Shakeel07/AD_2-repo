package assignment3;

public class Q1 {
	public static int[][] createAdjacencyMatrix(int vertices, int[][] edges){
		int[][] adjMatrix = new int[vertices][vertices];
		for(int[] edge : edges) {
			int u =edge[0];
			int v =edge[1];
			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}
		return adjMatrix;
	}
	public static void printAdjacencyMatrix(int[][] adjMatrix) {
		System.out.println("Adjacency Matrix:");
		for(int[] row : adjMatrix) {
			for(int cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		int vertices = 5;
		int[][] edges = {
				{0,1},
				{0,4},
				{1,2},
				{1,3},
				{1,4},
				{2,3},
				{3,4},
				{2,4}
		};
		int[][] adjMatrix = createAdjacencyMatrix(vertices , edges);
		printAdjacencyMatrix(adjMatrix);


	}

}
