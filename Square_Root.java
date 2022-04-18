package Easy;

public class Square_Root {

	public static void main(String[] args) 
	{
		int X=24;
		int sqr=mySqrt(X);
		System.out.println(sqr);

	}
	static  int mySqrt(int x) 
    {
        int L=1;
        int R=x;
        
        while(L < R)
        {
        	int mid = (L + R) / 2;
        	int temp=x / mid ;
        	
        	if(temp == mid)
        	{
        		return mid;
        	}
        	else if(temp < mid)
        	{
        		R=mid;
        	}
        	else
        	{
        		L=mid+1;
        	}
        }
        
        return L-1;
        
    }

}
