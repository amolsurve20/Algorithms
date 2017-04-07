//class Stack
{
	char stackarr[];
	int top;
	int maxsize;
	
	public Stack(int s)
	{
		maxsize=s;
		top=-1;
		stackarr=new char[maxsize];	
	}
	
	public void push(char value)
	{
		stackarr[++top]=value;
	}
	
	public char pop()
	{
		return stackarr[top--];
	}
	
	public boolean isFull()
	{
		return(top==maxsize-1);	
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public int peek()
	{
		return stackarr[top];
	}
	
	public int peekN(int n)
	{
		return stackarr[n];
	}
	
	public void display()
	{
		for(int i=0;i<stackarr.length;i++)
		{
			System.out.println(peekN(i));
		}
	}
}

class StackInt
{
	int stackarr[];
	int top;
	int maxsize;
	
	public StackInt(int s)
	{
		maxsize=s;
		top=-1;
		stackarr=new int[maxsize];	
	}
	
	public void push(int value)
	{
		stackarr[++top]=value;
	}
	
	public int pop()
	{
		return stackarr[top--];
	}
	
	public boolean isFull()
	{
		return(top==maxsize-1);
		
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public int peek()
	{
		return stackarr[top];
	}
	
	public int peekN(int n)
	{
		return stackarr[n];
	}
	
	public void display()
	{
		for(int i=0;i<stackarr.length;i++)
		{
			System.out.println(peekN(i));
		}
	}
}


public class StackApp 
{
	
	
	public static String doReverse(String input)
	{
		Stack st=new Stack(input.length());
		String rev="";
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			st.push(ch);	
		}
		
		while(!st.isEmpty())
		{
			rev=rev+st.pop();
		}
		
		return rev;
			
	}
	
	public static void bracketCheck(String input)
	{
		Stack br=new Stack(input.length());
		
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			
			switch(ch)
			{
			case '{':
			case '(':
			case '[':
				br.push(ch);
				break;
				
			case '}':
			case ']':
			case ')':
				if(!br.isEmpty())
			{
				char chx=br.pop();
				if((ch=='}'&&chx!='{')||((ch==')'&&chx!='('))||(ch==']'&&chx!='['))
				{
					System.out.println("Error char "+ch+" at "+i);
				}
			}
				else
				{
					System.out.println("Error char "+ch+" at "+i);
				}
				break;
				
				
				default:
					break;
		
			}
		
		}
		
		if(!br.isEmpty())
			System.out.println("Missing right delimiter");
	}
	
	
	
	public static void main(String args[])
	{
		Stack obj=new Stack(4);
		obj.push('a');
		obj.push('b');
		obj.push('c');
		
		obj.display();
		String input="AMOL";
		String res=doReverse(input);
		System.out.println(res);
		
		String bracket="()){}";
		
		bracketCheck(bracket); 
		
		String infix="1+2";
		
		InfixToPost object=new InfixToPost(infix);
	
		String result=object.infixToPost();
		
		System.out.println(result);
		
		String inp="1253*+";
		
		Posteval obj1=new Posteval(inp);
		
		int resu=obj1.postEval();
		
		System.out.println("Result is "+resu);
		
	}
}

class InfixToPost
{
	
String input;
String output="";
Stack infix;

	public InfixToPost(String in)
		{
			input=in;
			infix=new Stack(input.length());
		}
	
	public String infixToPost()
	{
		String output="";
		
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			
			if(ch=='+'||ch=='-')
			{
				gotOperator(ch,1);
			}
			else
				if(ch=='*'||ch=='/')
				{
					gotOperator(ch,2);
				}
				else
					if(ch=='(')
					{
						infix.push(ch);
					}
					else
						if(ch==')')
						{
							gotParen(ch);
						}
						else
						{
							output=output+ch;
						}
		
		}
		
		while(!infix.isEmpty())
		{
			output=output+infix.pop();
		}
		
		return output;
	}
	
	public  void gotOperator(char ch,int prec1)
	{
		
	
		while(!infix.isEmpty())
		{
			char optop=infix.pop();
			
			if(optop=='(')
			{
				infix.push(optop);
				break;
			}
			else
			{
				int prec2;
			
				if(optop=='+'||optop=='-')
					prec2=1;
				else
					prec2=2;
				
					
			if(prec2<prec1)
			{
				infix.push(optop);
				break;
			}
			else
			{
				output=output+optop;
			}
			
			}
			
		}
	
		infix.push(ch);
	}
	
	public void gotParen(char ch)
	{
		while(!infix.isEmpty())
		{
			char chx=infix.pop();
			if(chx=='(')
			{		
				break;
			}
			else
			{
				output=output+chx;	
			}
		
		}

	}
}


class Posteval
{
	String post;
	StackInt obj5;
	
	public Posteval(String s)
			{
				post=s;
				
			}

		
	public int postEval()
	{
		obj5=new StackInt(post.length());
		int ans;
		int num1,num2;
		for(int i=0;i<post.length();i++)
		{
			char ch=post.charAt(i);
			System.out.println("Character is "+ch);
			
			if(ch>='0'&&ch<='9')
			{
				obj5.push((int)(ch-'0'));
			}
			else
			{
				num2=obj5.pop();
				num1=obj5.pop();
		
				switch(ch)
				{
				case '+':
					ans=num1+num2;
					break;
				case '-':
					ans=num1-num2;
					break;
				case '*':
					ans=num1*num2;
					break;
				case '/':
					ans=num1/num2;
					break;
				default:
					ans=0;
				}
				
				obj5.push(ans);
				
			}
			
		}
		
		ans=obj5.pop();
		
		return ans;
	}
	
}


