package Easy;

//												Arranging Coins
//				
//				You have n coins and you want to build a staircase with these
//				coins. The staircase consists of k rows where the ith row has exactly
//				i coins. The last row of the staircase may be incomplete.
//				
//				Given the integer n, return the number of complete rows of the staircase
//				you will build.
//				
//				
//				Example 1:
//				
//				
//				Input: n = 5
//				Output: 2
//				Explanation: Because the 3rd row is incomplete, we return 2.
//				Example 2:
//				
//				
//				Input: n = 8
//				Output: 3
//				Explanation: Because the 4th row is incomplete, we return 3.
//				
//				
//				Constraints:
//				
//				1 <= n <= 231 - 1

public class ArrangingCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int arrangeCoins(int n) 
	    {
//	         int count=0;
//	         int p=n;
//	         if(n == 1)
//	         {
//	             return 1;
//	         }
	        
//	         for(int i=1;i<=n;i++)
//	         {
//	             if(p < i)
//	             {
//	                break; 
//	             }
//	             count++;
//	             p=p-i;
//	         }
//	         return count;
		 
		 
	        // int rcount=0;
	        // int total=0;
	        // while(n > 0)
	        // {
	        //     rcount++;
	        //     n=n-rcount;
	        // }
	        // return n==0 ? rcount : rcount-1;
	        
		 
		 
//	         long start=0;
//	         long end=n;
	        
//	         while(start <= end)
//	         {
//	             long mid=start + (end - start)/2;
	            
//	             long sum=(mid*(mid + 1))/2;
	            
//	             if(sum == n)
//	             {
//	                 return (int)mid;
//	             }
//	             else if(sum < n)
//	             {
//	                 start=mid+1;
//	             }
//	             else
//	             {
//	                 end=mid-1;
//	             }
//	         }
//	         return (int)end;
	        
	        
	        return (int)(-0.5 + Math.sqrt(2*(long)n + 0.25));
	    }
}
