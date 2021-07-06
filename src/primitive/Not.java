package primitive;
public class Not{
	public static void main(String[] args){
		if (args.length == 1){
			String input = args[0];
			if (input.equalsIgnoreCase("true"))
				System.out.println("false");	
			else if (input.equalsIgnoreCase("false"))
				System.out.println("true");	
			else 
				System.out.println("Invalid input");	
		}
		else
			System.out.println("Invalid input");	
	}
}