package Hard;

public class CheckIfItIsaGoodArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isGoodArray(int[] nums) 
    {
        int ans=nums[0];
        int n=nums.length;
        
        for(int i=1;i<n;i++)
        {
            ans=findGCD(ans,nums[i]);
        }
        return ans==1;
    }
    
    int findGCD(int a, int b)   
    {   
    if (b == 0)   
    return a;     
    return findGCD(b, a % b);   
    }   
}
