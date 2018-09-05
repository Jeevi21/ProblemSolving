package com.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 
 * @author Jeevi
 *
 */
public class LongestIncreasingSubSeq {
	
	
	public static void LIS (int [] nums) {
		
		int [] LIS = new int[nums.length];		
		Arrays.fill(LIS, 1);		

		for(int i=0;i<nums.length;i++) { //For each LIS index
			int maxSofar =0;		
			
			for(int j=0;j<i;j++) { //find the max LIS sofar.
				if(maxSofar < LIS[j] && nums[j]<nums[i]) {  
					maxSofar = LIS[j];									
				}
			}
			
			LIS[i] = maxSofar+1;
		}
		
		
		//Find the max of LIS
		OptionalInt max = Arrays.stream(LIS).max();
		if(max.isPresent()) {
		  System.out.println(max.getAsInt());
		  //Get the max elem
		  OptionalInt maxIndex = IntStream.range(0,LIS.length)
		            .reduce((i,j) -> LIS[i] > LIS[j] ? i : j);
		  int maxInd = maxIndex.getAsInt();
		  //TODO print the seq.
			
		}
		else
		 System.out.println(0);		
		
	}
	
	
	private static void printSequence(int [] arr, int [] LIS , int maxIndex , int end) {
		
		
		if(maxIndex<=0)
			return ;
		
		if(LIS[end]==maxIndex) { //this is when we reach the max element in the LIS
			
			printSequence(arr, LIS, maxIndex-1, end-1);
			System.out.println(arr[maxIndex]);
		}
		else {
			printSequence(arr, LIS, maxIndex, end-1);
		}
		
		
	}
	
	public static void main(String[] args) {
		int [] arr = {50, 3, 10, 7, 40, 80};
		
		LIS(arr);
		
		
	}

}
