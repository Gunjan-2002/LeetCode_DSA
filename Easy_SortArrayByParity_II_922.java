package Sorting;

import java.util.Arrays;

//											922  :  Sort Array By Parity II
//				
//				Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
//				
//				Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
//				
//				Return any answer array that satisfies this condition.
//				
//				Example 1:
//				
//				Input: nums = [4,2,5,7]
//				Output: [4,5,2,7]
//				Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//				Example 2:
//				
//				Input: nums = [2,3]
//				Output: [2,3]
//				
//				Constraints:
//				
//				2 <= nums.length <= 2 * 104
//				nums.length is even.
//				Half of the integers in nums are even.
//				0 <= nums[i] <= 1000
//				
//				Follow Up: Could you solve it in-place?


public class Easy_SortArrayByParity_II_922
{
	public static void main(String[] args)
	{
		int arr[]= {4,2,5,7};
		
		int ans[]=sortArrayByParityII(arr);
		
		System.out.println(Arrays.toString(ans));
	}
	
//				Note :
//					
//				Here we use two pointers first one points even index always
//				and second one points odd index i.e i=0 & j=1 and increment 
//				it by 2 always .
//				
//				Boundry condition for i is i < arr.length-2 & for j is j < arr.length .
//				
//				if(arr[i] is even ) then increment i if(arr[j] is odd) then increement
//				j also check if both condition not follows then swap elements present
//				at index i and j and also check boundry condition for i and j .
//				That's it !
//				
	
	static int[] sortArrayByParityII(int[] nums) 
    {
        int i=0;
        int j=1;
        
        while(i <= nums.length-2 && j <= nums.length-1)
        {
            if(nums[i] %2 == 0)
            {
                i=i+2;
            }
            if(nums[j] %2 != 0)
            {
                j=j+2;
            }
            if(i <= nums.length-2 && j <= nums.length-1 && nums[i] %2 != 0  && nums[j] %2 == 0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        return nums;
    }
}
