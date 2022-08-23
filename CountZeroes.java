package Recursion.Easy;

public class CountZeroes {

	public static void main(String[] args) {
		System.out.println(countZeroes(10230450, 0));
	}
	
	static int countZeroes(int num , int count)
	{
		if(num == 0)
		{
			return count;
		}
		
		if(num%10 == 0)
		{
			return countZeroes(num/10, count+1);
		}
		return countZeroes(num/10, count);
	}

}
