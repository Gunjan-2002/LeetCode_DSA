package Easy;

public class PeakIndex_inMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {24,69,100,99,79,78,67,36,26,19};
		int peak=peakIndexInMountainArray(arr);
		System.out.println(peak);
//		[24,69,100,99,79,78,67,36,26,19]
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

}
