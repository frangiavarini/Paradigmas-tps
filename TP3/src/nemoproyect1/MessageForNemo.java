package nemoproyect1;
import java.util.List;
import java.util.ArrayList;

public class MessageForNemo {
	public List<String> characters = new ArrayList<>();
	public String message;
	
	public MessageForNemo(String commands) {
		this.message = commands;
	}
	
	public MessageForNemo disarmMessage(String commands) {
	    for (char c : commands.toCharArray()) {
	    	characters.add(String.valueOf(c));
	    
	    }
	    return this;
	}

	
	public MessageForNemo doSomenthing(Submarine nemo) { //capaz es mejor un hash map
	    disarmMessage(this.message);
	    for (int i = 0; i < characters.size(); i++) {
	        String elemento = characters.get(i);
	        
	        if (elemento.equals("d") || elemento.equals("u") || elemento.equals("f") || elemento.equals("")) {
	            nemo.move(elemento);
	        } else if ((elemento.equals("r")) || (elemento.equals("l"))) {
	            nemo.spin(elemento);
	        } else {
	            nemo.throwBrownie();
	        }
	    }
	    
	    return this;
	}
	
//	static commandFor(char c) {
//		{}hash, para todo e perteneciente al hash e.cumple(c)
//	
//	}
//	
//	public bool cumple(Char c) {
//		return key(en hash) == c;
//	}
	
	
	//clase commando y subclases POR CARACTER

}
