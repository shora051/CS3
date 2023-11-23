public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */

    public void solve()
    {
        // student code here
        for (int i = 0; i < SIZE; i++){
            if (myGrid[SIZE-1][i].getStatus() == 1){
                myGrid[SIZE-1][i].setStatus(2);
            }

        }
        boolean done = false;
        for (int i = 0; i < SIZE; i++){
            if (myGrid[SIZE-1][i].getStatus()==2){
                if(firetree(46, i)){
                    System.out.println("Onett is in trouble!");
                    done = true;
                }
            }
        }
        if (!done){
            System.out.println("Onett is safe");
        }
        myView.updateView(myGrid);
    }

    public boolean firetree(int x, int y){
        boolean dead = false;
        myGrid[x][y].setStatus(2);
        if (x == 0){
            return true;
        }
        int[]xs = {-1,0,1,0};
        int[]ys = {0,1,0,-1};
        
        for (int i = 0; i < 4; i++){
            int new_x = x+xs[i];
            int new_y = y+ys[i];
            
            if (new_x >= 0 && new_x < SIZE && new_y > 0 && new_y < SIZE && myGrid[new_x][new_y].getStatus()==1){
                dead = dead|firetree(new_x, new_y);
            }
        }
        return dead;

    }

}
