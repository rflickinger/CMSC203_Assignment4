
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth();
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		int myLeftX = x;
		int myRightX = x + width;
		int myTopY = y;
		int myBottomY = y + depth;
		
		int otherLeftX = plot.getX();
		int otherRightX = plot.getX() + plot.getWidth();
		int otherTopY = plot.getY();
		int otherBottomY = plot.getY() + plot.getDepth();
		
		boolean topLeft1 = false, topRight1 = false, bottomLeft1 = false, bottomRight1 = false, topLeft2 = false, topRight2 = false, bottomLeft2 = false, bottomRight2 = false;
		boolean encompass1 = false, encompass2 = false;
		boolean halfInside1 = false, halfInside2 = false;
		
		//check if top left corner of this is overlapping new plot
		if((myLeftX > otherLeftX && myLeftX < otherRightX) && (myTopY > otherTopY && myTopY < otherBottomY))
			topLeft1 = true;
		
		//check if top right corner of this is overlapping new plot
		if((myRightX > otherLeftX && myRightX < otherRightX) && (myTopY > otherTopY && myTopY < otherBottomY))
			topRight1 = true;
		
		//check if bottom left corner of this is overlapping new plot
		if((myLeftX > otherLeftX && myLeftX < otherRightX) && (myBottomY > otherTopY && myBottomY < otherBottomY))
			bottomLeft1 = true;
		
		//check if bottom right corner of this is overlapping new plot
		if((myRightX > otherLeftX && myRightX < otherRightX) && (myBottomY > otherTopY && myBottomY < otherBottomY))
			bottomRight1 = true;
		
		//check if top left corner of new plot is overlapping this
		if((otherLeftX > myLeftX && otherLeftX < myRightX) && (otherTopY > myTopY && otherTopY < myBottomY))
			topLeft2 = true;
		
		//check if top right corner of new plot is overlapping this
		if((otherRightX > myLeftX && otherRightX < myRightX) && (otherTopY > myTopY && otherTopY < myBottomY))
			topRight2 = true;
		
		//check if bottom left corner of new plot is overlapping this
		if((otherLeftX > myLeftX && otherLeftX < myRightX) && (otherBottomY > myTopY && otherBottomY < myBottomY))
			bottomLeft2 = true;
		
		//check if bottom right corner of new plot is overlapping this
		if((otherRightX > myLeftX && otherRightX < myRightX) && (otherBottomY > myTopY && otherBottomY < myBottomY))
			bottomRight2 = true;
		
		//check if this encompasses new plot
		if(this.encompasses(plot))
			encompass1 = true;
		
		//check if new plot encompasses this
		if(plot.encompasses(this))
			encompass2 = true;
		
		//Check if neither are encompassed, but the left or right line is inside
		if((myTopY == otherTopY && myBottomY == otherBottomY) && ((myLeftX > otherLeftX && myLeftX < otherRightX) || (myRightX > otherLeftX && myRightX < otherRightX)))
			halfInside1 = true;
		
		//Check if neither are encompassed, but the top or bottom line is inside
		if((myLeftX == otherLeftX && myRightX == otherRightX) &&((myTopY > otherTopY && myTopY < otherBottomY) || (myBottomY > otherTopY && myBottomY < otherBottomY)))
			halfInside2 = true;
		
		return topLeft1 || topRight1 || bottomLeft1 || bottomRight1 || topLeft2 || topRight2 || bottomLeft2 || bottomRight2 || encompass1 || encompass2 || halfInside1 || halfInside2;
	}
	
	//takes a Plot instance and determines if the current plot contains it.
	public boolean encompasses(Plot plot) {
		int myLeftX = x;
		int myRightX = x + width;
		int myTopY = y;
		int myBottomY = y + depth;
		
		int otherLeftX = plot.getX();
		int otherRightX = plot.getX() + plot.getWidth();
		int otherTopY = plot.getY();
		int otherBottomY = plot.getY() + plot.getDepth();
		
		return (myLeftX <= otherLeftX) && (myRightX >= otherRightX) && (myTopY <= otherTopY) && (myBottomY >= otherBottomY);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
	
}
