import java.util.*;

public class Activit� {
	private String nom;
	private List<Groupe> groupes; //groupes est un objet contenant une liste d'objet Groupe
	protected List<Salle> sallesAppropri�es;
	
	public Activit�(String nom){
		this.nom = new String (nom);
		groupes = new ArrayList<Groupe>();
		sallesAppropri�es = new ArrayList<Salle>();
	}
	
	public void addGroupe(Groupe groupe){ 
		groupes.add(groupe); 
	}
	
	public List<Salle> getSalles(){ 
		return sallesAppropri�es; 
	}
	
	public List<Groupe> getGroupes(){ 
		return groupes; 
	}
	
	public String toString(){ 
		return "Activit� " + nom + " (" + groupes +")"; 
	}
}