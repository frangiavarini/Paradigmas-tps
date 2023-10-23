package nemoproyect1;

public class CommandF extends Commands {

	public boolean findKey(char c) {
		return c == 'f';
		
	}


	public void doSomething(Submarine nemo) {
		nemo.coordinates = nemo.cardinal.forward(nemo);		
	}

}
