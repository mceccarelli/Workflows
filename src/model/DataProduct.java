// This is the DataProduct class.
package model;
public class DataProduct<T> {
  // The parts of a DataProduct
  private String id;
  private T value;
  // private String type;

  // Constructor for the class
  public DataProduct(String id, T value/*, String type*/) {
    this.id = id;
    this.value = value;
    // this.type = type;
  }

  // toString overriding
  public String toString() {
    return id + ": " + T.getClass().getSimpleName() + " = " + value;
  }

  // Getter methods for the variables
  public String getID() {
    return id;
  }
  public T getValue() {
    return value;
  }
  /*
  public String getType() {
    return type;
  }
  */
}
