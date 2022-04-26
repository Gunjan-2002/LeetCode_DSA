package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//												1122 :  Relative Sort Array
//				
//				Given two arrays arr1 and arr2, the elements of arr2 are distinct,
//				and all elements in arr2 are also in arr1.
//				
//				Sort the elements of arr1 such that the relative ordering of items in 
//				arr1 are the same as in arr2. Elements that do not appear in arr2 should 
//				be placed at the end of arr1 in ascending order.
//				
//				Example 1:
//				
//				Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//				Output: [2,2,2,1,4,3,3,9,6,7,19]
//				Example 2:
//				
//				Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//				Output: [22,28,8,6,17,44]
//				
//				Constraints:
//				
//				1 <= arr1.length, arr2.length <= 1000
//				0 <= arr1[i], arr2[i] <= 1000
//				All the elements of arr2 are distinct.
//				Each arr2[i] is in arr1.



public class Easy_RelativeSortArray_1122 
{
	public static void main(String[] args) 
	{
		int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
		int arr2[] = {2,1,4,3,9,6};
		
		int ans1[]=relativeSortArray_1(arr1, arr2);
		int ans2[]=relativeSortArray_2(arr1, arr2);
		
		System.out.println(Arrays.toString(ans1));
		System.out.println(Arrays.toString(ans2));
	}

	 static int[] relativeSortArray_1(int[] arr1, int[] arr2)
	 {
		 int ans[]=new int[arr1.length];
	        int c=0;
	        
	        for(int i=0;i<arr2.length;i++)
	        {
	            int tg=arr2[i];
	            for(int j=0;j<arr1.length;j++)
	            {
	                if(tg == arr1[j])
	                {
	                    ans[c++]=arr1[j];
	                }
	            }
	        }
	        
	        ArrayList<Integer> ar=new ArrayList<>();
	        int g=0;
	        
	        for(int i=0;i<arr1.length;i++)
	        {
	            int tg=arr1[i];
	            for(int j=0;j<arr2.length;j++)
	            {
	                if(tg == arr2[j])
	                {
	                    g=1;
	                    break;
	                }
	            }
	            if(g == 0)
	            {
	                ar.add(arr1[i]);
	            }
	            g=0;
	        }
	        Collections.sort(ar);
	        for(int x : ar)
	        {
	            ans[c++]=x;
	        }
	        return ans;
	  }
	 
	 static int[] relativeSortArray_2(int[] arr1, int[] arr2)
	 {
		 HashMap<Integer, Integer> hm=new HashMap<>();
		 
			 for(int i=0;i<arr1.length;i++)
			 {
				 if(hm.containsKey(arr1[i]))
				 {
					 hm.put(arr1[i],hm.get(arr1[i])+1);
				 }
				 else
				 {
					 hm.put(arr1[i],1);
				 }
			 }
			 int idx=0;
			 
			 for(int i=0;i<arr2.length;i++)
			 {
				 for(int j=0;j<hm.get(arr2[i]);j++)
				 {
					 arr1[idx++]=arr2[i];
				 }
				 hm.remove(arr2[i]);
			 }
			 ArrayList<Integer> ar=new ArrayList<>();
			 
			 for(int x : hm.keySet())
			 {
				 for(int j=0;j<hm.get(x);j++)
				 {
					 ar.add(x);
				 }
			 }
			 
			 Collections.sort(ar);
			 
			 for(int x : ar)
			 {
				 arr1[idx++]=x;
			 }
			 
			 return arr1;
	 }	
}
