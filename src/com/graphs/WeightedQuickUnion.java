package com.graphs;

/**
 * The idea is to always make the smaller tree as child the other(irrespective of order)
 *  So we need extra array to keep track of size of tree.
 *  
 *  Here depth of any node is log n .. since it is blanced. 
 *  
 *  
 * @author Jeevi
 *
 */
public class WeightedQuickUnion {
	
	private int [] ids;
	private int [] size;
	
	public WeightedQuickUnion(int N) {
		//Initialize ids.. 
		ids = new int[N];
		size = new int[N];
		
		for(int i=0;i<N;i++) {
			ids[i]=i; //initially each element has independent set of its own.
			size[i]=1;
		}		
	}
	
	private int findRoot(int p) {
		if(ids[p]==p) { //its the root
			return p;
		}
		else {
			return findRoot(ids[p]); //Find root of its root(parent);
		}		
	}
	
	public boolean find(int p,int q) {
		return findRoot(p) == findRoot(q);
	}
	
	public void union(int p,int q) {
		//Make the smaller tree as child of another.
		int rootp = findRoot(p);
		int rootq = findRoot(q);
		
		if(size[rootp] > size[rootq]) { //q is smaller			
			ids[rootq] = rootp; //parent of rootq is rootp
			size[rootp]+=size[rootq];
		}
		else {
			ids[rootp] = rootq; //parent of rootq is rootp
			size[rootq]+=size[rootp];
		}		
	}
	
	public static void main(String[] args) {
		WeightedQuickUnion qu = new WeightedQuickUnion(9);
		System.out.println(qu.find(1,2));
		qu.union(1, 2);
		System.out.println(qu.find(1,2));
		qu.union(4,2);
		System.out.println(qu.find(3,4));
		System.out.println(qu.find(1,4));
	}
	
}
