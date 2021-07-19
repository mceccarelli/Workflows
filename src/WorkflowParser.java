import java.io.*;
import java.util.*;
import model.*;
public class WorkflowParser {
	public static int[][] buildMatrix(String matrixFile){
		int size = 0;
		try {
      		File myObj = new File(matrixFile);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
			    String data = myReader.nextLine();
				size = data.split(" ").length;
		    }
		    myReader.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    	int[][] matrix = new int[size][size];
    	return matrix;
	}
	public static int[][] loadMatrix(String matrixFile, int[][] matrix){
		int[][] res_matrix = matrix;
		try {
      		File myObj = new File(matrixFile);
		    Scanner myReader = new Scanner(myObj);
		    int row = 0;
		    while (myReader.hasNextLine()) {
			    String[] data = myReader.nextLine().split(" ");
			    int col = 0;
				for (String element: data){
					res_matrix[row][col] = Integer.parseInt(element);					
					col++;
				}
				row++;
		    }
		    myReader.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    	return res_matrix;
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
