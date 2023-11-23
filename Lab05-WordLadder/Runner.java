import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
class Runner{


    public static void main(String[] args) 
    {



        Scanner input = null;
        try {
            input = new Scanner(new File("input.txt"));
        } catch (IOException e) {
            System.out.println("Can't find file!");
        }

        while (input.hasNextLine()) {
            Word test = new Word(input.next(), input.next());
            test.makeQueue();
            Stack<String> lad = test.getLadder();
            if (lad != null){
                Stack<String> otra = new Stack<>();

                int x = lad.size();
                for (int i = 0; i < x; i++){

                    otra.push(lad.pop().toLowerCase());

                }
                for (int i = 0; i < x; i++){
                    lad.push(otra.pop().toLowerCase());
                }
                System.out.println("Found a ladder! >>> " + lad);


        }


        }

    }

}
