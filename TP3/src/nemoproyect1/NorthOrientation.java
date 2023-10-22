package nemoproyect1;

public class NorthOrientation extends Orientation {
	public String direction = "North";
	
	public Orientation turnRight() {
		return new EastOrientation();
	}
	
	public Orientation turnLeft() {
		return new WestOrientation();
	}

	
	public Coordinate forward(Submarine nemo) {
		
		return nemo.coordinates.suma(new Coordinate(0,1));
	}

	public String getDirection() {
		return direction;
	}
}
