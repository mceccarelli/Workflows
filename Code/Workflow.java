// This is the Workflow class.

import java.lang.*;
import java.util.*;

class Workflow {
  // The 9-tuple which builds the Workflow.
  private String id;
  private Port[] inputs;
  private Port[] outputs;
  private Workflow[] workflows;
  private DataProduct[] dataProducts;
  private DataChannel[] dcin;
  private DataChannel[] dcout;
  private DataChannel[] dcmid;
  private DataChannel[] dcidp;

  // Descriptions for this Workflow
  private boolean isPrimitive;
  private boolean isComposite;

  // Constructor for this class
  public Workflow(String id, Port[] inputs, Port[] outputs, Workflow[] workflows, DataProduct[] dataProducts, DataChannel[] dcin, DataChannel[] dcout, DataChannel[] dcmid, DataChannel[] dcidp) {
    this.id = id;
    this.inputs = inputs;
    this.outputs = outputs;
    this.workflows = workflows;
    this.dataProducts = dataProducts;
    this.dcin = dcin;
    this.dcout = dcout;
    this.dcmid = dcmid;
    this.dcidp = dcidp;

    if (inputs.length != 0 && outputs.length != 0 && (workflows.length == dataProducts.length == dcin.length == dcout.length == dcmid.length = dcidp.length == 0)) {
      isPrimitive = true;
      isComposite = false;
    } else {
      isPrimitive = false;
      isComposite = true;
    }
  }

  // Getter methods for a Workflow
  public String getID() {
    return id;
  }
  public Port[] getInputs() {
    return inputs;
  }
  public Port[] getOutputs() {
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
}
