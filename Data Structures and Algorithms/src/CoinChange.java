import java.util.*;
public class CoinChange 
{
	static int makeChange(int n)
	{
		int denom[]={25,10,5,1};
		
		//creating a 2-D table to store the amount from 1-amount as rows and denom values as columns
		int map[][]=new int[n+1][denom.length];
		return makeChange(n,denom,0,map);
	}
	
	static int makeChange(int amount, int denom[],int index,int map[][])
	{
		//Checking if the map already cntains the value
		if(map[amount][index]>0)
			return map[amount][index];
		
		//one denom remaining
		if(index>=denom.length-1)
			return 1;
		
		//current denom amount based on the current index value
		
		int denomAmount=denom[index];
		int ways=0;
		
		//iterating over the entire amount till we find the sum=total amount
		for(int i=0;i*denomAmount<=amount;i++)
		{
			int remainingAmount=amount-i*denomAmount;
			ways=ways+makeChange(remainingAmount, denom,index+1,map);
		}
		
		//adding the newly found number of ways into map
		map[amount][index]=ways;
		
		return ways;
		
	}
	
	public static void main(String args[])
	{
		int n=10;
		System.out.println(makeChange(n)+" ways");
	}

}
