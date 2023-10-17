//package nemoproyect1;
//
//import java.util.HashMap;
//import java.util.Map.Entry;
//import java.util.List;
//import java.util.ArrayList;
//
//
//public class Operator {
//	  
//	public HashMap<String, Integer> cardinalMap1 = new HashMap<>();
//	public HashMap<Integer,String> cardinalMap2 = new HashMap<>();
//	
//	public Operator() {
//		cardinalMap1.put("N",0);
//		cardinalMap1.put("E",1);
//		cardinalMap1.put("S",2);
//		cardinalMap1.put("W",3);
//		cardinalMap2.put(0,"N");
//		cardinalMap2.put(1,"E");
//		cardinalMap2.put(2,"S");
//		cardinalMap2.put(3,"W");
//	}
//	
//	public int counter(String command, char targetLetter) {
//	    int count = (int) command.chars()
//	            .filter(ch -> ch == targetLetter)
//	            .count();
//
//	    return count;
//	}
//	
//
//	public String spinl(String orientacionActual, int cantidadGiros) {
//		return cardinalMap2.get((cardinalMap1.get(orientacionActual) - cantidadGiros)% 4);
//	}
//	
//	public String spinr(String orientacionActual, int cantidadGiros) {
//		return cardinalMap2.get((cardinalMap1.get(orientacionActual) + cantidadGiros)% 4);
//	}
//		
//}
