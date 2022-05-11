package Strings.Easy;



//					1108  :  Defanging an IP Address
//		
//		Given a valid (IPv4) IP address, return a defanged version of that IP address.
//		
//		A defanged IP address replaces every period "." with "[.]".
//		
//		 
//		
//		Example 1:
//		
//		Input: address = "1.1.1.1"
//		Output: "1[.]1[.]1[.]1"
//		Example 2:
//		
//		Input: address = "255.100.50.0"
//		Output: "255[.]100[.]50[.]0"
//		 
//		
//		Constraints:
//		
//		The given address is a valid IPv4 address.



public class Easy_DefanginganIPAddress_1108 
{
	public static void main(String[] args) 
	{
		
	}
	
	 public static String defangIPaddr(String address) 
	    {
	        // String str="";
	        // for(int i=0;i<address.length();i++)
	        // {
	        //     char ch=address.charAt(i);
	        //     if(ch == '.')
	        //     {
	        //         str=str+"[.]";
	        //     }
	        //     else
	        //     {
	        //         str=str+ch;
	        //     }
	        // }
	        // return str;
	        
	        final StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < address.length(); i++) {
	            if (address.charAt(i) == '.')
	                sb.append("[.]");
	            else
	                sb.append(address.charAt(i));
	        }
	        
	        return sb.toString();
	    }
}
