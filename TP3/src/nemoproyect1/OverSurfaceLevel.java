package nemoproyect1;

public class OverSurfaceLevel extends Depth{
	
	public int depth = 1;

	public int getDepth() {

		return this.depth ;
		
	}

	
	public Depth ascend() {
		this.depth += 1;
		return this;
	}

	
	public Depth descend() {
		this.depth -= 1;
		if(this.depth == 0) {
			return new SurfaceLevel();
		}
		return this;
	}


	@Override
	public Submarine throwBrownie(Submarine nemo) {
		//lanzar error
		return null;
	}
}
