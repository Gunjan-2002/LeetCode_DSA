package Sorting;
import java.util.*;


//			215  :  Kth Largest Element in an Array
//			
//			Given an integer array nums and an integer k, 
//			return the kth largest element in the array.
//			
//			Note that it is the kth largest element in the 
//			sorted order, not the kth distinct element.
//			
//			Example 1:
//			
//			Input: nums = [3,2,1,5,6,4], k = 2
//			Output: 5
//			Example 2:
//			
//			Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//			Output: 4
//			
//			Constraints:
//			
//			1 <= k <= nums.length <= 104
//			-104 <= nums[i] <= 104



public class Medium_KthLargestElementinanArray_215 
{
	public static void main(String[] args) 
	{
		int arr[]= {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(arr, 4 ));
	}

	
//		Note :
//			
//		To solve this question we have two method's
//		1] Sort the array and then return k element from last
//		2] Use Priority Queue
//		    	In java by default Priority queue forms Min Heap .
//		    	In C++  by default Priority queue forms Max Heap .
//		    	
//		    	so first of all add the first k elements of array to priority
//		    	queue .
//		    	Then start the loop from k index check that if peek element 
//		    	is smaller than the currnet index array element if yes then remove
//		    	the peek element and add the current index element to priority queue.
//		    	At last return peek element .
//		    	That's it .
	    	
	
	 static int findKthLargest(int[] nums, int k)  
	    {
//	         Arrays.sort(nums);
	        
//	         return nums[nums.length - k ];
	        
	        PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
	        
	        for(int i=0;i<k;i++)
	        {
	            pq.add(nums[i]);
	        }
	        
	        for(int i=k;i<nums.length;i++)
	        {
	            if(pq.peek() < nums[i])
	            {
	                pq.remove();
	                pq.add(nums[i]);
	            }
	        }
	        return pq.peek();
	    }
}
