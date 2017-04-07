
public class Palindrome
{
	public static void main(String args[])
	{
		int num=1234;
		String atr="aaba";
		
		
		
		if(isPal(atr)==true)
			System.out.println("String is a palindrome");
		else
			System.out.println("String is not a palindrome");
	}
	
	public static boolean isPal(String str)
	{
		int n=str.length();
		for(int i=0;i<n/2;i++)
		{
			if(str.charAt(i)!=str.charAt(n-i-1))
				return false;
		}
		return true;
	}

}
