package Recursion.Easy;

public class MultiplicationOfDigits {

	public static void main(String[] args) {
		int ans=mul(12314);
		System.out.println(ans);
	}
	
	static int mul(int num)
	{
		if(num%10 == num)
		{
			return num;
		}
		
		return  num%10 * mul(num/10);
	}

}
