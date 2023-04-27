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
	
	public String getIdCours() {
	    	return cou_id;
	}
				
	public int getNumCours() {
		return num_cours;
	}
    	
	public String getMatiere() {
		return matiere;
	}
	
	public int getDuree() {
		return duree;
	}
	
	public DateEtHeure getDateEtHeure() {
		return date_heure;
	}
   
	public String getSalle() {
		return salle;
	}
	
	public int getTypeCours() {
		return type_de_cours;
	}
	
	public int getEns() {
		return id_ens;
	}
	
	public int getGrp() {
		return id_grp;
	}
	
	public int getRemp() {
		return id_ens_remp;
	}
	
	public int getAbsent() {
		return estAbsent;
	}
	
	public void setNumCours(int numcours) {
		this.num_cours=numcours;
	}
	
	public void setDuree(int duree) {
		this.duree=duree;
	}
	
	public void setDateEtHeure(DateEtHeure dateEtHeure) {
		this.date_heure=dateEtHeure;
	}
	
	public void setSalle(String salle) {
		this.salle=salle;
	}
	
	public void setMatiere(String matiere) {
			this.matiere=matiere;
	}
	
	public void setIdCours(String idCours) {
			this.cou_id=idCours;
	}
	
	public void setRemp(int id_remp) {
		this.id_ens_remp=id_remp;
	}
	
	public void setTypeCours(int typeCours) {
			this.type_de_cours=typeCours;
	}
	
	public void setIdGroupe(int idGroupe) {
		this.id_grp=idGroupe;
	}
	
	public void setEns(int id_ens) {
		this.id_ens=id_ens;
	}
	
	public void setAbsent(int absent) {
		this.estAbsent=absent;
	}
	
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