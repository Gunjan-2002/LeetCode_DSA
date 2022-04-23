package Sorting;

import java.util.HashMap;
import java.util.HashSet;

//									217  :  Contains Duplicate
//				
//				Given an integer array nums, return true if any value appears 
//				at least twice in the array, and return false if every element is distinct.
//				
//				Example 1:
//				
//				Input: nums = [1,2,3,1]
//				Output: true
//				Example 2:
//				
//				Input: nums = [1,2,3,4]
//				Output: false
//				Example 3:
//				
//				Input: nums = [1,1,1,3,3,4,3,2,4,2]
//				Output: true
//				
//				Constraints:
//				
//				1 <= nums.length <= 105
//				-109 <= nums[i] <= 109


public class Easy_ContainsDuplicate_217 
{
	public static void main(String[] args)
	{
		int arr[]= {1,1,1,3,3,4,3,2,4,2};
		int arr1[]= {1};
		
		boolean ans=duplicate(arr);
		boolean ans1=duplicate(arr1);
		
		System.out.println(ans);
		System.out.println(ans1);
	}

//				Note :
//				
//			In this question we can use two methods
//			1] Using HashSet
//			2] Using Hashmap
//		
//			Both methods are good 
//			but Hashmap will be more efficient in time than Hashset
	
	static boolean duplicate(int arr[])
	{
		
//		Method 1 :
		
//		HashSet<Integer> h= new HashSet<>();
//		
//		for(int x : arr)
//		{
//			h.add(x);
//		}
//		
//		if( h.size() != arr.length)
//		{
//			return true;
//		}
//		
//		return false;
		
//		Method 2 :
		
		HashMap<Integer, Integer> hm= new HashMap<>();
		
		for(int x : arr)
		{
			if(hm.containsKey(x))
			{
				return true;
			}
			else
			{
				hm.put(x ,1);
			}	
		}
		
		return false;
	}
	
}
