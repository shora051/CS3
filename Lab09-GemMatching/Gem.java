import java.awt.Font;
import java.math.*;
enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	

	private GemType color;
	private int pointValue;

	public Gem(){

		int rand = (int)Math.floor(Math.random()*(3-1+1)+1);
		int[] points = new int[11];
		for (int i = 0; i < 11; i++){
			points[i] = 5*i;
		}
		if (rand == 1){
			this.color = GemType.GREEN;
		}
		else if (rand == 2){
			this.color = GemType.BLUE;
		}
		else {
			this.color = GemType.ORANGE;
		}
		this.pointValue = points[(int)Math.floor(Math.random()*(10-0+1)+0)];



	}
	public Gem(GemType type, int points){
		this.color = type;
		this.pointValue = points;
	}
	public String toString(){
		String msg = "";
		if (color == GemType.GREEN){
			msg += "Green: ";
		}
		else if (color == GemType.BLUE){
			msg += "Blue: ";
		}
		else if (color == GemType.ORANGE){
			msg += "Orange: ";
		}
		msg += pointValue;
		return msg;
	}
	public GemType getType(){
		return color;
	}
	public int getPoints(){
		return pointValue;
	}
	public void draw(double x, double y){
		String filename = "";
		if (color == GemType.GREEN){
			filename += "gem_green.png";
		}
		else if (color == GemType.BLUE){
			filename += "gem_blue.png";
		}
		else if (color == GemType.ORANGE){
			filename += "gem_orange.png";
		}
		StdDraw.picture(x, y, filename);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x, y, String.valueOf(pointValue));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
