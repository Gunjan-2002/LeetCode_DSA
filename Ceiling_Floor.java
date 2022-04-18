package Easy;

public class Ceiling_Floor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {23 , 45 , 54 , 67 , 76 , 78 , 89};
		int ceil=ceiling(arr, 89);
		System.out.println(ceil);
		int floor=floor(arr, 89);
		System.out.println(floor);

	}
	
	static int ceiling(int arr[] , int target)
	{
		int start=0;
		int last=arr.length-1;
		boolean isAsc = arr[start] < arr[last];
		if(target > arr[arr.length-1])
		{
			return -1;
		}
		
		while(start <= last)
		{
			int mid=start + (last - start)/2;
			
			if(target == mid)
			{
				return mid;
			}
			
			if(isAsc)
			{
				if(target > arr[mid])
				{
					start=mid+1;
				}
				else
				{
					last=mid-1;
				}
			}
			else
			{
				if(target < arr[mid])
				{
					start=mid+1;
				}
				else
				{
					last=mid-1;
				}
			}
		}
		
		return arr[start];
		
	}

	
	static int floor(int arr[] , int target)
	{
		int start=0;
		int last=arr.length-1;
		boolean isAsc = arr[start] < arr[last];
		
		if(target > arr[arr.length-1])
		{
			return -1;
		}
		
		while(start <= last)
		{
			int mid=start + (last - start)/2;
			
			if(target == mid)
			{
				return mid;
			}
			
			if(isAsc)
			{
				if(target > arr[mid])
				{
					start=mid+1;
				}
				else
				{
					last=mid-1;
				}
			}
			else
			{
				if(target < arr[mid])
				{
					start=mid+1;
				}
				else
				{
					last=mid-1;
				}
			}
		}
		
		return arr[last];		
	}	
}
