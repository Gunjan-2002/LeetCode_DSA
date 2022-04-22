package Cyclic_Sort;

import java.util.Arrays;

//												645 :  Set Mismatch
//					
//					You have a set of integers s, which originally contains all the numbers from 1 to n. 
//					Unfortunately, due to some error, one of the numbers in s got duplicated to another
//					number in the set, which results in repetition of one number and loss of another number.
//					
//					You are given an integer array nums representing the data status of this set after the error.
//					
//					Find the number that occurs twice and the number that is missing and return them in the form 
//					of an array.
//					
//					Example 1:
//					
//					Input: nums = [1,2,2,4]
//					Output: [2,3]
//					Example 2:
//					
//					Input: nums = [1,1]
//					Output: [1,2]
//					
//					Constraints:
//					
//					2 <= nums.length <= 104
//					1 <= nums[i] <= 104

public class SetMismatch_645 
{
	public static void main(String[] args)
	{
		int arr[]= {1,2,2,4};
		int arr1[]= {1,1};
		
		int ans1[]=findErrorNums(arr);
		int ans2[]=findErrorNums(arr1);
		
		System.out.println(Arrays.toString(ans1));
		System.out.println(Arrays.toString(ans2));
	}

	 static int[] findErrorNums(int[] nums) 
	    {
	        int i=0;
	        
	        while(i < nums.length)
	        {
	               if(nums[nums[i]-1]  != nums[i])
	               {
	                   swap(nums,i,nums[i]-1);
	               }
	                else
	                {
	                    i++;
	                }
	        }
	        
	        for(int j=0;j<nums.length;j++)
	        {
	            if(j+1  != nums[j])
	            {
	                return new int[]{nums[j],j+1};
	            }
	        }
	        return new int[]{-1,-1};
	    }
	    
	    static void swap(int arr[] , int a , int b)
	    {
	        int temp=arr[a];
	        arr[a]=arr[b];
	        arr[b]=temp;
	    }
	
}
