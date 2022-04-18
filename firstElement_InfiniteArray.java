package Easy;

public class firstElement_InfiniteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1 ,2 , 3 , 3 , 3 , 4 , 7,7 , 8 ,9 , 10 , 34 , 45 , 56 , 59 , 67 , 78};
		int ans=range(arr, 8);
		System.out.println(ans);
	}
	
	static int range(int arr[] , int target)
	{
		int start=0;
		int end=1;
		
		while(target > arr[end])
		{
			int newStart=end+1;
			
			end=end + (end -start +1)*2;
			start=newStart;
		}
		return search(arr, target, start, end);
	}
	
	static int search(int arr[] ,int target ,int start , int end)
	{	
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
				return mid;
			}
		}
		
		return -1;
	}

}
