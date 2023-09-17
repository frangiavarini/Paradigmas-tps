package queue;

import java.util.List;

public class ToxicDude extends Dude{
	
	
	public Object ret(List aList) {
		throw new Error("Queue is empty");
	}
	
	
	
}
