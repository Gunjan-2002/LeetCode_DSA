package Cyclic_Sort;
import java.util.Arrays;

//				Note :
//					
//				Whenever it is given that array contains number from 1 to n or 0 to n 
//				then in our mind first thing that should  come must be "Cyclic Sort"
//				
//				Cyclic Sort Time Complexity is O(n)
//				Space Complexity is O(1)



public class CyclicSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,5,2,1,4};
		int ans[]=cyclicSort(arr);
		System.out.println("Hellooooo");
		System.out.println("hello"+Arrays.toString(ans));	
	}

//			Cyclic Sort
//			
//			In Cyclic Sort we run a loop from 0 index to n-1 index . We check that element 
//			present at i index is same as element present at arr[i]-1 index , if this is true then
//			we increment pointer i if false we just swap this two elements .
//			
	
	static int[] cyclicSort(int arr[])
	{
		int i=0;
		while(i < arr.length)
		{
			if(arr[arr[i]-1] != arr[i] )
			{
				swap(arr,i,arr[i]-1);
			}
			else
			{
				i++;
			}
		}
		return arr;
	}
	
	static void swap(int arr[] ,int a , int b)
	{
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
}
