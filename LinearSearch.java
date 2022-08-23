package Recursion.Easy;

import java.util.ArrayList;

public class LinearSearch {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		int arr1[]= {1,2,3,4,5,3,6,3};
		ArrayList<Integer> al = new ArrayList<>();
		System.out.println(search(arr, 12, 0));
		System.out.println(search1(arr, 5, 0));
		System.out.println(search2(arr1, 3, 0,al));
		System.out.println(search3(arr1, 3, 0));

	}
	
	static boolean search(int arr[] , int target , int ind)
	{
		if(ind == arr.length)
		{
			return false;
		}
		
		return arr[ind]==target || search(arr, target, ind+1);
	} 

	static int search1(int arr[] , int target , int ind)
	{
		if(ind == arr.length)
		{
			return -1;
		}
		
		if(arr[ind]==target)
		{
			return ind;
		}
		return search1(arr, target, ind+1);
	}
	
	static ArrayList<Integer> search2(int arr[] , int target , int ind , ArrayList<Integer> al)
	{
		if(ind == arr.length)
		{
			return al;
		}
		
		if(arr[ind]==target)
		{
			al.add(ind);
		}
		return search2(arr, target, ind+1,al);
	}
	
	static ArrayList<Integer> search3(int arr[] , int target , int ind)
	{
		ArrayList<Integer> al = new ArrayList<>();
		if(ind == arr.length)
		{
			return al;
		}
		
		if(arr[ind]==target)
		{
			al.add(ind);
		}
		
		ArrayList<Integer> lastCallResult = search3(arr, target, ind+1);
		
		al.addAll(lastCallResult);
		
		return al;
	}

}
