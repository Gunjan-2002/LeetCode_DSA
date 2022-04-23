package Sorting;

//												169  : Majority Element
//					
//					Given an array nums of size n, return the majority element.
//					
//					The majority element is the element that appears more than n / 2
//					times. You may assume that the majority element always exists in the array.
//					
//					Example 1:
//					
//					Input: nums = [3,2,3]
//					Output: 3
//					Example 2:
//					
//					Input: nums = [2,2,1,1,1,2,2]
//					Output: 2
//					
//					Constraints:
//					
//					n == nums.length
//					1 <= n <= 5 * 104
//					-109 <= nums[i] <= 109
//					
//					Follow-up: Could you solve the problem in linear time and in O(1) space?



public class Easy_MajorityElement_169
{
	public static void main(String[] args) 
	{
		int arr[]= {2,2,1,1,1,2,2};
		
		int ans=majority(arr);
		
		System.out.println(ans);
	}

	static int majority(int arr[])
	{
		int ele=0;
		int count=1;
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i] == arr[ele])
			{
				count++;
			}
			else
			{
				count--;
			}
			
			if(count==0)
			{
				ele=i;
				count=1;
			}
		}
		
		return arr[ele];
	}	
	
}
