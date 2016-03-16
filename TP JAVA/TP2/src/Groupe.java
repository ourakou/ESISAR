import java.util.*;

public class Groupe {
	private String nom;
	private int effectif;
	private List<String> d�pendances;
	
	public Groupe(String n, int e){ 
		nom = new String(n);
		effectif = e;
		d�pendances = new ArrayList<String>();
		
		if (n.charAt(2) == 'd'){
			d�pendances.add('a' + n.charAt(1) + "promo");
		}else if(n.charAt(2) == 'p'){
			d�pendances.add('a' + n.charAt(1) + "promo");
			d�pendances.add('a' + n.charAt(1) + "td" + (((int)n.charAt(4))*2-1));
			d�pendances.add('a' + n.charAt(1) + "td" + (((int)n.charAt(4))*2));
		}
	}

	public int getEffectif(){ 
		return effectif;
	} 
	
	public String getNom(){ 
		return nom; 
	} 
	
	public String toString(){ 
		return nom + " (" + effectif + " �tudiants)"; 
	}
}
