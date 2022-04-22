package Cyclic_Sort;

//									41 : First Missing Positive
//			
//			Given an unsorted integer array nums, return the smallest missing positive integer.
//			
//			You must implement an algorithm that runs in O(n) time and uses constant extra space.
//			
//			
//			Example 1:
//			
//			Input: nums = [1,2,0]
//			Output: 3
//			Example 2:
//			
//			Input: nums = [3,4,-1,1]
//			Output: 2
//			Example 3:
//			
//			Input: nums = [7,8,9,11,12]
//			Output: 1
//			
//			Constraints:
//			
//			1 <= nums.length <= 5 * 105
//			-231 <= nums[i] <= 231 - 1

public class FirstMissingPositive_41 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}
	
//			Note :
//				
//			Question says that array has elements starting from 1 to n
//			So first thing should click in our mind must be Cyclic Sort
//			
//			First apply Cyclic Sort 
//			then print elements which are not present at their correct position
//			Ignore elements which are negative and which are greater than array length
//			and its solved !!
	
	
	public int firstMissingPositive(int[] nums) 
    {
        int i=0;
        while(i < nums.length)
        {
                    if(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i])
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
            if(j+1 != nums[j])
            {
                return j+1;
            }
        }
         return nums.length+1;             
    }
	
    void swap(int arr[] , int a , int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
