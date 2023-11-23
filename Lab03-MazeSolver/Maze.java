import java.io.*;

import java.util.*;

public class Maze {

    private Square[][] maze;

    private Square start;

    private Square exit;

    public Maze() {

    }

    public boolean loadMaze(String filename) {
        File mazeFile = new File(filename);
        Scanner input = null;

        try {
            input = new Scanner(mazeFile);
        } catch (IOException e) {
            System.out.println("Can't find file!");
        }
        int row = input.nextInt();
        int col = input.nextInt();
        maze = new Square[row][col];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                int x = input.nextInt();

                maze[i][j] = new Square(i, j, x);
                if (x == 2){
                    start = maze[i][j];
                }
                else if (x == 3){
                    exit = maze[i][j];
                }

            }

        }


        return true;

    }


    public ArrayList<Square> getNeighbors(Square s){
        ArrayList<Square> listo = new ArrayList<Square>();

        int[] r= {-1, 0, 1, 0};
        int[] c= {0, 1, 0, -1};

        for (int i = 0; i < 4; i++){

            if ((s.getRow() + r[i]) >= 0 && (s.getRow() + r[i]) < maze.length &&(s.getCol() + c[i]) >= 0 && (s.getCol() + c[i]) < maze[0].length  ) {
                listo.add(maze[s.getRow() + r[i]][s.getCol() + c[i]]);
            }
        }
        return listo;

    }

    public Square getStart(){
        return start;
    }

    public Square getExit(){
        return exit;
    }

    public void reset(){
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                maze[i][j].reset();
            }
        }
    }
    public String toString(){
        String msg = "";
        for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[0].length; j++){
                msg += maze[i][j].toString() + " ";
            }
            msg += "\n";
        }
        return msg;
    }
    public static void main(String[] args) {
         Maze one = new Maze();
         one.loadMaze("maze-7");

         System.out.println(one);

         System.out.println(one.getExit());
         System.out.println(one.getStart());
         System.out.println(one.getNeighbors(one.getStart()));

    }


}