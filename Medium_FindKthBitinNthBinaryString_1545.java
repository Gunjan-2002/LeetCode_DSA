package Recursion.Medium;


//						1545. Find Kth Bit in Nth Binary String
//		
//		Given two positive integers n and k, the binary string Sn is formed as follows:
//		
//		S1 = "0"
//		Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
//		Where + denotes the concatenation operation, reverse(x) returns the reversed string
//		x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
//		
//		For example, the first four strings in the above sequence are:
//		
//		S1 = "0"
//		S2 = "011"
//		S3 = "0111001"
//		S4 = "011100110110001"
//		Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
//		
//		Example 1:
//		
//		Input: n = 3, k = 1
//		Output: "0"
//		Explanation: S3 is "0111001".
//		The 1st bit is "0".
//		Example 2:
//		
//		Input: n = 4, k = 11
//		Output: "1"
//		Explanation: S4 is "011100110110001".
//		The 11th bit is "1".
//		 
//		Constraints:
//		
//		1 <= n <= 20
//		1 <= k <= 2n - 1


public class Medium_FindKthBitinNthBinaryString_1545 {

	public static void main(String[] args) {
		System.out.println(findChar(3, 1));
		System.out.println(findChar(4, 11));
	}
	
	static char findChar(int n , int k)
	{
		String ans=findString(n);
		return ans.charAt(k-1);
	}

	// IN THIS RECURSION CODE
	// FIRST WE FIND THE Nth STRING BY RECURSION THE WE APPEND THE STRING WITH 1
	// THEN REVERSE AND INVERT THE STRING AND THEN APPEND WITH THE MODIFIED STRING.
	// THAT'S IT !
	static String findString(int n) 
	{
		if(n == 1)
		{
			return "0";
		}
		
		String str=findString(n-1);
		String ans=str+"1";
		
		char arr[]=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			if(arr[i]=='1')
			{
				arr[i]='0';
			}
			else
			{
				arr[i]='1';
			}
		}
		String str1 = new String(arr);
		StringBuilder sb = new StringBuilder();
		sb.append(str1);
		sb.reverse();
		return ans+sb.toString();
	}
	

}
