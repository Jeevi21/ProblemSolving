package com.graphs;

import java.util.Arrays;
import java.util.List;

import com.graphs.Graph.Edge;

/**
 * https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/
 * 
 * Greedy Algorithm to color graph.
 * @author Jeevi
 *
 */
public class GraphColoring {

	
	public static void graphColoring(Graph graph) {  
		
		int [] colorsAssigned = new int[graph.getAdjList().length]; //Has the colors assigned to each vertex.
		
		Arrays.fill(colorsAssigned,-1); //Initially no color is assigned to any of the vertex.
		
		boolean [] colorAvailable = new boolean[graph.getAdjList().length]; //This has list of available colors.
								//Here max no.of colors available = V . 
		//But infact max colors requed would be max degree of any vertext +1..(At the max it can go till V)
		
		//Lets assign first color to 0th vertex 
		colorsAssigned[0] = 0; // We are starting the travesing from 0th node.so, assigning 1st color available to first vertex.
		
		for(int v=0;v<graph.getAdjList().length;v++) { //Assign a color to V , which is not used by the neighbours.
			
			for(int u : graph.getAdjList()[v]) {//Check if any neighbour u, has any color assigned already and mark the color unavailable. 
				
				if(colorsAssigned[u]!=-1) //Already a color is assinged. So mark it unavailable.
					colorAvailable[colorsAssigned[u]]= false;
				
			}
			
			//Now assign the first available color to V.
			for(int i=0;i<colorAvailable.length;i++) {
				if(colorAvailable[i]) {
					colorsAssigned[v]= i;
					break;
				}					
			}
			
			//Now make all colors available again.
			Arrays.fill(colorAvailable, true);
			
		}
		
		
	//Print the colors 
	for(int i=0;i<colorsAssigned.length;i++) {
		System.out.println(i + " -> " + colorsAssigned[i]);
	}
	}
	
	
	
	public static void main(String[] args) {
		
		
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 2), 
                new Edge(1, 2), new Edge(1,3),new Edge(2,3), 
                new Edge(3,4 ));
		
		Graph graph = new Graph(5, edges);
		
		graphColoring(graph);
		
	}
	
}
