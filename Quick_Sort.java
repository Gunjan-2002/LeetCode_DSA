package Sorting;

import java.util.Arrays;

public class Quick_Sort
{
	public static void main(String[] args)
	{
		int arr[]= {4 , 2 , 1 , 5 , 3,7};
		System.out.println(Arrays.toString(arr));
		QuickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	
	static void QuickSort(int arr[] , int low , int high)
	{
		if(low >= high)
		{
			return;
		}
		
		int s=low;
		int e=high;
		
		int mid=s + (e-s)/2;
		int pivot=arr[e];
		
		while(s <= e)
		{
			while(arr[s] < pivot)
			{
				s++;
			}
			
			while(arr[e] > pivot)
			{
				e--;
			}
			
			if(s <= e)
			{
				int temp=arr[s];
				arr[s]=arr[e];
				arr[e]=temp;
				s++;
				e--;
			}
		}
		
		QuickSort(arr, low, e);
		QuickSort(arr, s, high);
		
	}

}
