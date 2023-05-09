/**
 * Cette classe représente un cours
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

public class Cours {
    private String cou_id;
	private int num_cours;
	private String matiere;
	private int duree;
	private DateEtHeure date_heure;
	private String salle;
	private int type_de_cours;
	private int id_ens;
	private int id_grp;
	private int id_ens_remp;
	private int estAbsent;
	
    //TODO Ajouter un cours classique 
	public Cours (String cou_id,int num_cours, String matiere,
			int duree, DateEtHeure date_et_heure, String salle, 
			int type_de_cours,int id_ens,int id_ens_remp, int id_grp,int estAbsent) 
	{
		this.cou_id=cou_id;
		this.num_cours=num_cours;
		this.matiere=matiere;
		this.duree=duree;
		this.date_heure=date_et_heure;
		this.salle=salle;
		this.type_de_cours=type_de_cours;
		this.id_ens=id_ens;
		this.id_grp=id_grp;
		this.id_ens_remp=id_ens_remp;
		this.estAbsent=estAbsent;			
	}
	
	/**
	 * Renvoie l'id du cours dans la bdd
	 * @return id du cours
	 */
	public String getIdCours() {
	    	return cou_id;
	}
	
	/**
	 * Renvoie le nombre de fois où ce cours est dispensé durant la semaine
	 * @return nombre de cours de la semaine
	 */
	public int getNumCours() {
		return num_cours;
	}
    	
	/**
	 * Renvoie la matiere du cours
	 * @return matiere du cours
	 */
	public String getMatiere() {
		return matiere;
	}
	
	/**
	 * Renvoie la duree du cours (en minutes
	 * @return duree du cours
	 */
	public int getDuree() {
		return duree;
	}
	
	/**
	 * Renvoie la date et l'heure du debut du cours (annee, mois, jour, heure, minute)
	 * @return Date et heure du debut du cours
	 */
	public DateEtHeure getDateEtHeure() {
		return date_heure;
	}
   
	/**
	 * Renvoie la salle du cours
	 * @return salle du cours
	 */
	public String getSalle() {
		return salle;
	}
	
	/**
	 * Renvoie le type du cours
	 * 0 = CM
	 * 1 = TD
	 * 2 = TP
	 * 3 = DS
	 * @return type du cours
	 */
	public int getTypeCours() {
		return type_de_cours;
	}
	
	/**
	 * Renvoie l'id de l'enseignant initial du cours
	 * @return id de l'enseignant initial
	 */
	public int getEns() {
		return id_ens;
	}
	
	/**
	 * Renvoie l'id du groupe concerne
	 * @return id du groupe
	 */
	public int getGrp() {
		return id_grp;
	}
	
	/**
	 * Renvoie l'id de l'enseignant remplacant
	 * @return id de l'enseignant remplacant
	 */
	public int getRemp() {
		return id_ens_remp;
	}
	
	/**
	 * Renvoie l'etat d'absence de l'enseignant initial
	 * 0 = present
	 * 1 = absent
	 * @return etat d'absence enseignant initial
	 */
	public int getAbsent() {
		return estAbsent;
	}
	
	/**
	 * Affecte un nouveau nombre de cours pour la semaine
	 * @param nombre de cours semaine
	 */
	public void setNumCours(int numcours) {
		this.num_cours=numcours;
	}
	
	/**
	 * Affecte une nouvelle duree au cours
	 * @param nouvelle duree du cours (en minutes)
	 */
	public void setDuree(int duree) {
		this.duree=duree;
	}
	
	/**
	 * Affecte une nouvelle date et heure de debut de cours
	 * @param nouvelle date et heure de debut de cours
	 */
	public void setDateEtHeure(DateEtHeure dateEtHeure) {
		this.date_heure=dateEtHeure;
	}
	
	/**
	 * Affecte une nouvelle salle au cours
	 * @param Nouvelle salle du cours
	 */
	public void setSalle(String salle) {
		this.salle=salle;
	}
	
	/**
	 * Affecte une nouvelle matiere au cours
	 * @param nouvelle matiere du cours
	 */
	public void setMatiere(String matiere) {
			this.matiere=matiere;
	}
	
	/**
	 * Affecte un nouvel id au cours
	 * @param nouvel id du cours
	 */
	public void setIdCours(String idCours) {
			this.cou_id=idCours;
	}
	
	/**
	 * Affecte un nouveau remplacant au cours
	 * @param id du nouvel enseignant remplacant
	 */
	public void setRemp(int id_remp) {
		this.id_ens_remp=id_remp;
	}
	
	/**
	 * Affecte un nouveau type de cours 
	 * 0 = CM
	 * 1 = TD
	 * 2 = TP
	 * 3 = DS
	 * @param nouveau type du cours
	 */
	public void setTypeCours(int typeCours) {
			this.type_de_cours=typeCours;
	}
	
	/**
	 * Affecte un nouvel id de groupe
	 * @param id nouveau groupe
	 */
	public void setIdGroupe(int idGroupe) {
		this.id_grp=idGroupe;
	}
	
	/**
	 * Affecte un nouvel enseignant initial
	 * @param id nouvel enseignant initial
	 */
	public void setEns(int id_ens) {
		this.id_ens=id_ens;
	}
	
	/**
	 * Change l'etat d'absence de l'enseignant initial
	 * @param nouvel etat absence enseignant initial
	 */
	public void setAbsent(int absent) {
		this.estAbsent=absent;
	}
	
	/**
	 * Affiche les infos du cours dans la console
	 */
	public void display() {
		System.out.println("id du Cours: "+cou_id);
		System.out.println("num du Cours: "+num_cours);
		System.out.println("Matiere: "+matiere);
		System.out.println("Duree: "+duree);
		System.out.println("Salle: "+salle);
		System.out.println("type de Cours: "+type_de_cours);
		System.out.println("id de l'enseignant: "+id_ens);
		System.out.println("id du Groupe: "+id_grp);
		System.out.println("id de l'enseignant remplacant: "+id_ens_remp);
		System.out.println("estAbsent: "+estAbsent);
		System.out.println("Ce cours aura lieu a:");
		date_heure.afficher();
		
	}

	/*
	 * Ce main n'est pas destinee a etre executee dans le projet, il sert a tester indiduellement les methodes de la classe Cours
	 */
	/*
	public static void main(String[] args) {
		DateEtHeure deh = new DateEtHeure(1,1,1,1,1,1); 
		DateEtHeure deh2 = new DateEtHeure(0,0,0,0,0,0); 
		Cours c1= new Cours("a",1,"algebre",1,deh,"C1225",1,1,1,1,1);
		c1.setAbsent(0);
		c1.setDateEtHeure(deh2);
		DateEtHeure deh3 =c1.getDateEtHeure();
		//c1.display();
		deh3.afficher();
	}
	*/
}