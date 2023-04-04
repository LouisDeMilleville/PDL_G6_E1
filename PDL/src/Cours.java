

public class Cours {

	private int num_cours;
	
	private String matiere;
	
	private int duree;
	
	private String salle;
	
	private int type_de_cours;
	
	private int id_ens;
	
	private int id_grp;
	
	private int id_ens_remp;
	
	private boolean estAbsent;
	
	public Cours(int num_cours, String matiere, int duree, String salle, int type_de_cours, int id_ens, int id_grp) {
	
	
		this.num_cours = num_cours;
		this.matiere = matiere;
		this.duree = duree;
		this.salle = salle;
		this.type_de_cours = type_de_cours;
		this.id_ens = id_ens;
		this.id_grp = id_grp;
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
	
	public boolean getAbsent() {
		return estAbsent;
	}
	
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	public void setSalle(String salle) {
		this.salle = salle;
	}
	
	public void setRemp(int id_remp) {
		this.id_ens_remp = id_remp;
	}
	public void setAbsent(boolean absent) {
		this.estAbsent = absent;
	}
}

//renvoi