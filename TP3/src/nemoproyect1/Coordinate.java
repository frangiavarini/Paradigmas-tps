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
	
	//implementar suma, add o lo q sea
	
	public Coordinate suma(Coordinate anotherCoord) {
		int newX = this.coordX + anotherCoord.coordX;
		int newY =  this.coordY + anotherCoord.coordY;
		Coordinate newCoord = new Coordinate(newX,newY);
		return newCoord;
	}
	
	public Coordinate modify(String letter, Submarine aSubmarine) { //hacer oficial de posicion
		
		if(letter == "d") {
			coordZ -= 1;
		}
		else if(letter == "u") {
			coordZ += 1;
		}
		
		else if (letter == "") {
			return this;
		}
		
		else if (letter == "f") {
			aSubmarine.moveForward();
			}
		return this;
	}
	
	public boolean getRidOfBrownie() {
		if (coordZ == 0 || coordZ == -1) {
			return true;
		}
		
		return false;
	
	}
	
}

