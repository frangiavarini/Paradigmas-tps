package nemoproyect1;

public class CommandR extends Commands{
	
	public boolean findKey(char c) {
		return c == 'r';
		
	}

	
	public void doSomething(Submarine nemo) {
		nemo.cardinal = nemo.cardinal.turnRight();
		
	}

}
