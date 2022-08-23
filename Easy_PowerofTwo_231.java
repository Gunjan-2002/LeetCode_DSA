package Recursion.Easy;


//									231. Power of Two
//		
//		Given an integer n, return true if it is a power of two. Otherwise, return false.
//		
//		An integer n is a power of two, if there exists an integer x such that n == 2x.
//		
//		Example 1:
//		
//		Input: n = 1
//		Output: true
//		Explanation: 20 = 1
//		
//		Example 2:
//		
//		Input: n = 16
//		Output: true
//		Explanation: 24 = 16
//		
//		Example 3:
//		
//		Input: n = 3
//		Output: false
//		
//		Constraints:
//		
//		-231 <= n <= 231 - 1
//		
//		Follow up: Could you solve it without loops/recursion?


public class Easy_PowerofTwo_231 {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(15));
	}
	
	 public static boolean isPowerOfTwo(int n) {
	       return check(n,0);
	    }
	 
	 public static boolean check(int n , int i)
	    {
	        if(Math.pow(2,i) > n)
	        {
	            return false;
	        }
	        
	        if(Math.pow(2,i) == n)
	        {
	            return true;
	        }
	        
	        
	        return check(n , i+1);
	    }

}
