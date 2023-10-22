package nemoproyect1;

public class SouthOrientation extends Orientation{
	public String direction = "South";
	
	public Orientation turnRight() {
		return new WestOrientation();
	}
	
	public Orientation turnLeft() {
		return new EastOrientation();
	}


	public Coordinate forward(Submarine nemo) {

		return nemo.coordinates.suma(new Coordinate(0,-1));	
		
	}

	public String getDirection() {
		return direction;
	}
}
