package Sorting;

import java.util.Arrays;

//						179  : Largest Number
//			
//			Given a list of non-negative integers nums, arrange
//			them such that they form the largest number and return it.
//			
//			Since the result may be very large, so you need to return 
//			a string instead of an integer.
//			
//			Example 1:
//			
//			Input: nums = [10,2]
//			Output: "210"
//			Example 2:
//			
//			Input: nums = [3,30,34,5,9]
//			Output: "9534330"
//			
//			Constraints:
//			
//			1 <= nums.length <= 100
//			0 <= nums[i] <= 109



public class Medium_LargestNumber_179 
{
	public static void main(String[] args) 
	{
		int arr[]= {3,30,34,5,9};
		System.out.println(largestNumber(arr));
	}
	
	
//		Note :
//			
//		In this question to find the largest number we use comparator
//		given by java language . So first we sort the array in comparisn 
//		with that the combination of two adjacent element will be higher .
//		for ex let consider two elements 3 , 30 so there are two possible 
//		combination 330 and 303 but 330 is larger so we put 30 behind 3 in
//		array in this way we sort the array using comparator .
//		If first element is 0 then we return 0 otherwise we convert the array
//		into the string and then return it .
//		That's it !
	

	 static String largestNumber(int[] nums) 
	    {
	        String ans[]=new String[nums.length];
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            ans[i]=nums[i] +"";
	        }
	        
	        Arrays.sort(ans,(a,b) -> (b+a).compareTo(a+b));
	        
	        if(ans[0].equals("0"))
	        {
	            return "0";
	        }
	        String str ="";
	        for(int i=0;i<ans.length;i++)
	        {
	            str = str + ans[i];
	        }
	        return str;       
	    }	
}
