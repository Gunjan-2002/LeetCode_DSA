package Recursion.Medium;

public class Count_Subsets_Sum_k {

	public static void main(String[] args) {
		int arr[]= {2,3,7,1,4,5};
		int ans=count(arr,7);
		System.out.println(ans);	
	}
	
	// DP
	
	static int count(int arr[] , int target)
	{
		// EDGE CASE 
		// IF ARRAY LENGTH IS 0 THEN THERE NEVER WILL BE ANY SUBSET HAVING SUM EQUAL TO TARGET &
		// IF TARGET IS NEGATIVE VALUE THEN NO SET IS POSSIBLE AGAIN.
		if(arr.length==0 || target<=0)
		{
			return 0;
		}
		
		int n = arr.length;
		
		int count[][] = new int[n][target+1];
		
		// SETTING ALL FIRST COLUMN ELEMENTS IN COUNT ARRAY EQUAL TO 1
		for(int i=0;i<n;i++)
		{
			count[i][0]=1;
		}
		
		// SETTING FIRST ROW ELEMENT AS 1 IF CURRENT ARRAY ELEMENT IS EQUAL TO CURRENT COLUMN INDEX ELSE 0
		for(int i=0;i<n;i++)
		{
			if(arr[0] == i)
			{
				count[0][i]=1;
			}
		}
		
		
		// THIS IS MAIN CODE
		// HERE WE START FROM (1,1) INDEX
		// WE HAVE TWO CHOICES WE CAN TAKE ELEMENT OR NOT
		// IF WE WANT TO TAKE THEN WE NEED TO CHECK IF ARR[I] <= CURRENT COLUMN INDEX IF TRUE
		// THEN WE CAN INCUDE.
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=target;j++)
			{
				int currentIncludingValue=0;
				int currentExcludingValue=0;
				
				if(arr[i] <= j)
				{
					currentExcludingValue=count[i-1][j-arr[i]];
				}
				currentIncludingValue=count[i-1][j];
				
				count[i][j] = currentExcludingValue + currentIncludingValue ;
			}	
		}
		
		return count[n-1][target];
	}
}
