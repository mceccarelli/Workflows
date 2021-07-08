// This is the Port class.
package model;
public class Port<T> {
  // The parts of a Port
  private int number;
  private String id;
  // private String type;

  // Constructor for a Port
  public Port(String id, int number/*, String type*/) {
    this.id = id;
    this.number = number;
    // this.type = type;
  }

  // toString overriding
  public String toString() {
    return id + number + ": " + "TYPE";// T.getClass().getSimpleName();
  }

  // Getter methods for the class
  public int getNumber() {
    return number;
  }
  public String getID() {
    return id;
  }
  /*
  public String getType() {
    return type;
  }
  */
}
