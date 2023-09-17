package queue;
import java.util.ArrayList;
import java.util.List;
public class Dude {
	
	public List<Dude> dudes = new ArrayList<>();
	

	public Dude() {
        dudes.add(new ToxicDude());
    }
	
	
	

	
	public Dude addInDude() {
		dudes.add(new GoodDude());
		return this;
		
	}
	
	
	

}
