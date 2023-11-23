import java.util.Stack;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.Set;

public class Word 
{
    private String start;
    private String end;
    private Set<String> tops;
    private boolean isWord;
    private Queue<Stack<String>> stew;

    public Word(String start, String end)
    {
        this.start = start;
        this.end = end;
        tops = new HashSet<>();
        isWord = false;
    }

    public Queue<Stack<String>> makeQueue()
    {
        stew = new LinkedList<>();

        Scanner input = null;
        try {
            input = new Scanner(new File("dictionary.txt"));
        }
        catch (IOException e) {
            System.out.println("Can't find file!");
        }

        while (input.hasNextLine()){
            String word = input.nextLine();
            if (word.toLowerCase().equals(start)){
                isWord = true;
            }
            if (word.length() == start.length()){

                int err = checkDif(word, start);

                if (err == 1){
                    Stack<String> it = new Stack<>();
                    it.push(start);
                    it.push(word);

                    stew.offer(it);

                }
            }

        }
        if (!isWord || start.length() != end.length()){
            System.out.println("There is no word ladder between " + start + " and " + end);
            return null;

        }
        return stew;
    }

    public Stack<String> getLadder()
    {
        if (start.equals(end)){
            Stack<String> give = new Stack<>();
            give.push(start);
            return give;
        }
        if (start.length() != end.length() || !isWord){

            return null;

        }
        while (!stew.isEmpty()){

            Stack<String> top = stew.poll();
            if (top.peek().toLowerCase().equals(end.toLowerCase())){
                return top;

            }
            else {
                String topper = top.peek();
                Scanner input = null;
                try {
                    input = new Scanner(new File("dictionary.txt"));
                }
                catch (IOException e) {
                    System.out.println("Can't find file!");
                }

                while (input.hasNextLine()){
                    String word = input.nextLine();

                    if (!tops.contains(word)){
                        if (word.length() == topper.length() ){
                            int err = checkDif(word, topper);
                            if (err == 1){
                                Stack<String> it = new Stack<>();
                                Stack<String> cor = new Stack<>();
                                int m = top.size();
                                for (int y = 0; y < m; y++){
                                    it.push(top.pop());
                                }
                                for (int y = 0; y < m; y++){
                                    cor.push(it.peek());
                                    tops.add(it.peek());

                                    top.push(it.pop());

                                }
                                cor.push(word);
                                tops.add(word);



                                stew.offer(cor);

                            }
                        }
                    }
                }
            }
        }
        System.out.println("There is no word ladder between " + start + " and " + end);
        return null;
    }

    public int checkDif(String word, String other){
        int err = 0;
        for (int x = 0; x < word.length(); x++){
            if (!(word.substring(x, x+1).equals(other.substring(x,x+1).toUpperCase()))){
                err++;

            }
        }
        return err;
    }
}
