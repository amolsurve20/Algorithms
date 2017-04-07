import java.util.*;
public class BitManipulation 
{
	static String insertIntoBigger(int bigger, int smaller, int from, int to)
	{
		int allOnes=~0;
		
		int left=allOnes<<(to+1);
		
		int rightTemp=1;
		
		int right=((rightTemp<<from)-1);
		
		int mask=right | left;
		
		int n=bigger & mask;
		
		int maskNew=mask<<from;
		
		int res= n | maskNew;
		String out=String.valueOf(res);
		
		return out;
		
	}
	
	static String fractionToBinary(double num)
	
	{
		if(num>=1||num<=0)
			return "ERROR";
		
		StringBuilder sb=new StringBuilder();
		
		sb.append(".");
		
		while(num>0)
		{
			/*if(sb.length()>=32)
			{
				return "ERROR";
			}
			*/
			double r=num*2;
			
			if(r>=1)
			{
				sb.append(1);
				num=r-1;
			}
			else
				if(r<1)
				{
					sb.append(0);
					num=r;
				}		
		
		}
		
		return sb.toString();
	}
	
	static int flipBit(int a)
	{
		//if the given string contains all 1s, then it is the maximum length string
		if(~a==0)
			return Integer.BYTES*8;
		
		int current=0;
		int previous=0;
		int maxLen=1;
		
		while(a>0)
		{
			if((a&1)==1)
			{
				current++;
			}
			else
				if((a&1)==0)
				{
					if((a&2)==0)
					{
						previous=0;
					}
					else
					{
						previous=current;
					}
					
					current=0;
				}
			
			maxLen=Math.max(previous+current+1, maxLen);//Update max
			
			a>>>=1; //right shit by 1 ***VEry important else endless loop
		}
		
		return maxLen;
		
	}
	
	int getNext(int n)
	{
		//computing c0 and c1
		//c0 = number of trailing zeros, so run that while loop first
		//c1 = number of 1's t the right of the division point
		//i.e. number of ones till we encounter our first rightmost non-trailing zero
		
		int c0=0;
		int c1=0;
		
		int c=n;
		
		while(((c&1)==0)&&(c!=0))
		{
			c0++;
			c >>= 1;
		}
		
		while((c&1)==1)
		{
			c1++;
			c >>= 1;
		}
		
		
		if(c0+c1==31 || c1+c1 == 0)
		{
			return -1;
		}
		
		int p=c0+c1;
		
		int a= 1<< p;
		
		n = n|a;
		
		int t=1<<p;
		
		int s=t-1;
		
		int mask=~s;
		
		n=n&mask;
		
		int add=(1<< (c1-1))-1;
		
		n |= add;
		
		return n;
		
	}
	
	static int bitSwapRequired(int a, int b)
	{
		int count=0;
		
		int c=a^b;
		while(c!=0)
		{
			c=c&(c-1);
			count++;
		}
		
		return count;
	}
	
	public static void main(String args[])
	{
		double number=0.74;
		
		int bigger = Integer.parseInt("10000", 2);
		int smaller=Integer.parseInt("101", 2);
		
		String finalRes=insertIntoBigger(bigger,smaller,2,4);
		
		System.out.println(finalRes);
		
		String res=fractionToBinary(number);
		System.out.println(res);
		
		int a=1775;
		
		int result=flipBit(a);
		
		System.out.print("Maximum length of consecutuve 1's sequence is = ");
		System.out.println(result);
		
		int c=bitSwapRequired(29,15);
		
		System.out.println(c);
		
	}
	
	

}
