package Easy;

//										Fair Candy Swap
//			
//			
//			Alice and Bob have a different total number of candies. You are 
//			given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is
//			the number of candies of the ith box of candy that Alice has and bobSizes[j] 
//			is the number of candies of the jth box of candy that Bob has.
//			
//			Since they are friends, they would like to exchange one candy box each so that 
//			after the exchange, they both have the same total amount of candy. The total amount 
//			of candy a person has is the sum of the number of candies in each box they have.
//			
//			Return an integer array answer where answer[0] is the number of candies in the box that 
//			Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. 
//			If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.
//			
//			
//			Example 1:
//			
//			Input: aliceSizes = [1,1], bobSizes = [2,2]
//			Output: [1,2]
//			Example 2:
//			
//			Input: aliceSizes = [1,2], bobSizes = [2,3]
//			Output: [1,2]
//			Example 3:
//			
//			Input: aliceSizes = [2], bobSizes = [1,3]
//			Output: [2,3]
//			
//			
//			Constraints:
//			
//			1 <= aliceSizes.length, bobSizes.length <= 104
//			1 <= aliceSizes[i], bobSizes[j] <= 105
//			Alice and Bob have a different total number of candies.
//			There will be at least one valid answer for the given input.


public class FairCandySwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) 
	    {
	        int aSum=0,bSum=0;
	        
	        for(int x : aliceSizes)
	        {
	            aSum+=x;
	        }
	        
	        for(int x : bobSizes)
	        {
	            bSum+=x;
	        }
	        
	        int n=aliceSizes.length;
	        int m=bobSizes.length;
	        
	        int ans[]=new int[2];
	        
	        for(int i= n-1 ;i>=0;i--)
	        {
	            for(int j=m-1;j>=0;j--)
	            {
	                int diff=aliceSizes[i] - bobSizes[j];
	                if(aSum-diff  == bSum+diff)
	                {
	                    ans[0]=aliceSizes[i];
	                    ans[1]=bobSizes[j];
	                    return ans;
	                }
	            }
	        }
	        return ans;
	    }
}
