package com.payments.finder.test.io;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.Test;

import com.payments.finder.Configuration;
import com.payments.finder.Finder;
import com.payments.finder.io.IOManager;

public class IOManagerTest {

	// test case for general data test (with exactly two decimal digits)
    private static String[] DATA = {"22.75", "22.74", "11.65", "6.00", "4.21", "3.10", "2.00", "100.99"};
    
    // test case for read input data (with exactly two decimal digits)
    private static Double[] DATA1 = {22.75, 22.74, 11.65, 6.0, 4.21, 3.1, 2.0, 100.99};
    
    @Test
    public void writeSolutionToFile_Test() throws IOException {
    	Finder finder = new Finder();
    	finder.setBankTransfer(Double.valueOf(DATA[0]));
		finder.getDuePayments(DATA, 1, DATA.length);
		
		if (!finder.getSolution().isEmpty()) IOManager.writeSolutionToFile(finder.getSolution(), Configuration.OUTPUT_FILE_NAME);
   
		Path path = FileSystems.getDefault().getPath(".", Configuration.OUTPUT_FILE_NAME);
		List<String> lines = Files.readAllLines(path, Charset.defaultCharset() );
		String solutionActual = lines.toString();
		String solutionExpected = "[2.00, 3.10, 6.00, 11.65]";
    	assertEquals("Unexpected value: " + solutionActual, solutionExpected, solutionActual);
    }
    
    
    @Test
    public void readInputFile_Test() {
    	createTestFile("test.txt", DATA1);
    	String[] input = IOManager.readInputFile("test.txt");
    	String solutionActual = Arrays.toString(input);
    	String solutionExpected = "[22.75, 22.74, 11.65, 6.00, 4.21, 3.10, 2.00, 100.99]";
    	assertEquals("Unexpected value: " + solutionActual, solutionExpected, solutionActual);
    }
    
    private void createTestFile(String nameFile, Double[] testSolution) {
    	PrintWriter writer = null;
		try {

			writer = new PrintWriter(new FileWriter(nameFile)); 
			    
			for(Double dbl: testSolution) {
				writer.printf(Configuration.FORMAT_OUTPUT, dbl);
			}

			writer.close();
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}    
	}
}
