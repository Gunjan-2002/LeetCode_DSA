package RECURSION.EASY;

public class Easy_ValidPalindrome_125 {

	public static void main(String[] args) {
		System.out.println(isPallindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPallindrome("race a car"));
	}
	
	static boolean isPallindrome(String s)
	{
		// IF STRING IS EMPTY THEN IT IS ALWAYS PALLINDROME
		if(s.length()==0)
		{
			return true;
		}
		
		// THIS IS TWO POINTER'S ALGORITHM WE TAKE TWO POINTERS
		// HEAD & TAIL 
		int head=0 , tail=s.length()-1;
		char chead , ctail;
		
		
		// THIS WHILE LOOP IS TO CHECK THAT IF STRING IS PALLINDROME OR NOT
		// IF CURRENT HEAD CHARACTER IS NOT A LETTER & NOT A DIGIT THEN WE INCREMENT
		// HEAD BY 1 ELSE IF CURRENT TAIL CHARACTER IS NOT A LETTER & NOT A DIGIT THEN
		// DECREMENT TAIL BY 1 
		// ELSE IF CURRENT TAIL CHARACTER IS NOT EQUAL TO CURRENT HEAD CHARACTER THEN
		// RETURN FALSE
		// AT LAST AFTER WHILE LOOP RETURN TRUE.
		// THAT'S IT.
		while(head <= tail)
		{
			chead=s.charAt(head);
			ctail=s.charAt(tail);
			
			if(!Character.isLetterOrDigit(chead))
			{
				head++;
			}
			else if(!Character.isLetterOrDigit(ctail))
			{
				tail--;
			}
			else 
			{
				if(Character.toLowerCase(chead) != Character.toLowerCase(ctail))
				{
					return false;
				}
				head++;
				tail--;
			}							
		}
		return true;
	}
}
