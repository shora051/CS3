

//import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


 class Node {
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
public class HuffmanTree {
   Node root;
  char ender = (char) 300;
  char sub = '~';

  public HuffmanTree(int[] count) {
     maketree(count);
  }
  void maketree(int[] count) {
    Queue<Node> pq = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.weight, node2.weight));
    for (int i = 0; i < count.length; ++i) {
      if (count[i] > 0)
        pq.add(new Node((char) i, count[i]));
    }
    pq.add(new Node(ender, 1));
    while (pq.size() > 1) {
      Node l = pq.poll(), r = pq.poll();
      Node k = new Node(sub, l.weight + r.weight);
      k.left = l;
      k.right = r;
      pq.add(k);
    }
    root = pq.poll();
    TreePrinter.printTree(root);
  }

  public HuffmanTree(String filename) {
    Queue<Node> bfs = new LinkedList<>();
    try {
      root = null;
      Scanner scan = new Scanner(new File(filename));

      while(scan.hasNext()) {
        char letter = scan.nextLine().toCharArray()[0];
        int val = Integer.parseInt(scan.nextLine());
        Node k = new Node(letter, val);
        if(root == null) root = k;
        else {
          if(bfs.peek().left == null) bfs.peek().left = k;
          else bfs.peek().right = k;
        }
        bfs.add(k);
      }
    } catch(Exception ex) {}
  }

  void decode(BitInputStream in, String outfile) {
    try {
      PrintWriter p = new PrintWriter(new File(outfile));
      Node cur = root;
      while(true) {
        int x = in.readBit();
        if(x == 1) cur = cur.right;
        else cur = cur.left;

        if((int)cur.c == ender) break;
        else if(cur.c != sub) {
          p.write(cur.c);
          cur = root;
        }
      }
      
    } catch(Exception ex) {}
  }

  void write(String filename) {
    try {
      Scanner output = new Scanner(new File(filename));
      Queue<Node> bfs = new LinkedList<>();
      bfs.add(root);

      while(bfs.size() > 0) {
        System.out.println(bfs.peek().c);
        System.out.println(bfs.peek().weight);
        if(bfs.peek().left != null) bfs.add(bfs.peek().left);
        if(bfs.peek().right != null) bfs.add(bfs.peek().right);
      }
    } catch(Exception ex) {}
  }

  void compress(String filename) {
    int[] res = new int[256];
    try {
      Scanner s = new Scanner(new File(filename));
      while(s.hasNext()) {
        String k = s.next();
        for(char c : k.toCharArray())
          ++res[c];
      }

      maketree(res);
      write(filename + ".short");
    } catch(Exception ex) {}
  }

  void expand(String codeFile, String FileName) {
    decode(new BitInputStream(codeFile), FileName);
  }

}


class BitOutputStream {
  private FileOutputStream output;
  private int digits;     // a buffer used to build up next set of digits
  private int numDigits;  // how many digits are currently in the buffer

  private static final int BYTE_SIZE = 8;  // digits per byte

  // pre : given file name is legal
  // post: creates a BitOutputStream sending output to the file
  public BitOutputStream(String file) {
    try {
      output = new FileOutputStream(file);
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
    digits = numDigits = 0;
  }

  // post: writes given bit to output
  public void writeBit(int bit) {
    if (bit < 0 || bit > 1)
      throw new IllegalArgumentException("Illegal bit: " + bit);
    digits += bit << numDigits;
    numDigits++;
    if (numDigits == BYTE_SIZE)
      flush();
  }

  // post: Flushes the buffer.  If numDigits < BYTE_SIZE, this will 
  //       effectively pad the output with extra 0's, so this should
  //       be called only when numDigits == BYTE_SIZE or when we are
  //       closing the output.
  private void flush() {
    try {
      output.write(digits);
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
    digits = 0;
    numDigits = 0;
  }

  // post: output is closed
  public void close() {
    if (numDigits > 0)
      flush();
    try {
      output.close();
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
  }

  // included to ensure that the stream is closed
  protected void finalize() {
    close();
  }
}

class BitInputStream {
  private FileInputStream input;
  private int digits; // next set of digits (buffer)
  private int numDigits; // how many digits from buffer have been used

  private static final int BYTE_SIZE = 8; // digits per byte

  // pre : given file name is legal
  // post: creates a BitInputStream reading input from the file
  public BitInputStream(String file) {
    try {
      input = new FileInputStream(file);
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
    nextByte(); // grab the next 8 bits from the file
  }

  // post: reads next bit from input (-1 if at end of file)
  public int readBit() {
    // if at eof, return -1
    if (digits == -1)
      return -1;
    int result = digits % 2;
    digits /= 2;
    numDigits++;
    if (numDigits == BYTE_SIZE)
      nextByte();
    return result;
  }

  // post: refreshes the internal buffer with the next BYTE_SIZE bits
  private void nextByte() {
    try {
      digits = input.read();
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
    numDigits = 0;
  }

  // post: input is closed
  public void close() {
    try {
      input.close();
    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
  }

  // included to ensure that the stream is closed
  protected void finalize() {
    close();
  }
}

class TreePrinter {
  /**
   * print the tree in a tree-like form
   * 
   * @param root the overall root of the tree
   */
  public static void printTree(Node root) {
    int maxLevel = TreePrinter.maxLevel(root);

    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
  }

  private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
    if (nodes.isEmpty() || TreePrinter.isAllElementsNull(nodes))
      return;

    int floor = maxLevel - level;
    int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

    TreePrinter.printWhitespaces(firstSpaces);

    List<Node> newNodes = new ArrayList<>();
    for (Node node : nodes) {
      if (node != null) {
        System.out.print(node);
        newNodes.add(node.left);
        newNodes.add(node.right);
      } else {
        newNodes.add(null);
        newNodes.add(null);
        System.out.print(" ");
      }

      TreePrinter.printWhitespaces(betweenSpaces);
    }
    System.out.println("");

    for (int i = 1; i <= endgeLines; i++) {
      for (int j = 0; j < nodes.size(); j++) {
        TreePrinter.printWhitespaces(firstSpaces - i);
        if (nodes.get(j) == null) {
          TreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
          continue;
        }

        if (nodes.get(j).left != null)
          System.out.print("/");
        else
          TreePrinter.printWhitespaces(1);

        TreePrinter.printWhitespaces(i + i - 1);

        if (nodes.get(j).right != null)
          System.out.print("\\");
        else
          TreePrinter.printWhitespaces(1);

        TreePrinter.printWhitespaces(endgeLines + endgeLines - i);
      }

      System.out.println("");
    }

    printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++)
      System.out.print(" ");
  }

  private static int maxLevel(Node node) {
    if (node == null)
      return 0;

    return Math.max(TreePrinter.maxLevel(node.left), TreePrinter.maxLevel(node.right)) + 1;
  }

  @SuppressWarnings("rawtypes")
  private static boolean isAllElementsNull(List list) {
    for (Object object : list) {
      if (object != null)
        return false;
    }

    return true;
  }
}