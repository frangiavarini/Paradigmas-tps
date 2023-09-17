
/*
package queue;
import java.util.ArrayList;
import java.util.List;


public class Queue {
  
  public AbstractQueue abstractqueue;
  

  public boolean isEmpty() { return abstractqueue.isEmpty();}

	public Queue add(Object cargo ) {
		abstractqueue.add(cargo);
		return this;
	}

	public Object take() {
	    abstractqueue.take();
	    return this;
	}

	
	public Object head() {
		abstractqueue.head();
		return this;
		
	}

	public int size() {
		 return abstractqueue.size();
	}

}
*/

package queue;
import java.util.ArrayList;
import java.util.List;


public class Queue {
	public List<String> queue = new ArrayList<>();
	public List<Instance> list_of_instances = new ArrayList<>(List.of(new NothingIn()));
	
    public boolean isEmpty() {return queue.isEmpty();}
    //hola
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













