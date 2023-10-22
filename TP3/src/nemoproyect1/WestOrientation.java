package nemoproyect1;

public class WestOrientation extends Orientation{

	public String direction = "West";
	
	public Orientation turnRight(){
		return new NorthOrientation();
	}
	
	public Orientation turnLeft() {
		return new SouthOrientation();
	}


	public Coordinate forward(Submarine nemo) {
	
		return nemo.coordinates.suma(new Coordinate(-1,0));
	}

	public String getDirection() {
		return direction;
	}

}
