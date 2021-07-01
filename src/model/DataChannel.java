// This is the DataChannel class.
package model;
public class DataChannel {
  // The parts of a DataChannel
  private Workflow in;
  private Workflow out;
  private Port input;
  private Port output;

  // Constructor for the class
  public DataChannel(Workflow in, Workflow out, Port input, Port output) {
    this.in = in;
    this.out = out;
    this.input = input;
    this.output = output;
  }

  // Getter methods for each part
  public Workflow getInWorkflow() {
    return in;
  }
  public Workflow getOutWorkflow() {
    return out;
  }
  public Port getInput() {
    return input;
  }
  public Port getOutput() {
    return output;
  }
}
