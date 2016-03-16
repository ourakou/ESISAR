
public class SalleCTD extends Salle {

	public SalleCTD(int capacité, String nom){ //Constructeur de la sous-classe
		super(capacité, nom); 
	}

	public String toString(){ 
		return "Salle cours-TD "+ super.toString(); 
	}
}
