package Sorting;

import java.util.Arrays;

//									628  :  Maximum Product of Three Numbers
//				
//				Given an integer array nums, find three numbers whose 
//				product is maximum and return the maximum product.
//				
//				Example 1:
//				
//				Input: nums = [1,2,3]
//				Output: 6
//				Example 2:
//				
//				Input: nums = [1,2,3,4]
//				Output: 24
//				Example 3:
//				
//				Input: nums = [-1,-2,-3]
//				Output: -6
//				
//				Constraints:
//				
//				3 <= nums.length <= 104
//				-1000 <= nums[i] <= 1000

public class MaximumProductofThreeNumbers_628 
{
	public static void main(String[] args)
	{
		int arr[]= {1,4,3,2};
		
		int ans=maximumProduct(arr);
		
		System.out.println(ans);
	}
	
//				Note :
//					
//				In this question first we sort and then find three numbers
//				whose multiplication is maximum . for this we have two options
//				First we can choose last three elements of array if no negative element
//				is present in array and return multiplication .
//				Second if negative elements are present then check if first two elements
//				multiplication is more than second last and third last element and last elemet
//				is positive if this is true
//				then return first second and last element multiplication else return multiplication
//				of last three elements .
	
	static int maximumProduct(int[] nums) 
    {
        Arrays.sort(nums);
        int n1=nums[nums.length-1];
        int n2=nums[nums.length-2];
        int n3=nums[nums.length-3];
        
        if(nums[1] <0)
        {
            if(n2*n3 < nums[0]*nums[1] && n1 > 0)
            {
                n2=nums[1];
                n3=nums[0];
            }
        }
        return n1*n2*n3;
        
    }

}
