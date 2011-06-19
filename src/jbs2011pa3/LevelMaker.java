package jbs2011pa3;

import java.util.LinkedList;

import jbs2011pa3.Disk;
import jbs2011pa3.Square;
import jbs2011pa3.Jewel;

public class LevelMaker
{
	LinkedList<Square> squares = new LinkedList<Square>();
	LinkedList<Jewel> jewels = new LinkedList<Jewel>();
	LinkedList<Disk> Disks = new LinkedList<Disk>();
	
	long timeLimit;
	public LevelMaker(String levelstring, long timeLimit, int disks)
	{
		this.timeLimit = timeLimit;
		/**
		 * Creates the number of disks with a specific radius
		 */
		for(int i=0; i < disks; i++)
		{
			Disks.add(new Disk(5,5,5));
		}
		/**Splits the string into objects, with the # being the divider
		 * between each object. These are all represented by the array
		 */

		String[] objects = levelstring.split("#");
		for (int i = 0; i < objects.length; i++){
			String obj = objects[i];
			String[] objel = obj.split("%"); //object elements
			
			
			double x = Double.parseDouble(objel[0]);
			double y = Double.parseDouble(objel[1]);
			double width = Double.parseDouble(objel[2]);
			int type = Integer.parseInt(objel[3]);
			
			if(type == 1)
			{
				squares.add(new Square(x,y,width));
			}
			else if(type == 2)
			{
				jewels.add(new Jewel(x,y,width));
			}
		}
	}

	public LinkedList<Square> getSquares()
	{
		return squares;
	}
	public LinkedList<Jewel> getJewel()
	{
		return jewels;
	}
	public LinkedList<Disk> getDisks()
	{
		return Disks;	
	}
	public long getTimeLimit()
	{
		return timeLimit;
	}
	public void testThis()
	{
		System.out.println("Testing LevelMaker");
		System.out.println("TimeLimit " + getTimeLimit() + " milliseconds");
		System.out.println("# of disks " + getDisks().size());
	}
}
