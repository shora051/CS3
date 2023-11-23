public class MazeSolverStack extends MazeSolver{

    public MyStack worklist;
    public MazeSolverStack(Maze maze){
        super(maze);
        worklist = new MyStack();
        worklist.push(maze.getStart());

    }

  
    @Override
    void makeEmpty() {

       worklist = new MyStack();

    }

    @Override
    boolean isEmpty() {

        if (MazeSolver.start == 1){
            return false;
        }
        else return worklist.isEmpty();

    }

    @Override
    void add(Square s) {
        
        worklist.push(s);
    
    }

    @Override
    Square next() {
        Square x = worklist.pop();
       
       return x;


    }
}
