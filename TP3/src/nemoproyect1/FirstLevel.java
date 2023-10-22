package nemoproyect1;


public class FirstLevel extends Depth {
	public int depth = -1;


	

	public Depth ascend (Submarine nemo) {
		nemo.depths.remove(nemo.depths.size() -1);
			return this;
	}
		

	
	public Depth descend(Submarine nemo) {
		nemo.depths.add(new UnderFirstLevel(-2));
		return this;
	}


	@Override
	public Depth throwBrownie(Submarine nemo) {
		nemo.wasBrownieThrown = true;
		return this;
	}



	@Override
	public int getDepth() {
		return depth;
	}
}
