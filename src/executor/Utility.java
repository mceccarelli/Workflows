package executor;
import java.util.*;
import model.*;
public class Utility{
	public static ArrayList<Workflow> findStartVertices(Workflow w){
		ArrayList<Workflow> startVertices = new ArrayList<Workflow>();
  for(int i =0; i < w.getWorkflows().length; i++){
      startVertices.add(w.getWorkflows()[i]);
      Iterator itr = w.getWorkflows()[i].getInputs().iterator();
  			 while (itr.hasNext()) {
  				   Port in = (Port) itr.next();
         String to = in.getID();
         for(int j = 0; j < w.getDCIDP().length; j++){
	           String idp = w.getDCIDP()[j].getOutPort().getID();
	        		 if (!to.equalsIgnoreCase(idp))
						         startVertices.remove(w.getWorkflows()[i]);
        		  }
	    	   }
       }
       return startVertices;
	}
	public static ArrayList<Workflow> findConsumers(Workflow w, Workflow producer){
		  ArrayList<Workflow> consumers = new ArrayList<Workflow>();
    for(int i =0; i < w.getWorkflows().length; i++){
        consumers.add(w.getWorkflows()[i]);
        Iterator itr1 = w.getWorkflows()[i].getInputs().iterator();
  			   while (itr1.hasNext()) {
  				     Port in = (Port) itr1.next();
           String to = in.getID();
           Iterator itr2 = producer.getOutputs().iterator();
  				     while (itr2.hasNext()) {
	  				        Port out = (Port) itr2.next();
	            	 String from = out.getID();
	            	 for(int j = 0; j < w.getDCMID().length; j++){
	        			       String mid1 = w.getDCMID()[j].getInPort().getID();
	        			       String mid2 = w.getDCMID()[j].getOutPort().getID();
	        			       if (!(from.equalsIgnoreCase(mid1) && to.equalsIgnoreCase(mid2)))
							                consumers.remove(w.getWorkflows()[i]);
        			    }	
	           }
        	}
      }
      return consumers;
	}
	public static ArrayList<Workflow> findEndVertices(Workflow w){
		   ArrayList<Workflow> endVertices = new ArrayList<Workflow>();
     for(int i =0; i < w.getWorkflows().length; i++){
         endVertices.add(w.getWorkflows()[i]);
        	Iterator itr = w.getWorkflows()[i].getOutputs().iterator();
  			    while (itr.hasNext()) {
  				      Port in = (Port) itr.next();
            String from = in.getID();
            for(int j = 0; j < w.getDCOUT().length; j++){
	        		    String out = w.getDCOUT()[j].getInPort().getID();
	        		    if (!from.equalsIgnoreCase(out))
						            endVertices.remove(w.getWorkflows()[i]);
        		  }	        		
        	}
      }
      return endVertices;
	}
 public static void giveInitialInputs(Workflow w, Workflow current){
      String input = "";
      DataChannel[] dcidp = w.getDCIDP();
      for(int i =0; i < dcidp.length; i++){
        Iterator itr = current.getInputs().iterator();
        while (itr.hasNext()) {
           Port in = (Port) itr.next();
           String from = in.getID();
           if (from.equalsIgnoreCase(dcidp[i].getOutPort().getID()))
              input += dcidp[i].getDataProduct().getValue() + " ";
        }   
        
      }
      current.setExecutableInput(input);
      
 }
 
  public static String executePrimitive(Workflow current){
    Executor exe = new Executor();
    String output = exe.run(current.getExecutableName(),current.getExecutableInput());
    return output;
  }
  public static void executeWorkflow(Workflow workflow, Workflow current){
    System.out.println("executing:\t" + current.getID());
    String output = executePrimitive(current);
    System.out.println("Output from " + current.getID() + ": " + output);
    if (findEndVertices(workflow).contains(current) == true)
      return;
    ArrayList<Workflow> consumers = findConsumers(workflow, current);
    int cons = 0;
    while (consumers.size() != 0){
      consumers.get(cons).setExecutableInput(output);
      executeWorkflow(workflow, consumers.get(cons));
      consumers.remove(consumers.get(cons));
      cons++;
    }
  }
}