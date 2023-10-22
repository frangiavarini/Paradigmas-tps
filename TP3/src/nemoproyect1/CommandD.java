package nemoproyect1;


public class CommandD extends Commands{
	
	public boolean findKey(char c) {
		return c == 'd';
		
	}


	public void doSomething(Submarine nemo) {
		nemo.depths.get(nemo.depths.size() - 1).descend(nemo);
	}

}