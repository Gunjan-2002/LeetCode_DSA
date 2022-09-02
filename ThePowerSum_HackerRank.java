package Recursion.Medium;


//							The Power Sum
//		
//		Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.
//		
//		For example, if  and , we have to find all combinations of unique squares adding up to . The only solution is .
//		
//		Function Description
//		
//		Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.
//		
//		powerSum has the following parameter(s):
//		
//		X: the integer to sum to
//		N: the integer power to raise numbers to
//		Input Format
//		
//		The first line contains an integer .
//		The second line contains an integer .
//		
//		Constraints
//		
//		Output Format
//		
//		Output a single integer, the number of possible combinations caclulated.
//		
//		Sample Input 0
//		
//		10
//		2
//		Sample Output 0
//		
//		1
//		Explanation 0
//		
//		If  and , we need to find the number of ways that  can be represented as the sum of squares of unique numbers.
//		
//		
//		This is the only way in which  can be expressed as the sum of unique squares.
//		
//		Sample Input 1
//		
//		100
//		2
//		Sample Output 1
//		
//		3
//		Explanation 1
//		
//		
//		Sample Input 2
//		
//		100
//		3
//		Sample Output 2
//		
//		1


public class ThePowerSum_HackerRank {

	public static void main(String[] args) {
		System.out.println(powerSum(10, 2));
		System.out.println(powerSum(100, 3));

	}
	
	static int powerSum(int x , int n)
	{
		return power(x,n,1);
	}
	
	
	// THIS IS HELPER FUNCTION IN WHICH WE ADD ONE MORE PARAMETER NUM WHICH IS 
	// INCREEMENTING ALWAYS EXCEPT WHEN RES IS NEGATIVE
	// BASIC IDEA IS FIRST WE FIND POWER OF NUM WITH N 
	// IF THAT IS EQUAL TO X THEN WE RETURN 1 ELSE IF RES IS LESS THAN X
	// WHICH MEANS WE CAN HAVE POSSIBILITY OF HAVING MORE POSSSIBLE ANSWER IN FUTURE SO
	// WE CALL A FUNCTION POWER(X-RES,N,NUM+1) +  POWER(X,N,NUM+1) , THIS WILL GIVE US 
	// THE MORE POSSIBLE WAYS 
	// ELSE IF RES IS NEGATIVE THEN WE JUST RETURN 0 I.E NO POSSIBLE WAY TO GET X
	// THAT'S IT !
	static int power(int x , int n , int num)
	{
		int res=(int)Math.pow(num, n);
		//  BASE CASE
		if(res == x)
		{
			return 1;
		}
		else
		{
			if(res < x)
			{
				return power(x-res,n,num+1) + power(x,n,num+1);
			}
			else
			{
				return 0;
			}
		}
	}

}
