package Cyclic_Sort;

import java.util.ArrayList;
import java.util.List;

//										448 : Find All Numbers Disappeared in an Array
//				
//				Given an array nums of n integers where nums[i] is in the range [1, n],
//				return an array of all the integers in the range [1, n] that do not appear in nums.
//				
//				
//				Example 1:
//				
//				Input: nums = [4,3,2,7,8,2,3,1]
//				Output: [5,6]
//				Example 2:
//				
//				Input: nums = [1,1]
//				Output: [2]
//				
//				Constraints:
//				
//				n == nums.length
//				1 <= n <= 105
//				1 <= nums[i] <= n
//				
//				Follow up: Could you do it without extra space and in O(n) runtime? You may assume the
//				returned list does not count as extra space.

public class FindAllNumbersDisappearedinanArray_448 {

	public static void main(String[] args) 
	{
		int arr[]= {4,3,2,7,8,2,3,1};
		
		List<Integer> ans=findDisappearedNumbers(arr);
		
		System.out.println(ans);
	}
	
	
//				Note :
//					
//				Question says array contains element from 1 to n . so first thing should be come in our mind is that we should use Cyclic Sort
//				After sorting elements we will run a loop and we will add the elements which are not present on their own place
//				for Ex :  index i+1 != arr[i] then we should add this element
//				
//				Time Complexity : O(n)
//				Space is : O(n);
	
	static List<Integer> findDisappearedNumbers(int[] nums) 
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
        
        for(int j=0;j<nums.length;j++)
        {
            if(j+1 != nums[j])
            {
                ar.add(j+1);
            }
        }
        return ar;
    }
    
    static void swap(int arr[] , int a , int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
