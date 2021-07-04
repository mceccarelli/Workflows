// This is the Port class.
package model;
public class Port {
  // The parts of a Port
  private String id;
  private String type;

  // Constructor for a Port
  public Port(String id, String type) {
    this.id = id;
    this.type = type;
  }

  // toString overriding
  public String toString() {
    return id + ": " + type;
  }

  // Getter methods for the class
  public String getID() {
    return id;
  }
  public String getType() {
    return type;
  }

}
