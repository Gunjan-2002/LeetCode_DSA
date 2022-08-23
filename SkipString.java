package Recursion.Easy;

public class SkipString {

	public static void main(String[] args) {
		System.out.println(skip("bdaapplefg"));
		System.out.println(skipAppNotApple("bdaapplfg"));
	}

	static String skip(String s)
	{
		if(s.isEmpty())
		{
			return "";
		}
		
		char ch = s.charAt(0);
		
		if(s.startsWith("apple"))
		{
			return skip(s.substring(5));
		}
		else
		{
			return ch + skip(s.substring(1));
		}
	}
	
	// SKIP APP BUT NOT APPLE
	static String skipAppNotApple(String s)
	{
		if(s.isEmpty())
		{
			return "";
		}
		
		char ch = s.charAt(0);
		
		if(s.startsWith("app") && !s.startsWith("apple"))
		{
			return skipAppNotApple(s.substring(3));
		}
		else
		{
			return ch + skipAppNotApple(s.substring(1));
		}
	}
	
	
	
}
