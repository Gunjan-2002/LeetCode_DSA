package Recursion.Easy;

import java.util.ArrayList;

public class PrintSubsets {

	public static void main(String[] args) {
//		subsets("gunjan","");
		System.out.println(subsetsAl("abc",""));
	}
	
	static void subsets(String oS , String sS)
	{
		if(oS.isEmpty())
		{
			System.out.print(sS + " ");
			return;
		}
		
		char ch = oS.charAt(0);
		
		subsets(oS.substring(1), sS+ch );
		subsets(oS.substring(1), sS);
	}

	
	static ArrayList<String> subsetsAl(String oS , String sS)
	{
		if(oS.isEmpty())
		{
			ArrayList<String> al = new ArrayList<>();
			al.add(sS);
			return al;
		}
		
		char ch = oS.charAt(0);
		
		ArrayList<String> left = subsetsAl(oS.substring(1), sS+ch );
		ArrayList<String> right = subsetsAl(oS.substring(1), sS);
		
		left.addAll(right);
		
		return left;
	}
}
