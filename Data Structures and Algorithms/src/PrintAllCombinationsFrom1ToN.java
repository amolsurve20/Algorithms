
public class PrintAllCombinationsFrom1ToN
{
	public static void main(String args[])
	{
		print(4,"");
	}
	public static void print(int n,String op)
	{
		int num=Math.abs(n);
		if(num == 0)
		{
		System.out.println(op);
		}
		
		for (int i = 1; i <= num; i++) 
		{
		print(num - i,op+i );
		}


	}
}
