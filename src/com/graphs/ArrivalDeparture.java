package com.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.graphs.Graph.Edge;

/**
 * http://www.techiedelight.com/arrival-departure-time-vertices-dfs/
 * This is nothing but find previsit and postvist.. 
 * DFS can be used.
 * 
 * @author Jeevi
 *
 */
public class ArrivalDeparture {

	private static int count=0;
	private static void previst(int [] arival,int v) {
		arival[v]=count++;
	}
	
	private static void postVisit(int [] departure,int v) {
		departure[v]=count++;
	}
		
	private static void explore(int v,LinkedList<Integer> [] adjList,boolean [] visited,int [] arival,int [] departure) {
		System.out.print(v + " ");
		visited[v]= true;
		
		previst(arival, v);
		
		//for each edge explore
		for(int u : adjList[v]) {
			if(!visited[u]) {
				explore(u, adjList, visited, arival, departure);
			}
		}
		
		postVisit(departure, v);
		
	}
	
	public static void DFS(Graph graph) {
		
		LinkedList<Integer> [] adjList = graph.getAdjList();
		boolean [] visited = new boolean [adjList.length];
		int [] arrival = new int [adjList.length];
		int [] departure = new int [adjList.length];
		
		
		for(int i=0;i<adjList.length;i++) {
			if(!visited[i])
				explore(i,adjList, visited, arrival, departure);
		}
		
		//Printing arrival , departure
        System.out.println("\n\nArrival,departure");
        for(int i=0;i<graph.getAdjList().length;i++) {
        	System.out.println( i +" -> ("+ arrival[i]+","+departure[i]+")");
        }
        
		
	}
	
	
	public static void main(String[] args) {
		
		// vector of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
                                new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
                                new Edge(4, 5), new Edge(6, 7)
                            );
        
        Graph graph = new Graph(8, edges);
        DFS(graph);
        

	}

}
