package Cyclic_Sort;
import java.util.*;


//												442 : Find All Duplicates in an Array
//				
//				Given an integer array nums of length n where all the integers of nums are in the range [1, n] 
//				and each integer appears once or twice, return an array of all the integers that appears twice.
//				
//				You must write an algorithm that runs in O(n) time and uses only constant extra space.
//				
//				Example 1:
//				
//				Input: nums = [4,3,2,7,8,2,3,1]
//				Output: [2,3]
//				Example 2:
//				
//				Input: nums = [1,1,2]
//				Output: [1]
//				Example 3:
//				
//				Input: nums = [1]
//				Output: []
//				
//				Constraints:
//				
//				n == nums.length
//				1 <= n <= 105
//				1 <= nums[i] <= n
//				Each element in nums appears once or twice.

public class FindAllDuplicatesinanArray_442 
{
	public static void main(String[] args)
	{
		int arr[]= {4,3,2,7,8,2,3,1};
		int arr1[]= {1};
		int arr2[]= {1,1,2};
		
		List<Integer> ar1=findDuplicates(arr);
		List<Integer> ar2=findDuplicates(arr1);
		List<Integer> ar3=findDuplicates(arr2);
		
		System.out.println(ar1);
		System.out.println(ar2);
		System.out.println(ar3);
	}
	
//				Note :
//					
//				Question says that array has elements starting from 1 to n
//				So first thing should click in our mind must be Cyclic Sort
//				
//				First apply Cyclic Sort 
//				then print elements which are not present at their correct position
//				and its solved !!
	
	static List<Integer> findDuplicates(int[] nums)
    {
        ArrayList<Integer> ar=new ArrayList<>();
        
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
        for(int index=0;index<nums.length;index++)
        {
            if(index+1 != nums[index])
            {
                ar.add(nums[index]);
            }
        }
     return ar;   
    }

	static void swap(int arr[] ,int a , int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
