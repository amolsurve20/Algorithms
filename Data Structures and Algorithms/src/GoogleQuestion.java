
	public class GoogleQuestion
	{
		// second question
		public static int google(String s)
		{
			int length = 0, fileNum = 0;
			String allDir = "", lastDir = "";
			String[] eachdir = s.split("\n");

			
			int countOfSpace = 0;
			boolean getThisDir = false;

			for (int i = 0; i < eachdir.length; i++)
			{
				if (eachdir[i].contains(".jpeg") || eachdir[i].contains(".gif"))
				{
					fileNum++;
					countOfSpace = numSpace(eachdir[i]);
					getThisDir = false;
					for (int j = i-1; j >= 0; j--)
					{
						if (numSpace(eachdir[j]) != numSpace(lastDir))
						{
							getThisDir = false;
						}
						if (numSpace(eachdir[j]) >= countOfSpace)
						{
							continue;
						}
						if (countOfSpace == 0)
						{
							break;
						}

						if (eachdir[j].contains(getSpace(countOfSpace - 1)) && getThisDir == false && !eachdir[j].contains("."))
						{
							if (getSpace(countOfSpace - 1) == "")
							{
								allDir += eachdir[j] + "\\";
							}
							else
							{
								allDir += eachdir[j].replace(getSpace(countOfSpace - 1), "") + "\\";
							}
							countOfSpace -= 1;
							getThisDir = true;
							lastDir = eachdir[j];
						}
					}
				}
			}

			for(int i=0;i<allDir.length();i++)
			{
			
			char c=allDir.charAt(i);
				if (c == '\\')
				{
					continue;
				}

				length++;
			}

			return length - fileNum;
		}

		public static String getSpace(int num)
		{
			String s = "";
			if (num < 0)
			{
				return "";
			}
			for (int i = 1; i <= num; i++)
			{
				s += " ";
			}

			return s;
		}

		public static int numSpace(String s)
		{
			int count = 0;
			String space = " ";
			for (int i = 0; i < s.length(); i++)
			{
				if (s.contains(space))
				{
					count++;
				}
				space += " ";
			}

			return count;
		}


		public static void Main(String[] args)
		{
			String listDir = "dir1\n dir11\n dir12\n picture.jpeg\n dir121\n file1.txt\ndir2\n file2.gif";
			GoogleQuestion obj=new GoogleQuestion();
			
			int res=obj.google(listDir);
			
			System.out.print(res);
			
		
			
		}
	}

