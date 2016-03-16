import java.util.*;

public class Groupe {
	private String nom;
	private int effectif;
	private List<String> dépendances;
	
	public Groupe(String n, int e){ 
		nom = new String(n);
		effectif = e;
		dépendances = new ArrayList<String>();
		
		if (n.charAt(2) == 'd'){
			dépendances.add('a' + n.charAt(1) + "promo");
		}else if(n.charAt(2) == 'p'){
			dépendances.add('a' + n.charAt(1) + "promo");
			dépendances.add('a' + n.charAt(1) + "td" + (((int)n.charAt(4))*2-1));
			dépendances.add('a' + n.charAt(1) + "td" + (((int)n.charAt(4))*2));
		}
	}

	public int getEffectif(){ 
		return effectif;
	} 
	
	public String getNom(){ 
		return nom; 
	} 
	
	public String toString(){ 
		return nom + " (" + effectif + " étudiants)"; 
	}
}
