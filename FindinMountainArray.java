package Hard;

public class FindinMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,2,4,2,1};
		int ans=findInMountainArray(3, arr);
		System.out.println(ans);
	}
	
	 static int findInMountainArray(int target,  int arr[]) 
	 {
	        int peak=peakIndexInMountainArray(arr);
	        int firstSearch=orderAgnosticBS(arr, target, 0, peak-1);
	        if(firstSearch != -1)
	        {
	        	return firstSearch;
	        }
	        return orderAgnosticBS(arr, target, peak+1, arr.length-1);
     }
	 
	 static  int peakIndexInMountainArray(int[] arr)
		{
			int start=0;
			int end=arr.length-1;
			
			while(start < end)
			{
				int mid=start + (end - start)/2;
				
				
				if(arr[mid] > arr[mid + 1])
				{
					end=mid;
				}
				else if( arr[mid] < arr[mid +1])
				{
					start=mid+1;
				}
			}
	        return arr[start];
	    }
	 
	 static int orderAgnosticBS(int arr[] , int target , int start , int end)
	 {
		 boolean isAsc=arr[start] < arr[end];
		 
		 while(start <= end )
		 {
			 int mid = start + (end - start)/2;
			 
			 if(arr[mid] == target)
			 {
				 return mid;
			 }
			 
			 if(isAsc)
			 {
				 if(arr[mid] < target)
				 {
					 start=mid+1;
				 }
				 else
				 {
					 end=mid-1;
				 }
			 }
			 else
			 {
				 if(arr[mid] > target)
				 {
					 start=mid+1;
				 }
				 else
				 {
					 end=mid-1;
				 }
			 }	 
		 }
		 return -1;
	 }
}
