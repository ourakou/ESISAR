
public class SalleCTD extends Salle {

	public SalleCTD(int capacit�, String nom){ //Constructeur de la sous-classe
		super(capacit�, nom); 
	}

	public String toString(){ 
		return "Salle cours-TD "+ super.toString(); 
	}
}
