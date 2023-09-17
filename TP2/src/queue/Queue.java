package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	public List<String> queue = new ArrayList<>();
	public List<Instance> list_of_instances = new ArrayList<>(List.of(new NothingIn()));
	
    public boolean isEmpty() {return queue.isEmpty();}
  
    public int size() {
    	return queue.size();
    }                          
    
    public Queue add( String  something ) {
		queue.add(something);
		list_of_instances.add(new SomethingIn());
		return this;
	}
    
	public Object take() {
		
		return list_of_instances.get(list_of_instances.size()-1).take(queue, list_of_instances);
	}
	
	public Object head() {
		return list_of_instances.get(list_of_instances.size()-1).head(queue,list_of_instances);
	}
}



