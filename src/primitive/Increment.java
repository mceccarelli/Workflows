package primitive;
public class Increment{
	public static void main(String[] args){
		if (args.length == 1){
			int input = Integer.parseInt(args[0]);
			int output = input+1;
			System.out.println(output);
		}
		else
			System.out.println("Invalid input");	
	}
}