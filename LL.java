package Linked_List_Easy;

public class LL 
{
	Node head;
	Node tail;
	int size;
		
	public LL() 
	{
		this.size=0;
	}

	public void insertFirst(int val)
	{
		Node node = new Node(val);
		node.next=head;
		head=node;
		
		if(tail == null)
		{
			tail=head;
		}
		
		size++;
	}
	
	public void insertLast(int val)
	{
		if(tail == null)
		{
			insertFirst(val);
			return;
		}
		
		Node node = new Node(val);
		tail.next=node;
		tail=node;		
		
		size++;
	}
	
	public void insert(int value , int ind)
	{
		if(ind == 0)
		{
			insertFirst(value);
			return;
		}
		
		if(ind == size)
		{
			insertLast(value);
			return;
		}
		
		Node temp = head;
		Node insert = new Node(value);
		int tempInd=0;
		
		while(tempInd != ind-1)
		{
			temp=temp.next;
			tempInd++;
		}
		
		insert.next=temp.next;
		temp.next=insert;
		size++;
	}
	
	// INSERT USING RECURSION
	
	public void insertRec(int val , int ind)
	{
		head=insertRec(val, ind, head);
	}
	
	private Node insertRec(int val , int ind , Node node)
	{
		if(ind == 0)
		{
			Node temp = new Node(val,node);
			size++;
			return temp;
		}
		
		node.next = insertRec(val, ind-1 , node.next);
		return node;
	}
	
	
	public int deleteFirst()
	{
		int val = head.data;
		head=head.next;
		
		if(head == null)
		{
			tail=null;
		}
		
		size--;
		
		return val;
	}
	
	public int deleteLast()
	{
		if(size <= 1)
		{
			return deleteFirst();
		}
		Node temp = head;
		
		while(temp.next.next != null)
		{
			temp=temp.next;
		}
		
		int val = temp.next.data;
		
		tail=temp;
		tail.next=null;
		size--;
		
		return val;
	}
	
	public int delete(int ind)
	{
		if(ind == 0)
		{
			return deleteFirst();
		}
		
		if(ind == size-1)
		{
			return deleteLast();
		}
		
		Node temp = head;
		int tempInd=0;
		
		while(tempInd != ind-1)
		{
			temp=temp.next;
			tempInd++;
		}
		
		temp.next=temp.next.next;
		int val = temp.next.data;
				
		return val;
	}
	
	public Node findNode(int val)
	{
		Node temp = head;
		
		while(temp != null)
		{
			if(temp.data == val)
			{
				return temp;
			}
			temp=temp.next;
		}
		return null;
	}

	public void display()
	{
		Node temp = head;
		
		while(temp != null)
		{
			System.out.print(temp.data + " -> ");
			temp=temp.next;
		}
		System.out.println("END");
	}
	
	
	 ********************************************************************************************************************************
	
	83. Remove Duplicates from Sorted List
	
	public Node duplicate(Node head)
	{
		Node node = head;
		
		while(node != null && node.next != null)
		{
			if(node.data == node.next.data)
			{
				node.next=node.next.next;
			}
			else
			{
				node=node.next;
			}
		}
		return head;
	}
	
	
	 ********************************************************************************************************************************

	21. Merge Two Sorted Lists
	
	public static LL mergeSorted(LL l1 , LL l2)
	{
		Node n1 = l1.head;
		Node n2 = l2.head;
		
		LL ans = new LL();
		
		while(n1 != null && n2 != null)
		{
			if(n1.data < n2.data)
			{
				ans.insertLast(n1.data);
				n1=n1.next;
			}
			else
			{
				ans.insertLast(n2.data);
				n2=n2.next;
			}
		}
		
		while(n1 != null)
		{
			ans.insertLast(n1.data);
			n1=n1.next;
		}
		
		while(n2 != null)
		{
			ans.insertLast(n2.data);
			n2=n2.next;
		}
		
		return ans;
	}
	
	
	 ********************************************************************************************************************************

	 141. Linked List Cycle
	

	    Note :
		
		Whenever question has term Find CYCLE irrespective of data structure
		then first use Slow Fast Pointer Algorithm 
	
		Here we take two pointer first one will walk one step and second one will walk 
		two steps for every iteration if anyone makes null then we return false else if
		both the pointers become equal then return true .
				
		Apply logic : If there is cycle then there must be a condition when these two pointer
				      will become equal.
	
		public boolean hasCycle(ListNode head) {
	        ListNode slow=head;
	        ListNode fast=head;
	        
	        while(fast!=null && fast.next!=null)
	        {
	            fast=fast.next.next;
	            slow=slow.next;
	            
	            if(fast == slow)
	            {
	                return true;
	            }
	        }
	        
	        return false;
	    }	

	
	
	 ********************************************************************************************************************************

	To find Length of Cycle in a Linked List


