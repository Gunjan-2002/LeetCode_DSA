package Sorting;

//										268 : Missing Number
//			
//			Given an array nums containing n distinct numbers in the range [0, n], 
//			return the only number in the range that is missing from the array.
//			
//			
//			Example 1:
//			
//			Input: nums = [3,0,1]
//			Output: 2
//			Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
//			2 is the missing number in the range since it does not appear in nums.
//			
//			Example 2:
//			
//			Input: nums = [0,1]
//			Output: 2
//			Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 
//			2 is the missing number in the range since it does not appear in nums.
//			
//			Example 3:
//			
//			Input: nums = [9,6,4,2,3,5,7,0,1]
//			Output: 8
//			Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 
//			8 is the missing number in the range since it does not appear in nums.
//			
//			Constraints:
//			
//			n == nums.length
//			1 <= n <= 104
//			0 <= nums[i] <= n
//			All the numbers of nums are unique.
//			
//			Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?


public class Easy_MissingNumber_268 
{
	public static void main(String[] args) 
	{
		int arr[]= {9,6,4,2,3,5,7,0,1};
		
		int ans=missingNumber(arr);
		System.out.println(ans);
	}
	
// 	Note :
	
// 	Here in this question array elements are from 0 to n so first
// 	thing should come in our mind must be use of Cyclic Sort .
	
// 	So by using cyclic sort first we will sort and then run a loop
// 	for checking the element which is not present at its correct index.
// 	if not present at correct index we will return it
// 	at last we will return array.length .
// 	That's it
	
	static int missingNumber(int[] arr) 
	{
		int i=0;
		while(i < arr.length)
		{
			if(arr[i]<arr.length &&  arr[arr[i]] != arr[i] )
			{
				swap(arr,i,arr[i]);
			}
			else
			{
				i++;
			}
		}
		
		for(int j=0;j<arr.length;j++)
		{
			if(j != arr[j])
			{
				return j;
			}
		}
		return arr.length;
	}
	
	static void swap(int arr[] ,int a , int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
