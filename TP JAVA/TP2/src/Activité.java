import java.util.*;

public class Activité {
	private String nom;
	private List<Groupe> groupes; //groupes est un objet contenant une liste d'objet Groupe
	protected List<Salle> sallesAppropriées;
	
	public Activité(String nom){
		this.nom = new String (nom);
		groupes = new ArrayList<Groupe>();
		sallesAppropriées = new ArrayList<Salle>();
	}
	
	public void addGroupe(Groupe groupe){ 
		groupes.add(groupe); 
	}
	
	public List<Salle> getSalles(){ 
		return sallesAppropriées; 
	}
	
	public List<Groupe> getGroupes(){ 
		return groupes; 
	}
	
	public String toString(){ 
		return "Activité " + nom + " (" + groupes +")"; 
	}
}