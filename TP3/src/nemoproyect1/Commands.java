package nemoproyect1;
import java.util.List;
import java.util.Arrays;

public abstract class Commands {
    public static List<Commands> listOfCommands =  Arrays.asList(new CommandU(),
    		new CommandL(), 
    		new CommandD(),
    		new CommandF(),
    		new CommandM(),
    		new CommandR()
    	);

    
    
    public abstract boolean findKey(char c);
    public abstract void doSomething(Submarine nemo);
}
		
		
		
			





































//	public List<String> characters = new ArrayList<>();
//	public String message;
//	
//	public Commands(String commands) {
//		this.message = commands;
//	}
//	
//	public Commands disarmMessage(String messageForNemo) {
//	    for (char c : messageForNemo.toCharArray()) {
//	    	characters.add(String.valueOf(c));
//	    
//	    }
//	    return this;
//	}
//
//	
//	public Commands doSomenthing(Submarine nemo) { //capaz es mejor un hash map
//	    disarmMessage(this.message);
//	    for (int i = 0; i < characters.size(); i++) {
//	        String elemento = characters.get(i);
//	        
//	        if (elemento.equals("d") || elemento.equals("u") || elemento.equals("f") || elemento.equals("")) {
//	            nemo.move(elemento);
//	        } else if ((elemento.equals("r")) || (elemento.equals("l"))) {
//	            nemo.spin(elemento);
//	        } else {
//	            nemo.throwBrownie();
//	        }
//	    }
//	    
//	    return this;
//	}
	
//	static commandFor(char c) {
//		{}hash, para todo e perteneciente a la palabra si e.cumple(c)
//	
//	}
//	
//	public bool cumple(Char c) {
//		return key(en hash) == c;
//	}
	
	
	//clase commando y subclases POR CARACTER


