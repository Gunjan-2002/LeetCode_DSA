package Medium;

public class RotationCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,5,6,7,0,1,2};
		int ans=pivot(arr);
		System.out.println(ans);
		System.out.println();
		int count=countRotation(arr);
		System.out.println(count);
	}
	
	static int countRotation(int arr[])
	{
		int piv=pivot(arr);
		return piv+1;
	}
	static int pivot(int arr[])
	{
		int start=0;
		int end=arr.length-1;
		
		while(start <= end)
		{
			int mid=start + (end -start)/2;
			if(arr[mid] > arr[mid+1])
			{
				return mid;
			}
			else if(arr[mid] < arr[mid-1])
			{
				return mid-1;
			}
			if(arr[start] < arr[mid])
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
