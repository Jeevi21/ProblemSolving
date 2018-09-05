package com.graphs;

/**
 * Quick find implementation
 * 
 * @author Jeevi
 *
 */
public class QuickFindUF {
	
	private int [] ids;
	
	public QuickFindUF(int N) {
		//Initialize ids.. 
		ids = new int[N];
		for(int i=0;i<N;i++) {
			ids[i]=i; //initially each element has independent set of its own.
		}		
	}
	
	/**
	 * Check if given 2 elements are in same set.
	 */
	public boolean find(int p,int q) {
		return ids[p]==ids[q];		
	}
	
	/**
	 * Merge the 2 sets which contains the given elements.
	 */
	public void union(int p,int q) {
		int pid = ids[p];
		int qid = ids[q];
		
		if(pid!=qid) { //both are in different sets so merge.
			for(int i=0;i<ids.length;i++) {// change all the ids =qid to pid.
				if(ids[i]==qid) 
					ids[i]=pid;				
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
	}
	

}
