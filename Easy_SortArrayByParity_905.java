package Sorting;

import java.util.Arrays;

//										905  :  Sort Array By Parity
//				
//				Given an integer array nums , move all the even integers at the 
//				beginning of the array followed by all the odd integers.
//				
//				Return any array that satisfies this condition. 
//				
//				Example 1:
//				
//				Input: nums = [3,1,2,4]
//				Output: [2,4,3,1]
//				Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//				Example 2:
//				
//				Input: nums = [0]
//				Output: [0]
//				
//				Constraints:
//				
//				1 <= nums.length <= 5000
//				0 <= nums[i] <= 5000


public class Easy_SortArrayByParity_905 
{
	public static void main(String[] args) 
	{
		int arr[] = {3,1,2,4};
		
		int ans[]=sortArrayByParity(arr);
		
		System.out.println(Arrays.toString(ans));
	}

//				Note :
//					
//				Here we use three pointer method as we use in sort color's question
//				By taking refrence fron sort color's question we have divide array as even and odd
//				form
	
	static int[] sortArrayByParity(int[] nums) 
    {
        int i=0;
        int k=0;
        int j=nums.length-1;
        
        if(nums.length == 1)
        {
            return nums;
        }
        while(k <= j)
        {
            if(nums[k] %2 ==0)
            {
                int temp=nums[k];
                nums[k]=nums[i];
                nums[i]=temp;
                i++;
                k++;
            }
            else
            {
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                j--;
            }
        }
        return nums;
    }
}
