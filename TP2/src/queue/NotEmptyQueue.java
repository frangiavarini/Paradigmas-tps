package queue;

import java.util.ArrayList;
import java.util.List;

public class NotEmptyQueue extends AbstractQueue {
	
	public List<Object> queue = new ArrayList<>();

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		
		return queue.size();
	}

	@Override
	public Object add(Object cargo) {
		
		return queue.add(cargo);
	}

	@Override
	public Object head() {
		
		return queue.get(0);
	}

	@Override
	public Object take() {
		
		return queue.remove(0);
	}

}
