package com.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * @author Jeevi
 *
 */
public class ClimbingStairs {

	
	public static int waysToClaimStairs(int N ) {
		
		if(N<=0) {
			return 0;			
		}
		if(N==1) {
			return 1;
		}
		if(N==2)
			return 2;
		
		 
		
		return  waysToClaimStairs(N-1)+ waysToClaimStairs(N-2); 
		
	}
	
	
	public static int climbStairs(int n) {
        int [] cache = new int[n+1];
        cache[0]=0;
        cache[1]=1;
        cache[2]=2; //This important , this fib series starts from 1,2 
        
        for(int i=3;i<=n;i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }
	
	
	
	public static void main(String[] args) {
		
		System.out.println(waysToClaimStairs(4));
		System.out.println(climbStairs(4));
		
	}
	
}
