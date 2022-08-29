package Recursion.Medium;

//								1922.Count Good Numbers
//		
//		A digit string is good if the digits (0-indexed) at even indices are
//		even and the digits at odd indices are prime (2, 3, 5, or 7).
//		
//		For example, "2582" is good because the digits (2 and 8) at even positions
//		are even and the digits (5 and 2) at odd positions are prime. However, "3245" 
//		is not good because 3 is at an even index but is not even.
//		
//		Given an integer n, return the total number of good digit strings of length n. 
//		 the answer may be large, return it modulo 109 + 7.
//		
//		A digit string is a string consisting of digits 0 through 9 that may contain 
//		leading zeros.
//		
//		Example 1:
//		
//		Input: n = 1
//		Output: 5
//		Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
//		Example 2:
//		
//		Input: n = 4
//		Output: 400
//		Example 3:
//		
//		Input: n = 50
//		Output: 564908303
//		 
//		
//		Constraints:
//		
//		1 <= n <= 1015

public class Medium_CountGoodNumbers_1922 {

	static int mod=(int)1e+7;
	
	public static void main(String[] args) {
		System.out.println(countGoodNumber(1));
		System.out.println(countGoodNumber(4));
		System.err.println(countGoodNumber(50));
		System.out.println(countGoodNumber(1924));
	}
	
	// THIS IS SO EASY QUESTION QUESTION IF ONE KNOWS THE LOGIC
	// HERE WE USE LOGIC OF COMBINATION nCr
	// IF N IS EVEN THE COUNT=5^N/2*4^N/2
	// ELSE COUNT=5^(N/2+1)*4^N/2
	// MAIN THING IS THE POWER FUNCTION USE CAREFULLY AND APPLY MOD VALUE WHICH IS 
	// GIVEN IN THE QUESTION
	
	public static int countGoodNumber(long n)
	{
		long first=((n%2==0)?(n/2):(n/2)+1);
		long second=n/2;
		
		long mul1=pow(5, first)%mod;
		long mul2=pow(4, second)%mod;
		
		long ans=1;
		
		ans=ans*mul1;
		
		ans=(second!=0)?(ans*second)%mod:ans;
		
		return (int)(ans%mod);
		
	}
	
	static long pow(long x , long n)
	{
		long temp;
		
		if(n==0)
		{
			return 1;
		}
		
		temp=pow(x, n/2);
		
		if(n%2==0)
		{
			return temp*temp%mod;
		}
		else
		{
			return x*temp*temp%mod;
		}
	}
}
