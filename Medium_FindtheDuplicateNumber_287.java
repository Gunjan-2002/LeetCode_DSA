package Sorting;

//							287  :  Find the Duplicate Number
//			
//			Given an array of integers nums containing n + 1 integers
//			where each integer is in the range [1, n] inclusive.
//			
//			There is only one repeated number in nums, return this repeated number.
//			
//			You must solve the problem without modifying the array nums and uses only
//			constant extra space.
//			
//			Example 1:
//			
//			Input: nums = [1,3,4,2,2]
//			Output: 2
//			Example 2:
//			
//			Input: nums = [3,1,3,4,2]
//			Output: 3
//			
//			Constraints:
//			
//			1 <= n <= 105
//			nums.length == n + 1
//			1 <= nums[i] <= n
//			All the integers in nums appear only once except for precisely one integer which appears two or more times.
//			
//			Follow up:
//			
//			How can we prove that at least one duplicate number must exist in nums?
//			Can you solve the problem in linear runtime complexity?

public class Medium_FindtheDuplicateNumber_287 
{
	public static void main(String[] args) 
	{
		int arr[]= {3,1,3,4,2};
		System.out.println(findDuplicate(arr));
	}
	
//		Note :
//			
//		First of all read the question carefully , it is given that
//		array consist of element range from 1 to n only , so first thing
//		which must come to our mind must be Cyclic Sort . 
//		Modify the Cyclic Sort for this question .
//		That's it !
	
	
	 static int findDuplicate(int[] nums) 
	    {
	        int i=0;
	        
	        while(i < nums.length)
	        {
	            if(nums[i] != i+1)
	            {
	                if(nums[i] != nums[nums[i] - 1])
	                {
	                    swap(nums,i,nums[i]-1);
	                }
	                else
	                {
	                    return nums[i];
	                }
	            }
	            else
	            {
	                i++;
	            }
	        }
	        return -1;
	    }
	    
	   static void swap(int arr[] , int a , int b)
	    {
	        int temp=arr[a];
	        arr[a]=arr[b];
	        arr[b]=temp;
	    }
}
