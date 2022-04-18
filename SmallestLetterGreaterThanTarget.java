package Easy;

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[]= {'c' , 'f' , 'j'};
		char ceil=ceiling(arr, 'g');
		System.out.println(ceil);
	}

	static char ceiling(char arr[] , int target)
	{
		int start=0;
		int last=arr.length-1;

		
		while(start <= last)
		{
			int mid=start + (last - start)/2;

				if(target >= arr[mid])
				{
					start=mid+1;
				}
				else
				{
					last=mid-1;
				}
			}

		return arr[start % arr.length];	
	}
}
