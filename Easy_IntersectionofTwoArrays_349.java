package Sorting;

import java.util.ArrayList;
import java.util.HashSet;

//											349  :  Intersection of Two Arrays
//					
//					Given two integer arrays nums1 and nums2, return an array
//					of their intersection. Each element in the result must be unique 
//					and you may return the result in any order.
//					
//					Example 1:
//					
//					Input: nums1 = [1,2,2,1], nums2 = [2,2]
//					Output: [2]
//					Example 2:
//					
//					Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//					Output: [9,4]
//					Explanation: [4,9] is also accepted.
//					
//					Constraints:
//					
//					1 <= nums1.length, nums2.length <= 1000
//					0 <= nums1[i], nums2[i] <= 1000

public class Easy_IntersectionofTwoArrays_349 {

	public static void main(String[] args) 
	{
		
	}

//			Note :
//				
//			In this we have two methods to solve question
//			1] With Frequency method
//			2] HashSet Method
//		
//			HashSet Method is so effective in means of time complexity
//			It is faster than frequency method
	
	
	 public int[] intersection1(int[] nums1, int[] nums2) 
	    {
	        int freq1[]=getFreq(nums1);
	        int freq2[]=getFreq(nums2);
	        ArrayList<Integer> l=new ArrayList<>();        
	        for(int i=0;i<freq1.length;i++)
	        {
	            int count=Math.min(freq1[i],freq2[i]);
	            // if(freq1[i] == freq2[i])
	            // {
	            //     l.add(i);
	            // }
	            if(count > 0)
	            {
	                l.add(i);
	            }
	        }
	        
	        int ans[] = new int[l.size()];
	        
	        for(int i=0;i<l.size();i++)
	        {
	            ans[i]=l.get(i);
	        }
	        
	        return ans;
	    }
	 
	 public int[] intersection2(int[] nums1, int[] nums2) 
	    {
	       HashSet<Integer> h=new HashSet<>();
	       
	       for(int x : nums1)
	       {
	    	   h.add(x);
	       }
	       
	       HashSet<Integer> intersection = new HashSet<>();
	       
	       for(int x : nums2)
	       {
	    	   if(h.contains(x))
	    	   {
	    		   intersection.add(x);
	    	   }
	       }
	       
	       int ans[]=new int[intersection.size()];
	       int i=0;
	       for(int x : intersection)
	       {
	    	   ans[i]=x;
	    	   i++;
	       }
	       
	       return ans;
	    }
  
	    private int[] getFreq(int arr[])
	    {
	        int ar[]=new int[1001];
	        for(int i : arr)
	        {
	            ar[i]++;
	        }
	        return ar;
	    }	
}
