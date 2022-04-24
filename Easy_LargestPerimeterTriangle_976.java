package Sorting;

import java.util.Arrays;

//										976  :  Largest Perimeter Triangle
//			
//			Given an integer array nums, return the largest perimeter of a triangle
//			with a non-zero area, formed from three of these lengths. If it is impossible 
//			to form any triangle of a non-zero area, return 0.
//			
//			Example 1:
//			
//			Input: nums = [2,1,2]
//			Output: 5
//			Example 2:
//			
//			Input: nums = [1,2,1]
//			Output: 0
//			
//			Constraints:
//			
//			3 <= nums.length <= 104
//			1 <= nums[i] <= 106

public class Easy_LargestPerimeterTriangle_976 
{
	public static void main(String[] args)
	{
		int arr[]= {2,1,2};
		
		int ans=largestPerimeter(arr);
		
		System.out.println(ans);
	}

//				Note :
//					
//				For this question to solve we should know the property
//				of triangle without which no triangle is legal .
//				let consider three sides a , ,b , c triangle formation is possible
//				if only if sum of any two sides should be greter than other remaining side
//				
//				In this question first we sort the array and then iterate from the last element to 
//				index 2 . Check for every elemet that sum of last two elements before it is greter than
//				the current element if it is true then return perimeter else check for other element .
//				At last return 0 if no triangle is possible .
//				
//				That's it !
	
	 static int largestPerimeter(int[] nums) 
	    {
	        Arrays.sort(nums);
	        
	        for(int i=nums.length-1 ; i>=2 ;i--)
	        {
	            if(nums[i] < nums[i-1]+nums[i-2])
	            {
	                return nums[i] + nums[i-1] + nums[i-2];
	            }
	        }
	        return 0;
	    }
}
