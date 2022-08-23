package Recursion.Easy;

public class Triangle_1 {

	public static void main(String[] args) {
		triangle1(6, 6);
		triangle2(6,6);
	}
	
	
//	TRIANGLE-1

//	*******
//	******
//	*****
//	****
//	***
//	**
//	*
	static void triangle1(int r , int c)
	{
		if(r == 0)
		{
			return;
		}
		
		if(c < r)
		{
			System.out.print("*");
			triangle1(r, c+1);
		}
		else
		{
			System.out.println();
			triangle1(r-1, 0);
		}
	}
	
	
//	TRIANGLE-2

//	*
//	**
//	***
//	****
//	*****	
	static void triangle2(int r , int c)
	{
		if(r == 0)
		{
			return;
		}
		
		if(c < r)
		{
			triangle2(r, c+1);
			System.out.print("*");
		}
		else
		{
			triangle2(r-1, 0);
			System.out.println();
		}
	}

}
