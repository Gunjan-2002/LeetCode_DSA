package Recursion.Easy;

import java.util.Arrays;

//												344. Reverse String
//		
//		Write a function that reverses a string. The input string is given as an array of characters s.
//		
//		You must do this by modifying the input array in-place with O(1) extra memory.
//		
//		Example 1:
//		
//		Input: s = ["h","e","l","l","o"]
//		Output: ["o","l","l","e","h"]
//				
//		Example 2:
//		
//		Input: s = ["H","a","n","n","a","h"]
//		Output: ["h","a","n","n","a","H"]
//		
//		Constraints:erse
//		
//		1 <= s.length <= 105
//		s[i] is a printable ascii character.


public class Easy_ReverseString_344 {

	public static void main(String[] args) {
		char ar[]={'h','e','l','l','o'};
		reverseString(ar);
		System.out.println(Arrays.toString(ar));
	}
	
	public static void reverseString(char[] s) {
        rec(s,0,s.length-1);
    }
	
	public static void rec(char arr[] , int i , int j)
    {
        if(i >= j)
        {
            return ;
        }
        
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
        rec(arr , ++i , --j);
    }

}
