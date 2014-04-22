import java.util.*;

public class Patient {
	
	String name;
	List<Drug> TakenDrug;
	
	public Patient(String n) {
		
		name = n;
		
	}
	
	public boolean addDrug(Drug d) {
		
		return TakenDrug.add(d);
		
	}
	

}
