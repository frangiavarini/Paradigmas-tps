package nemoproyect1;

public class CommandM extends Commands{
	@Override
	public boolean findKey(char c) {
		return c == 'm';
		
	}

	@Override
	public void doSomething(Submarine nemo) {
		nemo.depths.get(nemo.depths.size() - 1).throwBrownie(nemo);
	}

}
