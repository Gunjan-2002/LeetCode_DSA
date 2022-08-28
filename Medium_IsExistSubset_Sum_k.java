package Recursion.Medium;

public class IsExistSubset_Sum_k {

	public static void main(String[] args) {
		int arr[]= {2,3,7,1,4,5};
		System.out.println(isExist(arr, 123));
	}
	
	static boolean isExist(int arr[] , int target)
	{
		if(arr.length==0 || target <= 0)
		{
			return false;
		}
		
		int n = arr.length;
		
		boolean exist[][] = new boolean[n][target+1];
		
		for(int i=0;i<n;i++)
		{
			exist[i][0]=true;
		}
		
		for(int i=0;i<n;i++)
		{
			if(arr[i] == i)
			{
				exist[0][i]=true;
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=target;j++)
			{
				if(exist[i-1][j] == true)
				{
					exist[i][j]=true;
				}
				else if(arr[i] <= j)
				{
					if(exist[i-1][j-arr[i]])
					{
						exist[i][j]=true;
					}
				}
			}
		}
		return exist[n-1][target];
	}

}
