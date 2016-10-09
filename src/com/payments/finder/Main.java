package com.payments.finder;

import com.payments.finder.io.IOManager;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		if (args.length == 1) {
			Finder finder = new Finder();
			IOManager.initOutputFile(Configuration.OUTPUT_FILE_NAME, Configuration.NO_SOLUTION_FOUND);
			String[] input = IOManager.readInputFile(args[0]);
			// is data corrupted?
	    	if (input != null && input.length > 1) {
				finder.setBankTransfer(Double.valueOf(input[0]));
				if (input != null) finder.getDuePayments(input, 1, input.length);
				if (!finder.getSolution().isEmpty()) IOManager.writeSolutionToFile(finder.getSolution(), Configuration.OUTPUT_FILE_NAME);
	    	}
		}
		else System.out.println("Usage: java -jar find_payments.jar filename");

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("The task has been completed in: " + elapsedTime + " ms");
	}
}
