package nemoproyect1;

public class CommandL extends Commands{

	@Override
	public boolean findKey(char c) {
		return c == 'l';
		
	}

	@Override
	public void doSomething(Submarine nemo) {
	
	nemo.cardinal = nemo.cardinal.turnLeft();	
		
	}

}
