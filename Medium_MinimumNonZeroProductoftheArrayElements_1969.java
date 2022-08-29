package Recursion.Medium;

//					1969. Minimum Non-Zero Product of the Array Elements
//		
//		You are given a positive integer p. Consider an array nums (1-indexed) that
//		consists of the integers in the inclusive range [1, 2p - 1] in their binary
//		representations. You are allowed to do the following operation any number of times:
//		
//		Choose two elements x and y from nums.
//		Choose a bit in x and swap it with its corresponding bit in y. Corresponding bit
//		refers to the bit that is in the same position in the other integer.
//		For example, if x = 1101 and y = 0011, after swapping the 2nd bit from the right,
//		we have x = 1111 and y = 0001.
//		
//		Find the minimum non-zero product of nums after performing the above operation any 
//		number of times. Return this product modulo 109 + 7.
//		
//		Note: The answer should be the minimum product before the modulo operation is done.
//		
//		Example 1:
//		
//		Input: p = 1
//		Output: 1
//		Explanation: nums = [1].
//		There is only one element, so the product equals that element.
//		Example 2:
//		
//		Input: p = 2
//		Output: 6
//		Explanation: nums = [01, 10, 11].
//		Any swap would either make the product 0 or stay the same.
//		Thus, the array product of 1 * 2 * 3 = 6 is already minimized.
//		Example 3:
//		
//		Input: p = 3
//		Output: 1512
//		Explanation: nums = [001, 010, 011, 100, 101, 110, 111]
//		- In the first operation we can swap the leftmost bit of the second and fifth elements.
//		    - The resulting array is [001, 110, 011, 100, 001, 110, 111].
//		- In the second operation we can swap the middle bit of the third and fourth elements.
//		    - The resulting array is [001, 110, 001, 110, 001, 110, 111].
//		The array product is 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512, which is the minimum possible product.
//		 
//		
//		Constraints:
//		
//		1 <= p <= 60

public class Medium_MinimumNonZeroProductoftheArrayElements_1969 {

	static long mod=(long)Math.pow(10, 9)+7;
	
	public static void main(String[] args) {
		System.out.println(minNonZeroProduct(4));
	}

	// THIS QUESTION IS INTRESTING AS IT REQUIRES LOGIC
	// FOR MINIMUM SUM FROM ONE NUMBER SUBTRACT 1 AND ADD 1 TO THER NUMBER 
	// AND THEN MULTIPLY BOTH NUMBER 
	// AFTER GETTING RESULTANT MULTIPLICATION NUMBER AGAIN MULTIPLY IT WITH
	// MAX VALUE
	// FOR FINDING MAX VALUE IT IS GIVEN IN THE QUESTIOM FOR THIS TAKE POW(2,P)-1;
	// -1 FOR THIS AS WE KNOW THAT FIRST NUMBER AND LAST NUMBER BINARY REPRSENTATION
	// IS INVERTED OF EACH OTHER MEANS IF WE CHANGE 0 TO 1 AND 1 TO 0 WE GET THE NUMBER
	// THIS LOGIC HAS BEEN USED.
	
	public static int minNonZeroProduct(int p) 
	{
		long max=(long)Math.pow(2, p)-1;
		
		long power=pow(max-1, (max-1)/2);
		
		power=power*max%mod;
		
		return (int)power;
	}
	
	static long pow(long x , long n)
	{
		if(n==0)
		{
			return 1;
		}
		
		long temp=pow(x, n/2);
		
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
