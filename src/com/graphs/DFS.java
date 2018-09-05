package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.graphs.Graph.Edge;

/**
 * 
 * @author Jeevi
 *
 */
public class DFS {

	private static void explore(int v, LinkedList<Integer>[] adjList, boolean[] visited) {

		System.out.print(v + " ");
		visited[v] = true;

		for (int u : adjList[v]) {

			if (!visited[u]) {
				explore(u, adjList, visited);
			}
		}
	}

	public static void DFS(Graph graph) {
		LinkedList<Integer>[] adjList = graph.getAdjList();

		boolean[] visited = new boolean[adjList.length];
		for (int v = 0; v < adjList.length; v++) {
			if (!visited[v]) {
				explore(v, adjList, visited);
			}
		}
	}

	private static void exploreIterative(int v, LinkedList<Integer>[] adjList, boolean[] visited) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(v);

		while (!stack.isEmpty()) {

			int currVertex = stack.pop();

			System.out.print(currVertex + " ");
			visited[currVertex] = true;

			LinkedList<Integer> list= adjList[currVertex];
			for(int i=list.size()-1;i>=0;i--) {  //put it in reverse.. How many hrs i spent on understanding this !
				int u = list.get(i);
				if(!visited[u])
					stack.push(u);				
			}
			
		}
	}

	public static void DFSIterative(Graph graph) {
		LinkedList<Integer>[] adjList = graph.getAdjList();

		boolean[] visited = new boolean[adjList.length];

		for (int v = 0; v < adjList.length; v++) {

			if (!visited[v]) {
				exploreIterative(v, adjList, visited);
			}
		}
	}

	public static void main(String[] args) {

		List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5), new Edge(2, 6),
				new Edge(5, 9), new Edge(5, 10), new Edge(4, 7), new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
		// vertex 0 is single nodes
		);

		Graph graph = new Graph(13, edges);

		DFS(graph); //

		System.out.println();

		DFSIterative(graph);

	}

}
