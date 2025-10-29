/*
* Class: CMSC 203 CRN 22608
* Instructor: Ahmed Tarek
* Description: A property management company manages individual properties they will build to rent, and charges
them a management fee as the percentages of the monthly rental amount. The properties cannot overlap
each other, and each property must be within the limits of the management company’s plot. Write an
application that lets the user create a management company and add the properties managed by the
company to its list.
* Due: 10/28/2025
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming
* assignment independently. I have not copied the code
* from a student or any source. I have not given my code
* to any student.
Print your Name here: Leo Chen
*/

public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	
	public Plot() {
		x = 0;
		y = 0;
		depth = 1;
		width = 1;
	}
	
	public Plot(int x, int y, int depth, int width) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	public Plot(Plot other) { //copy constructor
		x = other.getX();
		y = other.getY();
		depth = other.getDepth();
		width = other.getWidth();
	}
	
	public void setX(int x) {this.x = x;}
	
	public void setY(int y) {this.y = y;}
	
	public void setDepth(int depth) {this.depth = depth;}
	
	public void setWidth(int width) {this.width = width;}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	public int getDepth() {return depth;}
	
	public int getWidth() {return width;}
	
	public boolean overlaps(Plot plot) {
	    return x < plot.getX() + plot.getWidth() && x + width > plot.getX() && y < plot.getY() + plot.getDepth() &&
	           this.y + this.depth > plot.getY();
	}
	
	public boolean encompasses(Plot plot) {
	    return this.x <= plot.getX() && y <= plot.getY() && x + width >= plot.getX() + plot.getWidth() && y + depth >= plot.getY() + plot.getDepth();
	}
	
	public String toString() {
		return x + "," + y + "," + depth + "," + width; 
	}

}