package Recursion.Medium;

public class Subset_Equal_Target {

	public static void main(String[] args) {
		int arr[]= {2,3,7,1,4,5};
		System.out.println(isExist(arr));
	}
	
	// THIS PROBLEM IS SIMILAR TO ISEXISTSUBSET_SUM 
	// AS WE NEED TO FINF ANSWER FOR THE TARGET WHICH IS EQUAL TO SUM/2
	// IF SUM OF ARRAY IS NEGATIVE THEN THERE WILL BE NO SUBSET HAVING SUM=SUM
	// IF IT IS EVEN THE APPLY SAME LOGIC OF ISEXISTSUBSET_SUM_K FOR THE TARGET
	// SUM/2
	//THAT'S IT !
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
	
	static boolean isExist(int arr[])
	{
		int sum=sum(arr);
		int n=arr.length;
		
		if(sum %2 != 0)
		{
			return false;
		}
		
		sum = sum/2;
		
		boolean count[][] = new boolean[n][sum+1];
		
		for(int i=0;i<n;i++)
		{
			count[i][0]=true;
		}
		
		for(int i=0;i<n;i++)
		{
			if(arr[i] == i)
			{
				count[0][i]=true;
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=sum;j++)
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
		
		return count[n-1][sum];
	}

}
