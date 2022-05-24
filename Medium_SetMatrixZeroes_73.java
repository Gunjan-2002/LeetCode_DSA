package Arrays.Medium;


//						73. Set Matrix Zeroes
//		
//		Given an m x n integer matrix matrix, if an element is 0, 
//		set its entire row and column to 0's.
//		
//		You must do it in place.
//		
//		Example 1:
//		
//		Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//		Output: [[1,0,1],[0,0,0],[1,0,1]]
//				
//		Example 2:
//		
//		Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//		Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//		
//		Constraints:
//		
//		m == matrix.length
//		n == matrix[0].length
//		1 <= m, n <= 200
//		-231 <= matrix[i][j] <= 231 - 1
//		
//		Follow up:
//		
//		A straightforward solution using O(mn) space is probably a bad idea.
//		A simple improvement uses O(m + n) space, but still not the best solution.
//		Could you devise a constant space solution?


public class Medium_SetMatrixZeroes_73 
{
	public static void main(String[] args) 
	{
		int arr[][]= {{1,1,1},{1,0,1},{1,1,1}};
		
		setZeroes(arr);
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	
//		Note :
//			
//		In this question we first check that any element of first row and 
//		first coloumn is zero or not if zero then set boolean row = zero 
//		or boolean col=zero .
//		Then start for loop from index 1 for row and index 1 for column
//		and check if elemnt is zero then set its corresponding first
//		column element  as zero and first row element as zero .
//		Then check for first row starting from index 1 if elemnt is zero
//		then set all element of corresponding column as zero .
//		Again check for first column starting from index 1 if elemnt is zero
//		then set all element of corresponding row as zero .
//		Check if row == true then set all elements of corresponding column as 
//		zero .
//		Check if col == true then set all elements of corresponding row as 
//		zero .
//		Thats it !
	
		
		
	static void setZeroes(int[][] matrix) 
	{
		boolean row=false;
        boolean col=false;
        
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][0] == 0)
            {
                col=true;
            }
        }
        
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[0][i] == 0)
            {
                row=true;
            }
        }
        
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++)
        {
            if(matrix[i][0] == 0)
            {
                for(int j=0;j<matrix[0].length;j++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<matrix[0].length;i++)
        {
            if(matrix[0][i] == 0)
            {
                for(int j=0;j<matrix.length;j++)
                {
                    matrix[j][i]=0;
                }
            }
        }
        
        if(row == true)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                matrix[0][i]=0;
            }
        }
        
         if(col == true)
        {
            for(int i=0;i<matrix.length;i++)
            {
                matrix[i][0]=0;
            }
        } 
    }

}
