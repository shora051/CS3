import java.lang.String;

public class Square {

    private  int type;

    private int row;

    private int col;

    public char status;

    public  boolean checked = false;
    public static final char onList = 'O';
    public static final char explored = '.';


    public boolean onWorklist;
    public static final int wall = 1;
    public static final int empty = 0;
    public static final int start = 2;
    public static final int exit = 3;   

    public Square(int r, int c, int t){
        row = r;
        col = c;
        type = t;
        if (type == 0){
            status = '_';
        }
    }

    public String toString(){
        if (type == 1){
            return "#";
        }
        else if (type == 2){
            return "S";
        }
        else if (type == 3){
            return "E";
        }
        
        return String.valueOf(status);



        



        

    }

    public boolean equals(Square obj){
        if (obj.row == this.row && obj.col == this.col){
            return true;
        }
        return false;
    }
    public int getRow(){
        return row;

    }
    public int getCol(){
        return col;
    }
    public int getType(){
        return type;
    }
    public char getStatus(){
        return status;
    }
    public void setStatus(int x){
        if (status == 0){
            status = '.';
        }
        if (status == 1){
            status = '0';

        }
        

    }
    public void reset(){
        status = '_';
        checked = false;

    }





}