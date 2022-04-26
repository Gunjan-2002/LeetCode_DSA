package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//									1200 : Minimum Absolute Difference
//			
//			Given an array of distinct integers arr, find all pairs of elements 
//			with the minimum absolute difference of any two elements.
//			
//			Return a list of pairs in ascending order(with respect to pairs), each
//			pair [a, b] follows
//			
//			a, b are from arr
//			a < b
//			b - a equals to the minimum absolute difference of any two elements in arr
//			
//			Example 1:
//			
//			Input: arr = [4,2,1,3]
//			Output: [[1,2],[2,3],[3,4]]
//			Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//			Example 2:
//			
//			Input: arr = [1,3,6,10,15]
//			Output: [[1,3]]
//			Example 3:
//			
//			Input: arr = [3,8,-10,23,19,-4,-14,27]
//			Output: [[-14,-10],[19,23],[23,27]]
//			
//			Constraints:
//			
//			2 <= arr.length <= 105
//			-106 <= arr[i] <= 106


public class Easy_MinimumAbsoluteDifference_1200 
{
	public static void main(String[] args) 
	{
		int arr[]= {3,8,-10,23,19,-4,-14,27};
		
		List<List<Integer>> al=minimumAbsDifference(arr);
		
		System.out.println(al);
	}
	
//			Note :
//				
//			First sort the element because we will get the minimum
//			pair easily because after sorting diffrence of adjacent element 
//			will be always smaller .
//			Then find the pairs having minimum sum and then print
//			That's it !
	
	
	 static List<List<Integer>> minimumAbsDifference(int[] arr)
	    {
			 Arrays.sort(arr);
		        int min=Integer.MAX_VALUE;
		        for(int i=0;i<arr.length-1;i++)
		        {
		            int diff=arr[i]-arr[i+1];
		            if(Math.abs(diff) < min)
		            {
		                min=Math.abs(diff);
		            }
		        }
		        List<List<Integer>> ar=new ArrayList<List<Integer>>();
		        
		        for(int i=0;i<arr.length-1;i++)
		        {
					if((arr[i+1]-arr[i]) == min)
		            {
						ArrayList<Integer> a=new ArrayList<>();
		                a.add(arr[i]);
		                a.add(arr[i+1]);
		                ar.add(a);
		            }
		        }
		        return ar;	   
	        }
}
