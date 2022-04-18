package Easy;

import java.util.Arrays;

//							BinarySearch_Matrix_1
//			
//			Matrix is sorted in Row and Column wise

public class BinarySearch_Matrix_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[][]= {
				{10 , 20 , 30 , 40},
				{15 , 25 , 35 , 45},
				{28 , 29 , 37 ,49},
				{33 , 34 , 38 , 50}
		};
		
		System.out.println(Arrays.toString(search(ans, 9)));
	}
	
	static int [] search(int arr[][] , int target)
	{
		int r=0;
		int c=arr[0].length-1;
		
		while(r < arr.length  && c >=0)
		{
			if(arr[r][c] == target)
			{
				return new int[]{r,c};
			}
			if(arr[r][c] < target)
			{
				r++;
			}
			else
			{
				c--;
			}
		}
		return new int[] {-1,-1};
	}

}
