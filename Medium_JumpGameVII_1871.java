package Strings.Medium;

import java.util.LinkedList;
import java.util.Queue;

//						1871. Jump Game VII
//		
//		You are given a 0-indexed binary string s and two integers 
//		minJump and maxJump. In the beginning, you are standing at 
//		index 0, which is equal to '0'. You can move from index i 
//		to index j if the following conditions are fulfilled:
//		
//		i + minJump <= j <= min(i + maxJump, s.length - 1), and
//		s[j] == '0'.
//		Return true if you can reach index s.length - 1 in s, or false
//		otherwise.
//		
//		Example 1:
//		
//		Input: s = "011010", minJump = 2, maxJump = 3
//		Output: true
//		Explanation:
//		In the first step, move from index 0 to index 3. 
//		In the second step, move from index 3 to index 5.
//		
//		Example 2:
//		
//		Input: s = "01101110", minJump = 2, maxJump = 3
//		Output: false
//		
//		Constraints:
//		
//		2 <= s.length <= 105
//		s[i] is either '0' or '1'.
//		s[0] == '0'
//		1 <= minJump <= maxJump < s.length


public class Medium_JumpGameVII_1871 
{
	public static void main(String[] args) 
	{
		String s1="011010";
		String s2 ="01101110";
		System.out.println(canReach(s1, 2, 3));
		System.out.println(canReach(s2, 2, 3));
	}
	
	
//		Note :
//			
//		Here we implement Queue and we use the logic of BFS here.
//		Basically we are storing the indices that are reachable
//		First we create a empty queue and add 0 in the queue .
//		then apply a for loop from index 1 and check for each index
//		if(current character is 0 or not ) if 0 then do this thing's
//			1]remove the elements from which we can't achive the current index
//			  i.e the scope of peek element+maxJump has been less than current
//			  index if not 0 then continue for next index for this apply for loop
//			2]check if queue is empty which means there is no way to get to the 
//			  current index position. and return false.
//			3]check if((peek element+maxJump) >= current index  && (peek element +minJump) <= current index)
//			  then add current index to queue and also check if(i == last index of string) then return true
//		At last return false if not possible to reach last index
//		That's it !		
		
	static boolean canReach(String s, int minJump, int maxJump) 
	{
		Queue<Integer> dp = new LinkedList<>();
		
		int n=s.length();
		
		dp.offer(0);
		
		for(int i=1;i<n;i++)
		{
			if(s.charAt(i) == '0')
			{
				while(!dp.isEmpty() && dp.peek() < (i-maxJump))
				{
					dp.poll();
				}
				
				if(dp.isEmpty())
				{
					return false;
				}
				
				int prev=dp.peek();
				
				if((prev+maxJump) >= i  && (prev+minJump) <= i)
				{
					dp.offer(i);
					if(i == n-1)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
}
