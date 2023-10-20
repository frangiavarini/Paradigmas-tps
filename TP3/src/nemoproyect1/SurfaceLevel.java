package nemoproyect1;

public class SurfaceLevel extends Depth{
	public int depth = 0;
	
	public int getDepth() {
		
		return this.depth;
	}

	
	public Depth ascend() {
		
		return new OverSurfaceLevel(); // o tiro error "nemo cant fly"
	}

	
	public Depth descend() {
	
		return new FirstLevel();
	}


	@Override
	public Submarine throwBrownie(Submarine nemo) {
		nemo.BrownieCapsuleThrown = true;
		return nemo;
	}

}
