package jbs2011pa3;

public class Main 
{
	public static void main (String arrrrrrgs[])
	{
		Disk disk = new Disk(5,6,7);
		disk.testThis();
	    
		System.out.println();
	    Game g = new Game();
	    g.load("1");
	    g.TestThis();
	    	    
	    System.out.println();
	    System.out.println("I Flung the 1st disk");
	    Game.getDisks().get(0).fling(15, 15);
	    System.out.println();
	    g.TestThis();
	    
	    System.out.println();
	    System.out.println("I Flung the 2nd disk");
	    Game.getDisks().get(0).fling(15, 15);
	    System.out.println();
	    g.TestThis();
	    
	    
	    System.out.println();
	    System.out.println("I Flung the 3rd disk");
	    Game.getDisks().get(0).fling(9, 9);
	    System.out.println();
	    g.TestThis();
	}
}
