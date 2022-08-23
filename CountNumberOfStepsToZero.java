package Recursion.Easy;

public class CountNumberOfStepsToZero {

	public static void main(String[] args) {
		System.out.println(countSteps(41, 0));
	}
	
	static int countSteps(int num , int steps)
	{
		if(num == 0)
		{
			return steps;
		}
		
		if(num%2 ==0)
		{
			return countSteps(num/2, steps+1);
		}
		return countSteps(num-1, steps+1);
	}

}
