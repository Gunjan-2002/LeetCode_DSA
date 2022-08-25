package RECURSION.EASY;



//								50. Pow(x, n)
//		
//		Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//		
//		
//		
//		Example 1:
//		
//		Input: x = 2.00000, n = 10
//		Output: 1024.00000
//		Example 2:
//		
//		Input: x = 2.10000, n = 3
//		Output: 9.26100
//		Example 3:
//		
//		Input: x = 2.00000, n = -2
//		Output: 0.25000
//		Explanation: 2-2 = 1/22 = 1/4 = 0.25
//		
//		Constraints:
//		
//		-100.0 < x < 100.0
//		-231 <= n <= 231-1
//		-104 <= xn <= 104


public class Easy_Pow_50 {

	public static void main(String[] args) {
		System.out.println(pow(2, 4));
		System.out.println(pow(2.1, 463546));
		System.out.println(pow(5.6, -23));

	}

	static double pow(double x , int n)
	{
		return rec(x,1L*n);
	}
	
	// THIS QUESTION IS SO IMPORTANT AND LOKS EASY WHEN WE SEE FIRST TIME
	// BUT MAJOR PROBLEM IN THIS QUESTION IS ANSWER FOR LARGER VAKUES OF N
	// AS N IS INTEGER SO WE NEED TO TAKE FOR THIS CASE . FOR THIS WE USE 
	// HELPER FUNCTION WHICH TAKE N AS DOUBLE IN ARGUMENT AND WHEN WE CALL
	// MAIN POW FUNCTION WE TYPE CAST IT AS 1L*N .
	// THAT'S IT !
	
	
	// HELPER FUNCTION FOR AVOIDING STACKOVERFLOW FOR INT AS INT 
	// NOT SUPPORT LONG VALUES.
	// IN THIS FUNCTION WE USE RECURSION IN WHICH WE CHECK IF NUMBER
	// IS 0 OR NOT IS ZERO THEN RETURN 1.0 .
	// THERE CAN BE SUCH CONDITION IF N IS NEGATIVE SO IN SUCH CASE 
	// WE CONVERT N INTO POSITIVE AND X AS 1/X .
	// AT LAST WE CHECK IF N IS EVEN THEN WE RETURN F(X*X,N/2) AND IF
	// ODD THEN WE RETURN X*F(X*X,N/2).
	
	static double rec(double x , long n)
	{
		if(n == 0)
		{
			return 1.0;
		}
		
		if(n < 0)
		{
			n=-n;
			x=1/x;
		}
		
		return n%2==0?rec(x*x,n/2):x*rec(x*x,n/2);
	}
	
}
