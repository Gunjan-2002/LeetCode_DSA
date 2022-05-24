package Strings.Medium;


//					1616. Split Two Strings to Make Palindrome
//		
//		You are given two strings a and b of the same length. Choose an index
//		and split both strings at the same index, splitting a into two strings:
//		aprefix and asuffix where a = aprefix + asuffix, and splitting b into
//		two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if
//		aprefix + bsuffix or bprefix + asuffix forms a palindrome.
//		
//		When you split a string s into sprefix and ssuffix, either ssuffix or sprefix
//		is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc",
//		"ab" + "c" , and "abc" + "" are valid splits.
//		
//		Return true if it is possible to form a palindrome string, otherwise return false.
//		
//		Notice that x + y denotes the concatenation of strings x and y.
//		
//		Example 1:
//		
//		Input: a = "x", b = "y"
//		Output: true
//		Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
//		aprefix = "", asuffix = "x"
//		bprefix = "", bsuffix = "y"
//		Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
//		
//		Example 2:
//		
//		Input: a = "xbdef", b = "xecab"
//		Output: false
//		Example 3:
//		
//		Input: a = "ulacfd", b = "jizalu"
//		Output: true
//		Explaination: Split them at index 3:
//		aprefix = "ula", asuffix = "cfd"
//		bprefix = "jiz", bsuffix = "alu"
//		Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
//		
//		Constraints:
//		
//		1 <= a.length, b.length <= 105
//		a.length == b.length
//		a and b consist of lowercase English letters


public class Medium_SplitTwoStringstoMakePalindrome_1616 
{
	public static void main(String[] args) 
	{
		String a = "ulacfd"; 
		String b = "jizalu";
		
		String c = "xbdef";
		String d = "xecab";
		
		System.out.println(checkPalindromeFormation(a, b));
		System.out.println(checkPalindromeFormation(c, d));
	}

	 static boolean checkPalindromeFormation(String a, String b)  
	 {
		 return isPallindrone(a,b) || isPallindrone(a,b);
	 }
	
	 
	 static boolean isPallindrone(String a , String b)
	 {
		 int l=0;
		 int r=a.length()-1;
		 
		 while(l < r)
		 {
			 if(a.charAt(l) != b.charAt(r))
			 {
				 break;
			 }
			 l++;
			 r--;
		 }
		 
		 return isPallindrone(a,l,r) || isPallindrone(b,l,r);
	 }
	 
	 static boolean isPallindrone(String s , int l , int r)
	 {
		 while(l < r)
		 {
			 if(s.charAt(l) != s.charAt(r))
			 {
				 return false;
			 }
			 l++;
			 r--;
		 }
		 return true;
	 }
}


	/*						Note : 

	  start from first char a and last letter of b and go towards the middle until l crosses r.
		but you are comparing a to b until it doesn't work, now the rest of the palindrome is hidden as part of the word itself.
		so, check remaining a or b to see if it is a palindrome.
		
		"pvhm upgqeltozftlmfjjde"
		"yjgp zbezspnnpszebz mhvp"
		
		pvhm == mhvp but fails at u != z, this is where you check rest of a or b itself.
		zbezspnnpszebz is palindrome.
		
		So in example, this is O(n)
		
	
	
	The basic idea is to use left pointer and right pointer to compare if the chars are equal

	For example:

	l
	ulabbxyz
	jizcdalu
	       r

	// Same, l++, r— 

	 l
	ulabbxyz
	jizcdalu
	      r
		   
	// Same, l++, r— 

	  l
	ulabbxyz
	jizcdalu
	     r

	// Same, l++, r— 

	   l
	ulabbxyz
	jizcdalu
	    r
		
	// the trick is here, “b” and “d” are different. 
	// That means we have two choice to make it possible
	// Either cut at l in string a, or cut at r in string b. 

	// try those 2 approaches
	    lr
	ula bb ... // <- need check if [l,r] in string a is palindrome
	..... alu
	// or 
	ula .....
	... cd alu  // <- need check if [l,r] in string b is palindrome
	    lr
	    
	    */
