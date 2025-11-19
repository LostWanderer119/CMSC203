/**
 * Class: CMSC203
 * Instructor: Ahmed Tarek 
 * Description: Utility class to manipulate a two-dimensional ragged array of doubles,
 * including file I/O, array total/average calculations, and finding
 * highest/lowest values in rows, columns, and the entire array.
 * Due: 11/18/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Leo Chen
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {
	
	private TwoDimRaggedArrayUtility() {} //no field to initialize

	public static double[][] readFile(File file) throws java.io.FileNotFoundException {
		ArrayList<ArrayList<Double>> tempArr = new ArrayList<>();
		Scanner file_scan = new Scanner(file);
		
		while (file_scan.hasNextLine()) { //reads data to a scalable Arraylist
			String line = file_scan.nextLine();
			String[] holder = line.split(" "); //separates the tokens by the spaces
			ArrayList<Double> row = new ArrayList<>(); 
			for (String token : holder) { 
				if (holder.length != 0) { 
					row.add(Double.parseDouble(token)); 
				} 
			}
		
			if (!row.isEmpty()) { 
				tempArr.add(row); 
			} 
		} 
		file_scan.close();
		
		double[][] raggedArray = new double[tempArr.size()][]; //initializes the outer array
		
		for (int i = 0; i < tempArr.size() && i < 10; i++) {
			raggedArray[i] = new double[tempArr.get(i).size()]; //initializes the inner array
				for (int j = 0; j < tempArr.get(i).size() && j < 10; j++) {
					raggedArray[i][j] = tempArr.get(i).get(j); 
				} 
		} 
	return raggedArray;
	}

	public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException {
		PrintWriter output = new PrintWriter(outputFile);
		for (double[] row : data) { //iterate through rows
			for (int j = 0; j < row.length; j++) {
				output.print(row[j] + " ");
			}
			output.println();
		}
	output.close();
	}

	public static double getTotal(double[][] data) {
		double total = 0;
		for (double[] row : data) { //iterate through rows
			for (int  c = 0; c < row.length; c++) {  //iterate through cols
				total += row[c];
			}
		}
		return total;
	}

	public static double getAverage(double[][] data) {
		int numEntries = 0;
		for (double[] row : data) { //iterate through rows
			for (int  c = 0; c < row.length; c++) { //iterate through cols
				numEntries++;
			}
		}
		return (getTotal(data)/numEntries);
	}

	public static double getRowTotal(double[][] data, int row) {
		if (row < 0 || row >= data.length) {
            return 0; //invalid row index
        }
		
		double row_total = 0;
		for (int i = 0; i < data[row].length; i++) { //iterate through cols in that row
			row_total += data[row][i];
		}
		return row_total;
	}

	public static double getColumnTotal(double[][] data, int col) {
		double col_total = 0;

		for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                col_total += row[col];
            }
        }
		return col_total;
	}

	public static double getHighestInRow(double[][] data, int row) {
		if (row < 0 || row >= data.length || data[row].length == 0) {
			return Double.MIN_VALUE;
        }
		double highest = data[row][0];
		for (int i = 1; i < data[row].length; i++) { //iterate through cols
			if (data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		return highest;
	}

	public static int getHighestInRowIndex(double[][] data, int row) {
		if (row < 0 || row >= data.length || data[row].length == 0) {
            return -1; //not found index
        }
		double highest = data[row][0];
		int highestIndex = 0;
		for (int i = 1; i < data[row].length; i++) { //iterate through cols
			if (data[row][i] > highest) {
				highest = data[row][i];
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	public static double getLowestInRow(double[][] data, int row) {
		if (row < 0 || row >= data.length || data[row].length == 0) {
			return Double.MAX_VALUE;
        }
		double lowest = data[row][0];
		for (int i = 1; i < data[row].length; i++) { //iterate through cols
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}

	public static int getLowestInRowIndex(double[][] data, int row) {
		if (row < 0 || row >= data.length || data[row].length == 0) {
            return -1; //not found index
        }
		double lowest = data[row][0];
		int lowestIndex = 0;
		for (int i = 1; i < data[row].length; i++) { //iterate through cols
			if (data[row][i] < lowest) {
				lowest = data[row][i];
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}

	public static double getHighestInColumn(double[][] data, int col) {
	    double highest = Double.MIN_VALUE;
	    boolean found = false;
	    for (double[] row : data) {
	        if (col >= 0 && col < row.length) { //check col length and flagger
	            if (!found || row[col] > highest) {
	                highest = row[col];
	                found = true;
	            }
	        }
	    }
	    return highest;
	}

	public static int getHighestInColumnIndex(double[][] data, int col) {
	    double highest = Double.MIN_VALUE;
	    int highestIndex = -1; //not found index
	    for (int i = 0; i < data.length; i++) {
	        if (col >= 0 && col < data[i].length) {
	            if (highestIndex == -1 || data[i][col] > highest) {
	                highest = data[i][col];
	                highestIndex = i;
	            }
	        }
	    }
	    return highestIndex;
	}

	public static double getLowestInColumn(double[][] data, int col) {
	    double lowest = Double.MAX_VALUE;
	    boolean found = false;
	    for (double[] row : data) {
	        if (col >= 0 && col < row.length) { //check col length and flag
	            if (!found || row[col] < lowest) {
	                lowest = row[col];
	                found = true;
	            }
	        }
	    }
	    return lowest;
	}

	public static int getLowestInColumnIndex(double[][] data, int col) {
	    double lowest = Double.MAX_VALUE;
	    int lowestIndex = -1; //not found index
	    for (int i = 0; i < data.length; i++) {
	        if (col >= 0 && col < data[i].length) {
	            if (lowestIndex == -1 || data[i][col] < lowest) {
	                lowest = data[i][col];
	                lowestIndex = i;
	            }
	        }
	    }
	    return lowestIndex;
	}

	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for (double[] row : data) { //iterate through rows
			for (int i = 0; i < row.length; i++) { //iterate through cols
				if (row[i] > highest) {
					highest = row[i];
				}
			}
		}
		return highest;
	}

	public static double getLowestInArray(double[][] data) { 
		double lowest = data[0][0];
		for (double[] row : data) { //iterate through rows
			for (int i = 0; i < row.length; i++) { //iterate through cols
				if (row[i] < lowest) {
					lowest = row[i];
				}
			}
		}
		return lowest;

	}

}
