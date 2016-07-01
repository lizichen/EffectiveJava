package javaIO;

import java.io.FileWriter;
import java.io.IOException;

public class ContineousFileWriter {
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator"); 
	
	public static void main(String[] args) throws IOException{
		
		   int [] a=new int[]{11112,222,333,444,555,666};
		   
		   FileWriter fileWriter = new FileWriter("C:/Users/chenlizi-ext/Downloads/test.txt", true);

		   for (int i = 0; i < a.length; i++) {
			   fileWriter.write("\n"+String.valueOf(a[i])+" "+ LINE_SEPARATOR);
		   }
		   
		   fileWriter.flush();
		   fileWriter.close();   
	}
}
