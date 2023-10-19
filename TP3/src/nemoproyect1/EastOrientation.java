package nemoproyect1;

public class EastOrientation extends Orientation{
	public String direction = "east";
	
	public Orientation turnRight() {
		return new SouthOrientation();
	}
	
	public Orientation turnLeft() {
		return new NorthOrientation();
		
	}

	@Override
	public Coordinate forward(Submarine nemo) {
		return nemo.coordinates.suma(new Coordinate(1,0));
	}
}
