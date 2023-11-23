import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
   public SnowFlakePanel()
   {
       super.setPreferredSize(new Dimension(400, 400));
       super.setBackground(Color.WHITE);
   }

   public  void drawStar(Graphics g, int x, int y, int size){



       for (int i = 0; i < 6; i++){
           double ang = Math.toRadians(60*i);
           double xchange = x + Math.cos(ang)*size;
           double ychange = y + Math.sin(ang)*size;
           g.drawLine(x, y, (int) (xchange), (int) (ychange));
           if (size > 0){
               drawStar(g, (int) (xchange), (int)(ychange),size/4 );
           }

       }

   }

   public void paintComponent(Graphics g)
   {
       int width  = getWidth();
       int height = getHeight();

       super.paintComponent(g);

       /*
        * DRAWING CODE BELOW
        */
       g.setColor(Color.BLUE);
	   for (int i = 0; i < 10; i++){
		Random rand = new Random();
		float r = rand.nextFloat();
		float e = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, e, b);
		g.setColor(randomColor);
	   	drawStar(g, (int)(Math.random()*(width-1))+1, (int)(Math.random()*(height-1))+1, (int)(Math.random()*25));
	   }

   }


}

public class Snowflake
{
   public static void main ( String[] args )
   {
       
        
       JFrame frame = new JFrame("Snowflake");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(new SnowFlakePanel());
       frame.pack();
       frame.setVisible(true);
   }


}

