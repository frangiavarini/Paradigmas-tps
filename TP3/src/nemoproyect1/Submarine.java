package nemoproyect1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Submarine {

	public Coordinate coordinates;
	public Orientation cardinal;
	public Boolean wasBrownieThrown;
	public ArrayList<Depth> depths = new ArrayList<Depth>();
	
	public Submarine() {
		coordinates= new Coordinate();
		cardinal = new NorthOrientation();
		depths.add(new SurfaceLevel());
		
	}
	
	public Submarine(Coordinate coords, Orientation point) {
		
		coordinates = coords;
		cardinal = point;
		depths.add(new SurfaceLevel());
		
	}
	

	
	public Submarine throwBrownie() {
		
		return this;
	}
	

	public Submarine executeCommands(String comandos) {
        
        List<Character> listaComandos = comandos.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        for (char comando : listaComandos) {
            	Commands.listOfCommands.stream()
	            .filter(command -> command.findKey(comando)) 
	            .findFirst()
	            .orElse(null).doSomething(this);
            }
        	return this;
        }
	
	
}