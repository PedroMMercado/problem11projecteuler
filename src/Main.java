import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Largest product in a grid
		// Problem 11
		// What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
		int [][] array = new int [20][20];
		ArrayList<String[]> list = new ArrayList<>();
		try {
			// get file
			Scanner input = new Scanner(new File("input.txt"));
			while(input.hasNextLine()){
				list.add(input.nextLine().split(" "));
			}
			populateArray(array, list);
			System.out.println("Largest Product is " + largestProduct(array));
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int largestProduct(int [][] array){
		int product = 1;
		int largest = -1;
		
		for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length - 3; j++){
                product = array[i][j] * array[i][j + 1] * array[i][j + 2] * array[i][j + 3];
                if(product > largest){
                    largest = product;
                }
            }   
        }
		
        
       // Check vertically
       for(int i = 0; i < array.length - 3; i ++){
           for(int j = 0; j < array[i].length; j++){
               product = array[i][j] * array[i + 1][j] * array[i + 2][j] * array[i + 3][j];
               if(product > largest){
                   largest = product;
               }
           }
       }
       
       // Check diagonally right
       for(int i = 0; i < array.length - 3; i++){
           for(int j = 0; j < array[i].length - 3; j++){
               product = array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2] * array[i + 3][i + 3];
               if(product > largest){
                   largest = product;
               }
           }
       }
       
    // Check diagonally left
       for(int i = 0; i < array.length - 3; i ++){
           for(int j = 3; j < array[i].length; j ++){
               product = array[i][j] * array[i + 1][j - 1] * array[i + 2][j  - 2] * array[i + 3][j - 3];
               if(product > largest){
                   largest = product;
               }
           }
       }
       
       return largest;
	}
	
	public static void populateArray(int [][] array, ArrayList<String[]> list){
		
		for(int i = 0; i < array.length;i++){
			for(int j = 0; j < array[i].length;j++){
				if(list.get(i)[j].charAt(0) == '0')
					array[i][j] = Character.getNumericValue(list.get(i)[j].charAt(1));
				else
					array[i][j] = Integer.parseInt(list.get(i)[j]);
			}
		} 
	}
	
}
