import java.io.*;
import java.util.*;

import model.*;

public class Driver {

/*
	private static ArrayList <Port> inputs = new ArrayList <Port>();
	private static ArrayList <Port> outputs = new ArrayList <Port>();



		System.out.println("\n\nWelcome to Workflow Executor\n");

		System.out.println("Workflow A:");
		Workflow wa = modelA();
		System.out.println(wa.toString());

		System.out.println("\nWorkflow D:");
		Workflow wd = modelD();
		System.out.println(wd.toString());




	public static Workflow modelNot() {
		// definining ports for increment primitive workflow
		ArrayList <Port> not_inputs = new ArrayList <Port>();
		ArrayList <Port> not_outputs = new ArrayList <Port>();
		Port not_ip1 = new Port("ip1","bool");
		not_inputs.add(not_ip1);
		Port not_op1 = new Port("op2","bool");
		not_outputs.add(not_op1);
		inputs.addAll(not_inputs);
		outputs.addAll(not_outputs);

		// empty fields for primitive workfows.
		Workflow[] constituents = new Workflow[0];
		DataProduct[] dataProducts = new DataProduct[0];
		DataChannel[] dcin = new DataChannel[0];
		DataChannel[] dcout = new DataChannel[0];
		DataChannel[] dcmid = new DataChannel[0];
		DataChannel[] dcidp = new DataChannel[0];

		Workflow primitive_not = new Workflow("not",not_inputs,not_outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return primitive_not;

	}

	public static Workflow modelIncrement() {
		// definining ports for increment primitive workflow
		ArrayList <Port> increment_inputs = new ArrayList <Port>();
		ArrayList <Port> increment_outputs = new ArrayList <Port>();
		Port increment_ip3 = new Port("ip3","int");
		increment_inputs.add(increment_ip3);
		Port increment_op4 = new Port("op4","int");
		increment_outputs.add(increment_op4);
		inputs.addAll(increment_inputs);
		outputs.addAll(increment_outputs);

		// empty fields for primitive workfows.
		Workflow[] constituents = new Workflow[0];
		DataProduct[] dataProducts = new DataProduct[0];
		DataChannel[] dcin = new DataChannel[0];
		DataChannel[] dcout = new DataChannel[0];
		DataChannel[] dcmid = new DataChannel[0];
		DataChannel[] dcidp = new DataChannel[0];
		Workflow primitive_increment = new Workflow("increment",increment_inputs,increment_outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return primitive_increment;
	}

	public static Workflow modelDecrement() {
		// definining ports for increment primitive workflow
		ArrayList <Port> decrement_inputs = new ArrayList <Port>();
		ArrayList <Port> decrement_outputs = new ArrayList <Port>();
		Port decrement_ip3 = new Port("ip3","int");
		decrement_inputs.add(decrement_ip3);
		Port decrement_op4 = new Port("op4","int");
		decrement_outputs.add(decrement_op4);
		inputs.addAll(decrement_inputs);
		outputs.addAll(decrement_outputs);

		// empty fields for primitive workfows.
		Workflow[] constituents = new Workflow[0];
		DataProduct[] dataProducts = new DataProduct[0];
		DataChannel[] dcin = new DataChannel[0];
		DataChannel[] dcout = new DataChannel[0];
		DataChannel[] dcmid = new DataChannel[0];
		DataChannel[] dcidp = new DataChannel[0];
		Workflow primitive_decrement = new Workflow("decrement",decrement_inputs,decrement_outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return primitive_decrement;
	}

	public static Workflow modelSqrt() {
		// definining ports for increment primitive workflow
		ArrayList <Port> sqrt_inputs = new ArrayList <Port>();
		ArrayList <Port> sqrt_outputs = new ArrayList <Port>();
		Port sqrt_ip1 = new Port("ip1","float");
		sqrt_inputs.add(sqrt_ip1);
		Port sqrt_op1 = new Port("op2","float");
		sqrt_outputs.add(sqrt_op1);
		inputs.addAll(sqrt_inputs);
		outputs.addAll(sqrt_outputs);

		// empty fields for primitive workfows.
		Workflow[] constituents = new Workflow[0];
		DataProduct[] dataProducts = new DataProduct[0];
		DataChannel[] dcin = new DataChannel[0];
		DataChannel[] dcout = new DataChannel[0];
		DataChannel[] dcmid = new DataChannel[0];
		DataChannel[] dcidp = new DataChannel[0];

		Workflow primitive_sqrt = new Workflow("sqrt",sqrt_inputs,sqrt_outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return primitive_sqrt;

	}

	public static Workflow modelMean() {
		// definining ports for increment primitive workflow
		ArrayList <Port> mean_inputs = new ArrayList <Port>();
		ArrayList <Port> mean_outputs = new ArrayList <Port>();
		Port mean_ip1 = new Port("ip1","float");
		Port mean_ip2 = new Port("ip2","float");
		Port mean_ip3 = new Port("ip3","float");
		mean_inputs.add(mean_ip1);
		mean_inputs.add(mean_ip2);
		mean_inputs.add(mean_ip3);
		Port mean_op1 = new Port("op2","float");
		mean_outputs.add(mean_op1);
		inputs.addAll(mean_inputs);
		outputs.addAll(mean_outputs);

		// empty fields for primitive workfows.
		Workflow[] constituents = new Workflow[0];
		DataProduct[] dataProducts = new DataProduct[0];
		DataChannel[] dcin = new DataChannel[0];
		DataChannel[] dcout = new DataChannel[0];
		DataChannel[] dcmid = new DataChannel[0];
		DataChannel[] dcidp = new DataChannel[0];

		Workflow primitive_mean = new Workflow("mean",mean_inputs,mean_outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return primitive_mean;

	}

	public static Workflow modelA() {
		Workflow not = modelNot();
		Workflow increment = modelIncrement();
		// Model Wa
		ArrayList <Port> wa_outputs = new ArrayList <Port>();
		Port wa_op5 = new Port("op5","int");
		wa_outputs.add(wa_op5);
		outputs.addAll(wa_outputs);

		// empty fields for primitive workfows.
		Workflow[] constituents = new Workflow[2];
		constituents[0] = not;
		constituents[1] = increment;

		DataProduct[] dataProducts = new DataProduct[1];
		DataProduct dp0 = new DataProduct("dp0","true","bool");
		dataProducts[0] = dp0;

		DataChannel[] dcidp = new DataChannel[1];
		DataChannel dcidp1 = new DataChannel(dp0, not.getInputs().stream().findFirst().get());
		dcidp[0] = dcidp1;

		// only for reusable workflows that is workflows without any data product ...
		DataChannel[] dcin = new DataChannel[0];

		DataChannel[] dcmid = new DataChannel[1];
		DataChannel dcmid1 = new DataChannel(not.getOutputs().stream().findFirst().get(), increment.getInputs().stream().findFirst().get());
		dcmid[0] = dcmid1;

		DataChannel[] dcout = new DataChannel[1];
		DataChannel dcout1 = new DataChannel(increment.getOutputs().stream().findFirst().get(), wa_op5);
		dcout[0] = dcout1;

		Workflow wa = new Workflow("wa",inputs,outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return wa;
	}

	public static Workflow modelD() {
		Workflow mean = modelMean();
		Workflow sqrt = modelSqrt();

		ArrayList <Port> wd_outputs = new ArrayList <Port>();
		Port wd_op9 = new Port("op9","float");
		wd_outputs.add(wd_op9);
		outputs.addAll(wd_outputs);

		Workflow[] constituents = new Workflow[2];
		constituents[0] = mean;
		constituents[1] = sqrt;

		DataProduct[] dataProducts = new DataProduct[3];
		DataProduct dp0 = new DataProduct("dp0","3","int");
		dataProducts[0] = dp0;
		DataProduct dp1 = new DataProduct("dp1","5","int");
		dataProducts[1] = dp1;
		DataProduct dp2 = new DataProduct("dp2","4","int");
		dataProducts[2] = dp2;

		DataChannel[] dcidp = new DataChannel[3];
		DataChannel dcidp1 = new DataChannel(dp0, mean.getInputs().stream().findFirst().get());
		dcidp[0] = dcidp1;
		DataChannel dcidp2 = new DataChannel(dp1, mean.getInputs().stream().findFirst().get());
		dcidp[1] = dcidp2;
		DataChannel dcidp3 = new DataChannel(dp2, mean.getInputs().stream().findFirst().get());
		dcidp[2] = dcidp3;

		DataChannel[] dcin = new DataChannel[0];

		DataChannel[] dcmid = new DataChannel[1];
		DataChannel dcmid1 = new DataChannel(mean.getOutputs().stream().findFirst().get(), sqrt.getInputs().stream().findFirst().get());
		dcmid[0] = dcmid1;

		DataChannel[] dcout = new DataChannel[1];
		DataChannel dcout1 = new DataChannel(sqrt.getOutputs().stream().findFirst().get(), wd_op9);
		dcout[0] = dcout1;

		Workflow wd = new Workflow("wd",inputs,outputs,constituents,dataProducts,dcin,dcout,dcmid,dcidp);
		return wd;
	}
*/

