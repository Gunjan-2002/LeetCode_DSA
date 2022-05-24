package Arrays.Medium;

import java.util.Arrays;


//							238. Product of Array Except Self
//		
//		Given an integer array nums, return an array answer such that 
//		answer[i] is equal to the product of all the elements of nums except nums[i].
//		
//		The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//		
//		You must write an algorithm that runs in O(n) time and without using the division operation.
//		
//		Example 1:
//		
//		Input: nums = [1,2,3,4]
//		Output: [24,12,8,6]
//				
//		Example 2:
//		
//		Input: nums = [-1,1,0,-3,3]
//		Output: [0,0,9,0,0]
//		
//		Constraints:
//		
//		2 <= nums.length <= 105
//		-30 <= nums[i] <= 30
//		The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//		 
//		
//		Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not 
//		count as extra space for space complexity analysis.)


public class Medium_ProductofArrayExceptSelf_238 
{
	public static void main(String[] args) 
	{
		int arr[]= {1,2,3,4};
		
		int ans[]=productExceptSelf(arr);
		
		System.out.println(Arrays.toString(ans));
	}

	
//		Note :
//			
//		In this Question first we find the prefix multiplication
//		of each element except self element .
//		After this implement a for loop starts from last index
//		and take a cariable initially value as 1 and multiply
//		this variable with prefix multiplication array element
//		and set variable as variable*original array corresponding
//		index element .
//		At last return resultant array .
//		Thats It !
	
	 static int[] productExceptSelf(int[] nums) 
	    {
	        int pre=1;
	        
	        int arr[]=new int[nums.length];
	        
	        for(int i=0;i<nums.length;i++)
	        {
	            arr[i]=pre;
	            pre=pre*nums[i];
	        }
	        
	        pre=1;
	        
	        for(int i=nums.length-1;i>=0;i--)
	        {
	            arr[i]=pre*arr[i];
	            pre=pre*nums[i];
	        }
	        return arr;
	    }
}
