package Strings.Medium;


//					1573. Number of Ways to Split a String
//		
//		Given a binary string s, you can split s into 3 non-empty
//		strings s1, s2, and s3 where s1 + s2 + s3 = s.
//		
//		Return the number of ways s can be split such that the number 
//		of ones is the same in s1, s2, and s3. Since the answer may be
//		too large, return it modulo 109 + 7.
//		
//		Example 1:
//		
//		Input: s = "10101"
//		Output: 4
//		Explanation: There are four ways to split s in 3 parts where each 
//		part contain the same number of letters '1'.
//		"1|010|1"
//		"1|01|01"
//		"10|10|1"
//		"10|1|01"
//		
//		Example 2:
//		
//		Input: s = "1001"
//		Output: 0
//		
//		Example 3:
//		
//		Input: s = "0000"
//		Output: 3
//		Explanation: There are three ways to split s in 3 parts.
//		"0|0|00"
//		"0|00|0"
//		"00|0|0"
//		
//		Constraints:
//		
//		3 <= s.length <= 105
//		s[i] is either '0' or '1'.


public class Medium_NumberofWaystoSplitaString_1573 
{
	public static void main(String[] args) 
	{
		String s = "10101";
		System.out.println(numWays(s));
	}
	
	
	
//			Note :
//			
//			We have three different scenarios.
//		
//			scenarios_1: If the total number of ones in the input string is not the multiple
//			of three, there is no way we can cut the string into three blocks with an equal 
//			number of ones. => Count the total number of the 1s, if not divisible by 3, then return 0;
//		
//			scenarios_2: If give input string are all zeros, it doesn't matter how you want to cut, and 
//			each block will have the same number of ones. In other words, the number of ones equals zero
//			in each block. Therefore, the total number of ways to cut the input string is (n - 2) + (n - 3)
//			+ ... + 2 + 1 = (n - 2) * (n - 1) / 2. (Please reference the proof from @rock explanation).
//		
//			scenarios_3: This is a more general situation. First, think about it, in order to cut the input 
//			string to three parts, we need only two cuts, so we can get three blocks. Let's say these three 
//			blocks are b1, b2, b3. Now, we want the number of ones to be equal for all three blocks and the 
//			number of ones we need for each block is total number of ones / 3. The questions now become where
//			we need to do our cut, remember we need to only two cuts to make three blocks, so we need to decide 
//			where we need to do our first cut, and where we can do our second cut, with all of these we can know
//			our final answer.
//			
//			Starts from begin of the input string, we can not cut until the number of ones in the substring is less
//			than total number of ones / 3. If the number of ones in the substring is equal to total number of ones / 3,
//			then that is our place to do the first cut. For example, we have an input string 100100010100110. The number
//			of ones for each block will be total number of ones / 3 = 6 / 3 = 2. The first cut place can be either after 
//			index 3,4,5 and 6 because of those substrings ( substring(0, 4), substring(0, 5), substring(0, 6), substring(0, 7)
//			will have the same number of ones, which is 2 and the number of ways to cut at first place is 4 (see diagram below).
//			
//			After, we know about our first places to cut the input string, we need to know the second place to cut. When it 
//			comes to the second block, the number of ones we want are the number of ones in the first block + the number of
//			ones in the second block = 1s in b1 + 1s in b2. Based on the example above, 1s in b1 + 1s in b2 = 2 + 2 = 4, since
//			the ones between blocks are equal, we can also simply do 2 * (number of ones each block) = 2 * 2 = 4. Therefore, we
//			need to find the substring with the total number of ones is equal to 4. Those substrings are substring(0, 10), 
//			substring(0, 11), substring(0, 12) and our second cut places can be either after index 9, 10, 11 and the number of ways
//			to cut at second place is 3. (see diagram below)
//			
//			Finally, after two cuts, we got our 3 blocks and we have known all the places we can do these two cuts, so we can calculate
//			the total ways of cutting are number of ways to cut at first place x number of ways to cut at second place = 4 x 3 = 12.
	
	
	
	static final int m = 1_000_000_007;
    static int numWays(String s) 
    {    
        int numberOfOnes=0;
        
        int n=s.length();
        
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '1')
            {
                numberOfOnes++;
            }
        }
        
        
        
        if(numberOfOnes % 3 != 0)
        {
            return 0;
        }
        
        if(numberOfOnes == 0)
        {
            return (int)((n-2L)*(n-1L)/2%m);
        }
        
        
        int onesInEachBlock=numberOfOnes/3;
                
        long waysOfFirstCut=0, waysOfSecondCut=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i) == '1')
            {
                count++;
            }
            
            if(count == onesInEachBlock)
            {
                waysOfFirstCut++;
            }
            if(count == 2*onesInEachBlock)
            {
                waysOfSecondCut++;
            }
        }
        
        return (int)(waysOfSecondCut*waysOfFirstCut%m);
    }
}
