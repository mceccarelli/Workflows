// This is the DataProduct class.
package model;
public class DataProduct {
  // The parts of a DataProduct
  private String id;
  private String value;
  private String type;

  // Constructor for the class
  public DataProduct(String id, String value, String type) {
    this.id = id;
    this.value = value;
    this.type = type;
  }

  // Getter methods for the variables
  public String getID() {
    return id;
  }
  public String getValue() {
    return value;
  }
  public String getType() {
    return type;
  }
}
