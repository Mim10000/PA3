package jbs2011pa3;

public class Disk 
{
	final static double GRAVITY = 9.8;
	double InitialY;
	double InitialX;
	double x;
	double y;
	double radius;
	//double vVelocity;
	//double hVelocity;
	long currentTime;
	long time;
		
	public Disk(double x, double y, double radius)
	{
		this.InitialX = x;
		this.InitialY = y;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public void fling(double IvVelocity, double  IhVelocity)
	{		
		//removes a disk from the game
		Game.getDisks().remove(0);
		
		currentTime = System.currentTimeMillis();
		while(y > 0 && !CollideSquare() && !CollideStaticDisk() && !CollideJewel())
		{
			time = System.currentTimeMillis();
			time = (time-currentTime)/1000 + 1;
			y =  (IhVelocity*time)-(.5*GRAVITY * Math.pow(time,2))+InitialY;
			x =  (IvVelocity)*time+InitialX;
			System.out.println("x," + x + " y, " + y + " Time " + time);
		}
	}
	/**
	 * Square to Circle collision creates new Static Disk
	 */
	public boolean CollideSquare()
	{
		for (int i=0;  i < Game.getSquares().size(); i++)
		{
			if (Math.abs(x - Game.getSquares().get(i).getX()) <= (Game.getSquares().get(i).getWidth()/2) + radius)
			{
				Game.addSDisk(x,y,radius);
				return true;
			}
			else if (Math.abs(y - Game.getSquares().get(i).getY()) <= (Game.getSquares().get(i).getWidth()/2 + radius))// then collision
			{
				Game.addSDisk(x,y,radius);
				return true;
			}
		}
	return false;
	}
	public boolean CollideStaticDisk()
	{
		for (int i=0;  i < Game.getSDisks().size(); i++)
		{
			/**
			 * Determines whether a circle collides with another circle makes a new static disk
			 */
			 final double a = radius + Game.getSDisks().get(i).getRadius();
			 final double dx = x - Game.getSDisks().get(i).getX();
			 final double dy = y - Game.getSDisks().get(i).getY();
			 //System.out.println("First" + a * a);
			 //System.out.println("Second" + dx * dx + dy * dy);
			 if ( a * a > (dx * dx + dy * dy))
			 {
				 Game.addSDisk(x,y,radius);
				 return true;
			 }
		}
			return false;
	}
	/**
	 * Square to Circle collision gets rid of Jewel
	 */
	public boolean CollideJewel()
	{
		for (int i=0;  i < Game.getJewels().size(); i++)
		{
				if (Math.abs(x - Game.getJewels().get(i).getX()) <= (Game.getJewels().get(i).getWidth()/2) + radius)
				{
					Game.getJewels().remove(i);
					return true;
				}
				else if (Math.abs(y - Game.getJewels().get(i).getY()) <= (Game.getJewels().get(i).getWidth()/2 + radius))// then collision
				{
					Game.getJewels().remove(i);
					return true;
				}
		}
		return false;
	}
	
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getRadius()
	{
		return radius;
	}
	
	
	public void testThis()
	{
		System.out.println("Radius " + getRadius());
		System.out.println("X " + getX()+ " , " +"Y " + getY());
	}
}
