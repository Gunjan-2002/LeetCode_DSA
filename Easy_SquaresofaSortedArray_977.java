package Sorting;

import java.util.Arrays;

//										977 : Squares of a Sorted Array
//			
//			Given an integer array nums sorted in non-decreasing order, 
//			return an array of the squares of each number sorted in non-decreasing
//			order.
//			
//			Example 1:
//			
//			Input: nums = [-4,-1,0,3,10]
//			Output: [0,1,9,16,100]
//			Explanation: After squaring, the array becomes [16,1,0,9,100].
//			After sorting, it becomes [0,1,9,16,100].
//			
//			Example 2:
//			
//			Input: nums = [-7,-3,2,3,11]
//			Output: [4,9,9,49,121]
//			
//			Constraints:
//			
//			1 <= nums.length <= 104
//			-104 <= nums[i] <= 104
//			nums is sorted in non-decreasing order.
//			
//			Follow up: Squaring each element and sorting the new array is very trivial,
//			could you find an O(n) solution using a different approach?


public class Easy_SquaresofaSortedArray_977 
{
	public static void main(String[] args)
	{
		int arr[]= {-4,-1,0,3,10};
		
		int ans[]=sortedSquares(arr);
		
		System.out.println(Arrays.toString(ans));
	}
	
//				Note :
//					
//				We can use here two methods 
//				1] First square all elements of array and then sort
//					the array again and return it .
//					Its time complexity is O(nlog(n)) and space is O(1).
//					
//				2] Three pointer method , here we use a extra array
//					Time complexity is O(n) and space is O(n).
	
	static int[] sortedSquares(int[] nums)
    {
        int l=0,r=nums.length-1;
        int p=nums.length-1;
        
        int ans[]=new int[nums.length];
        
        while(l <= r)
        {
            if(Math.abs(nums[l]) > Math.abs(nums[r]))
            {
                ans[p]=nums[l]*nums[l];
                p--;
                l++;
            }
            else
            {
                ans[p]=nums[r]*nums[r];
                p--;
                r--;
            }
        }
        return ans;
    }
}
