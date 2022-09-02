package Recursion.Medium;


//						Recursive Digit Sum
//		
//		We define super digit of an integer  using the following rules:
//		
//		Given an integer, we need to find the super digit of the integer.
//		
//		If  has only  digit, then its super digit is .
//		Otherwise, the super digit of  is equal to the super digit of the sum of the digits of .
//		For example, the super digit of  will be calculated as:
//		
//			super_digit(9875)   	9+8+7+5 = 29 
//			super_digit(29) 	2 + 9 = 11
//			super_digit(11)		1 + 1 = 2
//			super_digit(2)		= 2  
//		Example
//		
//		
//		The number  is created by concatenating the string   times so the initial .
//		
//		    superDigit(p) = superDigit(9875987598759875)
//		                  9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
//		    superDigit(p) = superDigit(116)
//		                  1+1+6 = 8
//		    superDigit(p) = superDigit(8)
//		All of the digits of  sum to . The digits of  sum to .  is only one digit, so it is the super digit.
//		
//		Function Description
//		
//		Complete the function superDigit in the editor below. It must return the calculated super digit as an integer.
//		
//		superDigit has the following parameter(s):
//		
//		string n: a string representation of an integer
//		int k: the times to concatenate  to make 
//		Returns
//		
//		int: the super digit of  repeated  times
//		Input Format
//		
//		The first line contains two space separated integers,  and .
//		
//		Constraints
//		
//		Sample Input 0
//		
//		148 3
//		Sample Output 0
//		
//		3
//		Explanation 0
//		
//		Here  and , so .
//		
//		super_digit(P) = super_digit(148148148) 
//		               = super_digit(1+4+8+1+4+8+1+4+8)
//		               = super_digit(39)
//		               = super_digit(3+9)
//		               = super_digit(12)
//		               = super_digit(1+2)
//		               = super_digit(3)
//		               = 3
//		Sample Input 1
//		
//		9875 4
//		Sample Output 1
//		
//		8
//		Sample Input 2
//		
//		123 3
//		Sample Output 2
//		
//		9


public class RecursiveDigitSum_HackerRank {

	public static void main(String[] args) {
		System.out.println(superDigit("9875", 3));
	}
	
	// LOGIC :
	// STRING 9875
	// SUM=29
	// SUM*K=87 & SET K=1
	// TWO DIGIT
	// AGAIN SUM=15
	// TWO DIGIT
	// AGAIN SUM=6
	// ONE DIGIT
	// RETURN N
	// THAT'S IT
	
	static int superDigit(String n , int k)
	{
		if(n.length() == 1)
		{
			return Integer.valueOf(n);
		}
		
		long sum=0;
		
		for(int i=0;i<n.length();i++)
		{
			sum=sum+n.charAt(i)-'0';
		}
		
		if(k != 1)
		{
			sum=sum*k;
		}
		
		return superDigit(sum+"", 1);
	}

}
