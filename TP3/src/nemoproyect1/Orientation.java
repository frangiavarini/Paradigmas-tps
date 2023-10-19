package nemoproyect1;

public abstract class Orientation  {// cambiar por direction y hacer oficial de direccion
	
	public abstract Orientation turnRight();
	public abstract Orientation turnLeft();
	public abstract Coordinate forward(Submarine nemo);
	
	
//	String directedTo;
//	
//	public Orientation() {
//		directedTo = "N";
//	}
//	
//	public Orientation(String cardinalPoint) {
//		directedTo = cardinalPoint;
//	}
//	
//	
//	public Orientation spinLeft() {
//		
//		if (directedTo == "N"){
//			directedTo = "W";
//			return this;
//		}
//		if (directedTo == "E") {
//			directedTo = "N";
//			return this;
//		}
//		if (directedTo == "S") {
//			directedTo = "E";
//			return this;
//		}
//		if (directedTo == "W") {
//			directedTo = "S";
//			return this;
//		}
//		return this;
//	}
//	
//	public Orientation spinRight () {
//		if (directedTo == "N"){
//			directedTo = "E";
//			return this;
//		}
//		if (directedTo == "E") {
//			directedTo = "S";
//			return this;
//		}
//		if (directedTo == "S") {
//			directedTo = "W";
//			return this;
//		}
//		if (directedTo == "W") {
//			directedTo = "N";
//			return this;
//		}
//		return this;
//	}
//	

	
}

