package Recursion.Easy;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		permutations("abc","");
		System.out.println();
		System.out.println(permutationsAl("abc",""));
	}
	
	static void permutations(String oS , String cS)
	{
		if(oS.isEmpty())
		{
			System.out.print(cS + " ");
			return;
		}
		
		char ch = oS.charAt(0);
		
		for(int i=0;i<=cS.length();i++)
		{
			String fS = cS.substring(0, i);
			String sS = cS.substring(i, cS.length());
			permutations(oS.substring(1), fS + ch + sS);
		}
	}
	
	static ArrayList<String> permutationsAl(String oS , String cS)
	{
		if(oS.isEmpty())
		{
			ArrayList<String> al = new ArrayList<>();
			al.add(cS);
			return al;
		}
		
		char ch = oS.charAt(0);
		
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i=0;i<=cS.length();i++)
		{
			String fS = cS.substring(0, i);
			String sS = cS.substring(i, cS.length());
			ans.addAll(permutationsAl(oS.substring(1), fS + ch + sS));
		}
		
		return ans;
	}

}
