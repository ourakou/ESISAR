
public class SalleTP extends Salle {
	private Discipline type;
	
	public SalleTP(int capacit�, String nom, Discipline d){ 
		super(capacit�, nom); 
		type = d; 
	}
	
	public Discipline getType(){
		return type;
	}
	
	public String toString(){ 
		return "Salle TP "+ type + " " + super.toString(); 
	}
}
