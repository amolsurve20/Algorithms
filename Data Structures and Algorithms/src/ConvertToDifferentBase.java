
public class ConvertToDifferentBase 
{
	public static void main(String args[])
	{
		int number=20;
		String res=convert(number,7);
		
		System.out.println(res);
	}
	
	public static String convert(int number, int base)
	{
	    int quotient = number / base;
	    int remainder = number % base;

	    if (quotient == 0) // base case
	    {
	        return Integer.toString(remainder);      
	    }
	    else
	    {
	        return convert(quotient, base) + Integer.toString(remainder);
	    }            
	}

}
