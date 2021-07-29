// This is the Port class.
package model;

public class Port {
  // The parts of a Port
  private int number;
  private char id;
  private String type;

  // Constructor for a Port
  public Port(char id, int number, String type) {
    this.id = id;
    this.number = number;
    this.type = type;
  }

  // toString overriding
  public String toString() {
    return getID() + ": " + getType();
  }

  // Getter methods for the class
  public int getNumber() {
    return number;
  }
  public String getID() {
    return (String)(id + "p" + number);
  }
  public String getType() {
    return type;
  }
}
