// Author: Gaurav Bishnoi

package tryArray;

import java.util.Scanner;
import java.util.Random;

public class RandomCypher {

	public static void main(String[] args) {
		
		System.out.println("Enter a String to cypher:");
		Scanner s1 = new Scanner(System.in);
		String str1 = s1.nextLine();
		
		Random rand = new Random();
		int shift1 = rand.nextInt(25);
		System.out.println("Shift: "+ shift1);

		
		cypher cyp = new cypher(str1, shift1);
		cyp.act();
		System.out.println(cyp.trial);
		
		cyp.unAct();
		System.out.println(cyp.trial);
		
		s1.close();
		

	}

}

class cypher 
{
	public String trial;
	public int shift;
	
	public cypher(String trial, int shift)
	{
		this.trial = trial;
		this.shift = shift;
	}
	
	public cypher(String trial)
	{
		this.trial = trial;
		this.shift = 3;		// default
	}
	
	public void act()
	{
		char[] A = trial.toCharArray();
		char[] checkArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		for (int i=0; i<A.length; i++)
		{
			if (A[i] == ' ')
				continue;
			
			int j = 0;
			while (j<checkArray.length && A[i] != checkArray[j] && A[i] != Character.toLowerCase(checkArray[j]))
				j++;
			if (j < checkArray.length)
			{
				if (j >= checkArray.length - shift)
				{
					A[i] = checkArray[j-(checkArray.length-shift)];
				}
				else
				{
					A[i] = checkArray[j+shift];
				}
			}
		}
		
		trial = new String(A);
		//System.out.println(trial);
	}
	
	public void unAct()
	{
		char[] A = trial.toCharArray();
		char[] checkArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		for (int i=0; i<A.length; i++)
		{
			if (A[i] == ' ')
				continue;
			
			int j = 0;
			while (j<checkArray.length && A[i] != checkArray[j] && A[i] != Character.toLowerCase(checkArray[j]))
				j++;
			if (j < checkArray.length)
			{
				if (j < shift)
				{
					A[i] = checkArray[j+(checkArray.length-shift)];
				}
				else
				{
					A[i] = checkArray[j-shift];
				}
			}
		}
		
		trial = new String(A);
	}
}