package Sorting;

import java.util.Arrays;
import java.util.HashMap;

//									1  :  Two Sum
//				
//				Given an array of integers nums and an integer target, 
//				return indices of the two numbers such that they add up to target.
//				
//				You may assume that each input would have exactly one solution, 
//				and you may not use the same element twice.
//				
//				You can return the answer in any order.
//				
//				Example 1:
//				
//				Input: nums = [2,7,11,15], target = 9
//				Output: [0,1]
//				Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//				Example 2:
//				
//				Input: nums = [3,2,4], target = 6
//				Output: [1,2]
//				Example 3:
//				
//				Input: nums = [3,3], target = 6
//				Output: [0,1]
//				
//				Constraints:
//				
//				2 <= nums.length <= 104
//				-109 <= nums[i] <= 109
//				-109 <= target <= 109
//				Only one valid answer exists.
//				
//				Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

public class Easy_TwoSum_1 
{
	public static void main(String[] args)
	{
		int arr[]= {2,7,11,15};
		
		int ans[]=twoSum(arr, 9);
		
		System.out.println(Arrays.toString(ans));
	}
	
//				Note :
//					
//				1] Method 1 : Brute Fore Method
//					Two loops 
//					Time - O(n^2)  Space - O(2)
//					
//				2] Method 2 : Using HashMap
//					First we need to store index of every element before sorting
//					We use two hashMap which contains index 
//					of element , second hashmap used for storing
//					index of duplicate element.
//					Then sort the original array
//					then one loop to check for target indices.
//					That's it !
//					Time - O(n) Space - O(n)
	
	
static int[] twoSum(int[] nums, int target) 
    {
//			        int ans[]=new int[2];
//			        
//			        
//			        boolean check=false;
//			        
//			        for(int i=0;i<nums.length;i++)
//			        {
//			            int hi=nums.length-1;
//			            
//			            while(i < hi)
//			            {
//			                if(nums[i] + nums[hi] == target)
//			                {
//			                    ans[0]=i;
//			                    ans[1]=hi;
//			                    check=true;
//			                    break;
//			                }
//			                hi--;
//			            }
//			            if(check == true)
//			            {
//			                break;
//			            }
//			        }
//			        return ans;
        
        HashMap<Integer,Integer> hm1= new HashMap<>();
        HashMap<Integer,Integer> hm2= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(	hm1.containsKey(nums[i]))
            {
                hm2.put(nums[i],i);
            }
            else
            {
                hm1.put(nums[i],i);
            }
            
        }
        Arrays.sort(nums);
        int ans[]=new int[2];
        
        int l=0;
        int h=nums.length-1;
        
        while(l < h)
        {
            if((nums[l] + nums[h]) == target)
            {
                if(nums[l] == nums[h])
                {
                     ans[0]=hm1.get(nums[l]);
                     ans[1]=hm2.get(nums[l]);
                }
                else
                {
                    ans[0]=hm1.get(nums[l]);
                    ans[1]=hm1.get(nums[h]);
                }
               
            }
            
            if((nums[l] + nums[h]) > target)
            {
                h--;
            }
            else
            {
                l++;
            }
        }
        
        return ans;
        
    }

}
