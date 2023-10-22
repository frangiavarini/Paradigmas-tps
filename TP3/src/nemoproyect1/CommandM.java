package nemoproyect1;

public class CommandM extends Commands{
	
	public boolean findKey(char c) {
		return c == 'm';
		
	}


	public void doSomething(Submarine nemo) {
		nemo.depths.get(nemo.depths.size() - 1).throwBrownie(nemo);
	}

}
