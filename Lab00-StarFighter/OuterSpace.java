import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
    private Ship ship;
    private Alien alienOne;
    private Alien alienTwo;
    private Ammo ammo;
     
    private AlienHorde horde;
    private Bullets shots;
    

    private boolean[] keys;
    private BufferedImage back;

    public OuterSpace()
    {
        setBackground(Color.black);

        keys = new boolean[5];

        //instantiate other instance variables
        //Ship, Alien
        ship= new Ship(350, 400, 100, 100, 2);
        //alienOne = new Alien(200, 100, 50, 50, 3);
        //alienTwo = new Alien(275, 100, 50, 50, 3);
        ammo = new Ammo((ship.getX() + ship.getWidth() / 2)- 5, ship.getY()-5, 1);
        shots = new Bullets();
        horde = new AlienHorde(6);
        horde.add(new Alien(350, 100, 50, 50, 1));
        horde.add(new Alien(300, 100, 50, 50, 1));
        horde.add(new Alien(250, 100, 50, 50, 1));
        horde.add(new Alien(200, 100, 50, 50, 1));
        horde.add(new Alien(150, 100, 50, 50, 1));
        horde.add(new Alien(100, 100, 50, 50, 1));

        this.addKeyListener(this);
        new Thread(this).start();

        setVisible(true);
    }

   public void update(Graphics window)
   {
       paint(window);
   }

    public void paint( Graphics window )
    {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D)window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if(back==null)
           back = (BufferedImage)(createImage(getWidth(),getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("StarFighter ", 25, 50 );
        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0,0,800,600);
        ship.draw(graphToBack);
        //alienOne.draw(graphToBack);
        //alienTwo.draw(graphToBack);
        shots.drawEmAll(graphToBack);
        shots.moveEmAll();
        horde.drawEmAll(graphToBack);
        horde.moveEmAll();
        if(keys[0] == true){
           if(ship.getX() > 10)
           {
               ship.move("LEFT");
           }
        }
        if(keys[1] == true)
        {
            if(ship.getX() < 700)
            {
               ship.move("RIGHT");
            }
        }
        if(keys[2] == true){
            if(ship.getY() > 10)
            {
               ship.move("UP");
            }
         }
        if(keys[3] == true){
            if(ship.getY() < 500)
            {
                  ship.move("DOWN");
            } 
        }
        if(keys[4] == true)
        {
            Ammo shot = new Ammo(ship.getX()+28, ship.getY(), 3);
            shots.add(shot);
            horde.removeDeadOnes(shots.getList());
            keys[4]=false;
        }
        //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
        twoDGraph.drawImage(back, null, 0, 0);
    }


    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            keys[4] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e)
    {
      //no code needed here
    }

   public void run()
   {
    try
    {
        while(true)
        {
           Thread.currentThread().sleep(5);
           ammo.move("UP");
            repaint();
         }
      }catch(Exception e)
      {
      }
    }
}
