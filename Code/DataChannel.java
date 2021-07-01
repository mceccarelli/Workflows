// This is the DataChannel class.

class DataChannel {
  // The parts of a DataChannel.

  private Workflow in;
  private Workflow out;
  private Port input;
  private Port output;

  // Getter methods for each part.

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
