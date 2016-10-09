package com.payments.finder.io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.payments.finder.Configuration;
import com.payments.finder.errors.BankTransferMalformed;
import com.payments.finder.errors.DuePaymentsMalformed;

/*
 * Manager for the I/O operations
 */
public class IOManager {

	/*
	 * Writing of the solution found on the File
	 */
	public static void writeSolutionToFile(List<Double> solution, String fileName) {
		PrintWriter writer = null;
		try {

			writer = new PrintWriter(new FileWriter(fileName)); 
			    
			for(Double dbl: solution) {
				writer.printf(Configuration.FORMAT_OUTPUT, dbl);
			}

			writer.close();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}        

	}

	/*
	 * Initialization of the output file to Default Value -> No Solution Found
	 */
	public static void initOutputFile(String nameFile, String initValue) {
		FileWriter writer = null;
		try {

			writer = new FileWriter(nameFile); 

			writer.write(initValue);

			writer.close();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}        

	}

	/*
	 * Read the input file
	 */
	public static String[] readInputFile(String name) {
		try {
			BufferedReader reader = Files.newBufferedReader(FileSystems.getDefault().getPath(".", name), 
															Charset.defaultCharset() );
			List<String> lines = new ArrayList<>();
			String line = null;
			
			//Validation of the first line of the input (Bank Transfer)
			if ((line = reader.readLine()) != null)
				if (!line.trim().isEmpty() && isNumeric(line.trim())) lines.add(line.trim());
				else throw new BankTransferMalformed();
			
			//Validation of the data in input (Due Payments)
			while ( (line = reader.readLine()) != null ) {
				if (line.trim().isEmpty()) continue; //jump the blank line
				else if (isNumeric(line.trim())) lines.add(line.trim());
				else throw new DuePaymentsMalformed();
			}

			return lines.toArray(new String[lines.size()]);
		} 
		catch (IOException ioe) {
			System.out.println("I/O error occurred: "+ioe);
		}
		catch (BankTransferMalformed ioe) {
			System.out.println("Bank Transfer Malformed");
		}
		catch (DuePaymentsMalformed ioe) {
			System.out.println("Due Payments Malformed");
		}
		return null;
	}
	
	private static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
