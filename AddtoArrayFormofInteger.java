package Easy;

public class AddtoArrayFormofInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {1,2,3,4};
		String str="";
        for(int i=0;i<num.length;i++)
        {
            str=str + num[i];
        }
        int n=Integer.parseInt(str);
        
        System.out.println(n+233);
        System.out.println(1234+233);
	}

}
