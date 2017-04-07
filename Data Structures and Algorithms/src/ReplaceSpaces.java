public class ReplaceSpaces 
{
	public static void main(String args[])
	{
		String str="Mr John Smith  ";
		int truelength=13;
		
		replaceSpaces(str.toCharArray(),truelength);
		
		System.out.println(str);
	}
	
	public static void replaceSpaces(char str[],int truelength)
	{
		int count=0,i=0;
		
		for( i=0;i<truelength;i++)
		{
			if(str[i]==' ')
			{
				count++;
			}
		}
			
		int index=truelength+3*count;
		
		if(truelength<str.length)
			str[truelength]='\0';
		
		for( i=truelength-1;i>=0;i--)
		{
			if(str[i]==' ')
			{
				str[index-1]='0';
				str[index-2]='2';
				str[index-3]='%';
				index=index-3;
			}
			else
			{
				str[index-1]=str[i];
				index--;
			}
			
		}
		
	}

}
