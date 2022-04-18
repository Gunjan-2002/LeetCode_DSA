package Easy;

import java.util.List;

//											Check if the Sentence Is Pangram
//				
//				A pangram is a sentence where every letter of the English 
//				alphabet appears at least once.
//				
//				Given a string sentence containing only lowercase English letters,
//				return true if sentence is a pangram, or false otherwise.
//				
//				 
//				
//				Example 1:
//				
//				Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//				Output: true
//				Explanation: sentence contains at least one of every letter of the English alphabet.
//				Example 2:
//				
//				Input: sentence = "leetcode"
//				Output: false
//				 
//				
//				Constraints:
//				
//				1 <= sentence.length <= 1000
//				sentence consists of lowercase English letters.


public class CheckiftheSentenceIsPangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean checkIfPangram(String sentence) 
	    {
		 String str="abcdefghijklmnopqrstuvwxyz";
	        for(int i=0;i<str.length();i++)
	        {
	            if(sentence.contains(str.charAt(i)+"")==false)
	            {
	                return false;
	            }
	        }
	        return true;
	    }
	 
	 public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) 
	    {
	        int count=0;
	        int place=0;
	        
	        for(int i=0;i<items.size();i++)
	        {
	            if(items.get(i).get(place).contains(ruleValue))
	            {
	                count++;
	            }
	        }
	        return count;
	    }
	 
}
