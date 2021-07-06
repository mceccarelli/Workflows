// Adjacency Matrix representation for Directed Acyclic Graph in Java
// Code adapted from https://www.programiz.com/dsa/graph-adjacency-matrix
public class Input {
  private boolean adjMatrix[][];
  private int numOfTasks;
  // Initialize the matrix
  public Input(int numOfTasks) {
    this.numOfTasks = numOfTasks;
    adjMatrix = new boolean[numOfTasks][numOfTasks];
  }
  // Add edges
  public void addEdge(int i, int j) {
    if (i != j)
      adjMatrix[i][j] = true;    
    else
      adjMatrix[i][j] = false; 
  }
  // Remove edges
  public void removeEdge(int i, int j) {
    adjMatrix[i][j] = false;    
  }
  // Print the matrix
  public String generateSubscript(int i) {
    StringBuilder sb = new StringBuilder();
    for (char ch : String.valueOf(i).toCharArray()) {
      sb.append((char) ('\u2080' + (ch - '0')));
    }
    return sb.toString();
  }
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < numOfTasks; i++) {
      s.append("t" + generateSubscript(i) + ": ");
      for (boolean j : adjMatrix[i]) {
        s.append((j ? 1 : 0) + " "); // if true then 1 else 0
      }
      s.append("\n");
    }
    return s.toString();
  }
  public static void main(String args[]) {
    Input w = new Input(6);
    w.addEdge(0, 1);
    w.addEdge(0, 2);
    w.addEdge(1, 3);
    w.addEdge(2, 4);
    w.addEdge(3, 5);
    w.addEdge(4, 5);
    System.out.print(w.toString());

  }
}