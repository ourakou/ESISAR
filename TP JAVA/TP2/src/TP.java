
public class TP extends Activit� {
	private Discipline type;
	
	public TP(String nom, Discipline t){ //Constructeur
		super(nom);
		type = t;
	}
	
	public void addSalle(SalleTP s){
		if(type == s.getType()){
			sallesAppropri�es.add(s);
		}else{
			System.out.println("La salle " + s.getNom() + " n'est pas fait "
								+ "pour la Discipline" + type);
		}
		 
	}
}
