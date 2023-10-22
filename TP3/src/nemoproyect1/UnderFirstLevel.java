package nemoproyect1;

public class UnderFirstLevel extends Depth{
	public int depth;
	
	public UnderFirstLevel (int profundidad) {
		depth = profundidad ; 
	}
	

	@Override
	public int getDepth() {
		return depth;
	}

	@Override
	public Depth ascend(Submarine nemo) {
		depth += 1;
		nemo.depths.remove(nemo.depths.size() - 1);
		return this;
	}

	@Override
	public Depth descend(Submarine nemo) {
		nemo.depths.add(new UnderFirstLevel(depth - 1));
		return this;
	}

	@Override
	public Depth throwBrownie(Submarine nemo) {
		nemo.wasBrownieThrown = false;
		return this;
	}


}
