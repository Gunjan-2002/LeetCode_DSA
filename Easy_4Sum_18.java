package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//								18  :  4Sum
//				
//				Given an array nums of n integers, return an array of all the
//				unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//				
//				0 <= a, b, c, d < n
//				a, b, c, and d are distinct.
//				nums[a] + nums[b] + nums[c] + nums[d] == target
//				You may return the answer in any order.
//				
//				Example 1:
//				
//				Input: nums = [1,0,-1,0,-2,2], target = 0
//				Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//				Example 2:
//				
//				Input: nums = [2,2,2,2,2], target = 8
//				Output: [[2,2,2,2]]
//				
//				Constraints:
//				
//				1 <= nums.length <= 200
//				-109 <= nums[i] <= 109
//				-109 <= target <= 109

public class Easy_4Sum_18
{
	public static void main(String[] args)
	{
		int arr[]= {1,0,-1,0,-2,2};
		
		ArrayList<ArrayList<Integer>> ar=fourSum(arr, 0);
		
		System.out.println(ar);
		
	}

//			Note :
//				
//			This question is similar to 3 sum question .
//			In this question only we need to nest one more for loop
//			That's it !
	
	static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target)
    {
        HashSet<ArrayList<Integer>> hs=new HashSet<>();
        
        if(nums.length < 4)
        {
            return new ArrayList<>(hs);
        }
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
            for(int j=i+1;j<nums.length-2;j++)
            {
                int start=j+1;
                int end=nums.length-1;
                
                while(start < end)
                {
                    int sum=nums[i] + nums[j] + nums[start] + nums[end];
                    
                    if(sum == target)
                    {
                        hs.add((ArrayList<Integer>) Arrays.asList(nums[i] , nums[j] , nums[start] , nums[end]));
                        start++;
                        end--;
                    }
                    else if(sum > target)
                    {
                        end--;
                    }
                    else
                    {
                        start++;
                    }
                }
            }
        }
        return new ArrayList<>(hs);
    }
}
