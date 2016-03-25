
import java.util.*;
import java.io.*;
public class ReduceSpaces{
    public static void main(String[] args) throws FileNotFoundException{
       Scanner sc = new Scanner(System.in);
//Prompt for the maximum formatted output width. The range is 30 to 100 characters.
       System.out.println("Enter maximum formatted output width (between 30 -100) :");
       int width = sc.nextInt();
       while( width<30 || width >100){
    	   System.out.println("Invalid number, please enter a number between 30 - 100");
    	   width = sc.nextInt();
       }
// Prompt for the file name of the input text file. Use a File object to test that the file exists, and can be read. If so, open the file for
// reading using the Scanner class. Use a do-while loop to repeat these steps until a valid input file is entered.
       System.out.println("Enter input file name :");
       String file_name = sc.next();
       File f = null;
       f = new File(file_name);
       while(!f.exists()){
       System.out.println("Cannot open file. Re-Enter input file name :");
       file_name = sc.next();
       f = new File(file_name);
       }
       Scanner fileReader = new Scanner(f);
// Prompt for the file name of the output file to write the formatted words to. Use a File object to test that the file doesn't already exist,
// and if it does, prompt to check for overwriting the file. Open the file for writing using a PrintWriter. Use a do-while loop to repeat
// these steps until a valid output file is entered.
       System.out.println("Enter output file name :");
       String out_file_name = sc.next();
       File out_f = null;
       System.out.println(out_file_name);
       out_f = new File(out_file_name); 
       while(!out_f.exists() && !out_f.isDirectory()){
       System.out.println("Cannot open file. Re-Enter output file name :");
       out_file_name = sc.next();
       out_f = new File(out_file_name);
       }
       System.out.println("File already exists: " + out_f);   
       System.out.println("Do you want to overwrite this file (Y/N)");   
       String yesno = sc.nextLine();   
       while (yesno.toLowerCase().startsWith("n")) {   
               System.out.println("Re-enter output file name");   
               out_file_name = sc.next();
               out_f = new File(out_file_name);
               while(!out_f.exists() && !out_f.isDirectory()){
                   System.out.println("Cannot open file. Re-Enter output file name :");
                   out_file_name = sc.next();
                   out_f = new File(out_file_name);
                   }
               System.out.println("File already exists: " + out_f);   
               System.out.println("Do you want to overwrite this file (Y/N)");   
                   yesno = sc.nextLine();   
               }
       PrintWriter printwriter = new PrintWriter(out_f);
		 // Write a line of * characters the width of the formatted output
       	 // as a heading in the output file (easier to see in output file)
       	  for(int i=0; i<width; i++)
    	  printwriter.printf("*");
		  printwriter.printf("\n");
		  int length = 0;
		  StringBuffer line_of_text = new StringBuffer();
		  while(fileReader.hasNext()){
		  String str = fileReader.next();
		 // Loop, reading words (text between whitespace) from the input file using Scanner.next(), appending them to a line of text being formatted,
		 // with one space character between words.
		  length += str.length()+1;
		 //Keep appending words until the current word would cause the line to become longer than the output column with.
		  if(length <= width+1){
		  line_of_text.append(str+ " ");
		  }
		  else{
		  printwriter.println(line_of_text);
		  line_of_text.setLength(0);
		  line_of_text.append(str+ " ");
		  length = str.length()+1;;
		  }
		 // If so, write the line to the output file, reset it to contain just the new word, and continue reading.
		 // Continue reading until the end-of-file is encountered, using Scanner.hasNext().
		  }
		 printwriter.println(line_of_text); // print any buffered data to output file.
		  sc.close();
		  fileReader.close();
		  printwriter.close();
		  }
    }

