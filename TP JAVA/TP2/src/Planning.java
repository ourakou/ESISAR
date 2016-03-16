import java.util.*;

public class Planning {
	private List<Cr�neau> edt; 
	
	public Planning(){ 
		edt = new ArrayList<Cr�neau>(); 
	}
	
	public String toString(){ 
		String res = new String(); 
		
			for (Cr�neau c : edt){ 
				res = res + c + "\n"; 
			} 
		return res; 
	}
	
	public boolean v�rifCr�neau(Cr�neau c){ 
		boolean ok = true; 
		int i = 0; 
		
			while (ok && i < edt.size()){ 
				Cr�neau cour = edt.get(i++); 
				ok = !c.intersection(cour); 
			} 
		return ok; 
	}
	
	public void addCr�neau(Cr�neau c){ 
		if (this.v�rifCr�neau(c)) edt.add(c); 
		else System.out.println("Cr�neau " + c + " non ins�r�"); 
	}
	
	public List<Cr�neau> planningGroupe(Groupe groupe){
		List<Cr�neau> listeCr�neauR�sultat = new ArrayList<Cr�neau>();
		List<Groupe> listGroupeTemp;
		Cr�neau cr�neauTemp;
		Groupe groupeTemp;
		Activit� activit�Temp;
		
		int tailleListCr�neau = edt.size();
		int tailleListGroupe;
		
		for(int i = 0; i < tailleListCr�neau; i++){
			cr�neauTemp = edt.get(i);
			activit�Temp = cr�neauTemp.getActivit�();
			listGroupeTemp = activit�Temp.getGroupes();
			tailleListGroupe = listGroupeTemp.size();
			
			for(int k = 0; k < tailleListGroupe; k++){
				groupeTemp = listGroupeTemp.get(k);
				if(groupe == groupeTemp){
					listeCr�neauR�sultat.add(cr�neauTemp);
				}
			}
		}
		return listeCr�neauR�sultat;
		// cr�neau -> activit� -> groupe -> check tout les groups puis add � la liste de retour
	}
	
	public float totalHeuresGroupe(Groupe groupe){ 
		//cr�neau -> atribu Activit� -> atribu List<Groupe> groupes
		// Si le groupe que l'on cherche est dans List<Groupe> groupes, alors on r�cup�re l'atribut dur�e de Cr�neau
		Cr�neau cr�neauTemp;
		Activit� activit�Temp;
		List<Groupe> groupesTemp;
		float totalHeures = 0;
		
		for(int i = 0; i < edt.size(); i++){
			cr�neauTemp = edt.get(i);
			activit�Temp = cr�neauTemp.getActivit�();
			groupesTemp = activit�Temp.getGroupes();
			if(groupesTemp.equals(groupe)){
				totalHeures += cr�neauTemp.getDur�e();
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
		
		Cr�neau c1 = null, c2 = null, c3 = null, c4 = null;
		
		c1 = new Cr�neau(2014, 1, 17, 13, 15, 105, a042, cs310cm); 
		c2 = new Cr�neau(2014, 1, 17, 8, 00, 210, b141, cs330tp1); 
		c3 = new Cr�neau(2014, 1, 17, 15, 15, 105, d030, cs410cm); 
		c4 = new Cr�neau(2014, 1, 17, 10, 00, 105, a042, cs310cm); 
		
		p.addCr�neau(c1); 
		p.addCr�neau(c2); 
		p.addCr�neau(c3);
		p.addCr�neau(c4); 
		
		System.out.println(p.planningGroupe(a3tp1) + " (" + 
						   p.totalHeuresGroupe(a3tp1) + ")"); 
		System.out.println(p.planningGroupe(a4ir));
	}
}