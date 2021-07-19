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
	public static Map<String, Map<String, String>> loadPWorkflows(String pSpecFile){
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
	public static void displayAllPWorkflows(Map<String, Map<String, String>> pwfs){
		 for (Map.Entry<String, Map<String, String>> pwf : pwfs.entrySet()) {
    	 	String workflowName = pwf.getKey();
    	 	for (Map.Entry<String, String> port : pwf.getValue().entrySet()) {
    	 		String inputPorts = port.getKey();
    	 		String outputPorts = port.getValue();
    	 		System.out.println(workflowName + "\t" + inputPorts + "\t" + outputPorts);
    	 	}
		 }
	}
	public static void displayPWorkflow(Map<String, Map<String, String>> pwfs, String pWorkflowName){
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
		String pSpecFile = "../data/primitive.spec";
		int[][] matrix = buildMatrix(matrixFile);
		loadMatrix(matrixFile, matrix);
		displayMatrix(matrix);
		Map<String, Map<String, String>> pwfs = loadPWorkflows(pSpecFile);
		// uncomment the below line to display all pworkflows
		// displayAllPWorkflows(pwfs);
		
		String pWorkflowName = "Not";
		displayPWorkflow(pwfs, pWorkflowName);

    
   	}
}
