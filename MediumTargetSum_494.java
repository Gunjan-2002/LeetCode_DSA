package Recursion.Medium;

public class MediumTargetSum_494 {

	public static void main(String[] args) {
		int arr[]= {1,1,1,1,1};
		System.out.println(ifExist(arr, 3));
		int arr1[]= {1,2,3,5,9};
		System.out.println(ifExist(arr1, 3));
	}
	
	static int sum(int arr[])
	{
		if(arr.length == 0)
		{
			return 0;
		}
		
		if(arr.length == 1)
		{
			return arr[0];
		}
		
		int s=0;
		
		for(int i=0;i<arr.length;i++)
		{
			s = s + arr[i];
		}
		return s;
	}
	
	static int ifExist(int arr[] , int target)
	{
		if(arr.length==0)
		{
			return 0;
		}
		
		int s = sum(arr);
		
		if(s < target || (s+target)%2 != 0)
		{
			return 0;
		}
		
		int newTarget=(s+target)/2;
		
		return countSubsets(arr, newTarget);
	}
	
	static int countSubsets(int arr[] , int target)
	{
		
		
		if(arr.length == 0 || target <= 0)
		{
			return 0;
		}
		
		int n=arr.length;
		
		int count[][] = new int[n][target+1];
		
		for(int i=0;i<n;i++)
		{
			count[i][0]=1;
		}
		
		for(int i=0;i<=target;i++)
		{
			if(arr[i] == i)
			{
				count[0][i]=1;
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=target;j++)
			{
				int currentIncludedElement=0;
				int currentExcludedElement=0;
				
				if(arr[i] <= j)
				{
					currentIncludedElement=count[i-1][j-arr[i]];
				}
				
				currentExcludedElement=count[i-1][j];
				
				count[i][j]=currentExcludedElement+currentIncludedElement;
			}
			
		}
		
		return count[n-1][target];
	}

}
