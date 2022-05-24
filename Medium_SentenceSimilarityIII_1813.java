package Strings.Medium;

//								1813. Sentence Similarity III
//			
//			A sentence is a list of words that are separated by a single space
//			with no leading or trailing spaces. For example, "Hello World", "HELLO",
//			"hello world hello world" are all sentences. Words consist of only uppercase
//			and lowercase English letters.
//			
//			Two sentences sentence1 and sentence2 are similar if it is possible to insert an
//			arbitrary sentence (possibly empty) inside one of these sentences such that the 
//			two sentences become equal. For example, sentence1 = "Hello my name is Jane" and 
//			sentence2 = "Hello Jane" can be made equal by inserting "my name is" between "Hello"
//			and "Jane" in sentence2.
//			
//			Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 
//			are similar. Otherwise, return false.
//			
//			Example 1:
//			
//			Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//			Output: true
//			Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
//			
//			Example 2:
//			
//			Input: sentence1 = "of", sentence2 = "A lot of words"
//			Output: false
//			Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.
//			
//			Example 3:
//			
//			Input: sentence1 = "Eating right now", sentence2 = "Eating"
//			Output: true
//			Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
//			 
//			Constraints:
//			
//			1 <= sentence1.length, sentence2.length <= 100
//			sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
//			The words in sentence1 and sentence2 are separated by a single space.



public class Medium_SentenceSimilarityIII_1813 
{
	public static void main(String[] args) 
	{
		String sentence1 = "My name is Haley";
		String sentence2 = "My Haley";
		
		System.out.println(areSentencesSimilar(sentence1, sentence2));
	}

	
//		Note :
//		
//		Method 1: Scan the shorter sentence compare with the longer.
//
//		1]Split the two sentences into words;
//	
//		2]Scan the shorter one from left and compare word by word with the 
//		longer; Whenever the words from the 2 sentences are not equal, compare
//		the tails of the 2 sentences word by word till the end or they do not match;
//		
//		3]Confirm if the pointer reaches the end of shorter sentence. If yes, return true;
//		otherwise, return false.
	
	
	 static boolean areSentencesSimilar(String sentence1, String sentence2) 
	    {    
	        String word1[]=sentence1.split(" ");
	        String word2[]=sentence2.split(" ");
	        
	        int n1= word1.length;
	        int n2= word2.length;
	        
	        if(n1 > n2)
	        {
	            return areSentencesSimilar(sentence2,sentence1);
	        }
	        
	        int i=0;
	        
	        while(i < n1 && word1[i].equals(word2[i]))
	        {
	            ++i;
	        }
	        
	        while(i < n1 && word1[i].equals(word2[n2-n1+i]))
	        {
	            ++i;
	        }
	        
	        return i==n1;
	    }
}