	private static int[][] array;
	private static ArrayList<String> inputs;
	private static ArrayList<String> workflows;

	private static void getInput() {
		// Connecting Scanner to File
		File file = null;
		Scanner scanner = null;
		try {
			file = new File("../input/input.txt");
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}

    // Declaring variables
    String line = scanner.nextLine();
    int num = 1 + line.charAt(line.length() - 1) - '0';
    array = new int[num][num];

    // Getting matrix values
    for (int i = 1; i < num + 1; i += 1) {
      line = scanner.nextLine();
      for (int k = 0; k < line.length(); k += 1) {
        if (line.charAt(k) == ' ') {
          line = line.substring(0, k) + line.substring(k + 1, line.length());
        }
      } // Remove spaces
      for (int j = 0; j < array[i - 1].length; j += 1) {
        array[i - 1][j] = line.charAt(j + 1) - '0';
      } // Input numbers
    }

/*
    // Outputting array
    for (int i = 0; i < array.length; i += 1) {
      for (int j = 0; j < array[i].length; j += 1) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
*/

    // Skip the space after the matrix
    scanner.nextLine();

		// Get the inputs
    inputs = new ArrayList<String>();
    while (scanner.hasNextLine()) {
      line = scanner.nextLine();

      if (line.isEmpty()) {
        break;
      }

			inputs.add(line);
    }

		// Get the constituents workflows
		workflows = new ArrayList<String>();
		while (scanner.hasNextLine()) {
      line = scanner.nextLine();
			workflows.add(line);
    }
	}

	public static void main(String[] args) {
		getInput();

   }
}
