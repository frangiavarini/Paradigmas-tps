package queue;

import java.util.List;

public abstract class Instance {
	
	protected abstract Object take(List<String> queue, List<Instance> list_of_instances);
	
	protected abstract Object head(List<String> queue, List<Instance> list_of_instances);
	
	static Instance Empty(){
		return new NothingIn();
		}
	
	static Instance NotEmpty() {
		return new SomethingIn();
	}
	

	
	
}
