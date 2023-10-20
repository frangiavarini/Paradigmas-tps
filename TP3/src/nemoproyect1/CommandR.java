package nemoproyect1;

public class CommandR extends Commands{
	@Override
	public boolean findKey(char c) {
		return c == 'r';
		
	}

	@Override
	public void doSomething(Submarine nemo) {
		nemo.cardinal = nemo.cardinal.turnRight();
		
	}

}
