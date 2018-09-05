package com.graphs;

/**
 * Disjoint set - Union and find algorith  - rank and path compression.
 * @author Jeevi
 * 
 * MakeSet  
 * Union
 * FindSet 
 *
 */
public class UnionAndFind {
	
	
	private Node [] sets;
	
	public UnionAndFind(int N) {
		
		sets = new Node[N];
		
		//initalize each node.
		for(int i=0;i<N;i++) {
			Node node = new Node();
			node.data=i;
			node.rank=0;
			node.parent=node; // initially each node is pointing to itself.
			
			sets[i]= node;			
		}
				
	}
	
	/**
	 * As part of find root , compress the tree also.
	 * @param p
	 * @return
	 */
	private Node findRoot(Node p) {
		
		if(sets[p.data].parent.data==p.data) { //Root
			return p;
		}
		else {
			p.parent = findRoot(sets[p.data].parent); //Path - Compression , making each node to point the returned Root.
			return p.parent;
		}
	}
	
	
	public boolean find(Node p,Node q) {
		return findRoot(p).data ==findRoot(q).data;
	}
	
	public void union(Node p,Node q) {
		
		Node parentp = findRoot(p);
		Node parentq = findRoot(q);
		
		if(parentp.rank>=parentq.rank) { //make tree with q child.
			parentq.parent = parentp;
			
			if(parentp.rank ==parentq.rank) //Increase the rank only when both the trees have same rank.
				parentp.rank+=1;
			
		}
		else { //make tree with p child
			parentp.parent = parentq;
		}
	}
	
	
	public static void main(String[] args) {
		
	}
	
			
			
	class Node{
		int data;
		int rank;
		Node parent;
	}

}
