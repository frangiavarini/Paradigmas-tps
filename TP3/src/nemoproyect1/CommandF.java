package nemoproyect1;

public class CommandF extends Commands {
	@Override
	public boolean findKey(char c) {
		return c == 'f';
		
	}

	@Override
	public void doSomething(Submarine nemo) {
		nemo.coordinates = nemo.cardinal.forward(nemo);		
	}

}
