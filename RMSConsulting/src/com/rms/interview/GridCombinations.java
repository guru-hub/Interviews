package com.rms.interview;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;


/**
* The GridCombinations program implements an application that
* calculate different combinations for  given adjacent numbers  and
*  calculate greatest product of given  adjacent numbers .
*
* @author  Guru  Alampalli
* @version 1.0
* @since   2019-07-21 
*/
public class GridCombinations
{

	// Given Matrix
	public static int[][] grid10x10 = {  	{  8,  2, 22, 97, 38, 15,  0, 40,  0, 75 },
											{ 49, 49, 99, 40, 17, 81, 18, 57, 60, 87 },
											{ 81, 49, 31, 73, 55, 79, 14, 29, 93, 71 }, 
											{ 52, 70, 95, 23,  4, 60, 11, 42, 69, 24 },
											{ 22, 31, 16, 71, 51, 67, 63, 89, 41, 92 }, 
											{ 24, 47, 32, 60, 99,  3, 45,  2, 44, 75 },
											{ 32, 98, 81, 28, 64, 23, 67, 10, 26, 38 }, 
											{ 67, 26, 20, 68,  2, 62, 12, 20, 95, 63 },
											{ 24, 55, 58,  5, 66, 73, 99, 26, 97, 17 }, 
											{ 21, 36, 23,  9, 75,  0, 76, 44, 20, 45 } 
																						};
	
	
	public static void main(String[] args) {

		int numbersInProduct = 3;
		print2DMatrix(grid10x10);
		int max10x10 = findProduct(grid10x10, numbersInProduct);
		System.out.println("The greatest product:  " + max10x10);
		
	}

	/**
	   * This method is used to findProductfor given matrix and length. 
	   *  also calculate print the number of combinations
	  
	   * @param grid This is the first parameter i.e given Matrix  
	   * @param length  This is the second parameter to for given length / number of adjunct numbers
	   * @return int This returns greatestProduct.
	   */
	
	public static int findProduct(int[][] grid, int length) {

		int numbersInProduct = length;
		int greatestProduct = 0;
		int totalCombinations = 0;
		
		//Checking start time for performance Test
		Instant start = Instant.now();

		for (int col = 0; col < grid.length; col++) {
			for (int row = 0; row < grid.length; row++) {
				int tempProd;

				// Check Up /  Down
				if (row < grid.length - numbersInProduct) {
					tempProd = grid[col][row];
					for (int i = 1; i < numbersInProduct; i++) {
						tempProd *= grid[col][row + i];
					}
					greatestProduct = Math.max(greatestProduct, tempProd);
					totalCombinations++;
				}

				// Check Left /  Right
				if (col < grid.length - numbersInProduct) {
					tempProd = grid[col][row];
					for (int i = 1; i < numbersInProduct; i++) {
						tempProd *= grid[col + i][row];
					}
					greatestProduct = Math.max(greatestProduct, tempProd);
					totalCombinations++;
				}

				// Check diagonally upwards / forwards
				if ((col < grid.length - numbersInProduct) && (row >= numbersInProduct)) {
					tempProd = grid[col][row];
					for (int i = 1; i < numbersInProduct; i++) {
						tempProd *= grid[col + i][row - i];
					}
					greatestProduct = Math.max(greatestProduct, tempProd);
					totalCombinations++;
				}

				// Check diagonally Downwards / forwards
				if ((row < grid.length - numbersInProduct) && (col < grid.length - numbersInProduct)) {
					tempProd = grid[col][row];
					for (int i = 1; i < numbersInProduct; i++) {
						tempProd *= grid[col + i][row + i];
					}
					greatestProduct = Math.max(greatestProduct, tempProd);
					totalCombinations++;
				}
			}
		}

		//System.out.println("The Adjcent numbers count " + numbersInProduct);
		System.out.println("Total Number of Combinations : " + totalCombinations);
		System.out.println("The greatest product  		 : " + greatestProduct);
		
		
		//Calculate  end  time for performance Test
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		
		return greatestProduct;

	}

	/**
	   * This method is used to print  given matrix. 
	   *  also calculate print the number of combinations
	  
	   * @param grid This is the first parameter i.e given Matrix  
	  
	   * @return void .
	   */
	
	
	public static void print2DMatrix(int mat[][]) {
		
		// Loop through all rows
		for (int[] row : mat)

			// converting each row as string,  then printing each row  in a separate line 
			System.out.println(Arrays.toString(row));
	}


	

}
