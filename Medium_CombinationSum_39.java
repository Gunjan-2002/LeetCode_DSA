package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;


//										39. Combination Sum
//		
//		Given an array of distinct integers candidates and a target integer target, 
//		return a list of all unique combinations of candidates where the chosen numbers
//		sum to target. You may return the combinations in any order.
//		
//		The same number may be chosen from candidates an unlimited number of times. Two 
//		combinations are unique if the frequency of at least one of the chosen numbers is
//		different.
//		
//		It is guaranteed that the number of unique combinations that sum up to target is 
//		less than 150 combinations for the given input.
//		
//		Example 1:
//		
//		Input: candidates = [2,3,6,7], target = 7
//		Output: [[2,2,3],[7]]
//		Explanation:
//		2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//		7 is a candidate, and 7 = 7.
//		These are the only two combinations.
//		
//		Example 2:
//		
//		Input: candidates = [2,3,5], target = 8
//		Output: [[2,2,2,2],[2,3,3],[3,5]]
//				
//		Example 3:
//		
//		Input: candidates = [2], target = 1
//		Output: []
//		
//		Constraints:
//		
//		1 <= candidates.length <= 30
//		1 <= candidates[i] <= 200
//		All elements of candidates are distinct.
//		1 <= target <= 500

public class Medium_CombinationSum_39 {

	public static void main(String[] args) {
		int arr[] = {2,3,6,7};
		List<List<Integer>> ans =combinationSum(arr, 7);
		System.out.println(ans);
	}
	
	
	//				NOTE ---
	
	// Here also we have two choices for every element .
	// we can take that element and does not increment index 
	// as we can take one element any number of time and decrement
	// target by that element and add that element in arraylist and
	// at last remove that element after recursive function call .
	
	// If we cannot take that element then call a function with increment ind 
	//  by 1 and rest argumenet are same .
	
	// Base Case :
	// 			if(ind == last index)
	// 				if(target == 0)
	//					then add arraylist in ans arraylist 
	//						and then return it .
		
	static void findCombination(int ind , int arr[] , int target , List<List<Integer>> ans , ArrayList<Integer> al)
	{
		if(ind == arr.length)
		{
			if(target == 0)
			{
				ans.add(new ArrayList<>(al));
			}
			return;
		}
		
		if(arr[ind] <= target)
		{
			al.add(arr[ind]);
			findCombination(ind, arr, target - arr[ind] , ans, al);
			al.remove(al.size()-1);
		}
		
		findCombination(ind + 1, arr, target, ans, al);
	}
	
	static List<List<Integer>> combinationSum(int[] candidates, int target) 
	{
		List<List<Integer>> ans = new ArrayList<>();
		
		findCombination(0, candidates , target, ans , new ArrayList<>());
		
		return ans;
    }
}
