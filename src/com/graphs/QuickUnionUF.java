package com.graphs;

/**
 * Quick-union Algorithm
 * The disadvantage is the trees can grow tall. then findroot method might take 0(n) time.
 * 
 * @author Jeevi
 */
public class QuickUnionUF {
	
	private int [] ids;
	
	public QuickUnionUF(int N) {
		//Initialize ids.. 
		ids = new int[N];
		for(int i=0;i<N;i++) {
			ids[i]=i; //initially each element has independent set of its own.
		}		
	}
	
	
	private int findRoot(int p) {
		
		if(ids[p]==p) //its the root.
			return p;
		else {
			//take the parent of current node p and check find its root.
			return findRoot(ids[p]);
		}		
	}
	
	/**
	 * 
	 * p and q belongs to same set if they have same root. 
	 * 
	 * @return
	 */
	public boolean find(int p,int q) {
		return findRoot(p) == findRoot(q);
	}

	/**
	 * 
	 * Merge the two given sets.
	 * 
	 * The idea is, each element is pointing to its root.. 
	 * 
	 * Make root of one tree(q) as child of other (p)
	 * 
	 */
	public void union(int p,int q) {
		int rootp= findRoot(p);
		int rootq = findRoot(q);
		
		ids[rootq] = rootp ; // parent of rootq is root p
			
	}
	
	public static void main(String[] args) {
		QuickUnionUF qu = new QuickUnionUF(9);
		System.out.println(qu.find(1,2));
		qu.union(1, 2);
		System.out.println(qu.find(1,2));
		qu.union(4,2);
		System.out.println(qu.find(3,4));
		System.out.println(qu.find(1,4));
	}
}
