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
