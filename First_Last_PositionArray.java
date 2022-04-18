package Easy;

public class First_Last_PositionArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1 ,2 , 3 , 3 , 3 , 4 , 7,7 , 8 ,9};
		int ans[]=firstLast(arr, 7);
		for(int a : ans)
		{
			System.out.println(a);
		}

	}
	
	static int [] firstLast(int arr[] , int target)
	{
		int ans[]= {-1,-1};
		int strt=search(arr, target, true);
		int lst=search(arr, target, false);
		ans[0]=strt;
		ans[1]=lst;
		return ans;
	}
	
	static int search(int arr[] ,int target , boolean startIdx)
	{
		int start=0;
		int end=arr.length-1;
		int ans=-1;
		
		while(start <= end)
		{
			int mid=start + (end-start)/2;
			
			if(target < arr[mid])
			{
				end=mid-1;
			}
			else if(target > arr[mid])
			{
				start=mid+1;
			}
			else
			if(target == arr[mid])
			{
				ans=mid;
				if(startIdx)
				{
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}
			}
		}
		
		return ans;
	}

}
