// This is the DataProduct class.

public class DataProduct<T> {
  // The parts of a DataProduct
  private String id;
  private T value;

  // Constructor for the class
  public DataProduct(String id, T value) {
    this.id = id;
    this.value = value;
  }

  // Getter methods for the variables
  public String getID() {
    return id;
  }
  public T getValue() {
    return value;
  }
}
