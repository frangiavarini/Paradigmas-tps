package nemoproyect1;

public class Nemo {
	public int prof;
	public int position;
	public String cardinals;
	
	
	public Nemo() {
		this.prof = 0;
		this.position = 0;
		this.cardinals="north";
		
	}
	
	public Nemo(int profundidad,int position,String cardinals) {
		this.prof=profundidad;
		this.position=position;
		this.cardinals=cardinals;
		
	}
	
	public int getProf() {
		return this.prof;
		
	}
	
	public int getPosition() {
		return this.position;
		
	}
	
	public String getCardinal() {
		return this.cardinals;
	}
	
	public Nemo move(String movements) {
		if (movements == "") {
			return this;
		}
		
		if (movements.equals("d")) {
			this.prof -= 1;
		}
		
		if (movements.equals("u")) {
			this.prof += 1;
		}
		if (movements.equals("f")) {
			this.position += 1;
		}
		
		if (movements.equals("l")) {
			switch (this.cardinals) {
				case "north":
					this.cardinals="west";
					break;
				case "west" :
					this.cardinals="south";
					break;
				case "south":
					this.cardinals="east";
					break;
				case "east":
					this.cardinals="north";
					break;
			}
			
			
		}
		
		if (movements.equals("r")) {
			switch (this.cardinals) {
				case "north":
					this.cardinals="east";
					break;
				case "east" :
					this.cardinals="south";
					break;
				case "south":
					this.cardinals="west";
					break;
				case "west":
					this.cardinals="north";
					break;
			}
		}
		
	return this;
	
	}
	
	
	
}
