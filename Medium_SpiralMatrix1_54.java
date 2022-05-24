package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

//								54. Spiral Matrix
//		
//		Given an m x n matrix, return all elements of the matrix in spiral order.
//		
//		Example 1:
//		
//		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//		Output: [1,2,3,6,9,8,7,4,5]
//				
//		Example 2:
//		
//		Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//		Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//		
//		Constraints:
//		
//		m == matrix.length
//		n == matrix[i].length
//		1 <= m, n <= 10
//		-100 <= matrix[i][j] <= 100


public class Medium_SpiralMatrix1_54 
{
	public static void main(String[] args) 
	{
		int arr[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		
		List<Integer> al = new ArrayList<>();
		
		al=spiralOrder(arr);
		
		System.out.println(al);

	}
	
	
//		Note :
//			
//		In this question we divide the array into four parts
//		for every part we implement for loop and add element
//		in arraylist.
//		one while loop is is outside the all four loop to check
//		that if count is less than total number of elements and
//		for every for loop we check that if count is less than 
//		total number of elements.
//		
//		1]Top-starts from sc to dc after we increment sr++
//		2]Right-starts from sr to dr after we increment dc--
//		3]Bottom-starts from dr to sr after we increment dr--
//		4]Left-starts from dr to sr after we increment sc++
//	
//		At last we return arraylist
	
	
	 static List<Integer> spiralOrder(int[][] matrix) 
	    {
	        int m=matrix.length;
	        int n=matrix[0].length;
	        int count=0;
	        int tne=m*n;
	        int sr=0,sc=0;
	        int dr=m-1,dc=n-1;
	        
	        ArrayList<Integer> al = new ArrayList<>();
	        
	        while(count < tne)
	        {
	            // top
	            for(int i=sc;i<=dc && count < tne ;i++)
	            {
	                al.add(matrix[sr][i]);
	                count++;
	            }
	            sr++;
	            
	            //right
	            for(int i=sr;i<=dr && count < tne;i++)
	            {
	                al.add(matrix[i][dc]);
	                 count++;
	            }
	            dc--;
	            
	            //bottom
	            for(int i=dc;i>=sc && count < tne;i--)
	            {
	                al.add(matrix[dr][i]);
	                 count++;
	            }
	            dr--;
	            
	            //left
	            for(int i=dr;i>=sr && count < tne;i--)
	            {
	                al.add(matrix[i][sc]);
	                 count++;
	            }
	            sc++;
	        }
	        return al;
	    }
}
