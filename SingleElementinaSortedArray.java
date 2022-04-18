package Medium;

import java.util.Arrays;

//									Single Element in a Sorted Array
//			
//			You are given a sorted array consisting of only integers
//			where every element appears exactly twice, except for one
//			element which appears exactly once.
//			
//			Return the single element that appears only once.
//			
//			Your solution must run in O(log n) time and O(1) space.
//			
//			
//			Example 1:
//			
//			Input: nums = [1,1,2,3,3,4,4,8,8]
//			Output: 2
//			Example 2:
//			
//			Input: nums = [3,3,7,7,10,11,11]
//			Output: 10
//			
//			Constraints:
//			
//			1 <= nums.length <= 105
//			0 <= nums[i] <= 105

public class SingleElementinaSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[]= {2,4,1,6,4,9};
		Arrays.sort(ans);
		System.out.println(Arrays.toString(ans));
	}
	
	public int singleNonDuplicate(int[] nums) 
    {
        
        int start=0;
        int end=nums.length-1;
        if(end ==0)
        {
            return nums[0];
        }
        
        if(nums[0] != nums[1])
        {
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2])
        {
            return nums[nums.length-1];
        }
        
        while(start <= end)
        {
            int mid=start + (end-start)/2;
            
            if(nums[mid+1] != nums[mid] && nums[mid-1] != nums[mid])
            {
                return nums[mid];
            }
            
            if((mid%2==0 && nums[mid]==nums[mid+1])  || (mid%2==1 && nums[mid-1]==nums[mid]))
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return nums[start];
    }

}
