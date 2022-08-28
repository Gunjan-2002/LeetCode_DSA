package Recursion.Medium;

public class Subset_Diffrence_Minimum {

	public static void main(String[] args) {
		int arr[]= {1,2,3,5,10};
		System.out.println(minDiffrence(arr));
		int arr1[]= {1,2,3,5,9};
		System.out.println(minDiffrence(arr1));
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
	
	static int minDiffrence(int arr[])
	{
		if(arr.length == 0)
		{
			return 0;
		}
		
		int s = sum(arr);
		int sTemp=s;
		
		int n= arr.length;
		
		s = s/2;
		
		boolean count[][] = new boolean[n][s+1];
		
		for(int i=0;i<n;i++)
		{
			count[i][0]=true;
		}
		
		for(int i=0;i<n;i++)
		{
			if(arr[i] == i)
			{
				count[i][0]=true;
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=s;j++)
			{
				if(count[i-1][j] == true)
				{
					count[i][j]=true;
				}
				else if(arr[i] <= j)
				{
					if(count[i-1][j-arr[i]] == true)
					{
						count[i][j]=true;
					}
				}
			}
		}
		
		int firstSubsetSum=0;
		
		for(int i=s;i>=0;i--)
		{
			if(count[arr.length-1][i] == true)
			{
				firstSubsetSum=i;
				break;
			}
		}
		
		int secondSubsetSum=sTemp-firstSubsetSum;
		
		return Math.abs(firstSubsetSum-secondSubsetSum);
	}	
}
