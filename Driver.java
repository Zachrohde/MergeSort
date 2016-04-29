import java.util.Random;


public class Driver 
{
	public static void main(String[] args) 
	{		
		Random r = new Random();
		int[] ar = new int[10];
		for(int i = 0; i < ar.length; i++)
		{
			ar[i] = r.nextInt(50);
		}
		Driver.display(ar);
		Driver.arrangeDivisions(ar);
		Driver.display(ar);
	}
	
	static void display(int[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}
	
	static void arrangeDivisions(int[] ar)
	{
		Driver.mergeSortAssist(ar, 0, ar.length-1);
	}
	
	static void mergeSortAssist(int[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int leftBegin = begin;
			int leftEnd = ((end-begin)/2 + begin);
			int rightBegin = ((end-begin)/2 + begin) + 1;
			int rightEnd = end;
			Driver.mergeSortAssist(ar, leftBegin, leftEnd);
			Driver.mergeSortAssist(ar, rightBegin, rightEnd);
			
			int[] temp = new int[rightEnd - leftBegin + 1];
			int currLeft = leftBegin;
			int currRight = rightBegin;
			
			for(int tempPos = 0; tempPos < temp.length; tempPos++)
			{
				if(currLeft > leftEnd)
				{
					temp[tempPos] = ar[currRight];
					currRight++;
				}
				else if(currRight > rightEnd)
				{
					temp[tempPos] = ar[currLeft];
					currLeft++;
				}
				else
				{
					if(ar[currLeft] < ar[currRight])
					{
						temp[tempPos] = ar[currLeft];
						currLeft++;
					}
					else
					{
						temp[tempPos] = ar[currRight];
						currRight++;
					}
				}
			}
			int tempPos = 0;
			for(int i = leftBegin; i <= rightEnd; i++)
			{
				ar[i] = temp[tempPos];
				tempPos++;
			}
		}
	}
	
	static void display(int[] ar, int begin, int end)
	{
		for(int i = begin; i <= end; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
	}
}