package executor;
import java.util.Scanner;
import java.io.IOException;
public class Executor{
	public String run(String taskCode, String taskInput){
		try{
			Process task = Runtime.getRuntime().exec("java -cp .:/classes " + taskCode + " " + taskInput); 
			Scanner scan = new Scanner(task.getInputStream());
			String result = "";
			while (scan.hasNext()) {
			   result += scan.next();
			}
			return result;	
		}
		catch(IOException ex){
			System.out.println(ex.toString());
		}
		return null;
	}
	public static void main(String[] args){
		String taskCode = "primitive.Increment";
		String taskInput = "10";
		Executor exe = new Executor();
		String output = exe.run(taskCode,taskInput);
		System.out.println(output);

		
	}
}