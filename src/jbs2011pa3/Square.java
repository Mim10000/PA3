package jbs2011pa3;

public class Square 
{
	double x;
	double y;
	double width;
	public Square(double x, double y, double width)
	{
		this.x = x;
		this.y = y;
		this.width = width;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public double getWidth()
	{
		return width;
	}
	public void testThis()
	{
			System.out.println("Width " + getWidth());
			System.out.println("X " + getX()+ " , " +"Y " + getY());
	}
}
