package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
	
	
	public static void combinations(int[] nums, List<Integer> choosen, int start) {

		if (choosen.size() == nums.length)
			System.out.println(choosen);
		else {
			for (int i = start; i < nums.length; i++) {
				choosen.add(nums[i]);

				// Explore
				combinations(nums, choosen, i); // repetation is allowed , to stop the recursion we need to have the r in nCr.

				// Unchoose
				choosen.remove(choosen.size() - 1);

			}
		}
	}
	
	
	/**
	 * Find Combination Sum
	 * @param nums
	 * @param choosen
	 * @param start
	 */
	static int  minSofar = Integer.MAX_VALUE;
	public static void CoinChange(int[] nums, List<Integer> choosen, int start, int target) {

		if (target==0) {
			System.out.println(choosen);
			if(minSofar>choosen.size())
				minSofar=choosen.size();			
		}
		else if(target>1) {
			for (int i = start; i < nums.length; i++) {
				choosen.add(nums[i]);

				// Explore
				CoinChange(nums, choosen, i,target-nums[i]); // repetation is allowed , to stop the recursion we need to have the r in nCr.

				// Unchoose
				choosen.remove(choosen.size() - 1);

			}
		}
	}
	
	
	
	
	/**
	 * All possible combination.. 
	 * @param denominations
	 * @param sum
	 */
	public static void coinChange(int [] denominations, int sum) {
		
		
		
		
		
	}
	
	public static void main(String[] args) {
	
		int [] denominations = {1,2,5};
		
//		combinations(denominations, new ArrayList<Integer>(), 0);
		
		CoinChange(denominations, new ArrayList<Integer>(), 0, 10 );
		
		System.out.println("Min : " + minSofar);
		
	}

}
