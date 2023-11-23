import java.util.ArrayList;

public abstract class MazeSolver {

    private Maze maze;
    boolean isSolved = false;
    boolean isSolvale = true;
    public static int start = 0;
    public MazeSolver(Maze maze){
        this.maze = maze;
        makeEmpty();

    }

    abstract void makeEmpty();


    abstract boolean isEmpty();

    abstract void add(Square s);

    abstract Square next();

    boolean isSolved(){
        if (isSolved){
            return true;
        }
        if (isEmpty()){
            return true;
        }
        return false;
    }
    void step(){
        if (!isEmpty()) {
            
            Square next = next();
            next.status = Square.explored;
            System.out.println(next);
            if (!next.equals(maze.getExit())) {
                ArrayList<Square> neighs = maze.getNeighbors(next);
                for (int i = neighs.size() - 1; i >= 0; i--) {
                    if (neighs.get(i).getType() == 1 || neighs.get(i).checked) {
                      
                        
                        
                        neighs.remove(i);
                    }


                }
                
                for (int i = 0; i < neighs.size(); i++) {
                    neighs.get(i).status = Square.onList;
                    add(neighs.get(i));
                   
                    
                    
                }
                next.checked = true;
                
            } else isSolved = true;
        }

    }
    String getPath(){
        if (!isSolved()){
            return "Not Solved";
        }
        else if (this.isSolved) {
            return "Solved!";

        }
        return "Unsolvable..";


    }

    void solve(){
        while (!isSolved()){
            step();
        }
    }












}
