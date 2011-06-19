package jbs2011pa3;

import java.util.LinkedList;


public class Game 
{
	static LinkedList <Disk> disks;
	
	long currentTime;
	long timeLimit;
		
	LevelMaker lvl = Levels.lvl1;
	
	static LinkedList<Square> Squares;
	static LinkedList<Jewel> Jewels;
	static LinkedList<StaticDisk> SDisks;
	public Game()
	{
		
	}
	public void load(String level)
	{
		this.timeLimit = lvl.timeLimit;
		Game.disks =  lvl.Disks;
		Game.Squares = lvl.getSquares();
		Game.Jewels = lvl.getJewel();
		Game.SDisks = new LinkedList<StaticDisk>();
	}
	/**
	 * The perameters for actually winning the game
	 */
	public void win()
	{
		if (Jewels.size() == 0 && currentTime < timeLimit)
		{
			System.out.println("You won");
			load("lvl2");
		}
		else if(currentTime < timeLimit && disks.size() > 0)
		{
			System.out.println("Game in Progress");
		}
		else 
		{
			System.out.println("Game Over");
			load("lvl1");
		}
	}
	public static LinkedList<Disk> getDisks()
	{
		return disks;
	}
	public static LinkedList<Square> getSquares()
	{
		return Squares;
	}
	public static LinkedList<Jewel> getJewels()
	{
		return Jewels;
	}
	public static LinkedList<StaticDisk> getSDisks()
	{
		return SDisks;
	}
	
	public static void addSDisk(double x, double y, double width)
	{
		StaticDisk s = new StaticDisk(x,y,width);
		SDisks.add(s);
	}
	
	
	public void TestThis()
	{
		System.out.println("Testing the Game");
		
		System.out.println("Location of the Squares");
		for(int i=0; i < getSquares().size(); i++)
		{
			System.out.println("Square at position " + i + ", X " + getSquares().get(i).getX() + " Y " + getSquares().get(i).getY() + 
						" Width " + getSquares().get(i).getWidth());
		}
		
		System.out.println("Location of the Jewels");
		for(int i=0; i < getJewels().size(); i++)
		{
			System.out.println("Jewel at position " + i + ", X " + getJewels().get(i).getX() + " Y " + getJewels().get(i).getY() + 
					" Width " + getJewels().get(i).getWidth());
		}
		System.out.println("Location of the StaticDisks");
		for(int i=0; i < getSDisks().size(); i++)
		{
			System.out.println("SDisk at position " + i + ", X " + getSDisks().get(i).getX() + " Y " + getSDisks().get(i).getY() + 
					" Radius " + getSDisks().get(i).getRadius());
		}
		win();
	}
}