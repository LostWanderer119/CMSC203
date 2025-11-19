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

public class HolidayBonus {
	public static final double highest_bonus = 5000.00;
	public static final double base_bonus = 2000.00;
	public static final double lowest_bonus = 1000.00;

	private HolidayBonus() {} //no field to initialize

	public static double[] calculateHolidayBonus(double[][] data) {
		
		if (data == null || data.length == 0) { //if data is empty
            return new double[0];
        }

        double[] storeBonuses = new double[data.length];

        int max_categories = 0;
        for (double[] row : data) { //find the max # of cols (categories) to iterate through
            if (row.length > max_categories) {
                max_categories = row.length;
            }
        }

        for (int col = 0; col < max_categories; col++) { //iterate through each category (column)
            
        	//Sets up which max an min for the search
            double highestSale = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            int highestRowIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);

            double lowestSale = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
            int lowestRowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            // Count eligible stores
            int eligibleStoresCount = 0;
            for (double[] row : data) {
                if (col < row.length && row[col] > 0) {
                    eligibleStoresCount++;
                }
            }

            for (int row = 0; row < data.length; row++) {
                //check if the current store has a sale for this category
                if (col < data[row].length) {
                    double currentSale = data[row][col];
                    
                    //if sale is not positive, the store is not eligible for a bonus 
                    if (currentSale <= 0) {
                        //bonus is 0, nothing to add to storeBonuses
                        continue;
                    }

                    //special case: only one store sold items in this category
                    if (eligibleStoresCount == 1) {
                        storeBonuses[row] += highest_bonus;
                    } 
                    //normal case: multiple eligible stores
                    else if (eligibleStoresCount > 1) {
                        if (row == highestRowIndex && currentSale == highestSale) {
                            storeBonuses[row] += highest_bonus;
                        } else if (row == lowestRowIndex && currentSale == lowestSale) {
                            storeBonuses[row] += lowest_bonus;
                        } else {
                            storeBonuses[row] += base_bonus;
                        }
                    }
                }
            }
        }
		
		return storeBonuses;
	}

	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] storeBonuses = calculateHolidayBonus(data);
		double total = 0;
		
		for (double store : storeBonuses) {
			total += store;
		}
		
		return total;
	}

}
