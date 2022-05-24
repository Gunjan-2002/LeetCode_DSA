package Strings.Medium;



/*							686. Repeated String Match
		
		Given two strings a and b, return the minimum number of times
		you should repeat string a so that string b is a substring of
		it. If it is impossible for b​​​​​​ to be a substring of a after repeating
		it, return -1.
		
		Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc"
		and repeated 2 times is "abcabc".
		
		Example 1:
		
		Input: a = "abcd", b = "cdabcdab"
		Output: 3
		Explanation: We return 3 because by repeating a three times "abcdabcdabcd",
		b is a substring of it.
		
		Example 2:
		
		Input: a = "a", b = "aa"
		Output: 2
		
		Constraints:
		
		1 <= a.length, b.length <= 104
		a and b consist of lowercase English letters.
*/


public class Medium_RepeatedStringMatch_686 
{
	public static void main(String[] args) 
	{
		String a = "abcd";
		String b = "cdabcdab";
		
		System.out.println(repeatedStringMatch(a, b));
	}

//		Note :
//			
//		In this question we build one StringBuilder string
//		initially size as 0 then append the string builder
//		until its size is greater than given string 2 and
//		also increment the counter every time when we append
//		by one which has initially has value 0 .
//		Then check if string builder contains string 2 if yes
//		then return count if not then append string 1 one time 
//		in string builder and again check if string builder 
//		contains string 2 if yes then return ++count not count++
//		At last return -1 if its impossible .
//		
	
	static int repeatedStringMatch(String a, String b) 
    {
        int n1=a.length();
        int n2=b.length();
        
        StringBuilder str = new StringBuilder();
        int count=0;
        while(str.length() < n2)
        {
            str.append(a);
            count++;
        }
        
        if(str.toString().contains(b)) return count;
        if(str.append(a).toString().contains(b)) return ++count;
        return -1;
    }
}

