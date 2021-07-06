// This is the DataChannel class.
package model;
public class DataChannel {
  // The parts of a DataChannel
  private Port in;
  private Port out;
  private DataProduct dp;

  // Constructor for the class
  public DataChannel(Port in, Port out) {
    this.in = in;
    this.out = out;
  }
  public DataChannel(DataProduct in, Port out) {
    this.dp = in;
    this.out = out;
  }

  // toString overriding
  public String toString() {
    if (dp == null) {
      return in.toString() + " | " + out.toString();
    } else {
      return dp.toString() + " | " + out.toString();
    }
  }

  // Getter methods for each part
  public Port getInPort() {
    return in;
  }
  public Port getOutPort() {
    return out;
  }
  public DataProduct getDataProduct() {
    return dp;
  }

}
