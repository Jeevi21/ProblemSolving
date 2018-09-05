package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.graphs.Graph.Edge;

/**
 * In undirected graph, if there is a cycle if the vertices adjacent to vertex v
 * is already visited and it is not parent of v.
 * 
 * @author Jeevi
 *
 */
public class CycleInUnDirectedGraph {

	private static boolean isCyclic(int u, LinkedList<Integer>[] adjList, boolean[] visited, int parent) {

		// System.out.print(u +" ");
		visited[u] = true;

		// For every edge u have.... explore.
		for (int v : adjList[u]) {

			// System.out.println(parent + " ---- " + u+" -> " + v );

			if (!visited[v])
				return isCyclic(v, adjList, visited, u);
			else if (v != parent) { // it is visited and it is not parent of u.. It is a cycle
//				System.out.println("Cycle Found !! " + u +"->"+ v );
				return true;
			}

		}

		return false;
	}

	public static void isCyclic(Graph graph) {

		LinkedList<Integer>[] adjList = graph.getAdjList();

		boolean[] visited = new boolean[adjList.length];		

		for (int v = 0; v < adjList.length; v++) {
			if (!visited[v]) {

				if (isCyclic(v, adjList, visited, -1)) { // passing non existing value(-1) as parent.
					System.out.println("Cycle Found!");
					return;
				}
			}
		}

		System.out.println("Graph has no cycle !");

	}

	public static void main(String[] args) {

		List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3), new Edge(2, 6),
				new Edge(3, 4), new Edge(3, 5), new Edge(8, 9), new Edge(8, 12), new Edge(9, 10), new Edge(9, 11),
				new Edge(11, 12)
		// edge (11->12) introduces a cycle in the graph
		);

		Graph graph = new Graph(13, edges); // undirected graph

		isCyclic(graph);

	}

}
