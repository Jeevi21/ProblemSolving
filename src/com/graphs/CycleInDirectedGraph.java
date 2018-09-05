package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.graphs.Graph.Edge;

/**
 * http://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
 * @author Jeevi
 *
 *https://stackoverflow.com/questions/36827641/java-detecting-a-cyclic-directed-graph
 *
 *
 */
public class CycleInDirectedGraph {

	
	private static void explore(int u,LinkedList<Integer> [] adjList,boolean [] visited,boolean [] recStack) {
		
//		System.out.print(u +" ");
		visited[u]=true;
		
		recStack[u]=true;
		
		for(int v : adjList[u]) {
					
			//this edge is from u,v .. Just check if v is in stack.. if it is in stack, then its a back edge.. 
			//so report there s a cycle.    
			
			if(recStack[v]) 
				System.out.println("Alert!! Cycle Found!! Cycle Found!! from " + u +" -> "+ v);				
			
			if(!visited[v])
				explore(v, adjList, visited, recStack);			
		}
		recStack[u]=false;
	}


	/**
	 * Graph contains cycle.. if there is a back edge.
	 * 
	 * Back edge for u,v  ==  v u u v . So, when you start exploring u , v will be already in the stack.
	 * 
	 * So, user an array to keep track the elements that are still in stack.. 
	 * 
	 * when exploring u,v if v is already in stack.. then it is a cycle.
	 * 
	 */
	public static void DFS(Graph graph) {
		
		LinkedList<Integer> [] adjList = graph.getAdjList();
		
		boolean [] visited = new boolean[adjList.length];
		boolean [] recStack = new boolean[adjList.length];
		
		for(int v=0;v<adjList.length;v++) {
			if(!visited[v]) {
				explore(v, adjList, visited, recStack);
			}
		}											
	}

	/**
	 * Same method.. But trying to return the value.
	 * @param u
	 * @param adjList
	 * @param visited
	 * @param recStack
	 * @return
	 */
	private static boolean isCyclic(int u,LinkedList<Integer> [] adjList,boolean [] visited,boolean [] recStack) {
		
//		System.out.print(u +" ");
		visited[u]=true;
		
		recStack[u]=true;
		
		//For every edge u have.... explore.		
		for(int v : adjList[u]) {
					
			//this edge is from u,v .. Just check if v is in stack.. if it is in stack, then its a back edge.. 
			//so report there s a cycle.    
			
			if(recStack[v]) {
				System.out.println("Alert!! Cycle Found!! Cycle Found!! from " + u +" -> "+ v);
				return true;
			}
						
			if(!visited[v])
				return isCyclic(v, adjList, visited, recStack);			
		}
		
		recStack[u]=false;
		return false;
	}
	
	public static void isCyclic(Graph graph) {
		
		LinkedList<Integer> [] adjList = graph.getAdjList();
		
		boolean [] visited = new boolean[adjList.length];
		boolean [] recStack = new boolean[adjList.length];
		
		for(int v=0;v<adjList.length;v++) {
			if(!visited[v]) {
				
				if(isCyclic(v, adjList, visited, recStack)) {
					System.out.println("Cycle Found!");		
					return;
				}				
			}
		}		
		
		System.out.println("Graph has no cycle !");
		
	}
	
	public static void main(String[] args) {
		
		  // vector of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
        		 		new Edge(0, 1),    new Edge(0, 2),   
        		 		new Edge(1, 2),    new Edge(2, 0),    
        		 		new Edge(2, 3),    new Edge(3, 3)
        		            );


        Graph graph = new Graph(13,edges,true);
        
//        DFS(graph);
        
        isCyclic(graph);
	}
	
	
}
