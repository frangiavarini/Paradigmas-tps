package nemoproyect1;

public class Submarine {

	public Coordinate coordinates;
	public Orientation cardinal;
	public Boolean isBrownieIn= true;
	//public Operator operator;
	
	
	public Submarine() {
		coordinates = new Coordinate();
		cardinal = new Orientation();
	}
	
	public Submarine(Coordinate coords, Orientation point ) {
		coordinates = coords;
		cardinal = point;
	}
	

	public void move(String letter) {
		
		coordinates.modify(letter,this);
	}
	
	public void spin(String letter) {
	    if (letter.equals("l")) {
	        cardinal.spinLeft();
	    }
	    else if (letter.equals("r")) {
	        cardinal.spinRight();
	    }
	}
	
	public Submarine throwBrownie() {
		if (coordinates.getRidOfBrownie()) {
			isBrownieIn = false;
		}
		
		return this;
	}
	
	public Submarine moveForward() {
		if(cardinal.directedTo=="N" || cardinal.directedTo=="S") {
			coordinates.coordX += 1;
		}
		
		else {
			coordinates.coordY += 1;
		}
		return this;
	}
	
	
	
}

//public int prof;
//public int position; // hacer subclase de coordenadas con prof y position
//public String cardinals; // hacer subclase cardinals
//
//
//
//public Nemo() {
//	this.prof = 0;
//	this.position = 0;
//	this.cardinals="north";
//	
//}
//
//public Nemo(int profundidad,int position,String cardinals) {
//	this.prof=profundidad;
//	this.position=position;
//	this.cardinals=cardinals;
//	
//}
//
//public int getProf() {
//	return this.prof;
//	
//}
//
//public int getPosition() {
//	return this.position;
//	
//}
//
//public String getCardinal() {
//	return this.cardinals;
//}
//
//public Nemo ascendOrdescend(String ascendOrdescendments) {
//	if (ascendOrdescendments == "") {
//		return this;
//	}
//	
//	if (ascendOrdescendments.equals("d")) {
//		this.prof -= 1;
//	}
//	
//	if (ascendOrdescendments.equals("u")) {
//		this.prof += 1;
//	}
//	if (ascendOrdescendments.equals("f")) {
//		this.position += 1;
//	}
//	
//	if (ascendOrdescendments.equals("l")) {
//		switch (this.cardinals) {
//			case "north":
//				this.cardinals="west";
//				break;
//			case "west" :
//				this.cardinals="south";
//				break;
//			case "south":
//				this.cardinals="east";
//				break;
//			case "east":
//				this.cardinals="north";
//				break;
//		}
//		
//		
//	}
//	
//	if (ascendOrdescendments.equals("r")) {
//		switch (this.cardinals) {
//			case "north":
//				this.cardinals="east";
//				break;
//			case "east" :
//				this.cardinals="south";
//				break;
//			case "south":
//				this.cardinals="west";
//				break;
//			case "west":
//				this.cardinals="north";
//				break;
//		}
//	}
//	
//return this;
//
//}
//
//
//
//}
