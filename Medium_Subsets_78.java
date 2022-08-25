package RECURSION.MEDIUM;

import java.util.*;

//									78. Subsets
//		
//		Given an integer array nums of unique elements, return all possible subsets (the power set).
//		
//		The solution set must not contain duplicate subsets. Return the solution in any order.
//		
//		Example 1:
//		
//		Input: nums = [1,2,3]
//		Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//		Example 2:
//		
//		Input: nums = [0]
//		Output: [[],[0]]
//		
//		Constraints:
//		
//		1 <= nums.length <= 10
//		-10 <= nums[i] <= 10
//		All the numbers of nums are unique.


public class Medium_Subsets_78 {

	public static void main(String[] args) {		
		int nums[]= {1,2,3};
		System.out.println(print(nums));
	}
	
	
	// IN THIS QUESTION WE HAVE TO FIND POSSIBLE SUBSETS OF AN ARRAY
	// SO WE USE HELPER FUNCTION TO GET ALL THESE POSSIBLE SUBSETS .
	
	static List<List<Integer>> print(int nums[])
	{
		ArrayList<Integer> al = new ArrayList<>();
		List<List<Integer>> ll = new ArrayList<>();
		find(nums,0,ll,al);
		return ll;
	}
	
	// BASIC IDEA FOR SUBSETS QUESTION IS THAT WE HAVE TWO CHOICES 
	// THAT WE CAN TAKE THE ELEMENT AND NOT TAKE THE ELEMENT
	// IF WE TAKE ELEMENT INCREMENT THE INDEX BY 1 AND ADD THAT ELEMENT
	// IN ARRAYLIST GIVEN
	// IF DONT WANT TO TAKE THEN JUST INCREMENT INDEX BY 1 AND BEFORE CALLING
	// FUNCTION REMOVE THE LASTLY ADDED ELEMENT FROM THE ARRAYLIST
	// BASE CASE IS IF INDEX IS EQUAL TO LAST INDEX IN GIVEN ARRAY THEN JUST ADD
	// LIST IN LIST OF LIST
	
	static void find(int nums[] , int ind , List<List<Integer>> ll , List<Integer> al)
	{
		if(ind == nums.length)
		{
			ll.add(new ArrayList<>(al));
			return;
		}
		
		int ele = nums[ind];
		
		al.add(ele);
		find(nums,ind+1,ll,al);
		al.remove(al.size()-1);
		find(nums, ind+1, ll, al);
	}
}
