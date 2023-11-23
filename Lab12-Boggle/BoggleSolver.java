import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import java.util.Scanner;
import java.io.*;
public class BoggleSolver
{
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
    private HashSet<String> wordz = new HashSet<String>();
    private HashSet<String> goodWords = new HashSet<String>();
    public BoggleSolver(String dictionaryName) throws FileNotFoundException
    {
        //TODO

        wordz = new HashSet<>();
        Scanner scan = new Scanner(new File(dictionaryName));
        while (scan.hasNext()){
            wordz.add(scan.next());

        }


    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        //TODO

        for (int i = 0;  i < board.rows(); i++){
            for (int j = 0; j < board.cols(); j++){
                helpWordsPlz(board, i, j, "", new boolean[board.rows()][board.cols()]);
            }

        }
        return goodWords;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)

    public void helpWordsPlz(BoggleBoard board, int x, int y, String rn, boolean[][] used ){
        
        used[x][y] = true; 
        String add= ""; 
        if (board.getLetter(x, y) == 'Q'){
            add = "U";
        }
        
        
        rn += board.getLetter(x, y) + add;
        if (wordz.contains(rn) && rn.length() >= 3){
            goodWords.add(rn);

        }
        
        int[]xs = {-1, 0, 1,-1, 1, -1, 0, 1};
        int[]ys = {-1, -1, -1, 0, 0, 1, 1, 1};
        
        for (int i = 0; i < xs.length; i++){
            int newx = x + xs[i];
            int newy = y + ys[i];

            if (newx >= 0 && newx < board.rows() && newy >= 0 && newy < board.cols() && !used[newx][newy]){
                
                used[newx][newy] = false;
                helpWordsPlz(board, newx, newy, rn, used);
            }
        }
        rn = "";
        used[x][y] = false;

    }
    public int scoreOf(String word)
    {
        //TODO
        if (word.length() >= 8){
            return 11;

        }
        else if (word.length() >= 3 && word.length() <= 4){
            return 1;
        }
        else if (word.length() == 5){
            return 2;
        }
        else if (word.length() == 6){
            return 3;
        }
        else if (word.length() == 7){
            return 5;
        }
        
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("WORKING");

        final String PATH   = "./data/";
        BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");

        BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");
        
        int totalPoints = 0;

        for (String s : solver.getAllValidWords(board)) {
            System.out.println(s + ", points = " + solver.scoreOf(s));
            totalPoints += solver.scoreOf(s);
        }

        System.out.println("Score = " + totalPoints); //should print 84

        //new BoggleGame(4, 4);
    }

}