package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.techiedelight.com/graph-implementation-java-using-collections/
 * @author Jeevi
 *
 */

public class Graph {
	
	private LinkedList<Integer> [] adjList;
	
	public LinkedList<Integer>[] getAdjList() {
		return adjList;
	}
	
	@SuppressWarnings("unchecked")
	public Graph(int V , List<Edge> edges) {
		
		adjList = new LinkedList[V];
		
		//Initalize the list
		for(int i=0;i<V;i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		//Add the edges..
		for(Edge edge : edges) {
			adjList[edge.src].add(edge.dest);
			
			//Add the dest also if the graph is undirected..
		
		}			
	}
	
	
	public void printGraph() {

		for (int i = 0; i < adjList.length; i++) {

			for (int dest : adjList[i]) {
				System.out.println(i + " -> " + dest);
			}
		}
	}

	
	public static void main(String[] args) {
		
		// Input: List of edges in a directed graph (as per above diagram)
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), 
								new Edge(2, 0), new Edge(2, 1),new Edge(3, 2), 
								new Edge(4, 5), new Edge(5, 4));
		
		Graph graph = new Graph(6, edges);
		graph.printGraph();
		
	}
	
	/**
	 * To access in main it was made static, i think.
	 * @author Jeevi
	 *
	 */
	static class Edge{
		int src;	
		int dest;
		
		public Edge(int src,int dest){
			this.src = src;
			this.dest = dest;
		}
	}
	

}
