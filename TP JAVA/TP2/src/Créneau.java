import java.util.List;

public class Créneau { 
	private int année; 
	private int mois; // 1 à 12 
	private int jour; // 1 à 31 
	private int heure; // 0 à 23 
	private int minute; // 0 à 59 
	private int durée; // en minutes, maximum 210 
	private Salle salle; 
	private Activité activité; 
	
	public Créneau(int a, int m, int j, int h, int min, int d, Salle s, Activité ac) { 
		année = a;
		mois = m; 
		jour = j; 
		heure = h; 
		minute = min; 
		durée = d; 
		salle = s; 
		activité = ac;
		
		if(!vérifCapacité()){ 
			System.exit(1); 
		} 
		if(!vérifDurée()){ 
			System.exit(1); 
		} 
		if(!vérifSalle()){ 
			System.exit(1); 
		} 
	} 
	private boolean vérifSalle(){ 
		List<Salle> listSalleTemp = activité.getSalles();
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
	
	private boolean vérifCapacité(){ 
		List<Groupe> listeGroupeTemp = activité.getGroupes();
		int tailleListeGroupeTemp = listeGroupeTemp.size();
		int effectifTotal = 0;
		Groupe groupeTemp;
		
		for(int i = 0; i < tailleListeGroupeTemp; i++){
			groupeTemp = listeGroupeTemp.get(i);
			effectifTotal += groupeTemp.getEffectif();
		}
		if(effectifTotal > salle.getCapacité()){
			return false;
		}else{
			return true;
		}
	} 
	private boolean vérifDurée(){ 
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
	public Activité getActivité(){
		return activité; 
	} 
	public int getDurée(){ 
		return durée;
	}
	public String toString(){ 
		return jour + "/" + mois + "/" + année + " " + heure + ":" + minute +" (" + durée +") : " + activité + " " + salle; 
	} 
	public boolean intersection(Créneau c){  
		List<Groupe> listeGroupeTemp1 = this.activité.getGroupes();
		List<Groupe> listeGroupeTemp2 = c.activité.getGroupes();
		int tailleListeGroupeTemp1 = listeGroupeTemp1.size();
		int tailleListeGroupeTemp2 = listeGroupeTemp2.size();
		int deb_c, deb_this, fin_c, fin_this;
		
		deb_c = c.getHeure()*60 + c.getMinute();
		deb_this = this.getHeure()*60 + this.getMinute();
		fin_c = c.getHeure()*60 + c.getDurée() + c.getMinute();
		fin_this = this.getHeure()*60 + this.getDurée() + this.getMinute();
		
		if (this.getAnnée() == c.getAnnée()) {
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
	
	public int getAnnée() {
		return année;
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