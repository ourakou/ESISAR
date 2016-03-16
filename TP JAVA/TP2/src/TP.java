
public class TP extends Activité {
	private Discipline type;
	
	public TP(String nom, Discipline t){ //Constructeur
		super(nom);
		type = t;
	}
	
	public void addSalle(SalleTP s){
		if(type == s.getType()){
			sallesAppropriées.add(s);
		}else{
			System.out.println("La salle " + s.getNom() + " n'est pas fait "
								+ "pour la Discipline" + type);
		}
		 
	}
}
