package nemoproyect1;


public class SurfaceLevel extends Depth{
	public int depth = 0;

	public int getDepth() {
		return this.depth;
	}

	
	public Depth ascend(Submarine nemo) {
		return this;
	}

	
	public Depth descend(Submarine nemo) {
		nemo.depths.add(new FirstLevel());
		return this;
	}


	
	public Depth throwBrownie(Submarine nemo) {
		nemo.wasBrownieThrown = true;
		return this;
	}

}
