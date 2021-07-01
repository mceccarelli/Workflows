import java.util.*;
import model.*;
public class Driver{
	private static HashSet <Port> inputs = new HashSet <Port>();
	private static HashSet <Port> outputs = new HashSet <Port>();
	public static Workflow modelNot(){
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
		return primitive_not;

	}
	public static Workflow modelIncrement(){
		// definining ports for increment primitive workflow
		HashSet <Port> increment_inputs = new HashSet <Port>();
		HashSet <Port> increment_outputs = new HashSet <Port>();
		Port increment_ip3 = new Port("ip3","int");
		increment_inputs.add(increment_ip3);
		Port increment_op4 = new Port("op4","bool");
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
	public static void main(String[] args){
		System.out.println("Welcome to Workflow Executor");
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
        	System.out.println(constituents[i].getID());
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
   }
}

