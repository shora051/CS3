
public class Node {
    public Node(char c, int w) {
      this.c = c;
      this.weight = w;
    }
  
    char c;
    int weight;
    Node right, left;
    public String toString() {
      return "|" + this.c + " " + this.weight + "|";
    }
  
  }