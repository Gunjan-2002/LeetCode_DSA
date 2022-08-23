package Recursion.Easy;

public class SumOfDigits {

	public static void main(String[] args) {
		int ans=sum(1234);
		System.out.println(ans);
	}
	
	static int sum(int num)
	{
		if(num == 0)
		{
			return 0;
		}
		
		return sum(num/10) + num%10;
	}
}
