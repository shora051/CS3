import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 0);
	}

	public Ammo(int x, int y, int s)
	{
		super(x, y);
		speed = s;
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw(Graphics window)
	{
	    window.setColor(Color.YELLOW);
	    window.fillRect(getX(), getY(), 10, 10);
	}
	
	
	public void move( String direction )
	{
		if(direction.equals("RIGHT"))
        {
            super.setX(super.getX() + speed);
        }
        if(direction.equals("LEFT"))
        {
            super.setX(super.getX() - speed);
        }
        if(direction.equals("UP"))
        {
            super.setY(super.getY() - speed);
        }
        if(direction.equals("DOWN"))
        {
            super.setY(super.getY() + speed);
        }
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
