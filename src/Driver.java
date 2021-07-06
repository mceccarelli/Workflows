import java.util.*;
import model.*;
import executor.*;
public class Driver{
	private static HashSet <Port> inputs = new HashSet <Port>();
	private static HashSet <Port> outputs = new HashSet <Port>();
<<<<<<< HEAD
	
	public static Workflow modelNot(){
=======

	public static Workflow modelNot() {
>>>>>>> 1a7f005d7615bccd1e0ca44777b1c6e1ae3e4647
		// definining ports for increment primitive workflow
		HashSet <Port> not_inputs = new HashSet <Port>();
		HashSet <Port> not_outputs = new HashSet <Port>();
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
		primitive_not.setExecutableName("primitive.Not");
		return primitive_not;

	}

	public static Workflow modelIncrement() {
		// definining ports for increment primitive workflow
		HashSet <Port> increment_inputs = new HashSet <Port>();
		HashSet <Port> increment_outputs = new HashSet <Port>();
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
		primitive_increment.setExecutableName("primitive.Increment");
		return primitive_increment;
	}

	public static Workflow modelDecrement() {
		// definining ports for increment primitive workflow
		HashSet <Port> decrement_inputs = new HashSet <Port>();
		HashSet <Port> decrement_outputs = new HashSet <Port>();
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
		HashSet <Port> sqrt_inputs = new HashSet <Port>();
		HashSet <Port> sqrt_outputs = new HashSet <Port>();
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
		HashSet <Port> mean_inputs = new HashSet <Port>();
		HashSet <Port> mean_outputs = new HashSet <Port>();
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
		HashSet <Port> wa_outputs = new HashSet <Port>();
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

		HashSet <Port> wd_outputs = new HashSet <Port>();
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

	public static void main(String[] args) {
		System.out.println("\n\nWelcome to Workflow Executor\n");

		System.out.println("Workflow A:");
		Workflow wa = modelA();
		System.out.println(wa.toString());

		System.out.println("\nWorkflow D:");
		Workflow wd = modelD();
		System.out.println(wd.toString());

<<<<<<< HEAD
		// displaying details related to workflow. 
		System.out.println("Workflow ID:\t" + wa.getID());
		System.out.println("Workflow Inputs:");
		Iterator itr1 = wa.getInputs().iterator();
  		while (itr1.hasNext()) {
  			Port in = (Port) itr1.next();
            System.out.println(in.getID() + "\t" + in.getType());
        }
        System.out.println("Workflow Outputs:");
        Iterator itr2 = wa.getOutputs().iterator();
  		while (itr2.hasNext()) {
  			Port out = (Port) itr2.next();
            System.out.println(out.getID() + "\t" + out.getType());
        }
        System.out.println("Workflow Constituents:");
        for(int i =0; i < constituents.length; i++){
        	System.out.println(constituents[i].getID() + "\t" + constituents[i].isPrimitive() + "\t" + constituents[i].isComposite());
        }
        System.out.println("Data Products:");
        for(int i =0; i < dataProducts.length; i++){
        	System.out.println(dataProducts[i].getID() + "\t" + dataProducts[i].getValue() + "\t" + dataProducts[i].getType());
        }
        System.out.println("Data Channels:");
        for(int i =0; i < dcin.length; i++){
        	System.out.println(dcin[i].getInPort().getID() + "\t" + dcin[i].getOutPort());
        }
        for(int i =0; i < dcout.length; i++){
        	System.out.println(dcout[i].getInPort().getID() + "\t" + dcout[i].getOutPort().getID());
        }
        for(int i =0; i < dcmid.length; i++){
        	System.out.println(dcmid[i].getInPort().getID() + "\t" + dcmid[i].getOutPort().getID());
        }
        for(int i =0; i < dcidp.length; i++){
        	System.out.println(dcidp[i].getDataProduct().getID() + "\t" + dcidp[i].getOutPort().getID());
        }

        Utility util = new Utility();
        ArrayList<Workflow> wfs= util.findStartVertices(wa);
        int wfc = 0;
        while (wfs.size() != 0){
			util.giveInitialInputs(wa,wfs.get(wfc));
			util.executeWorkflow(wa, wfs.get(wfc));
			wfs.remove(wfs.get(wfc));
			wfc++;
        }

        
=======
>>>>>>> 1a7f005d7615bccd1e0ca44777b1c6e1ae3e4647
   }
}
