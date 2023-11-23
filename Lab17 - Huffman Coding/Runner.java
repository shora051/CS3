class Runner{
  public static void main(String[] args) {
    HuffmanTree t = new HuffmanTree("");
    t.compress("C:/Users/sandy/Desktop/CS3/Lab17 - Huffman Coding/Text Files/happy hip hop.txt");
    System.out.println("121\n" +
            "00\n" +
            "256\n" +
            "010\n" +
            "99\n" +
            "0110\n" +
            "120\n" +
            "0111\n" +
            "97\n" +
            "10\n" +
            "98\n" +
            "11");

  }
}