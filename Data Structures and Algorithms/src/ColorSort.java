
public class ColorSort 
{
	public static void main(String args[])
	{
		int arr[]={0,1,1,6,6,2,2,2,3,4,4,5,5,5,5};
		colorSort(arr);
	}
	
	
	private static void colorSort(int arr[])
	{
		int zero=0;
		int one=0;
		int two=0;
		int three=0;
		int four=0;
		int five=0;
		int six=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
			{
				arr[six]=6;
				arr[five]=5;
				arr[four]=4;
				arr[three]=3;
				arr[two]=2;
				arr[one]=1;
				arr[zero]=0;
				zero++;
				one++;
				two++;
				three++;
				four++;
				five++;
				six++;
			}
			else
				if(arr[i]==1)
				{
					arr[six]=6;
					arr[five]=5;
					arr[four]=4;
					arr[three]=3;
					arr[two]=2;
					arr[one]=1;
					one++;
					two++;
					three++;
					four++;
					five++;
					six++;
					
				}
				else
					
					if(arr[i]==2)
				{
					arr[six]=6;
					arr[five]=5;
					arr[four]=4;
					arr[three]=3;
					arr[two]=2;
					
				
					two++;
					three++;
					four++;
					five++;
					six++;
					
				}
					else
						if(arr[i]==3)
						{
							arr[six]=6;
							arr[five]=5;
							arr[four]=4;
							arr[three]=3;
						
							three++;
							four++;
							five++;
							six++;
							
						}
						else
							if(arr[i]==4)
							{
								arr[six]=6;
								arr[five]=5;
								arr[four]=4;
								
								four++;
								five++;
								six++;
								
							}
							else
								if(arr[i]==5)
								{
									arr[six]=6;
									arr[five]=5;
									
									five++;
									six++;
									
								}
								else
									if(arr[i]==6)
									{
										arr[six]=6;
										
										

										six++;
										
									}
									
						
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"  ");
	}

}
