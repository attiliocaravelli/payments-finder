package com.payments.finder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Account finder solution
 * @author attilio
 *
 */
public class Finder {
	
	 /** 
	  * Target sum 
	  */
    private double bankTransfer;
   
    /**
     * Partial Subset
     */
	private Stack<String> stack = new Stack<>();
    
	/**
	 * Solution list (Sorted)
	 */
	private List<Double> solution = new ArrayList<>();
	
	/**
	 * Store the sum of current elements stored in stack
	 */
    private String partialSum = "0.00";
    
    /**
	 * Is the solution found?
	 */
    private boolean solutionFound = false;
   
    /*
     * Recursive implementation of the exhaustive search (brute-force)
     * Worst case -> exponential complexity
     * 
     * I am using BigDecimal(String) data type in order to avoid the 
     * round approximation in sum and sub mathematical operations.
     * This involves several conversions but I assumed the input data is 
     * not BigData
     * 
     * Observation: In order to accelerate the execution of the 
     * algorithm you could make use of parallel programming techniques
     * with an iterative implementation
     */
    public void getDuePayments(String[] data, int fromIndex, int endIndex) {
       	
    	if (new BigDecimal(partialSum).doubleValue() > bankTransfer) {
            return;
        }
    	
    	if (new BigDecimal(partialSum).doubleValue() == bankTransfer) {
    		sortAndCopySolution(stack);
    		solutionFound = true;
            return;
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex && !solutionFound; currentIndex++) {
        	BigDecimal partialAdd = new BigDecimal(partialSum).add(new BigDecimal(data[currentIndex]));
            if ( partialAdd.doubleValue() <= bankTransfer) {
            	stack.push(data[currentIndex]);
            	partialSum = partialAdd.toPlainString();
          
                getDuePayments(data, currentIndex + 1, endIndex);
             
                if (!solutionFound) {
                	/*
                     * backtracking technique (pop from the stack)
                     */
                	BigDecimal partialSub = new BigDecimal(partialSum).subtract(new BigDecimal(stack.pop()));
                	partialSum = partialSub.toPlainString();
                }
                
            }
        }
    }
    
    public double getBankTransfer() {
  		return bankTransfer;
  	}

  	public void setBankTransfer(double bankTransfer) {
  		this.bankTransfer = bankTransfer;
  	}
  	
    private void sortAndCopySolution(Stack<String> solution) {
    	for (String i : solution)
    		this.solution.add(new Double(i));
    	Collections.sort(this.solution);
    }

	public List<Double> getSolution() {
		return solution;
	}
    
}
