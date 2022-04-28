package Sorting;

//						1491  :  Average Salary Excluding the Minimum and Maximum Salary
//			
//			You are given an array of unique integers salary where salary[i] is the salary
//			of the ith employee.
//			
//			Return the average salary of employees excluding the minimum and maximum 
//			salary. Answers within 10-5 of the actual answer will be accepted.
//			
//			Example 1:
//			
//			Input: salary = [4000,3000,1000,2000]
//			Output: 2500.00000
//			Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
//			Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
//			Example 2:
//			
//			Input: salary = [1000,2000,3000]
//			Output: 2000.00000
//			Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
//			Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
//			
//			Constraints:
//			
//			3 <= salary.length <= 100
//			1000 <= salary[i] <= 106
//			All the integers of salary are unique.

public class Easy_AverageSalaryExcludingtheMinimumandMaximumSalary_1419 
{
	public static void main(String[] args) 
	{
		int arr[]= {4000,3000,1000,2000};
		
		double ans=average(arr);
		
		System.out.println();
	}

//				Note :
//					
//				1] Sort the array and then find average of elements
//					excluding first and last element .
//					O(n) , O(1)
//					
//				2] Find the minimum , maximum element and sum of all element
//					in same for loop and then return average of sum - min - max.
//							
//				That's it !
	
	
	static double average(int[] salary) 
    {
        // Arrays.sort(salary);
        // double sum=0d;
        // for(int i=1;i<salary.length-1;i++)
        // {
        //     sum=sum+salary[i];
        // }
        // double ans=sum/(salary.length-2);
        // return ans;
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        double sum=0d;
        for(int x : salary)
        {
            min=Math.min(min,x);
            max=Math.max(max,x);
            sum=sum+x;
        }
        return (sum-min-max)/(salary.length-2);
    }
	
}
