import java.util.*;
public class BuildValidParenthesis 
{
	static ArrayList<String> generateParen(int count)
	{
		char str[]=new char[count*2];
		
		ArrayList<String>lst=new ArrayList<String>();
		
		addParen(lst,count,count,str,0);
		
		return lst;
	}
	
	static void addParen(ArrayList<String>list,int leftRem, int rightRem, char str[],int index)
	{
		if(leftRem<0 || leftRem>rightRem)
			return;
		
		if(leftRem==0 && rightRem==0)
		{
			
			list.add(String.copyValueOf(str));
		}
		
		else
		{
			str[index]='(';
			addParen(list,leftRem-1,rightRem,str,index+1);
			
			str[index]=')';
			addParen(list,leftRem,rightRem-1,str,index+1);
		}
		
	}
	public static void main(String args[])
	{
		int n=3;
		
		ArrayList<String>lm=new ArrayList<String>();
		lm=generateParen(3);
		
		System.out.println(lm);
	}

}
