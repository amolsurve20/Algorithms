import java.util.*;
public class SwapInPlace 
{
	public static void main(String args[])
	{
		int a=2;
		int b=3;
		
		swapInPlace(a,b);
		
		
		long x=2030405;
		
		long y=67473737;
		
		swapInPlaceBinary(x,y);
	}
	
	static void swapInPlace(int a,int b)
	{
		a=a-b;
		b=a+b;
		a=b-a;
		
		System.out.println("a is "+a);
		System.out.println("b is "+b);
				
	}
	
	static void swapInPlaceBinary(long a,long b)
	{
		
		
		System.out.println("Before swap");
		System.out.println("x is "+a);
		System.out.println("y is "+b);

		a=a^b;
		b=a^b;
		a=a^b;
		
		System.out.println("After swap");
		System.out.println("x is "+a);
		System.out.println("y is "+ ""+b);
				
		
	}

}
