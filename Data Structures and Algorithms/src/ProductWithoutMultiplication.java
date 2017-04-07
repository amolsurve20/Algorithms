import java.util.*;
public class ProductWithoutMultiplication 
{
	static int product(int a,int b)
	{
		int bigger,smaller;
		if(a>=b)
		{
			bigger=a;
			smaller=b;
		}
		else
		{
			bigger=b;
			smaller=a;
		}
		
		return productHelper(smaller,bigger);
			
	}
	
	static int productHelper(int smaller, int bigger)
	{
		if(smaller==0)
			return 0;
		else
			if(smaller==1)
				return bigger;
		
		int s=smaller>>1;
		
		int halfProduct=productHelper(s,bigger);
		
		if(smaller%2==0)
			return halfProduct+halfProduct;
		else
			return halfProduct+halfProduct+bigger;
		
	}
	
	public static void main(String args[])
	{
		System.out.println(product(10,5));
	}

}
