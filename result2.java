import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintStream;
	import java.util.Random;
	import java.util.Scanner;


	public class result2 {
		public static void main(String args[]) throws FileNotFoundException{
			Scanner input = new Scanner(new File("results.csv"));
			PrintStream output = new PrintStream(new File("output_8.txt"));
			int SNP = 0;
			int Sample = 0;
			while(input.hasNextLine()){
				String line = input.nextLine();
				line = line.replace(",", " ");
				Scanner lineScanner = new Scanner(line);
				output.print(lineScanner.next());
				output.print(","+lineScanner.next());
				output.print(","+SNP);
				output.println(","+Sample);
				SNP++;
				if(SNP > 61337){
					SNP = 0;
					Sample++;
				}
			}
			System.out.println("finish loading original file");
			append(output,8);
			System.out.println("double finished");
		}
		
		public static void append(PrintStream output, int size){
			for(int i = 279; i <= 557 + 279*(size-2); i++){
				for(int j = 0; j <= 61337; j++){
					Random randomGenerator = new Random();
					int genotype = randomGenerator.nextInt(4);
					if(genotype == 3){
						output.print("NA");
					}else{
						output.print(genotype);
					}
					int gender = randomGenerator.nextInt(2);
					if(gender == 0){
						output.print(",M");
					}else{
						output.print(",F");
					}
					output.print(","+j);
					if(i == 557+ 279*(size-2) && j == 61337){
						output.print(","+i);
					}else{
						output.println(","+i);
						
					}
				}
			}
		}
	}


