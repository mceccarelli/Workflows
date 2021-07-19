import java.io.*;
import java.util.*;
import model.*;
public class WorkflowParser {
	public static int[][] buildMatrix(String matrixFile){
		int size = 0;
		try {
      		File file = new File(matrixFile);
		    Scanner scan = new Scanner(file);
		    while (scan.hasNextLine()) {
			    String data = scan.nextLine();
				size = data.split(" ").length;
		    }
		    scan.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    	int[][] matrix = new int[size][size];
    	return matrix;
	}
	public static void loadMatrix(String matrixFile, int[][] matrix){
		try {
      		File file = new File(matrixFile);
		    Scanner scan = new Scanner(file);
		    int row = 0;
		    while (scan.hasNextLine()) {
			    String[] data = scan.nextLine().split(" ");
			    int col = 0;
				for (String element: data){
					matrix[row][col] = Integer.parseInt(element);					
					col++;
				}
				row++;
		    }
		    scan.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}

	}
	public static void displayMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + "\t");			
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		String matrixFile = "../data/wa/matrix.txt";
		int[][] matrix = buildMatrix(matrixFile);
		loadMatrix(matrixFile, matrix);
		displayMatrix(matrix);

    
   	}
}
