package com.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.graphs.Graph.Edge;



/**
 * http://www.techiedelight.com/breadth-first-search/
 * @author Jeevi
 *
 */
public class BFS {
	
	private static void BFSRecUtil(boolean [] visited,Queue<Integer> queue, LinkedList<Integer> [] adjList) {
		
		if(!queue.isEmpty()) {
			
			int currVertex = queue.poll();
			System.out.print(currVertex +" ");
			visited[currVertex]=true;
			
			for(int dest : adjList[currVertex]) { //for each edge add it to queue
				if(!visited[dest]) 
					queue.add(dest);				
			}
			BFSRecUtil(visited, queue, adjList);			
		}
	}
	
	public static void BFSRec(Graph graph,int stVertex) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(stVertex);
		LinkedList<Integer> [] adjList = graph.getAdjList();
		boolean [] visited = new boolean[adjList.length];
		BFSRecUtil(visited, queue, adjList);		
	}
	
	
	private static void BFS(int v,LinkedList<Integer> [] adjList,boolean [] visited) {
		
		if(!visited[v]) {
			Queue<Integer> queue = new ArrayDeque<Integer>();
			queue.add(v);
			
			while(!queue.isEmpty()) {
				int src = queue.poll();
				System.out.print(src +"  ");
				visited[src]= true;
				//For each edge this vertex has.
				for(int dest : adjList[src] ) {
					//add it to queue if it not visited.
					if(!visited[dest])
						queue.add(dest);					
				}				
			}						
		}		
	}
	
	public static void BFS(int v,Graph graph) {
		
		LinkedList<Integer> [] adjList = graph.getAdjList();
		
		boolean [] visited = new boolean[adjList.length];
		
		BFS(v,adjList,visited);
				
	}
	
	
	public static void main(String[] args) {
		
		// vector of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                new Edge(7, 11), new Edge(7, 12)
                // vertex 0, 13 and 14 are single nodes
        );
                
		Graph graph = new Graph(15,edges);
		
//		BFS(1,graph);
		
		BFSRec(graph, 1);
		
	}

}
