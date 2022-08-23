package Recursion.Easy;

public class ArraySortedOrNot {

	public static void main(String[] args) {
		int arr[]= {1,1,1,1,1};
		int arr1[]= {1,2,3,4,5};
		int arr2[]= {1,3,2,4,5};

		System.out.println(check(arr, 0));
		System.out.println(check(arr1, 0));
		System.out.println(check(arr2, 0));

	}
	
	static boolean check(int arr[] , int ind)
	{
		if(ind == arr.length-1)
		{
			return true;
		}
		
		return arr[ind] <= arr[ind+1] && check(arr, ind+1);
	}

}
