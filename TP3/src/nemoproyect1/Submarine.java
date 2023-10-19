package nemoproyect1;

import java.util.List;
import java.util.stream.Collectors;

public class Submarine {

	public Coordinate coordinates;
	public Orientation cardinal;
	public Boolean isBrownieIn= true;

	
	public Submarine() {
		coordinates= new Coordinate(0,0);
		cardinal = new NorthOrientation();
	}
	
	public Submarine(Coordinate coords, Orientation point) {
		
		this.coordinates = coords;
		this.cardinal = point;
	
		
	}
	
//	

//	public void move(String letter) {
//		
//		coordinates.modify(letter,this);
//	}
	

	
	public Submarine throwBrownie() {
		if (coordinates.getRidOfBrownie()) {
			isBrownieIn = false;
		}
		
		return this;
	}
	

	public Submarine ejecutarComandos(String comandos) {
        
        List<Character> listaComandos = comandos.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        for (char comando : listaComandos) {
            	Commands.listOfCommands.stream()
	            .filter(command -> command.findKey(comando)) //comando es el char que viene d elas acciones de nemo. command es cada objeto de la lista de Comandos.
	            .findFirst()
	            .orElse(null).doSomething(this);
            }
        	return this;
        }
	
	
}


