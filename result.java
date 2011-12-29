import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class result {
	public static void main(String args[]) throws FileNotFoundException{
		Scanner input = new Scanner(new File("result.csv"));
		PrintStream output = new PrintStream(new File("output.txt"));
		int SNP = 0;
		int Sample = 0;
		while(input.hasNextLine()){
			String line = input.nextLine();
			//Scanner lineScanner = new Scanner(line);
			
			//String line = lineScanner.next();
			line = line.replace(",", " ");
			
			Scanner lineScanner = new Scanner(line);
			output.print(lineScanner.next());
			output.print(","+lineScanner.next());
			
			output.print(","+SNP);
			output.print(","+Sample+"\n");
		
			SNP++;
			if(SNP > 61337){
				SNP = 0;
				Sample++;
			}
			
		}
		System.out.println("finish");
		
	}
}
