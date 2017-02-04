package org.usfirst.frc.team4611.testHarness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 *
 */
public class TestDataCSVReader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("You must supply the name of the file to read");
		}
		String filenm = args[0];
		if (!filenm.startsWith("/") && !filenm.startsWith("\\")) {  // if the user did not specify an absolute path, figure out where we are
			String cur = Paths.get(".").toAbsolutePath().normalize().toString();
			filenm = cur + File.separator + filenm;
		}
		
		readAndTest(filenm);
	}

	/**
	 * This will open a file and read in a group of arrays, each one being on separate line which might look like 
	 *    centerX,45,6,7,3
	 *    centerY,32,8,6,4
	 *    centerX,12,3,3,4
	 *    centerY,76,3,3,3
	 * @param filenm The name of the file to read
	 * @throws IOException 
	 */
	private static void readAndTest(String filenm) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filenm),2048000);  // large buffer may be beneficial for large files
		} catch (FileNotFoundException e) {
			System.out.println("File "+filenm+" not found");
			e.printStackTrace();
			System.exit(8);
		}  
		String rec = null;
		
		String firstName = null;
		HashMap<String,double []> arrays = new HashMap<String,double[]>();
		int iteration = 0;
		
		while( (rec = br.readLine()) != null) {
			String vals[] = rec.split(",");
			if (firstName == null) {  // if this is the first record
				firstName = vals[0];  // remember this name--it will be our signal to process some data
			}
			else {
				if (vals[0].equals(firstName)) {  // if we find that first name again, process the data we've read
					processData(arrays, iteration++);
					arrays = new HashMap<String,double[]>();  // reset the hashmap for the next set of data
				}
			}
			double [] numbers = new double[vals.length -1];
			for (int k=1;k<vals.length;k++) {
				numbers[k-1] = Double.parseDouble(vals[k]);
			}
			arrays.put(vals[0], numbers);  // add this array of numbers to the hashmap
		}
		processData(arrays, iteration++);  // after reading the last line, process the last set of data
	}

	/**
	 * This method will be called with for each group of data read from the file
	 * We'll pull the data out of the array and pretend to do something useful
	 * @param arrays HashMap of arrays of data
	 * @param iteration Keeps track of which iteration that we're on
	 */
	private static void processData(HashMap<String, double[]> arrays, int iteration) {
		// if we want we can pull the data out of the hash map 
		double [] centerX = arrays.get("centerX");
		double [] centerY = arrays.get("centerY");
		
		// this is where you do something clever with the data
		// but I'm not very clever, so I'll just write out the center coordinates for each contour
		System.out.println("Iteration "+iteration);
		for (int k=0;k<centerX.length;k++) {
			System.out.format("  Contour # %3d is at %8.3f , %8.3f"+System.lineSeparator(), k, centerX[k], centerY[k]);
		}
		System.out.println("-----------------------------------------");
		// TODO use the data to figure out how to move towards the target
	}
	
}
