// This is the DataProduct class.
package model;

public class DataProduct extends Port {
  // The parts of a DataProduct
  private String value;

  // Constructor for the class
  public DataProduct(int number, String value, String type) {
    super('d', number, type);
    this.value = value;
  }

  // toString overriding
  public String toString() {
    return getID() + ": " + getType() + " = " + value;
  }

  // Getter methods for the variables
  public String getValue() {
    return value;
  }
}
