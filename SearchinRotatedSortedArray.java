package Medium;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,5,6,7,0,1,2};
		int ans=pivotIdx(arr);
		System.out.println(ans);
		System.out.println();
		int ans1=search(arr, 0);
		System.out.println(ans1);
	}
	
	static int search(int[] nums, int target)
	{
	        int piv=pivotIdx(nums);
	        
	        if(piv == -1)
	        {
	        	return searchBS(nums, target, 0, nums.length-1);
	        }
	        if(nums[piv] == target)
	        {
	        	return piv;
	        }
	        int first=searchBS(nums, target, 0, piv-1);
	        if(first != -1)
	        {
	        	return first;
	        }
	        return searchBS(nums, target, piv +1 , nums.length-1);
	        
	 }
	
	static int searchBS(int arr[] ,int target ,int start , int end)
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
	
	static int pivotIdx(int arr[])
	{
		int start=0;
		int end=arr.length-1;
		
		while(start <= end)
		{
			int mid=start + (end - start)/2;
			
			if( mid < end && arr[mid] > arr[mid+1])
			{
				return mid;
			}
			else if(mid > start && arr[mid] < arr[mid-1])
			{
				return mid-1;
			}
			
			if(arr[start] >= arr[mid])
			{
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		return -1;
	}

	static int pivotIdx_withDuplicates(int arr[])
	{
		int start=0;
		int end=arr.length-1;
		
		while(start <= end)
		{
			int mid=start + (end - start)/2;
			
			if( mid < end && arr[mid] > arr[mid+1])
			{
				return mid;
			}
			else if(mid > start && arr[mid] < arr[mid-1])
			{
				return mid-1;
			}
			
			if(arr[mid] == arr[start] && arr[mid] == arr[end])
			{
				if(arr[start] > arr[start+1])
				{
					return start;
				}
				start++;
				
				if(arr[end] < arr[end-1])
				{
					return end;
				}
				end--;
			}
			else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]))
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		return -1;
	}
	
	
	
}
