package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//											15  :  3 Sum
//					
//					Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
//					such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//					
//					Notice that the solution set must not contain duplicate triplets.
//					
//					Example 1:
//					
//					Input: nums = [-1,0,1,2,-1,-4]
//					Output: [[-1,-1,2],[-1,0,1]]
//					Example 2:
//					
//					Input: nums = []
//					Output: []
//					Example 3:
//					
//					Input: nums = [0]
//					Output: []
//					
//					Constraints:
//					
//					0 <= nums.length <= 3000
//					-105 <= nums[i] <= 105

public class Medium_3Sum_15 
{
	public static void main(String[] args) 
	{
			int arr[]={-1,0,1,2,-1,-4};
		List<List<Integer>> ar=new ArrayList<>();
		
		ar=threeSum(arr);
		
		System.out.println(ar);
	}
	
//			Note :
//				
//			In this question we use HashSet so that no two list would be same
//			So first we check that if array size is less than 3 or not if less then return
//			empty list .
//			Then we sort the array and then iterate from i=0 to array length .
//			Inside it declare j=i+1 and k=array length-1 .
//			Apply while loop upto j < k find sum of element at index i , j , k
//			If(sum ==0) then add this three elements to hashset , if(sum > 0)
//			then just decrement k by 1 and if(sum < 0) then increment j by 1.
//			At last return ArrayList as hashset .
//			That's it !
	
	
	 static List<List<Integer>> threeSum(int[] nums) 
	    {
		 HashSet<List<Integer>> hs=new HashSet<>();
	        if(nums.length < 3)
	        {
	            return new ArrayList<>(hs);
	        }
	        Arrays.sort(nums);
	        for(int i=0;i<nums.length;i++)
	        {
	            int j=i+1;
	            int k=nums.length-1;
	            
	            while(j < k)
	            {
	                int sum=nums[i]+nums[j]+nums[k];
	                if(sum == 0)
	                {
	                    hs.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
	                }
	                else if(sum > 0)
	                {
	                    k--;
	                }
	                else if(sum < 0)
	                {
	                    j++;
	                }
	            }
	        }
	        return new ArrayList<>(hs);
	    }
}
