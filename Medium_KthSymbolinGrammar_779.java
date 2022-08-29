package Recursion.Medium;

//							779. K-th Symbol in Grammar
//		
//		We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every
//		subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and 
//		each occurrence of 1 with 10.
//		
//		For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
//		Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
//		
//		Example 1:
//		
//		Input: n = 1, k = 1
//		Output: 0
//		Explanation: row 1: 0
//		Example 2:
//		
//		Input: n = 2, k = 1
//		Output: 0
//		Explanation: 
//		row 1: 0
//		row 2: 01
//		Example 3:
//		
//		Input: n = 2, k = 2
//		Output: 1
//		Explanation: 
//		row 1: 0
//		row 2: 01
//		
//		Constraints:
//		
//		1 <= n <= 30
//		1 <= k <= 2n - 1

public class Medium_KthSymbolinGrammar_779 {

	public static void main(String[] args) {
		System.out.println(kthGrammar(4, 5));
		System.out.println(kthGrammar(2, 2));
	}
	
	// THIS IS AGAIN A SIMPLE PROBLEM FOR THIS ONE SHOULD KNOW THE BASIC
	// RECURSION KNOWLEDGE AND BIT MANIPULATION KNOWLEDGE .
	
	// IN THIS QUESTION WE NEED TO FIND THE Kth SYMBOL IN GRAMMAR
	// FOR MORE UNDERSTANDING SEE THE GIVEN EXAMPLES.
	
	// SO BASE CASE FOR THIS IS THAT IF N==1 && K==1 THEN RETURN 0 THIS CONDITION
	// IS GIVEN IN QUESTION.
	// SO WE FIND THE NUMBER FOR N-1 BUT K HAS DIFFRENT VALUES BASED ON CERTAIAN CONDITIONS
	// BY THE OBSERVATION WE GET TO KNOW THAT THE N STRING IS CONBINATION OF N-1 + REVERSED BIT OF N-1 NUMBER
	// SO BY THIS VARIATION THERE HAPEN TWO CASES FOR K TO CHOOSE
	// IF WE TAKE THE MID OF NUMBER WHICH WE GET 
	// IF K <= MID THEN RETURN FUNTION WITH N-1 & K
	// ELSE RETURN FUNCTION WITH N-1 & K-MID AND FOR REVERSE THAT BIT WRITE ^1 AFTER FUNCTION CALL .
	// THAT'S IT.
	
	public static int kthGrammar(int n, int k) 
	{
		if(n == 1 && k == 1)
		{
			return 0;
		}
		
		int mid = (int) Math.pow(2 , n-1)/2;
		
		if(k <= mid)
		{
			return kthGrammar(n-1, k);
		}
		else
		{
			return kthGrammar(n-1, k-mid)^1;
		}
        
    }

}
