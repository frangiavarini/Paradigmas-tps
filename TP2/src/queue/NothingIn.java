package queue;

import java.util.List;

public class NothingIn extends Instance{

	private static final String queueIsEmptyError = "Queue is empty";

	protected Object take(List<String> queue, List<Instance> list_of_instances) {
		throw new Error(queueIsEmptyError);
	}

	
	protected Object head(List<String> queue, List<Instance> list_of_instances) {
		throw new Error(queueIsEmptyError);
		
	}

}
