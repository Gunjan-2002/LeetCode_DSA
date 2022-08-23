package Recursion.Easy;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int arr1[]= {5,6,7,8,9,1,2,3};
		System.out.println(rotatedBS(arr1, 0,arr1.length-1, 3));
	}
	
	// THIS IS ONLY FOR ASCENDING ORDER SORTED ARRAY
	static int rotatedBS(int arr[] , int s , int e , int target)
	{
		if(s > e)
		{
			return -1;
		}
		
		int m = s + (e-s)/2;
		
		
		// Edge Case 1
		if(arr[m] == target)
		{
			return m;
		}
		
		// Edge Case 2
		if(arr[s] <= arr[m])
		{
			if(target >= arr[s] && target <= arr[m])
			{
				return rotatedBS(arr, s, m-1, target);
			}
			else
			{
				return rotatedBS(arr, m+1, e, target);
			}
		}
		
		// Edge Case 3
		if(target >= arr[m] && target <= arr[e])
		{
			return rotatedBS(arr, m+1, e, target);
		}
		
		return rotatedBS(arr, s, m-1, target);			
	}

}
