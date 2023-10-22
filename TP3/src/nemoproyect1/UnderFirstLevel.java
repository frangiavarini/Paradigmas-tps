package nemoproyect1;

public class UnderFirstLevel extends Depth{
	
	public int depth;
	
	public UnderFirstLevel (int profundidad) {
		depth = profundidad ; 
	}
	

	public int getDepth() {
		return depth;
	}

	
	public Depth ascend(Submarine nemo) {
		depth += 1;
		nemo.depths.remove(nemo.depths.size() - 1);
		return this;
	}


	public Depth descend(Submarine nemo) {
		nemo.depths.add(new UnderFirstLevel(depth - 1));
		return this;
	}

	
	public Depth throwBrownie(Submarine nemo) {
		throw new RuntimeException ("Boom!");
	}

}