	public int hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast == slow)
            {
               ListNode temp = slow;
               int length = 0;
               
               do
               {
            	   temp=temp.next;
            	   length++;
               } while(temp != slow);
               
               return length;
            }
        }
        
        return 0;
    }	

	
	
	 ********************************************************************************************************************************

	142. Linked List Cycle II
	

    1] FIND THE LENGTH OF CYCLE
    2] MOVE THE FIRST POINTER LENGTH NUMBER OF TIMES
    3] MOVE BOTH FIRST AND SECOND POINTER UNTIL FIRST & SECOND BECOME EQUAL
    4] RETURN FIRST OR SECOND

	
	 public ListNode detectCycle(ListNode head) 
	    {
	        int length=0;
	        
	        ListNode slow=head;
	        ListNode fast=head;
	        
	        while(fast!=null && fast.next!=null)
	        {
	            fast=fast.next.next;
	            slow=slow.next;
	            
	            if(fast == slow)
	            {
	                ListNode temp=slow;
	                
	                do
	                {
	                    temp=temp.next;
	                    length++;
	                }
	                while(temp != slow);
	                
	                break;
	            }
	        }
	        
	        if(length == 0)
	        {
	            return null;
	        }
	        
	        ListNode f=head;
	        ListNode s=head;
	        
	        while(length > 0)
	        {
	            f=f.next;
	            length--;
	        }
	        
	        while(f != s)
	        {
	            f=f.next;
	            s=s.next;
	        }
	        
	        return s;
	    }

	
	 ********************************************************************************************************************************

	202. Happy Number
		

    HERE WE APPLIED THE LOGIC OF FAST AND SLOW POINTER FROM THE LINKED LIST
    WHILE SOLVING THIS EXAMPLE IF THE NUMBER IS NOT HAPPY THEN THERE IS CYCLE
    MEANS THE ONE NUMBER IS REPEATED WHEN WE TAKE SQUARE AND DO SAME LOGIC 
    OPERATION ON THAT NUMBER .
    
    SO WE TAKE TWO POINTER FAST AND SLOW SLOW WILL MOVE ONE STEP AND FAST WILL
    MOVE TWO STEPS AND THE WHILE LOOP WILL RUN UPTO WHICH FAST IS NOT EQUAL TO 
    SLOW . AFTER LOOP IS EXECUTED THEN WE WILL CHECK IF SLOW IS EQUAL TO ONE THEN
    RERURN TRUE ELSE RETURN FALSE.
    
	
    public boolean isHappy(int n) 
    {
        int slow=n;
        int fast=n;
        
        do
        {
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));
        }
        while(slow != fast);
        
        if(slow == 1)
        {
            return true;
        }
        return false;
    }
    
    private int findSquare(int n)
    {
        int ans=0;
        int temp=n;
        
        while(temp > 0)
        {
            int rem = temp % 10;
            ans = ans + rem*rem;
            temp=temp/10;
        }
        return ans;
    }
    
	
	
	 ********************************************************************************************************************************

	876. Middle of the Linked List
	
 
 	public ListNode middleNode(ListNode head) 
    {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast != null && fast.next != null)
        {
            slow=slow.next;
           
                 fast=fast.next.next;
           
        }
        return slow;
    }
    
    
    
     public ListNode getMid(ListNode head) 
    {  
        ListNode midprev=null;
        
        while(head != null && head.next!=null)
        {
            midprev=(midprev == null)?head:midprev.next;
            head=head.next.next;
        }
        
        ListNode mid=midprev.next;
        midprev.next=null;
        return mid;
    }
    
	
	
	 ********************************************************************************************************************************

	148. Sort List
 
 	public ListNode sortList(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode mid = getMid(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
         
        return mergeSortedList(left,right);
    }
    
    public ListNode getMid(ListNode head)
    {  
        ListNode midprev=null;
        
        while(head != null && head.next!=null)
        {
            midprev=(midprev == null)?head:midprev.next;
            head=head.next.next;
        }
        
        ListNode mid=midprev.next;
        midprev.next=null;
        return mid;
    }
    
    public ListNode mergeSortedList(ListNode n1 , ListNode n2)
    {
        ListNode l = new ListNode();
        ListNode temp=l;
        
        while(n1 != null && n2 != null)
        {
            if(n1.val < n2.val)
            {
                temp.next=n1;
                temp=temp.next;
                n1=n1.next;
            }
            else
            {
                temp.next=n2;
                temp=temp.next;
                n2=n2.next;
            }
        }
        
        while(n1 != null)
        {
            temp.next=n1;
            temp=temp.next;
            n1=n1.next;
        }
        
        while(n2 != null)
        {
            temp.next=n2;
            temp=temp.next;
            n2=n2.next;
        }
        
        // temp.next=(n1!=null)?n1:n2;
        
        return l.next;
    }
 
 
	
	 ********************************************************************************************************************************
	
	206. Reverse Linked List
	
 * 
 * 	HERE WE USE TWO POINTER'S APPROACH
 * 		WE TAKE TWO POINTERS CURR ONE POINTS TOWARDS HEAD 
 * 		PRE ONE POINT TOWARDS NULL
 * 		AFTER THIS WE RUN WHILE LOOP UNTIL CURR POINTS TO NULL
 * 			INSIDE THE LOOP WE FIRST SAVE THE CURR NEXT NODE IN 
 * 			NEW NODE CALLED AS NEXT 
 * 			AFTER THIS WE SET CURR NEXT TO PRE AFTER THIS WE SET PRE
 * 			TO CURR AND AFTER THIS CURR TO NEXT 
 * 		ALSE INSIDE THE LOOP IF CURR KA NEXT IS NULL THEN WE SAVE THAT CURR
 * 		NODE IN A GLOBAL DECLARED NEW NODE AND AT LAST WE RETURN THAT GLOBAL NODE
 * 	THAT'S IT .
 * 				THANK YOU !
 
 	 
    
     public ListNode reverseList(ListNode head) 
    {        
        return reverseHelper(head , null);        
    }
 
    
    public ListNode reverseHelper(ListNode head , ListNode newHead)
    {
        if(head == null)
        {
            return newHead;
        }
        
        ListNode nextHead=head.next;
        head.next=newHead;
                
        return reverseHelper(nextHead , head );
    }
    
    public ListNode reverseList(ListNode head) 
    {        
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode newHead=reverseList(head.next);
        
        ListNode headNext=head.next;
        headNext.next=head;
        head.next=null;
        
        return newHead;
    }
 	 	
	
	
	 ********************************************************************************************************************************

	234. Palindrome Linked List
	
 * 
 * NOTE :
 * 		HERE WE FIRST FIND THE MID NODE
 * 		THEN WE REVERSE THE LIST FROM MID TO LAST
 * 		THEN WE CHECK IF HEAD.VAL IS EQUAL TO OR NOT EQUAL TO REVERSE LIST HEAD
 * 		IF NOT SAME WE BREAK FROM A LOOP 
 * 		THIS WILL CONTINUE UNTIL HEAD != NULL && NEW REVERSE LIST HEAD != NULL
 * 		IF HEAD == NULL OR NEW REVERSE LIST HEAD == NULL
 * 			RETURN TRUE
 * 		ELSE
 * 			RETURN FALSE;
 
 

	public boolean isPalindrome(ListNode head) 
    {
        ListNode mid=mid(head);
        
        ListNode rev=rev(mid);
        
        ListNode midRem=rev;
        
        while(head != null && rev != null)
        {
            if(head.val != rev.val)
            {
                break;
            }
            head=head.next;
            rev=rev.next;
        }
        
        rev(midRem);
        
        if(head == null || rev == null)
        {
            return true;
        }
        
        return false;
        
    }
    
    public ListNode mid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast != null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode rev(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode newHead=rev(head.next);
        ListNode headNext=head.next;
        headNext.next=head;
        head.next=null;
        
        return newHead;
    }
  
	
	
	 ********************************************************************************************************************************

	143. Reorder List
	

	public void reorderList(ListNode head) 
    {
       if(head==null || head.next==null)
       {
           return;
       }
        
        ListNode mid=mid(head);
        
        ListNode hs=rev(mid);
        
        ListNode hf=head;
        
        while(hf!=null && hs!=null)
        {
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;
            
            temp=hs.next;
            hs.next=hf;
            hs=temp;           
        }
        
        if(hf != null)
        {
            hf.next=null;
        }     
    }
    
    public ListNode mid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast != null  && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    
    public ListNode rev(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode newHead=rev(head.next);
        
        ListNode headNext=head.next;
        headNext.next=head;
        head.next=null;
        
        return newHead;
    }
 
	
	
	 ********************************************************************************************************************************

	92. Reverse Linked List II
	


* HERE WE USED THREE POINTERS TO REVERSE THE SUBLIST
* FIRST WE TAKE ONE POINTER NODEBEFORESUBLIST WHICH POINTS TO NULL INITIALLY
* THEN WE TRAVERSE THE NODEBEFORESUBLIST POINTER AT THE POSITION ONE LESS THAN
* STARTING OF SUBLIST I.E ONE NODE BEFORE STARTING OF SUBLIST
* AFTER THAT WE DECLARE NEW NODE AS WORKING POINTER WHICH HAS VALUE OF NEXT NODE
* OF NODEBEFORESUBLIST AFTER THIS
* WE RUN A WHILE LOOP UNTIL START IS LESS THAN END
* INSIDE THE LOOP
* WE DECLARE ANATHER I.E THIRD POINTER WHICH IS CALLED AS NODETOBEEXTRACTED
* WHICH HAS VALUE WORKING POINTER.NEXT FOR EVERY ITERATION
* THEN WE SET WORKING POINTER.NEXT TO NODETOBEEXTRACTED.NEXT
* THEN NODETOBEEXTRACTED.NEXT TO NODEBEFORESUBLIST.NEXT
* THEN NODEBEFORESUBLIST.NEXT TO NODETOBEEXTRACTED
* AND INCREEMENT THE START
* END WHILE LOOP
* AT LAST WE RETURN DUMMY HEAD WHICH WE CREATED AT THE BEGINNIG


 	 public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if(head==null || left==right)
        {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next=head;
        
        ListNode nbl=dummy;
        int pos=1;
        
        while(pos < left)
        {
            nbl=nbl.next;
            pos++;
        }
        
        ListNode wn=nbl.next;
        
        while(left < right)
        {
            ListNode ne=wn.next;
            wn.next=ne.next;
            ne.next=nbl.next;
            nbl.next=ne;
            left++;
        }
       return dummy.next;
        
    }
    
	
	
	 ********************************************************************************************************************************

	25. Reverse Nodes in k-Group
	

 * HERE ALSO WE TAKE THREE POINTER PRE CURR NEXT
 * FIRST OF ALL WE CHECK THAT IF HEAD==NULL OR K==1 IF YES
 * THEN RETURN HEAD
 * ELSE
 * FIRST OF ALL WE NEED TO FIND THE NUMBER OF NODES IN A LINK LIST AND STORE
 * IT IN A INTEGER VARIABLE 
 * THEN WE DECLARE A PREVIOUS NODE WHICH POINTS TO NULL INITIALLY
 * NOW RUN A WHILE LOOP UNTIL TOTAL NUMBER OF NODES IS GREATER THAN K
 * INSIDE THE LOOP DECLARE TWO NODES
 * FIRST ONE CURR WHICH POINTS TO PREV.NEXT AND SECOND ONE NEXT WHICH POINTS TO
 * CURR.NEXT
 * NOW RUN A FOR LOOP UPTO K-1 TIMES WHY K-1 TIMES ? BECAUSE IF THERE ARE K ELEMENTS
 * THEN WE NEED TO DO SWAPPPING OPERATION K-1 TIME SO WE WILL FOR LOOP FOR K-1 TIMES
 * INSIDE FOR LOOP WE DO SWAPPING OPERERATION
 * CURR.NEXT=NEXT.NEXT
 * NEXT.NEXT=PRE.NEXT
 * PRE.NEXT=NEXT
 * NEXT=CURR.NEXT
 * FOR LOOP OVER
 * AFTER THIS WE CHANGE THE PRE TO CURR AS IT POINTS TO ONE NODE LESS THAN FOR A NEXT SUBLIST
 * AND DECREMENT THE TOTAL NUMBER OF NODE BY K
 * WHILE LOOP ENDS
 * AT LAST RETURN DUMMY.NEXT I.E ORIGINAL HEAD OF LINKEDLIST
 

 public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null || k==1)
        {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next=head;
        
        int totalNoNode=totalNodes(head);
        
        ListNode previous=dummy;
        
        while(totalNoNode >= k)
        {
            ListNode current=previous.next;
            ListNode next = current.next;
            
            for(int i=1;i<k;i++)
            {
                current.next=next.next;
                next.next=previous.next;
                previous.next=next;
                next=current.next;
            }
            previous=current;
            totalNoNode=totalNoNode-k;
        }
         return dummy.next;
    }
    
    public int totalNodes(ListNode head)
    {
        ListNode temp=head;
        int count=0;
        
        while(temp != null)
        {
            temp=temp.next;
            count++;
        }
        
        return count;
    }
 

	
	
	 ********************************************************************************************************************************

	25. Reverse Alternate Nodes in k-Group
	

  public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(head==null || k==1)
        {
            return head;
        }
        
        ListNode dummy = new ListNode();
        dummy.next=head;
        
        int totalNoNode=totalNodes(head);
        
        ListNode previous=dummy;
        
        while(totalNoNode >= k)
        {
            ListNode current=previous.next;
            ListNode next = current.next;
            
            for(int i=1;i<k;i++)
            {
                current.next=next.next;
                next.next=previous.next;
                previous.next=next;
                next=current.next;
            }
            
            
            // THIS IS THE ONLY CHANGE IN CODE AS COMPARED TO PREVIOUIS PROBLEM
            // WE SKIP K NODES
            
            for(int i=0;current!=null && i<k+1 ;i++)
            {
                previous=current;
                current=current.next;
                totalNoNode=totalNoNode-1;
            }
             
            totalNoNode=totalNoNode-k;
        }
         return dummy.next;
    }
    
    public int totalNodes(ListNode head)
    {
        ListNode temp=head;
        int count=0;
        
        while(temp != null)
        {
            temp=temp.next;
            count++;
        }
        
        return count;
    }
	
	
	 ********************************************************************************************************************************

	2. Add Two Numbers 

	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse 
	order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
	
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.
	
	Example 2:
	Input: l1 = [0], l2 = [0]
	Output: [0]
	
	Example 3:
	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]
	 
	Constraints:
	
	The number of nodes in each linked list is in the range [1, 100].
	0 <= Node.val <= 9
	It is guaranteed that the list represents a number that does not have leading zeros.
 
 
 * Notes --
 * 
 * Given solution is so simple if you know the logic
 * Given two link list which are already in reverse order and we 
 * have to add two link list by original order and return the link list 
 * again in reverse order.
 * 
 * So may of us think the first we reverse both the list and then add 
 * one by one node value into some variable but it is not a good logic.
 * We also have to think about the carry.
 * 
 * So here we take one dummy linkList initially it points to null.
 * Then take two pointers curr1 & curr2 which points to head1 and head2
 * of given two link list and initialize carry variable as 0.
 * 
 * Now apply while loop with condition that curr1 not equal to null or 
 * curr2 not equal to null or carry is not equal to 0
 * inside loop :
 * Take out the value of current node in variable and name it as num1 and num2
 * Create new variable newNum assign it num1+num2+carry , This is the whole addition
 * of two values now extract the carry part and num part for num part take  modulus
 * for carry part take division part 
 * assign modulus part to new variable name as num and change the carry to new carry 
 * we get.
 * 
 * Now append the num part we get to a dummyNode and move it one position
 * 
 * Now move curr1 and curr2 to next pointer but check if curr1 and curr2 is equal to
 * null or not if null then assign nul to curr1 or curr2 respectively.
 
  
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	    {
	        ListNode dummyNode = new ListNode(0);
	        ListNode tempNode = dummyNode;
	        
	        int carry=0;
	        
	        ListNode curr1 = l1;
	        ListNode curr2 = l2;
	        
	        while(curr1 != null || curr2 != null || carry != 0)
	        {
	            int num1 = curr1 == null ? 0 : curr1.val;
	            int num2 = curr2 == null ? 0 : curr2.val;
	            
	            int newNum = num1 + num2 + carry;
	            int num = newNum % 10;
	            carry = newNum / 10;
	            
	            tempNode.next = new ListNode(num);
	            tempNode = tempNode.next;
	            
	            curr1 = curr1 == null ? null : curr1.next;
	            curr2 = curr2 == null ? null : curr2.next;
	        }
	        
	        return dummyNode.next;
	    }
	}

	
	
	 ********************************************************************************************************************************

	445. Add Two Numbers II
	
	
	You are given two non-empty linked lists representing two non-negative integers. 
	The most significant digit comes first and each of their nodes contains a single
	digit. Add the two numbers and return the sum as a linked list.
	
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
	Input: l1 = [7,2,4,3], l2 = [5,6,4]
	Output: [7,8,0,7]
	
	Example 2:
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [8,0,7]
	
	Example 3:
	Input: l1 = [0], l2 = [0]
	Output: [0]
	 
	Constraints:
	
	The number of nodes in each linked list is in the range [1, 100].
	0 <= Node.val <= 9
	It is guaranteed that the list represents a number that does not have leading zeros.
 
 
  * Notes --
  * 
  * In this question we use stack of integers.
  * First we declare two stacks and and add all elements of each link list
  * into respective stack 1 and 2 
  * 
  * Also initialize a empty list node with null and also carry variable with value 0
  * 
  * Apply while loop with condition of stack1 is not equal to null or stack 2
  * is not equal to null the :
  * As we know that stack is FILO First in last out so we extract last elements of
  * each stack add them with carry 
  * then declare new list node temp with value newNum % 10 and change carry to newNum / 10
  * 
  * then we also have to go from last position to first 
  * for that write temp.next = result and result is equal to temp 
  * While loop over 
  * 
  * If by chance carry is not equal to zero or greater than 0 then add carry to new Listnode
  * and write temp.next = result and result = temp;

	class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while(l1 != null)
        {
            s1.add(l1.val);
            l1=l1.next;
        }
        
        while(l2 != null)
        {
            s2.add(l2.val);
            l2=l2.next;
        }
        
        int carry=0;
        
        ListNode result = null;
        
        while( !s1.isEmpty() || !s2.isEmpty())
        {
            int num1=0,num2=0;
            
            if(!s1.isEmpty())
            {
                num1 = s1.pop();
            }
            
            if(!s2.isEmpty())
            {
                num2 = s2.pop();
            }
            
            int newNum = num1 + num2 + carry;
            
            ListNode temp = new ListNode(newNum % 10);
            
            carry = newNum / 10;
            
            if(result == null)
            {
                result = temp;
            }
            else
            {
                temp.next = result;
                result = temp;
            }
        }
        
        if(carry > 0)
        {
            ListNode temp = new ListNode(carry);
            temp.next = result;
            result=temp;
        }
 
        return result;
    }
}
 
	
	
	 ********************************************************************************************************************************

	61. Rotate List
	


	Given the head of a linked list, rotate the list to the right by k places.
	
	Example 1:
	Input: head = [1,2,3,4,5], k = 2
	Output: [4,5,1,2,3]
	 
	Example 2:
	Input: head = [0,1,2], k = 4
	Output: [2,0,1]
	 
	Constraints:
	The number of nodes in the list is in the range [0, 500].
	-100 <= Node.val <= 100
	0 <= k <= 2 * 109


 * Notes --
 * 
 * In this question we have to rotate the list by k positions to right side
 * 
 * So first of all we will take two pointer which points to just one position behind the head i.e
 * we will take a new node dummy which points to one position before head
 * and then we assign that dummy.next equal to head
 * Then take two nodes lastpointer which points to last node of original linkedlist and newLastPointer
 * which points to new Last pointer after rotation of list by k points.
 * 
 * Formula = size - k % size  , This formula is used to find the new last node after rotation of list
 * 
 * after getting last node and new last node we will do some interchange means
 * 
 * change lastnode.next = dummy.next[head]
 * then dummy.next[head] = newlastnode.next
 * then newlastnode.next = null
 * 
 * then return dummy.next


 class Solution {
    public ListNode rotateRight(ListNode head, int k) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        
        if(head == null || head.next == null )
        {
            return head;
        }
        
        ListNode lastPointer = dummy;
        ListNode newLastPointer = dummy;
        
        int size=0;
        
        while(lastPointer.next != null)
        {
            lastPointer = lastPointer.next;
            size++;
        }
        
        for(int j = size - k % size ; j>0 ; j--)
        {
            newLastPointer = newLastPointer.next;
        }
        
        lastPointer.next = dummy.next;
        dummy.next = newLastPointer.next;
        newLastPointer.next = null;
        
        return dummy.next;
    }   
}
 
	
	
	 ********************************************************************************************************************************

	86. Partition List
	

	Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	
	You should preserve the original relative order of the nodes in each of the two partitions.
	
	Example 1:
	Input: head = [1,4,3,2,5,2], x = 3
	Output: [1,2,2,4,3,5]
	
	Example 2:
	Input: head = [2,1], x = 2
	Output: [1,2]
	 
	Constraints:
	The number of nodes in the list is in the range [0, 200].
	-100 <= Node.val <= 100
	-200 <= x <= 200 
 

  * Notes --
  * 
  * This question was simple to solve but i was thinking totally diffrent means
  * I was thinking that we take two pointer then if second pointer.val is small
  * then swap with first pointer if large then just increment pointers and bla bla bla
  * But that solution was wrong
  * 
  * Then i get this solution from discussion box 
  * In this solution we have to make two linked list first link list will contain all the nodes which
  * value is strictly smaller than given x value and second link list will contain all the values which
  * are equal to or greater than given x value this way we create two link list small and large
  * 
  * After this we will assign leftTail.next as right.next
  * and rightTail.next as null
  *  
  * At last we will return left.next

	
	class Solution {
    public ListNode partition(ListNode head, int x) 
    {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode leftTail = left;
        ListNode rightTail = right;
        
        while(head != null)
        {
            if(head.val < x)
            {
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else
            {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            
            head = head.next;
        }
        
        leftTail.next = right.next;
        rightTail.next = null;
            
            return left.next;
    }
}

	
	
	
	 ********************************************************************************************************************************

	
	203. Remove Linked List Elements


	Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
	
	Example 1:
	Input: head = [1,2,6,3,4,5,6], val = 6
	Output: [1,2,3,4,5]
	
	Example 2:
	Input: head = [], val = 1
	Output: []
	
	Example 3:
	Input: head = [7,7,7,7], val = 7
	Output: []
	 
	Constraints:
	The number of nodes in the list is in the range [0, 104].
	1 <= Node.val <= 50
	0 <= val <= 50
 
 
 
  * Notes --
  * 
  * Approach 1 : Iterative
  * 
  * This question is so easy but i was thinking in a wrong way
  * 
  * In this question we have to take a dummy node whose next points to head
  * 
  * Initialize a new node as curr which points to dummy
  * 
  * Run a while until curr.next != null
  * Inside it 
  * if curr.val is same as val then : make curr.next = curr.next.next
  * else make curr = curr.next
  * 
  * At last return dummy.next
  * 
  * 
  * Approach 2 : Recursion
  * 
  * Simple Base case is if there is no node i.e linkedlist is empty then just return head or null
  * else Recursion call
  * head.next = function(head.next , val)
  * 
  *  if(head.val == val) return head.next else return head;


	
	ITERATIVE SOLUTION
	
	class Solution {
	    public ListNode removeElements(ListNode head, int val) 
	    {
	       
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode curr = dummy;
	        
	        while(curr.next != null)
	        {
	            if(curr.next.val == val)
	            {
	                curr.next = curr.next.next;
	            }
	            else
	            {
	                curr = curr.next;
	            }
	        }
	        
	        return dummy.next;
	        
	    }
	}
	
	RECURSIVE SOLUTION
	
	class Solution 
	{
	    public ListNode removeElements(ListNode head, int val) 
	    {
	       if(head == null)
	       {
	           return head;
	       }
	        
	        head.next = removeElements(head.next , val);
	        
	        return head.val == val ? head.next : head;      
	    }
	}

	

	
	
	 ********************************************************************************************************************************

	237. Delete Node in a Linked List
	
	There is a singly-linked list head and we want to delete a node node in it.

	You are given the node to be deleted node. You will not be given access to the first node of head.
	
	All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
	
	Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
	
	The value of the given node should not exist in the linked list.
	The number of nodes in the linked list should decrease by one.
	All the values before node should be in the same order.
	All the values after node should be in the same order.
	Custom testing:
	
	For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list
	and should be an actual node in the list.
	We will build the linked list and pass the node to your function.
	The output will be the entire list after calling your function.
	 
	
	Example 1:
	Input: head = [4,5,1,9], node = 5
	Output: [4,1,9]
	Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
	
	Example 2:
	Input: head = [4,5,1,9], node = 1
	Output: [4,5,9]
	Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
	 
	
	Constraints:
	The number of the nodes in the given list is in the range [2, 1000].
	-1000 <= Node.val <= 1000
	The value of each node in the list is unique.
	The node to be deleted is in the list and is not a tail node.
	
	
	 * Notes --
	 * 
	 * This Question was so simple and i was thinking that it is a very hard problem by seeing its difficulty level
	 * Leetcode sometimes makes you fool by giving easy question as a medium level question in difficulty
	 * 
	 * So never go on difficulty level and solve question apply your own brain to solve it.
	 * 
	 * So in this question we have to delete the given node from a link list
	 * 
	 * For this simply apply if operator with condition node is not equal to null and node.next not equal to null
	 * Inside if :
	 * Change node.val = node.next.val
	 * change node = node.next.next
	 * 
	 
	 
	class Solution 
	{
	    public void deleteNode(ListNode node) 
	    {
	         if(node != null && node.next != null) 
	         {
	                node.val = node.next.val;
	                node.next = node.next.next;
	         }
	    }  
    }
    
    
    
    	 ********************************************************************************************************************************

        2095. Delete the Middle Node of a Linked List
    
        You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
	The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ 
	denotes the largest integer less than or equal to x.
	
	For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
	 	
	Example 1:	
	Input: head = [1,3,4,7,1,2,6]
	Output: [1,3,4,1,2,6]
	Explanation:
	The above figure represents the given linked list. The indices of the nodes are written below.
	Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
	We return the new list after removing this node. 
	
	Example 2:
	Input: head = [1,2,3,4]
	Output: [1,2,4]
	Explanation:
	The above figure represents the given linked list.
	For n = 4, node 2 with value 3 is the middle node, which is marked in red.
	
	Example 3:
	Input: head = [2,1]
	Output: [2]
	Explanation:
	The above figure represents the given linked list.
	For n = 2, node 1 with value 1 is the middle node, which is marked in red.
	Node 0 with value 2 is the only node remaining after removing node 1.
	 	
	Constraints:	
	The number of nodes in the list is in the range [1, 105].
	1 <= Node.val <= 105
    
     * 
     * Notes --
     * 
     * This is also another simple question like delete the given node question
     * 
     * In this question we have delete the middle node of link list and return head.
     * 
     * So first we will find the mid node
     * 
     * Then just apply logic to delete the given node problem
     * To delete the node just apply if operator
     * Inside if :
     * change mid.val = mid.next.val
     * change mod.next = mid.next.next
     * 
     *  That's It !!
     *

	class Solution {
    public ListNode deleteMiddle(ListNode head) 
    {
        ListNode midN = mid(head);
        
        if(midN.next == null)
        {
            if(head.next == null)
            {
                return null;
            }
            
            head.next = null;
            return head;
        }
        
        if(midN != null && midN.next != null)
        {
            midN.val = midN.next.val;
            midN.next = midN.next.next;
        }
        
        return head;
    }
    
    private ListNode mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }    
}
    
	
	
	    	 ********************************************************************************************************************************
	    	 
    725. Split Linked List in Parts
     
    Given the head of a singly linked list and an integer k, split the linked list
    into k consecutive linked list parts.
	The length of each part should be as equal as possible: no two parts should have
	 a size differing by more than one. 
	This may lead to some parts being null.
	
	The parts should be in the order of occurrence in the input list, and parts occurring
	earlier should always have a size greater than or equal to parts occurring later.
	
	Return an array of the k parts.
	
	Example 1:
	Input: head = [1,2,3], k = 5
	Output: [[1],[2],[3],[],[]]
	Explanation:
	The first element output[0] has output[0].val = 1, output[0].next = null.
	The last element output[4] is null, but its string representation as a ListNode is [].
	
	Example 2:
	Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
	Output: [[1,2,3,4],[5,6,7],[8,9,10]]
	Explanation:
	The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
	 	
	Constraints:	
	The number of nodes in the list is in the range [0, 1000].
	0 <= Node.val <= 1000
	1 <= k <= 50
	
	
	 * 
	 * Notes --
	 * 
	 * This question was easy by logic but implementation was hard but cracked it 
	 * from discussion section ha ha ha ..
	 * 
	 * So to solve this we need to create a array of link list which has size of k 
	 * 
	 * If link list is empty then return empty array else
	 * 
	 * Find the length of link list
	 * 
	 * Find the number of indices which will never have empty link list
	 * To find this n = length / k
	 * 
	 * Now find the first r number of indices in which link list have extra r nodes
	 * To find this r = length % k
	 * 
	 * Now apply for Loop inside it another for Loop
	 * And description about for loop is given in the code section in the comments .
	 * 
	 * That's it !!
	 * 

	class Solution 
{
    public ListNode[] splitListToParts(ListNode head, int k) 
    {
        // We want array of link list of size k means array 
        // will have k link list inside it .
        ListNode res[] = new ListNode[k];
        
        // If LinkedList is Empty then :
        if(head == null)
        {
            return res;
        }
        
        int length = 0;
        
        ListNode temp = head;
        
        // To find the length
        while(temp != null)
        {
            length++;
            temp = temp.next;
        }
        
        // To find Minimum Number of Elements in each part
        int n = length / k; 
        
        // To find r Number of LinkList from first which have extra r nodes
        int r = length % k;
        
        // pre will denote last node of each link list 
        ListNode pre = null;
        
        // curr will denote first node of each link list
        ListNode curr = head;
        
        // First for loop for number of link list in array i.e size of our link list array 
        // which we have to return at last.
        for(int i=0 ; i < k && curr != null ; i++)
        {
            res[i] = curr;
            
            // This loop is for how many nodes are there in each link list 
            for(int j=0 ; j < n + (r > 0 ? 1 : 0) ; j++)
            {
                pre = curr;
                curr = curr.next;
            }
            
            // This denote the last node of link list for index i of link list array
            pre.next = null;
            
            // This is for number of index at which link list will have extra one element
            // and we have to decrement
            r--;
        }
        
        return res;       
    }
}


	    	 ********************************************************************************************************************************

	19. Remove Nth Node From End of List
	
	Given the head of a linked list, remove the nth node from the end of the list and return its head.

	Example 1:
	Input: head = [1,2,3,4,5], n = 2
	Output: [1,2,3,5]
	
	Example 2:
	Input: head = [1], n = 1
	Output: []
	
	Example 3:
	Input: head = [1,2], n = 1
	Output: [1]
	 
	Constraints:
	The number of nodes in the list is sz.
	1 <= sz <= 30
	0 <= Node.val <= 100
	1 <= n <= sz
	 
	Follow up: Could you do this in one pass?
	
	
	class Solution 
	{
	    public ListNode removeNthFromEnd(ListNode head, int n) 
	    {
	        ListNode temp=head;
	        int size =0;
	        
	        while(temp != null)
	        {
	            size ++;
	            temp = temp.next;
	        }
	        
	        ListNode dummy = head;
	        
	        int len = size - n;
	        
	        if(size == n )
	        {
	            return head.next;
	        }
	        
	        for(int j=0 ; j< len -1 ; j++)
	        {
	            dummy = dummy.next;
	        }
	        
	        dummy.next = dummy.next.next;       
	        return head;
	    }
    }


	class Solution 
	{
	    public ListNode removeNthFromEnd(ListNode head, int n) 
	    {
	       ListNode newHead = new ListNode(0);
	       newHead.next = head;
	       ListNode p = newHead;
	       ListNode runner = newHead;
	       while(n>0){
	           runner = runner.next;
	           n--;
	       }
	       while(runner.next!=null){
	           runner = runner.next;
	           p=p.next;
	       }
	       p.next = p.next.next;
	       return newHead.next;
	    }
    }
	   


	    	 ********************************************************************************************************************************

	
	


	
	private class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data=data;
		}
		
		public Node(int data , Node next)
		{
			this.data=data;
			this.next=next;
		}
	}
	
	public static void main(String[] args) 
	{
//		1]
//		LL ll = new LL();
//		ll.insertLast(1);
//		ll.insertLast(1);
//		ll.insertLast(1);
//		ll.insertLast(2);
//		ll.insertLast(4);
//		ll.insertLast(4);
//		ll.duplicate(ll.head);
//		ll.display();
		
		
//		2]
		LL ll1 = new LL();
		ll1.insertLast(1);
		ll1.insertLast(2);
		ll1.insertLast(4);
		
		LL ll2 = new LL();
		ll2.insertLast(1);
		ll2.insertLast(3);
		ll2.insertLast(4);
		
		LL ans = mergeSorted(ll1, ll2);
		ans.display();
		
		
		
	}
//  ListNode slow=head;
//  ListNode fast=head;
 
//  while(fast != null && fast.next != null)
//  {
//      slow=slow.next;
//      fast=fast.next.next;
//  }
//  return slow;
}
