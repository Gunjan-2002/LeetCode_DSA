package Strings.Easy;

//								1528  :  Shuffle String
//		
//		You are given a string s and an integer array indices of the same length. 
//		The string s will be shuffled such that the character at the ith position 
//		moves to indices[i] in the shuffled string.
//		
//		Return the shuffled string.
//		
//		Example 1:
//		
//		Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//		Output: "leetcode"
//		Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
//		
//		Example 2:
//		
//		Input: s = "abc", indices = [0,1,2]
//		Output: "abc"
//		Explanation: After shuffling, each character remains in its position.
//		
//		Constraints:
//		
//		s.length == indices.length == n
//		1 <= n <= 100
//		s consists of only lowercase English letters.
//		0 <= indices[i] < n
//		All values of indices are unique.



public class Easy_ShuffleString_1528 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	 public static String restoreString_1(String s, int[] indices) 
	    {
	        StringBuilder sb=new StringBuilder(s);  
	        
	        for(int i=0;i<s.length();i++)
	        {
	            int idx=indices[i];
	            char ch=s.charAt(i);
	            sb.replace(idx,idx+1,ch+"");
	        }
	        return sb.toString();     
	    }

	   public String restoreString_2(String s, int[] indices) 
	    {
		 char[] cArr = s.toCharArray();
		    for (int i = 0; i < cArr.length; i++) {
		        while (i != indices[i]) {
		            swapChar(cArr, i, indices[i]);
		            swapInt(indices, i, indices[i]);
		        }        
		    }
		    return String.valueOf(cArr);
	    }
	 
	   public void swapInt(int[] indices, int x, int y) 
	   {
		    int temp = indices[x];
		    indices[x] = indices[y];
		    indices[y] = temp;   
	   }

		public void swapChar(char[] cArr, int x, int y) 
		{
		    char t = cArr[x];
		    cArr[x] = cArr[y];
		    cArr[y] = t;
		}
}
