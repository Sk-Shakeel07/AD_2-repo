package assignment3;
import java.util.*;
public class Q2 {
	public static List<List<Integer>> createAdjacencyList(int vertices,int[][] edges){
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<vertices; i++) {
			adjList.add(new ArrayList<>());
		}
		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		return adjList;
	}
	public static void printAdjacencyList(List<List<Integer>>  adjList) {
		System.out.println("Adjacency List:");
		for(int i =0;i<adjList.size(); i++) {
			System.out.print(i + ":");
			for(int neighbor : adjList.get(i)) {
				System.out.print(neighbor + " --> ");
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
		
		List<List<Integer>> adjList = createAdjacencyList(vertices, edges);
		printAdjacencyList(adjList);


	}

}
