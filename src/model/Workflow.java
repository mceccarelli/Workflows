// This is the Workflow class.
package model;

import java.lang.*;
import java.util.*;

public class Workflow {
  // The 9-tuple which builds the Workflow.
  private String id;
  private HashSet<Port> inputs;
  private HashSet<Port> outputs;
  private Workflow[] workflows;
  private DataProduct[] dataProducts;
  private DataChannel[] dcin;
  private DataChannel[] dcout;
  private DataChannel[] dcmid;
  private DataChannel[] dcidp;

  // Descriptions for this Workflow
  private boolean isPrimitive;
  private boolean isComposite;
  
  private String executableName;
  private String executableInput;


  // Constructor for this class
  public Workflow(String id, HashSet<Port> inputs, HashSet<Port> outputs, Workflow[] workflows, DataProduct[] dataProducts, DataChannel[] dcin, DataChannel[] dcout, DataChannel[] dcmid, DataChannel[] dcidp) {
    this.id = id;
    this.inputs = inputs;
    this.outputs = outputs;
    this.workflows = workflows;
    this.dataProducts = dataProducts;
    this.dcin = dcin;
    this.dcout = dcout;
    this.dcmid = dcmid;
    this.dcidp = dcidp;
    /* we can add other conditions later ...*/
    if (inputs.size() != 0 && outputs.size() != 0 && (workflows.length == 0 && dataProducts.length == 0 && dcin.length == 0 && dcout.length == 0 && dcmid.length == 0 && dcidp.length == 0)) {
      isPrimitive = true;
      isComposite = false;
    }
    if ((workflows.length != 0 && inputs.size() != 0 && outputs.size() != 0 && dcin.length != 0 && dcmid.length != 0) || (workflows.length != 0 && outputs.size() != 0 && dataProducts.length != 0 && dcidp.length != 0)){
      isPrimitive = false;
      isComposite = true;
    }
  }

  // toString overriding
  public String toString() {
    Iterator itr1 = inputs.iterator();
    ArrayList<String> inputsArray = new ArrayList<String>();
    while (itr1.hasNext()) {
      Port in = (Port)(itr1.next());
      inputsArray.add(in.toString());
    }

    Iterator itr2 = inputs.iterator();
    ArrayList<String> outputsArray = new ArrayList<String>();
    while (itr2.hasNext()) {
      Port out = (Port)(itr2.next());
      outputsArray.add(out.toString());
    }

    ArrayList<String> dataprod = new ArrayList<String>();
    for (int i = 0; i < dataProducts.length; i += 1) {
      dataprod.add(dataProducts[i].toString());
    }

    ArrayList<String> datain = new ArrayList<String>();
    for (int i = 0; i < dcin.length; i += 1) {
      datain.add(dcin[i].toString());
    }

    ArrayList<String> dataout = new ArrayList<String>();
    for (int i = 0; i < dcout.length; i += 1) {
      dataout.add(dcout[i].toString());
    }

    ArrayList<String> datamid = new ArrayList<String>();
    for (int i = 0; i < dcmid.length; i += 1) {
      datamid.add(dcmid[i].toString());
    }

    ArrayList<String> dataidp = new ArrayList<String>();
    for (int i = 0; i < dcidp.length; i += 1) {
      dataidp.add(dcidp[i].toString());
    }

    return ""
    + "ID: " + id + "\n"
    + "Inputs: " + inputsArray + "\n"
    + "Outputs: " + outputsArray + "\n"
    + "Workflows: " + "Workflows here" + "\n"
    + "Data Products: " + dataprod + "\n"
    + "Data Channels" + "\n"
    + "In: " + datain + "\n"
    + "Out: " + dataout + "\n"
    + "Mid: " + datamid + "\n"
    + "IDP: " + dataidp;
  }

  // Getter methods for a Workflow
  public String getID() {
    return id;
  }
  public HashSet<Port> getInputs() {
    return inputs;
  }
  public HashSet<Port> getOutputs() {
    return outputs;
  }
  public Workflow[] getWorkflows() {
    return workflows;
  }
  public DataProduct[] getDataProducts() {
    return dataProducts;
  }
  public DataChannel[] getDCIN() {
    return dcin;
  }
  public DataChannel[] getDCOUT() {
    return dcout;
  }
  public DataChannel[] getDCMID() {
    return dcmid;
  }
  public DataChannel[] getDCIDP() {
    return dcidp;
  }

  public boolean isPrimitive() {
    return isPrimitive;
  }
  public boolean isComposite() {
    return isComposite;
  }
  public void setExecutableName(String name) {
    this.executableName = name;
  }
  public String getExecutableName() {
    return this.executableName;
  }
  public void setExecutableInput(String input) {
    this.executableInput = input;
  }
  public String getExecutableInput() {
    return this.executableInput;
  }

}
