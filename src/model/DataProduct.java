// This is the DataProduct class.
package model;

public class DataProduct<T> extends Port {
  // The parts of a DataProduct
  private T value;

  // Constructor for the class
  public DataProduct(char id, int number, T value, String type) {
    super(id, number, type);
    this.value = value;
  }

  // toString overriding
  public String toString() {
    return getID() + ": " + getType() + " = " + value;
  }

  // Getter methods for the variables
  public T getValue() {
    return value;
  }
}

/*
public class DataProduct<T> {
  // The parts of a DataProduct
  private char id;
  private int number;
  private T value;
  private String type;

  // Constructor for the class
  public DataProduct(char id, int number, T value, String type) {
    this.id = id;
    this.number = number;
    this.value = value;
    this.type = type;
  }

  // toString overriding
  public String toString() {
    return id + ": " + type + " = " + value;
  }

  // Getter methods for the variables
  public String getID() {
    return (String)(id + "p" + number);
  }
  public int getNumber() {
    return number;
  }
  public T getValue() {
    return value;
  }
  public String getType() {
    return type;
  }
}
*/
