package Sorting;

//					41  :  First Missing Positive
//		
//		Given an unsorted integer array nums, return the
//		smallest missing positive integer.
//		
//		You must implement an algorithm that runs in O(n) 
//		time and uses constant extra space.
//		
//		Example 1:
//		
//		Input: nums = [1,2,0]
//		Output: 3
//		Example 2:
//		
//		Input: nums = [3,4,-1,1]
//		Output: 2
//		Example 3:
//		
//		Input: nums = [7,8,9,11,12]
//		Output: 1
//		
//		Constraints:
//		
//		1 <= nums.length <= 5 * 105
//		-231 <= nums[i] <= 231 - 1


public class Hard_FirstMissingPositive_41 
{
	public static void main(String[] args) 
	{
		int arr[]= {7,8,9,11,12};
		System.out.println(firstMissingPositive(arr));
	}

//		Note :
//		
//		All the questions where we need to find the repeating numbers, or missing
//		numbers can easily be solved with the help of a pattern that is cyclic sort.
//		In this pattern we simply place the elements of the array on their positions
//		( or at least try to ), like 1 should be at 1st position and 2 at the second 
//		position, and then we iterate again and check if for any index we have an element
//		whose value is not equal to index + 1, then that is the missing number.
//
//
//		In this question we can simply ignore the -ve elements as we only need to find the 
//		smallest positive element, so we ignore elements that are less than 0 and greater 
//		than arrays length and swap only if the element is not at its correct posiition. Then
//		we iterate again and find the missing number and return it.
	
	
	 static int firstMissingPositive(int[] nums) 
	    {
	        int i=0;
	        
	        while(i < nums.length)
	        {
	            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1])
	            {
	                swap(nums , i , nums[i]-1);
	            }
	            else
	            {
	                i++;
	            }
	        }
	        
	        for(int j=0;j<nums.length;j++)
	        {
	            if(nums[j] != j+1)
	            {
	                return j+1;
	            }
	        }
	        
	        return nums.length+1;
	    }
	    
	    static void swap(int arr[] , int a , int b)
	    {
	        int temp=arr[a];
	        arr[a]=arr[b];
	        arr[b]=temp;
	    }
}
