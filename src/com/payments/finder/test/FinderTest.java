package com.payments.finder.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.payments.finder.Configuration;
import com.payments.finder.Finder;

public class FinderTest {
	
	// test case for NO solution
	private static String[] DATA3 = {"22.71", "22.74", "11.65", "6.00", "4.21", "3.10", "2.00", "100.99",
										 "22.75", "22.74", "11.65", "6.00", "4.21", "3.10", "2.00", "100.99"};
 
	// test case for multiple solution
	private static String[] DATA2 = {"22.75", "22.74", "11.65", "6.00", "4.21", "3.10", "2.00", "100.99",
									 "22.75", "22.74", "11.65", "6.00", "4.21", "3.10", "2.00", "100.99"};
	
	// test case for no round approximation effect
	// changing some decimal digits
    private static String[] DATA1 = {"22.75", "22.74", "11.66", "5.99", "4.21", "3.08", "2.02", "100.99"};
    
    // test case for general data test (with exactly two decimal digits)
    private static String[] DATA = {"22.75", "22.74", "11.65", "6.00", "4.21", "3.10", "2.00", "100.99"};
    
    @Test
    public void finderGeneralSmallDataWithExactlyTwoDecimalDigits_Test() {
    	String solutionActual = finderExecution(DATA);
    	String solutionExpected = "2.00,3.10,6.00,11.65";
    	assertEquals("Unexpected value: " + solutionActual, solutionExpected, solutionActual);
    }
    
    
    @Test
    public void finderDecimalDigitsModified_Test() {
    	String solutionActual = finderExecution(DATA1);
    	String solutionExpected = "2.02,3.08,5.99,11.66";
    	assertEquals("Unexpected value: " + solutionActual, solutionExpected, solutionActual);   
    }
    
    @Test
    public void finderFirstSolutionOfMultipleSolutions() {
    	String solutionActual = finderExecution(DATA2);
    	String solutionExpected = "2.00,3.10,6.00,11.65";
    	assertEquals("Unexpected value: " + solutionActual, solutionExpected, solutionActual);    
    }
    
    
    @Test
    public void finderNoSolution() {
    	String solutionActual = finderExecution(DATA3);
    	String solutionExpected = "NO SOLUTION";
    	assertEquals("Unexpected value: " + solutionActual, solutionExpected, solutionActual);    
    }
    
    private String finderExecution(String [] data) {
        
    	long startTime = System.currentTimeMillis();
    	
    	Finder finder = new Finder();
    	finder.setBankTransfer(Double.valueOf(data[0]));
		finder.getDuePayments(data, 1, data.length);
		
		List<Double> solution = finder.getSolution();
		
		if (solution == null || solution.isEmpty()) return Configuration.NO_SOLUTION_FOUND;
		
		StringBuilder solutionActual = new StringBuilder();
    	
		for(Double dbl: solution) {
    		solutionActual.append(String.format("%.2f", dbl));
    		solutionActual.append(Configuration.SEPARATOR_CHAR);
		}
    	
    	long stopTime = System.currentTimeMillis();
    	long elapsedTime = stopTime - startTime;
    	System.out.println("The task has been completed in: " + elapsedTime + " ms");
    	
    	return solutionActual.toString().substring(0, solutionActual.length() - 1);
    }
}
