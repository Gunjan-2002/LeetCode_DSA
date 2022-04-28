package Sorting;

import java.util.Arrays;

//							16  :   3Sum Closest
//			
//			Given an integer array nums of length n and an integer target,
//			find three integers in nums such that the sum is closest to target.
//			
//			Return the sum of the three integers.
//			
//			You may assume that each input would have exactly one solution.
//			
//			Example 1:
//			
//			Input: nums = [-1,2,1,-4], target = 1
//			Output: 2
//			Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//			Example 2:
//			
//			Input: nums = [0,0,0], target = 1
//			Output: 0
//			
//			Constraints:
//			
//			3 <= nums.length <= 1000
//			-1000 <= nums[i] <= 1000
//			-104 <= target <= 104

public class Easy_3SumClosest_16
{
	public static void main(String[] args) 
	{
		int arr[]= {-1,2,1,-4};
		System.out.println(threeSumClosest(arr, 1));
	}

//			Note :
//				
//			It is similar to the three sum problem .
//			Here first we sort the array and then define the closestsum 
//			variable which has value arr[0] + arr[1] + arr[arr.length-1] 
//			initially and then we run a for loop from index i=0 to arr.length
//			inside it define start=i+1 and end=last element 
//			then while loop upto start < end and we check if current sum - target 
//			is less than than closestsum - target if yes then update closestsum with 
//			currentsum.
//			At last return closest sum.
//			That's it !
	
	
	static int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int closestSum=nums[0] + nums[1] + nums[nums.length-1];
        
        for(int i=0;i<nums.length-2;i++)
        {
            int start=i+1;
            int end=nums.length-1;
            
            while(start < end)
            {
            int currentSum=nums[i] + nums[start] + nums[end];
            
            if(currentSum > target)
            {
                end--;
            }
            else
            {
                start++;
            }
            
            if(Math.abs(currentSum - target) < Math.abs(closestSum - target))
            {
                closestSum=currentSum;
            }
            }
        }      
        return closestSum;
    }	
}
