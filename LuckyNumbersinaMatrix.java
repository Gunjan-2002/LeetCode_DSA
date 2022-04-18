package Easy;

import java.util.ArrayList;
import java.util.List;

//										Lucky Numbers in a Matrix
//			
//			Given an m x n matrix of distinct numbers, return all 
//					lucky numbers in the matrix in any order.
//			
//			A lucky number is an element of the matrix such that it
//			is the minimum element in its row and maximum in its column.
//			
//			 
//			
//			Example 1:
//			
//			Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
//			Output: [15]
//			Explanation: 15 is the only lucky number since it is the 
//			minimum in its row and the maximum in its column.
//			Example 2:
//			
//			Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//			Output: [12]
//			Explanation: 12 is the only lucky number since it is the minimum 
//			in its row and the maximum in its column.
//			Example 3:
//			
//			Input: matrix = [[7,8],[1,2]]
//			Output: [7]
//			Explanation: 7 is the only lucky number since it is the minimum in
//			its row and the maximum in its column.
//			 
//			
//			Constraints:
//			
//			m == mat.length
//			n == mat[i].length
//			1 <= n, m <= 50
//			1 <= matrix[i][j] <= 105.
//			All elements in the matrix are distinct.


public class LuckyNumbersinaMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		
		 List<Integer> arrr= luckyNumbers(arr);
		 System.out.println(arrr);

	}
	static List<Integer> luckyNumbers (int[][] arr) 
    {
       ArrayList<Integer> arrr= new ArrayList<>();
       
       for(int i=0;i<arr.length;i++)
       {
    	   int minIdx=0;
    	   int min=Integer.MAX_VALUE;
    	   for(int j=0;j<arr[i].length;j++)
    	   {
    		   if(arr[i][j] < min)
    		   {
    			   min=arr[i][j];
    			   minIdx=j;
    		   }
    	   }
    	   
    	   boolean isTrue=true;
    	   
    	   for(int p=0;p<arr.length;p++)
    	   {
    		   if(arr[i][minIdx] < arr[p][minIdx])
    		   {
    			   isTrue=false;
    			   break;
    		   }
    	   }
    	   if(isTrue == true)
    	   {
    		   arrr.add(arr[i][minIdx]);
    	   }
       }
       return arrr;
    }

}
