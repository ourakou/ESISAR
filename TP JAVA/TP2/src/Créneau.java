import java.util.List;

public class Cr�neau { 
	private int ann�e; 
	private int mois; // 1 � 12 
	private int jour; // 1 � 31 
	private int heure; // 0 � 23 
	private int minute; // 0 � 59 
	private int dur�e; // en minutes, maximum 210 
	private Salle salle; 
	private Activit� activit�; 
	
	public Cr�neau(int a, int m, int j, int h, int min, int d, Salle s, Activit� ac) { 
		ann�e = a;
		mois = m; 
		jour = j; 
		heure = h; 
		minute = min; 
		dur�e = d; 
		salle = s; 
		activit� = ac;
		
		if(!v�rifCapacit�()){ 
			System.exit(1); 
		} 
		if(!v�rifDur�e()){ 
			System.exit(1); 
		} 
		if(!v�rifSalle()){ 
			System.exit(1); 
		} 
	} 
	private boolean v�rifSalle(){ 
		List<Salle> listSalleTemp = activit�.getSalles();
		int tailleListSalleTemp = listSalleTemp.size();
		Salle salleTemp;
		
		for(int i = 0; i < tailleListSalleTemp; i++){
			salleTemp = listSalleTemp.get(i);
			if(salleTemp.getNom() == salle.getNom()){
				return true;
			}
		}
		return false;
	} 
	
	private boolean v�rifCapacit�(){ 
		List<Groupe> listeGroupeTemp = activit�.getGroupes();
		int tailleListeGroupeTemp = listeGroupeTemp.size();
		int effectifTotal = 0;
		Groupe groupeTemp;
		
		for(int i = 0; i < tailleListeGroupeTemp; i++){
			groupeTemp = listeGroupeTemp.get(i);
			effectifTotal += groupeTemp.getEffectif();
		}
		if(effectifTotal > salle.getCapacit�()){
			return false;
		}else{
			return true;
		}
	} 
	private boolean v�rifDur�e(){ 
		if(this.heure >= 8){
			if(this.heure <= 19){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	} 
	public Salle getSalle(){ 
		return salle;
	} 
	public Activit� getActivit�(){
		return activit�; 
	} 
	public int getDur�e(){ 
		return dur�e;
	}
	public String toString(){ 
		return jour + "/" + mois + "/" + ann�e + " " + heure + ":" + minute +" (" + dur�e +") : " + activit� + " " + salle; 
	} 
	public boolean intersection(Cr�neau c){  
		List<Groupe> listeGroupeTemp1 = this.activit�.getGroupes();
		List<Groupe> listeGroupeTemp2 = c.activit�.getGroupes();
		int tailleListeGroupeTemp1 = listeGroupeTemp1.size();
		int tailleListeGroupeTemp2 = listeGroupeTemp2.size();
		int deb_c, deb_this, fin_c, fin_this;
		
		deb_c = c.getHeure()*60 + c.getMinute();
		deb_this = this.getHeure()*60 + this.getMinute();
		fin_c = c.getHeure()*60 + c.getDur�e() + c.getMinute();
		fin_this = this.getHeure()*60 + this.getDur�e() + this.getMinute();
		
		if (this.getAnn�e() == c.getAnn�e()) {
			if (this.getMois() == c.getMois()) {
				if (this.getJour() == c.getJour()) {
					if ((deb_c < fin_this && fin_this < fin_c) || (deb_this < fin_c && fin_c < fin_this )) {
						if(this.getSalle() == c.getSalle()){
							return true;
						}else{
							for (int i = 0; i <tailleListeGroupeTemp1; i++){
								for (int k = 0; k <tailleListeGroupeTemp2; k++){
									if(listeGroupeTemp1.get(i) == listeGroupeTemp2.get(k)) {
										return true;
									}
								}
							}
								return false;
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public int getAnn�e() {
		return ann�e;
	}
	public int getMois() {
		return(mois);
	}
	public int getJour() {
		return jour;
	}
	public int getHeure() {
		return(heure);
	}
	public int getMinute() {
		return(minute);
	}

	
}