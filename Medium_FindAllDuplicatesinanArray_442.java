package Sorting;

import java.util.ArrayList;
import java.util.List;

//						442  :  Find All Duplicates in an Array
//			
//			Given an integer array nums of length n where all the integers
//			of nums are in the range [1, n] and each integer appears once or
//			twice, return an array of all the integers that appears twice.
//			
//			You must write an algorithm that runs in O(n) time and uses only
//			constant extra space.
//			
//			Example 1:
//			
//			Input: nums = [4,3,2,7,8,2,3,1]
//			Output: [2,3]
//			Example 2:
//			
//			Input: nums = [1,1,2]
//			Output: [1]
//			Example 3:
//			
//			Input: nums = [1]
//			Output: []
//			
//			Constraints:
//			
//			n == nums.length
//			1 <= n <= 105
//			1 <= nums[i] <= n
//			Each element in nums appears once or twice.

public class Medium_FindAllDuplicatesinanArray_442 
{
	public static void main(String[] args) 
	{
		int arr[]= {4,3,2,7,8,2,3,1};
		List<Integer> l=findDuplicates(arr);
		System.out.println(l);	
	}
	
	static List<Integer> findDuplicates(int[] nums) 
    {
        int i=0;
        ArrayList<Integer> l = new ArrayList<>();
        while(i < nums.length)
        {
            if(nums[i] != nums[nums[i]-1])
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
            if(nums[j] != j+1)
            {
                l.add(nums[j]);
            }
        }
        return l;
    }
    static void swap(int arr[] ,int a , int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
