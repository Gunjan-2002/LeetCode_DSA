package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//											414 : Third Maximum Number
//				
//				Given an integer array nums, return the third distinct maximum number in
//				this array. If the third maximum does not exist, return the maximum number.
//				
//				Example 1:
//				
//				Input: nums = [3,2,1]
//				Output: 1
//				Explanation:
//				The first distinct maximum is 3.
//				The second distinct maximum is 2.
//				The third distinct maximum is 1.
//				Example 2:
//				
//				Input: nums = [1,2]
//				Output: 2
//				Explanation:
//				The first distinct maximum is 2.
//				The second distinct maximum is 1.
//				The third distinct maximum does not exist, so the maximum (2) is 
//				returned instead.
//				
//				Example 3:
//				
//				Input: nums = [2,2,3,1]
//				Output: 1
//				Explanation:
//				The first distinct maximum is 3.
//				The second distinct maximum is 2 (both 2's are counted together since they have the same value).
//				The third distinct maximum is 1.
//				
//				Constraints:
//				
//				1 <= nums.length <= 104
//				-231 <= nums[i] <= 231 - 1
//				
//				Follow up: Can you find an O(n) solution?


public class Easy_ThirdMaximumNumber_414
{
	public static void main(String[] args) 
	{
		int arr[]= {3,2,1};
		
		int a1=thirdMax_1(arr);
		int a2=thirdMax_2(arr);
		int a3=thirdMax_3(arr);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
	
//			Note :
//				
//			1] First Sort the array and then find third maximum element.
//			2] Use 3 variable max1 , max2 , max3 . run for loop and check
//			    for every element with max1 , max2 , max3 .
//			    if element is same as max1 , max2 , max3 then dont do anything
//			    At last return max3 if max3 is not equal to -infinity else return max1
//			3] Use hashSet  
	
	
	static int thirdMax_1(int[] nums) 
	{
      Arrays.sort(nums);
        
      int count=1;
      int max=nums[nums.length-1];
      int tmax=nums[nums.length-1];
     
      for(int i=nums.length-2;i>=0;i--)
      {
          if(nums[i] != nums[i+1])
          {
              count++;
              tmax=nums[i];
          }
         
          if(count == 3)
          {
              return tmax;
          }
      }  
      return max; 
    }
	
	static int thirdMax_2(int[] nums) 
	{
		int n=nums.length;
	     
	     if(n == 1)
	     {
	         return nums[0];
	     }
	     if(n == 2)
	     {
	         return Math.max(nums[0],nums[1]);
	     }
	     
	     long max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
	     
	     for(int x : nums)
	     {
	         if(x == max1 || x == max2 || x == max3)
	         {
	             continue;
	         }
	         if(x > max1)
	         {
	             max3=max2;
	             max2=max1;
	             max1=x;
	         }
	         else if(x > max2)
	         {
	             max3=max2;
	             max2=x;
	         }
	         else
	         {
	             max3=x;
	         }
	     }
	     
	     if(max3 == Integer.MIN_VALUE)
	     {
	         return (int)max1;
	     }
	     
	     return (int)max3;     
	}
	
	static int thirdMax_3(int[] nums) 
	{
		Set <Integer> maxElements = new HashSet <>();
        for(int element : nums)
        {
            maxElements.add(element);
            if(maxElements.size() > 3)
                maxElements.remove(Collections.min(maxElements));
        }
        if(maxElements.size() == 3)
            return Collections.min(maxElements);
        return Collections.max(maxElements);
	}
	
}
