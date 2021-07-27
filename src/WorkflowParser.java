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

		loadMatrix(matrixFile, matrix);

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

	/** Use an input file to get the information about all the primitive
		* workflows that may be used inside a composite workflow.
		*/
	public static Map<String, Map<String, String>> loadPWorkflows(String pSpecFile) {
		// Create an instance of HashMap
		Map<String, Map<String, String>> pwfs = new HashMap<String, Map<String, String>>();

		try {
			// Connect the Scanner to a File
    	File file = new File(pSpecFile);
		  Scanner scan = new Scanner(file);

	  	while (scan.hasNextLine()) {
				// Break up the file into three parts
		  	String[] workflow = scan.nextLine().split(" = ");

				// Get the name and ports from the clever split of the array
	   		String workflowName = workflow[0];
	    	String[] workflowPorts = workflow[1].split("]");

				// Get the type of input and output ports
    		String inputPorts = workflowPorts[0].substring(workflowPorts[0].indexOf("[IP: ") + 4, workflowPorts[0].length());
    		String outputPorts = workflowPorts[1].substring(workflowPorts[1].indexOf("[OP: ") + 4, workflowPorts[1].length());

				// Create a new HashMap of the ports
    		Map<String, String> ports = new HashMap<String, String>();

				// Put the ports into the ports HashMap
    		ports.put(inputPorts, outputPorts);
				// Put the ports Map into the workflow HashMap
    		pwfs.put(workflowName, ports);
			}

			// Close the Scanner
	  	scan.close();
		} catch (FileNotFoundException e) { // Catch a FileNotFoundException
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

    return pwfs;
	}

	/** Get the data from the specification file */
	public static String[] specParser(String specFile) {
		String[] array = new String[3];

		try {
			// Connect the Scanner to a File
	  	File file = new File(specFile);
	    Scanner scan = new Scanner(file);

			// Loop through the whole file
	    while (scan.hasNextLine()) {
				// Split the line into four parts
		  	String[] workflow = scan.nextLine().split(" = ");

				if (workflow.length == 4) { // It's a composite workflow
	    		String workflowName = workflow[0];
					array[0] = workflowName;
	    		//System.out.println(workflowName);
	    		String workflowInput = workflow[2].substring(0, workflow[2].indexOf("]"));
					array[1] = workflowInput;
	    		//System.out.println(workflowInput);
	    		String workflowConstituents = workflow[3].substring(0, workflow[3].length() - 1);
					array[2] = workflowConstituents;
	    		//System.out.println(workflowConstituents);
		    }
	    }

			// Close the Scanner
	    scan.close();
		} catch (FileNotFoundException e) { // Catch a FileNotFoundException
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return array;
	}

	/** Display a 2D matrix. */
	public static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i += 1) { // Loop through rows
			for (int j = 0; j < matrix[i].length; j += 1) { // Loop through columns
				System.out.print(matrix[i][j] + " "); // Display an element
			}
			System.out.println(); // Skip a line
		}
	}

	/** Display the details of all the primitive workflows in the input map. */
	public static void displayAllPWorkflows(Map<String, Map<String, String>> pwfs) {
		// Loop through all the entries
		for (Map.Entry<String, Map<String, String>> pwf : pwfs.entrySet()) {
    	String workflowName = pwf.getKey();
			// Loop through all the entries of the entries
    	for (Map.Entry<String, String> port : pwf.getValue().entrySet()) {
    		System.out.println(workflowName + ": " + port.getKey() + " -> " + port.getValue());
    	}
		}
	}

	/** Display the details of a specific primitive workflow. */
	public static void displayPWorkflow(Map<String, Map<String, String>> pwfs, String pWorkflowName) {
		// Loop through all the entries
		for (Map.Entry<String, Map<String, String>> pwf : pwfs.entrySet()) {
    	String workflowName = pwf.getKey();

			// Loop through all the entries of the entries
    	for (Map.Entry<String, String> port : pwf.getValue().entrySet()) {
				// If it exists, print it and return
    		if (pWorkflowName.equalsIgnoreCase(workflowName)) {
    	 		System.out.println(workflowName + ": " + port.getKey() + " -> " + port.getValue());
    	 		return;
    	 	}
    	}
		}
		System.out.println("Workflow not found!"); // Error message if not yet returned
	}

	/** The main method. */
	public static void main(String[] args) {
		// Input files
		String matrixFile = "../data/wa/matrix.txt";
		String specFile = "../data/wa/spec.txt";
		String pSpecFile = "../data/primitive.spec";

		// Storage for all our data
		int[][] matrix = buildMatrix(matrixFile);
		String[] specs = specParser(specFile);
		String[] pwfs = specs[2].split(",");

		String id = specs[0];
		ArrayList<Port> in = new ArrayList<Port>();
	  ArrayList<Port> out = new ArrayList<Port>();
	  Workflow[] constituents;
	  DataProduct[] dataProducts;
	  DataChannel[] dcin;
	  DataChannel[] dcout;
	  DataChannel[] dcmid;
	  DataChannel[] dcidp;

		if (specs[1].contains(" ")) {
			dcin = new DataChannel[0];
		} else {
			dataProducts = new DataProduct[0];
			dcidp = new DataChannel[0];
		}

		// if we get all the input ports, we can line up where each workflow exists
		// we can get the output ports too knowing that information.  it's every other.
		// then, we have the Port ArrayLists filled completely, so we can make all our data channels
		// and our constituent workflows
  }

}
