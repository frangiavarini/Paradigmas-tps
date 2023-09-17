package queue;

public abstract class AbstractQueue {
	
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract Object add(Object cargo);
	public abstract Object head();
	public abstract Object take();
	
	
	
}
