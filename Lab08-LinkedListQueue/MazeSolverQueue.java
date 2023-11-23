public class MazeSolverQueue extends MazeSolver {


        public MyQueue<Square> worklist;




        public MazeSolverQueue(Maze maze){
            super(maze);
            worklist = new MyQueue<Square>();
            worklist.offer(maze.getStart());

        }


        @Override
        void makeEmpty() {

            worklist = new MyQueue<Square>();

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

            worklist.offer(s);

        }

        @Override
        Square next() {
            Square x = worklist.poll();

            return x;


        }









}
