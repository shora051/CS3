import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
    private List<Alien> aliens;

    public AlienHorde(int size)
    {
        aliens = new ArrayList<Alien>(size);
    }

    public void add(Alien al)
    {
        aliens.add(al);
    }

    public void drawEmAll( Graphics window )
    {
        if(aliens.size() > 0)
            for(Alien a: aliens)
                a.draw(window);
    }

    public void moveEmAll()
    {
        if(aliens.size() > 0)
            for(Alien a: aliens)
            {
                if(a.getX() <= 800)
                {
                    if(a.getX() >= 700)
                        a.setX(-20);
                }
                a.move("RIGHT");
            }
    }

    public void removeDeadOnes(List<Ammo> shots)
    {   
        for(Alien a : aliens)
        {
            for(Ammo s: shots)
            {
                if((a.getX() >= s.getX()-50) && (a.getX() <= s.getX()+50) && (a.getY() >= s.getY()-40) && (a.getY() <= s.getY()+40))
                {
                    aliens.remove(a);
                    shots.remove(s);
                }
            }
        }
    }

    public String toString()
    {
        return "";
    }
    
    public List<Alien> getList()
    {
        return aliens;
    }
}
