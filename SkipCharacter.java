package Recursion.Easy;

public class SkipCharacter {

	public static void main(String[] args) {
		skip("baccda","");
		System.out.println(skip2("baccda"));
	}

	static void skip(String oS , String cS)
	{
		if(oS.isEmpty())
		{
			System.out.println(cS);
			return;
		}
		
		char ch = oS.charAt(0);
		
		if(ch == 'a')
		{
			skip(oS.substring(1), cS);
		}
		else
		{
			skip(oS.substring(1),cS+ch);
		}
	}
	
	
	static String skip2(String oS)
	{
		if(oS.isEmpty())
		{
			return "";
		}
		
		char ch = oS.charAt(0);
		
		if(ch == 'a')
		{
			return skip2(oS.substring(1));
		}
		else
		{
			return ch + skip2(oS.substring(1));
		}
	}
	
}
