package executor;
import java.util.Scanner;
import java.io.IOException;
public class Executor{
	public static void main(String[] args){
		try{
			String taskCode = "../primitive/Increment"; // task code is the location to the Increment class file, without the .class. I am expecting the Increment.class file to exist in the primitive directory. 
			String taskInput = "10"; // here dataProduct is the task input which is the input data which of string type, that is the data product. 
			Process task = Runtime.getRuntime().exec("java " + taskCode + " " + taskInput); 
			Scanner scan = new Scanner(task.getInputStream());
			String result = "";
			while (scan.hasNext()) {
			   result += scan.next();
			}
			int output = Integer.parseInt(result); // bind the output from primitive workflow to an integer. 
			System.out.println("Output Stub:" + output);	
		}
		catch(IOException ex){
			System.out.println(ex.toString());
		}
		
	}
}