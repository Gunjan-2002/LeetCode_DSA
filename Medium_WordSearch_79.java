package Recursion.Medium;


//											79. Word Search
//		
//		Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//		
//		The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
//		horizontally or vertically neighboring. The same letter cell may not be used more than once.
//		
//		Example 1:
//		
//		Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//		Output: true
//		
//		Example 2:
//		
//		Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//		Output: true
//		
//		Example 3:
//		
//		Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//		Output: false
//		
//		Constraints:
//		
//		m == board.length
//		n = board[i].length
//		1 <= m, n <= 6
//		1 <= word.length <= 15
//		board and word consists of only lowercase and uppercase English letters.
//		
//		Follow up: Could you use search pruning to make your solution faster with a larger board?


public class Medium_WordSearch_79 {

	public static void main(String[] args) {
		char ar[][]={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist(ar, "ABCCED"));
	}

	static boolean exist(char[][] board, String word) {
		for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(word.charAt(0) == board[i][j]  && check(board,i,j,word,0))
                {
                    return true;
                }
            }
        }
        return false;
    }
	
	static boolean check(char[][] board , int i , int j , String word , int pos)
	{
		// If pos is at last position means word has been found
		if(pos == word.length())
        {
            return true;
        }
        
		
		// For out of bound index for i & j
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
        {
            return false;
        }
        
        
        // If not equal then return false so we can check for next character so that it will equal
        if(word.charAt(pos) != board[i][j])
        {
            return false;
        }
        
        // For Visited Mark
        char temp=board[i][j];
        board[i][j]='*';
        
        
        // Recursive call for the word start from position+1 and assume that we have got the first character of String word
        if(check(board,i+1,j,word,pos+1) ||
           check(board,i-1,j,word,pos+1) ||
           check(board,i,j+1,word,pos+1) ||
           check(board,i,j-1,word,pos+1) )
        {
            return true;
        }
        
        board[i][j]=temp;
        
        return false;
	}
	
}
