import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Largest product in a grid
		// Problem 11
		// What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
		String [][] array = new String [20][20];
		try {
			// get file
			Scanner input = new Scanner(new File("input.txt"));
			System.out.println(array.length);
			
			// gets 20 x 20 array from input file
			for(int i = 0; i < array.length;i++){
				for(int j = 0; j < array[i].length;j++){
					if(input.hasNextLine()){
						array[i][j] = input.nextLine();
					}
				}
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// todo
	public static int largestProduct(int [][] array){
		return 1;
	}

}
