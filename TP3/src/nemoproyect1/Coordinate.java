package nemoproyect1;

public class Coordinate {
	int coordX;
	int coordY;
	int coordZ; 
	public Coordinate() {
		coordX = 0;
		coordY = 0;
		coordZ = 0;
	}
	
	public Coordinate(int x, int y) {
		coordX = x;
		coordY = y;
		coordZ = 0;
	}
	
	
	
	public Coordinate suma(Coordinate anotherCoord) {
		int newX = this.coordX + anotherCoord.coordX;
		int newY =  this.coordY + anotherCoord.coordY;
		Coordinate newCoord = new Coordinate(newX,newY);
		return newCoord;
	}
	

	public boolean getRidOfBrownie() {
		if (coordZ == 0 || coordZ == -1) {
			return true;
		}
		
		return false;
	
	}
	
}

