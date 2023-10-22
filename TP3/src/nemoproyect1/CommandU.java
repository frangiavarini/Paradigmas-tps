package nemoproyect1;

public class CommandU extends Commands {


	public boolean findKey(char c) {
		return c == 'u';
		
	}
	@Override
	public void doSomething(Submarine nemo) {
		nemo.depths.get(nemo.depths.size() - 1).ascend(nemo);
		
	}
}
