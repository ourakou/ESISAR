import java.util.*;

public class Planning {
	private List<Créneau> edt; 
	
	public Planning(){ 
		edt = new ArrayList<Créneau>(); 
	}
	
	public String toString(){ 
		String res = new String(); 
		
			for (Créneau c : edt){ 
				res = res + c + "\n"; 
			} 
		return res; 
	}
	
	public boolean vérifCréneau(Créneau c){ 
		boolean ok = true; 
		int i = 0; 
		
			while (ok && i < edt.size()){ 
				Créneau cour = edt.get(i++); 
				ok = !c.intersection(cour); 
			} 
		return ok; 
	}
	
	public void addCréneau(Créneau c){ 
		if (this.vérifCréneau(c)) edt.add(c); 
		else System.out.println("Créneau " + c + " non inséré"); 
	}
	
	public List<Créneau> planningGroupe(Groupe groupe){
		List<Créneau> listeCréneauRésultat = new ArrayList<Créneau>();
		List<Groupe> listGroupeTemp;
		Créneau créneauTemp;
		Groupe groupeTemp;
		Activité activitéTemp;
		
		int tailleListCréneau = edt.size();
		int tailleListGroupe;
		
		for(int i = 0; i < tailleListCréneau; i++){
			créneauTemp = edt.get(i);
			activitéTemp = créneauTemp.getActivité();
			listGroupeTemp = activitéTemp.getGroupes();
			tailleListGroupe = listGroupeTemp.size();
			
			for(int k = 0; k < tailleListGroupe; k++){
				groupeTemp = listGroupeTemp.get(k);
				if(groupe == groupeTemp){
					listeCréneauRésultat.add(créneauTemp);
				}
			}
		}
		return listeCréneauRésultat;
		// créneau -> activité -> groupe -> check tout les groups puis add à la liste de retour
	}
	
	public float totalHeuresGroupe(Groupe groupe){ 
		//créneau -> atribu Activité -> atribu List<Groupe> groupes
		// Si le groupe que l'on cherche est dans List<Groupe> groupes, alors on récupère l'atribut durée de Créneau
		Créneau créneauTemp;
		Activité activitéTemp;
		List<Groupe> groupesTemp;
		float totalHeures = 0;
		
		for(int i = 0; i < edt.size(); i++){
			créneauTemp = edt.get(i);
			activitéTemp = créneauTemp.getActivité();
			groupesTemp = activitéTemp.getGroupes();
			if(groupesTemp.equals(groupe)){
				totalHeures += créneauTemp.getDurée();
			}
		}
		return totalHeures;
	}
	
	public static void main (String [] args){ 
		
		Planning p = new Planning();
		SalleCTD a042 = new SalleCTD(100, "A042"); 
		SalleCTD d030 = new SalleCTD(180, "D030"); 
		SalleTP b141 = new SalleTP(16, "B141", Discipline.Informatique); 
		SalleCTD a048 = new SalleCTD(25, "A048"); 
		
		CM cs310cm = new CM("CM CS310"); 
		cs310cm.addSalle(a042); 
		cs310cm.addSalle(d030); 
		cs310cm.addSalle(a048); 
		
		TP cs330tp1 = new TP("TP1 CS330", Discipline.Informatique); 
		cs330tp1.addSalle(b141); 
		
		CM cs410cm = new CM("CM CS410"); 
		cs410cm.addSalle(a042); 
		cs410cm.addSalle(d030); 
		cs410cm.addSalle(a048); 
		
		Groupe a3tp1 = new Groupe("3ATP1", 16); 
		Groupe a3tp2 = new Groupe("3ATP2", 16); 
		Groupe a3tp3 = new Groupe("3ATP3", 16); 
		Groupe a3tp4 = new Groupe("3ATP4", 16); 
		Groupe a3tp5 = new Groupe("3ATP5", 16); 
		
		Groupe a4ir = new Groupe("4AIR", 29); 
		
		cs310cm.addGroupe(a3tp1); 
		cs310cm.addGroupe(a3tp2); 
		cs310cm.addGroupe(a3tp3); 
		cs310cm.addGroupe(a3tp4); 
		cs310cm.addGroupe(a3tp5); 
		
		cs330tp1.addGroupe(a3tp1); 
		cs410cm.addGroupe(a4ir); 
		
		Créneau c1 = null, c2 = null, c3 = null, c4 = null;
		
		c1 = new Créneau(2014, 1, 17, 13, 15, 105, a042, cs310cm); 
		c2 = new Créneau(2014, 1, 17, 8, 00, 210, b141, cs330tp1); 
		c3 = new Créneau(2014, 1, 17, 15, 15, 105, d030, cs410cm); 
		c4 = new Créneau(2014, 1, 17, 10, 00, 105, a042, cs310cm); 
		
		p.addCréneau(c1); 
		p.addCréneau(c2); 
		p.addCréneau(c3);
		p.addCréneau(c4); 
		
		System.out.println(p.planningGroupe(a3tp1) + " (" + 
						   p.totalHeuresGroupe(a3tp1) + ")"); 
		System.out.println(p.planningGroupe(a4ir));
	}
}