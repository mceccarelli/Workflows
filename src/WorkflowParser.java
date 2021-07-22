import java.io.*;
import java.util.*;

import model.*;

public class WorkflowParser {

	/** Take an input file, which contains a matrix, and
		*	return an empty 2D int matrix based off the length calculated.
		*/
	public static int[][] buildMatrix(String matrixFile) {
		int size = 0;

		try {
				// Connect Scanner to File
      	File file = new File(matrixFile);
		    Scanner scan = new Scanner(file);

				// Loop through the whole file
		    while (scan.hasNextLine()) {
			    String data = scan.nextLine();
					size = data.split(" ").length; // Find size of matrix
		    }

				// Close Scanner
		    scan.close();
    	} catch (FileNotFoundException e) { // Catch a FileNotFoundException
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}

			// Create a matrix based off of the size we found.
    	int[][] matrix = new int[size][size];

    	return matrix;
	}

	/** Get the information from a matrix file and insert
		* it into a 2D int array, which the user passes.
		*/
	public static void loadMatrix(String matrixFile, int[][] matrix) {
		try {
				// Connect Scanner to File
      	File file = new File(matrixFile);
		    Scanner scan = new Scanner(file);

		    int row = 0;
				int col = 0;
		    while (scan.hasNextLine()) { // Loop through whole matrix file
					// Get the row in a String array
			    String[] data = scan.nextLine().split(" ");

					for (String element: data) { // For `element` in data
						matrix[row][col] = Integer.parseInt(element); // Place the 1 or 0
						col += 1; // Increment the column so we move to the next one
					}

					col = 0; // Reset the column to 0
					row += 1; // Increment row so we move to the next one
		    }

				// Close the Scanner
		    scan.close();
		} catch (FileNotFoundException e) { // Catch a FileNotFoundException
				System.out.println("An error occurred.");
				e.printStackTrace();
		}

	}

	/** Display a 2D matrix.
		*/
	public static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i += 1) { // Loop through rows
			for (int j = 0; j < matrix[i].length; j += 1) { // Loop through columns
				System.out.print(matrix[i][j] + " "); // Display an element
			}
			System.out.println(); // Skip a line
		}

	}

	public static Map<String, Map<String, String>> loadPWorkflows(String pSpecFile) {
		Map<String, Map<String, String>> pwfs = new HashMap<String, Map<String, String>>();
		try {
      		File file = new File(pSpecFile);
		    Scanner scan = new Scanner(file);
		    while (scan.hasNextLine()) {
			    String[] workflow = scan.nextLine().split(" = ");
			    if (workflow.length == 2){
			    	String workflowName = workflow[0];
			    	String[] workflowPorts = workflow[1].split("]");
			    	if (workflowPorts.length == 2){
			    		String inputPorts = workflowPorts[0].substring(workflowPorts[0].indexOf("[IP: ") + 4, workflowPorts[0].length());
			    		String outputPorts = workflowPorts[1].substring(workflowPorts[1].indexOf("[OP: ") + 4, workflowPorts[1].length());
			    		Map<String, String> ports = new HashMap<String, String>();
			    		ports.put(inputPorts, outputPorts);
			    		pwfs.put(workflowName, ports);
			    	}
			    }
		    }
		    scan.close();
    	} catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    	return pwfs;
	}

	public static void specParser(String specFile) {
		try {
      	File file = new File(specFile);
		    Scanner scan = new Scanner(file);
		    while (scan.hasNextLine()) {
			    String[] workflow = scan.nextLine().split(" = ");
				if (workflow.length == 4){
		    	String workflowName = workflow[0];
		    	System.out.println(workflowName);
		    	String workflowInput = workflow[2].substring(0, workflow[2].indexOf("]"));
		    	System.out.println(workflowInput);
		    	String workflowConstituents = workflow[3].substring(0, workflow[3].length() - 1);
		    	System.out.println(workflowConstituents);
			    }
		    }
		    scan.close();
    	} catch (FileNotFoundException e) {
	  		System.out.println("An error occurred.");
	  		e.printStackTrace();
    	}

	}

	public static void displayAllPWorkflows(Map<String, Map<String, String>> pwfs) {
		 for (Map.Entry<String, Map<String, String>> pwf : pwfs.entrySet()) {
    	 	String workflowName = pwf.getKey();
    	 	for (Map.Entry<String, String> port : pwf.getValue().entrySet()) {
    	 		String inputPorts = port.getKey();
    	 		String outputPorts = port.getValue();
    	 		System.out.println(workflowName + "\t" + inputPorts + "\t" + outputPorts);
    	 	}
		 }
	}

	public static void displayPWorkflow(Map<String, Map<String, String>> pwfs, String pWorkflowName) {
		 boolean exist = false;
		 for (Map.Entry<String, Map<String, String>> pwf : pwfs.entrySet()) {
    	 	String workflowName = pwf.getKey();
    	 	for (Map.Entry<String, String> port : pwf.getValue().entrySet()) {
    	 		String inputPorts = port.getKey();
    	 		String outputPorts = port.getValue();
    	 		if (pWorkflowName.equalsIgnoreCase(workflowName)){
    	 			System.out.println(workflowName + "\t" + inputPorts + "\t" + outputPorts);
    	 			exist = true;
    	 		}
    	 	}
		 }
		 if (!exist)
		 	System.out.println("primtive workflow not found ...");
	}

	public static void main(String[] args) {
		String matrixFile = "../data/wa/matrix.txt";
		String specFile = "../data/wa/spec.txt";
		String pSpecFile = "../data/primitive.spec";
		int[][] matrix = buildMatrix(matrixFile);
		loadMatrix(matrixFile, matrix);
		displayMatrix(matrix);
		Map<String, Map<String, String>> pwfs = loadPWorkflows(pSpecFile);
		// uncomment the below line to display all pworkflows
		// displayAllPWorkflows(pwfs);

		String pWorkflowName = "Not";
		displayPWorkflow(pwfs, pWorkflowName);
		specParser(specFile);

   	}

}
