package Cyclic_Sort;

//											287 : Find the Duplicate Number
//				
//				Given an array of integers nums containing n + 1 integers where each 
//				integer is in the range [1, n] inclusive.
//				
//				There is only one repeated number in nums, return this repeated number.
//				
//				You must solve the problem without modifying the array nums and uses only 
//				constant extra space.
//				
//				
//				Example 1:
//				
//				Input: nums = [1,3,4,2,2]
//				Output: 2
//				Example 2:
//				
//				Input: nums = [3,1,3,4,2]
//				Output: 3
//				
//				Constraints:
//				
//				1 <= n <= 105
//				nums.length == n + 1
//				1 <= nums[i] <= n
//				All the integers in nums appear only once except for precisely one integer which appears two or more times.
//				
//				Follow up:
//				
//				How can we prove that at least one duplicate number must exist in nums?
//				Can you solve the problem in linear runtime complexity?

public class FindtheDuplicateNumber_287 
{
	public static void main(String[] args)
	{
		int arr[]= {1,3,4,2,4};
		int ans=findDuplicate(arr);
		System.out.println(ans);
	}
	
//				Note :
//					
//				To find Duplicates in a Array first check the array elements
//				In question array elements are from 1 to n . so first thing should come in our mind is Cyclic Sort .
//				
//				In this question we will use cyclic sort but will do some midifications .
//				first we will check that index i+1 and arr[i] if they are equal we will increment pointer i by one else
//				we will again check that arr[arr[i]-1] and arr[i] if they are equal then we return arr[i] else we will swap 
//				the elements present at index arr[i]-1 and i .
	
	static int findDuplicate(int[] nums) 
	{
		int i=0;
		
		while(i < nums.length)
		{
			if(i+1 != nums[i])
			{
				if(nums[nums[i]-1] != nums[i])
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
	
	static void swap(int arr[] , int a, int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
