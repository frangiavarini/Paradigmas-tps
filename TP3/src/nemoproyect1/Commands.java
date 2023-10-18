package nemoproyect1;
import java.util.List;
import java.util.ArrayList;

public abstract class Commands {
    public List<Commands> listOfCommands = new ArrayList<>();

    public Commands() {
        // Agrega todas las subclases a la lista en el constructor
        listOfCommands.add(new CommandU());
        listOfCommands.add(new CommandL());
        listOfCommands.add(new CommandD());
        listOfCommands.add(new CommandF());
        listOfCommands.add(new CommandM());
        listOfCommands.add(new CommandR());
    }

    public abstract Character getKey();

    public Commands addMessage(String message) {
        // Resto del código...
        return this;
    }


	

    public boolean findKey(Character c,Commands aCommand) {
        
           return aCommand.getKey() == c;
     
    
    }
    
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


