package nemoproyect1;

public class Coordinate {
	int coordX;
	int coordY;
	int coordZ; // para la  z hay que hacer uno nuevo, profundidad
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
	
//	public Coordinate modify(String letter, Submarine aSubmarine) { //hacer oficial de posicion
//		
//		if(letter.equals("d")) {
//			coordZ -= 1;
//		}
//		else if(letter.equals("u")) {
//			coordZ += 1;
//		}
//		
//		else if (letter.equals("")) {
//			return this;
//		}
//		
//		else if (letter.equals("f")) {
//			aSubmarine.moveForward();
//			}
//		return this;
//	}
//	
	public boolean getRidOfBrownie() {
		if (coordZ == 0 || coordZ == -1) {
			return true;
		}
		
		return false;
	
	}
	
}

