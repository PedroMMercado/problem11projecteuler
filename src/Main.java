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
			System.out.println(array.length);
			while(input.hasNextLine()){
				list.add(input.nextLine().split(" "));
			}
			populateArray(array, list);
			System.out.println(array[0][0]);
			
			
			// gets 20 x 20 array from input file
//			for(int i = 0; i < array.length;i++){
//				for(int j = 0; j < array[i].length;j++){
//					if(input.hasNextLine()){
//						String [] temp = input.nextLine().split(" ");
//						array[i][j] = input.nextLine();
//						System.out.println(array[i][j]);
//					}
//				}
//			}
//			
//			largestProduct(array);
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int largestProduct(int [][] array){
		return 1;
	}
	
	public static void populateArray(int [][] array, ArrayList<String[]> list){
		
		for(int i = 0; i < array.length;i++){
			for(int j = 0; j < array[i].length;j++){
				if(list.get(i)[j].charAt(0) == '0')
					array[i][j] = Character.getNumericValue(list.get(0)[0].charAt(1));
				else
					array[i][j] = Integer.parseInt(list.get(0)[0]);
			}
		}
	}
	
	// todo
	public static int largestProduct(String [][] array){
		// stores temporary string tokens
		String temp = "";
		String[] tempArray;
		// check horizonal
		int maxProduct = 1;
		for(int i = 0; i < array.length;i++){
			// needed to keep track of  4 adjacent values
			int count = 0;
			for(int j = 0; j < array[i].length;j++){
				tempArray = array[i][j].split(" ");
				int tempProduct = 1;
				for(int k = 0; k < tempArray.length;k++){
					if(count == 4)
						break;
					int num;
					if(tempArray[k].charAt(0) == '0')
						num = Character.getNumericValue(tempArray[k].charAt(1));
					else
						num = Integer.parseInt(tempArray[k]);
					tempProduct = tempProduct * num;
					count++;	
				}
				if(tempProduct > maxProduct)
					maxProduct = tempProduct;
			}
			count = 0;
			maxProduct = 1;
		}
		return 1;
	}

}
