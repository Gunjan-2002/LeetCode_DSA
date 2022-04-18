package Easy;

import java.util.HashMap;
import java.util.Map;

//											Check If N and Its Double Exist
//			
//			Given an array arr of integers, check if there exists two integers 
//			N and M such that N is the double of M ( i.e. N = 2 * M).
//			
//			More formally check if there exists two indices i and j such that :
//			
//			i != j
//			0 <= i, j < arr.length
//			arr[i] == 2 * arr[j]
//			 
//			
//			Example 1:
//			
//			Input: arr = [10,2,5,3]
//			Output: true
//			Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
//			Example 2:
//			
//			Input: arr = [7,1,14,11]
//			Output: true
//			Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
//			Example 3:
//			
//			Input: arr = [3,1,7,11]
//			Output: false
//			Explanation: In this case does not exist N and M, such that N = 2 * M.
//			 
//			
//			Constraints:
//			
//			2 <= arr.length <= 500
//			-10^3 <= arr[i] <= 10^3

public class CheckIfNandItsDoubleExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean checkIfExist(int[] arr) 
	    {
//	        for(int i=0;i<arr.length;i++)
//	        {
//	            for(int j=i+1;j<arr.length;j++)
//	            {
//	                if(arr[i]*2 == arr[j]  || arr[j]*2 == arr[i])
//	                {
//	                    return true;
//	                }
//	            }
//	        }
//	        return false;
	        
	        Map<Double, Integer> mp=new HashMap<>();
	        
	        for(int i=0;i<arr.length;i++)
	        {
	        	if(mp.containsKey((double)arr[i]*2)   || mp.containsKey((double)arr[i]/2))
	        	{
	        		return true;
	        	}
	        	mp.put((double)arr[i],1);
	        }
	        return false;
	    }
	
}
