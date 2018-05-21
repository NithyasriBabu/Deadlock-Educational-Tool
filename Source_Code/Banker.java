package bankersproject;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Banker {
	public int[][] Max,Need,Alloc;
	public int[] Avail,safeSequence, unSafeSequence;
	public int p, r, n;
	public Boolean Safe = false;
	public File inputFile;
	public String E = "<html> <br>"; 
	public String R = "<html> <br>";
	
	public String getInput(File file) {
		try {
			
			Scanner scanner = new Scanner(file);
			
			p = scanner.nextInt();
			r = scanner.nextInt();
			
			Max = new int[p][r];
			Alloc = new int[p][r];
			Need = new int[p][r];
			Avail = new int[r];
			
			for(int i = 0; i < r; i++)
				Avail[i] = scanner.nextInt();
			
			for(int i = 0; i < p; i++)
			{
				for(int j = 0; j < r; j++)
					Max[i][j] = scanner.nextInt();
			}
			
			for(int i = 0; i < p; i++)
			{
				for(int j = 0; j < r; j++)
				{
					Alloc[i][j] = scanner.nextInt();
					if(Alloc[i][j] > Max[i][j])
					{
						scanner.close();
						return "<html> Allocated resource " + j + " For process " + i + " is greater than Max <br> Correct and Recall Function</html>";
					}
				}
			}
			
			scanner.close();
			
			for(int i = 0; i < p; i++)
			{
				for(int j = 0; j < r; j++)
					Need[i][j] = Max[i][j] - Alloc[i][j];  
			}
			return "Success";
		}
		catch(FileNotFoundException e){
			return "<html>File Not Found<br>Select Proper File</html>";
		}
		catch(InputMismatchException e) {
			return "<html>Input Format Incorrect<br>Find Input Format in About<br>Select Proper File</html>";
		}
		catch(Throwable e) {
			return "<html>Improper Format<br>Find Input Format in About<br>Select Proper File</html>";
		}
	}
	
	public String print(int[][] D) {
		String Output ="";
		for(int i = 0; i < p; i++)
		{
			Output += "P" + i + " :";
			for(int j = 0; j < r; j++)
			{
				Output += Integer.toString(D[i][j]) + " ";
			}
			Output += "<br>";
		}
		
		return Output;
	}
	
	public String printAvail(int[] Av) {
		String AvailableString = ""; 
		
		for(int i = 0; i< r; i++)
			AvailableString += Integer.toString(Av[i]) + " ";  
		
		return AvailableString;
	}	
	
	public String Safety()
	{
		String SafetyOutput = "<html> <br>";
		int count = 0, current = 0, nc = 0, nc1 = 0, count1 = 0, IterationVal = 1;
		int[] lAvail, completed;
		int[][] lAlloc;
		
		Boolean Available = true;
				
		completed = new int[p];
		safeSequence = new int[p];
		unSafeSequence = new int[p];
		lAvail = new int[r];
		lAlloc = new int[p][r];
		
		for(int i=0;i<r;i++)
			lAvail[i] = Avail[i];
		
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
				lAlloc[i][j] = Alloc[i][j];
		
		for(int i = 0; i < p; i++)
			completed[i]=0;
		
		E += "Initail Values of completed = 0 for all Processes <br>";
		
		do
		{
			E += "Iteration " + IterationVal + ": <br> ";
			IterationVal += 1;
			E += "Available = <br>" + this.printAvail(lAvail) + "<br>"; 
			E += "Max = <br>" + this.print(Max) + "<br>";
			E += "Alloc = <br>" + this.print(lAlloc) + "<br>";
			if(nc == p)
			{
				E += "All Processes Deadlocked<br>";
				break;
			}
			
			if(count+nc == p)
			{
				count1=0;
				for(int i=0;i<p;i++)
				{
					for(int j=0;j<r;j++)
					{
						if(completed[i] == 0 && lAvail[j] < Need[i][j])
						{
							nc1 = nc1 +1;
							unSafeSequence[count1++] = i;
						}
					}
				}
				if(nc == nc1)
				{
					E += "All remaining processes Deadlocked<br>";
					break;
				}
			}
			
			Available = true;
			if(completed[current] == 0)
			{
				for(int j=0;j<r;j++)
				{
					if(lAvail[j] < Need[current][j])
					{
						SafetyOutput += "Resource not available for P"+current+" now <br>";
						E += "Resource not available for P"+current+" now <br>";
						Available = false;
						nc = nc + 1; 
						break;
					}
				}
				
				if(Available)
				{
					SafetyOutput += "P"+current+" runs to completion!<br>";
					E += "P"+current+" runs to completion!<br>";
					completed[current] = 1;
					safeSequence[count++] = current;
					E += this.printAvail(lAvail) + " + <br>";
					for(int j = 0; j < r; j++)
					{
						lAvail[j] += lAlloc[current][j];
						lAlloc[current][j] = 0;
					}
					E += this.printAvail(Alloc[current]) + " = <br>";
					E += this.printAvail(lAvail) + "<br>";
				}
			}
			current = (current+1)%p;
		}while(count != p);
		
		if(nc == p)
		{
			count1 = nc;
			for(int k = 0; k < p; k++)
				unSafeSequence[k] = k;
		}
		
		if(count == p)
		{
			SafetyOutput += "<br>The system is in a safe state!!<br>";
			SafetyOutput += "Safe Sequence :  ";
			E += "<br>The system is in a safe state!!<br> Safe Sequence :  ";
			for(int i = 0; i < p; i++)
			{
				SafetyOutput +="P" + safeSequence[i] +" ";
				E += "P" + safeSequence[i] +" ";
			}
			SafetyOutput += " <br>";
			E += " <br>";
			Safe = true;
		}
		else
		{
			SafetyOutput += "<br>The system is in an unsafe state!!<br>";
			SafetyOutput += "Completed Processes: ";
			E += "<br>The system is in an unsafe state!!<br> Completed Processes: ";
			for(int i = 0; i < count; i++)
			{
				SafetyOutput += "P"+safeSequence[i]+" ";
				E += "P"+safeSequence[i]+" ";
			}
			SafetyOutput += "<br>Deadlocked Processes: ";
			E += "<br>Deadlocked Processes: ";
			for(int i = 0; i < count1; i++)
			{
				SafetyOutput += "P"+unSafeSequence[i]+" ";
				E += "P"+unSafeSequence[i]+" ";
			}
			SafetyOutput += "<br><br>";
			E += "<br><br>";
			Safe = false;
		}
		
		SafetyOutput += "</html>";
		E += "</html>";
		return SafetyOutput;
	}
	
	public void Request(int newR,int[] Request)
	{	
		int[] lAvail = new int[r];
		int[][] lAlloc = new int[p][r];
		int[][] lNeed = new int[p][r];
		
		for(int i=0;i<r;i++)
			lAvail[i] = Avail[i];
		
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
				lAlloc[i][j] = Alloc[i][j];
		
		for(int i=0;i<p;i++)
			for(int j=0;j<r;j++)
				lNeed[i][j] = Alloc[i][j];
	
		Boolean Req=true;
		
		R += "Values Before Request : <br> ";
		R += "Available :" + this.printAvail(lAvail) + "<br>";
		R += "Max of P"+newR+" : " + this.printAvail(Max[newR]) + "<br>";;
		R += "Alloc of P"+newR+" : " + this.printAvail(lAlloc[newR]) + "<br>";
		R += "Need of P"+newR+" : " + this.printAvail(lNeed[newR]) + "<br>";
		R += "Requested Resource for P"+newR+" : " + this.printAvail(Request) + "<br>";
	
		for(int j = 0; j < r; j++)
		{
			if((Request[j] > Need[newR][j]) || (Request[j] > lAvail[j]))
			{
				Req = false;
				R += "Does not Satisfy allocation condition. <br>"; 
				R += "<br> P"+newR+" cannot be allocated requested resource<br>";
				break;
			}
		}
		
		if(Req)
		{
			for(int j = 0;j < r; j++)
			{
				lAvail[j] -= Request[j];
				lAlloc[newR][j] += Request[j];
				lNeed[newR][j] -= Request[j];
			}
			R += "<br>P"+newR+" was allocated requested resource <br>";
		}
	}
}