package primitive;
public class Increment{
	public static void main(String[] args){
		if (args.length == 1){
			int input = 0;
			if (args[0].equalsIgnoreCase("true"))
				input = 1;
			else if (args[0].equalsIgnoreCase("false"))
				input = 0;
			else
				input = Integer.parseInt(args[0]);
			int output = input+1;
			System.out.println(output);
		}
		else
			System.out.println("Invalid input");	
	}
}