package Arrays.Medium;


//							59. Spiral Matrix II
//		
//		Given a positive integer n, generate an n x n matrix filled
//		with elements from 1 to n2 in spiral order.
//		
//		Example 1:
//		
//		Input: n = 3
//		Output: [[1,2,3],[8,9,4],[7,6,5]]
//				
//		Example 2:
//		
//		Input: n = 1
//		Output: [[1]]
//		
//		Constraints:
//		
//		1 <= n <= 20

public class Medium_SpiralMatrix2_59 
{
	public static void main(String[] args) 
	{
		int n=3;
		int ans[][] = new int[n][n];
		
		ans=generateMatrix(n);
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(ans[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
//		Note :
//			
//		This question is similar as the spiral matrix 1
//		Only change in this question is that we put the
//		elements on the time in the array which we created
//		on time.
//		Thats it !
	
	static int[][] generateMatrix(int n) 
    {
        int ele=1;
        
        int sr=0,sc=0;
        int dr=n-1,dc=n-1;
        
        int tne=n*n;
        int count=0;
        
        int ans[][] = new int[n][n];
        
        while(count < tne)
        {
            //top
            for(int i=sc;i<=dc && count < tne;i++)
            {
                ans[sr][i]=ele;
                ele++;
                count++;
            }
            sr++;
            
            //right
            for(int i=sr;i<=dr && count < tne;i++)
            {
                ans[i][dc]=ele;
                ele++;
                count++;
            }
            dc--;
            
            //bottom
            for(int i=dc;i>=sc && count < tne;i--)
            {
                ans[dr][i]=ele;
                ele++;
                count++;
            }
            dr--;
            
            //left
            for(int i=dr;i>=sr && count < tne;i--)
            {
                ans[i][sc]=ele;
                ele++;
                count++;
            }
            sc++;
        }
        return ans;
    }

}
