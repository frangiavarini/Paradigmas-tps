package queue;

import java.util.List;

public class SomethingIn extends Instance {
	
	protected Object take(List<String> queue, List<Instance> list_of_instances) {
		list_of_instances.remove(list_of_instances.size()-1);
		return queue.remove(0);
	}

	protected Object head(List<String> queue, List<Instance> list_of_instances) {return queue.get(0);}
	
}

