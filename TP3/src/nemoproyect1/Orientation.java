package nemoproyect1;

public abstract class Orientation  {// cambiar por direction y hacer oficial de direccion
	
	public abstract Orientation turnRight();
	public abstract Orientation turnLeft();
	public abstract Coordinate forward(Submarine nemo);
	public abstract String getDirection();
		

	
}

