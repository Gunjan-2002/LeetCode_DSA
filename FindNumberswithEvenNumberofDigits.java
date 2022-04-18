package Easy;

//											Find Numbers with Even Number of Digits
//				
//				Given an array nums of integers, return how many of them contain an even number of digits.
//				
//						 
//				
//				Example 1:
//				
//				Input: nums = [12,345,2,6,7896]
//				Output: 2
//				Explanation: 
//				12 contains 2 digits (even number of digits). 
//				345 contains 3 digits (odd number of digits). 
//				2 contains 1 digit (odd number of digits). 
//				6 contains 1 digit (odd number of digits). 
//				7896 contains 4 digits (even number of digits). 
//				Therefore only 12 and 7896 contain an even number of digits.
//				Example 2:
//				
//				Input: nums = [555,901,482,1771]
//				Output: 1 
//				Explanation: 
//				Only 1771 contains an even number of digits.
//				 
//				
//				Constraints:
//				
//				1 <= nums.length <= 500
//				1 <= nums[i] <= 105

public class FindNumberswithEvenNumberofDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int findNumbers(int[] nums) 
    {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(even(nums[i]))
            {
                count++;
            }
        }
        return count;
    }

	 static Boolean even(int num)
	    {
	        int count=countNum(num);
	        if(count%2==0)
	        {
	            return true;
	        }
	        
	        return false;
	    }
	    
	    static int countNum(int num)
	    {
	        if(num == 0)
	        {
	            return 1;
	        }
	        return (int)(Math.log10(num)+1);
	    }
	
}
