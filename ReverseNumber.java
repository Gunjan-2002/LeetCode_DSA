package Recursion.Easy;

public class ReverseNumber {

	static int rev=0;
	
	static void reverse(int num)
	{
		if(num == 0)
		{
			return;
		}
		int lD = num%10;
		
		rev = rev*10 + lD;
		reverse(num/10);
	}
	
	static int reverse2(int num)
	{
		int digits = (int)(Math.log10(num))+1;
		return helper(num,digits);
	}
		
	private static int helper(int num, int digits) 
	{
		if(num%10 == num)
		{
			return num;
		}
		
		int rem = num%10;
		
		return rem * (int)Math.pow(10,digits-1) + helper(num/10,digits-1);
	}

	public static void main(String[] args) {
		reverse(15427);
		System.out.println(rev);
		int dig=(int)(Math.log10(12345))+1;
		System.out.println(dig);
		int ans2=reverse2(1234);
		System.out.println(ans2);
	}
}
