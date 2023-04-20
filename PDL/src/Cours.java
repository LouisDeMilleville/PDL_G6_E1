public class Cours {

	private int num_cours;
	private String matiere;
	private int duree;
	private DateEtHeure date_heure;
	private String salle;
	private int type_de_cours;
	private int id_ens;
	private int id_grp;
	private int id_ens_remp;
	private boolean estAbsent;

	public Cours (int num_cours, String matiere,int duree, DateEtHeure date_et_heure, String salle, int type_de_cours,int id_ens, int id_grp) {
		
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
	
	public boolean getAbsent() {
		return estAbsent;
	}
	
	public void setDuree(int duree) {
		
	}
	
	public void setDateEtHeure(DateEtHeure date) {
		
	}
	
	public void setSalle(String salle) {
		
	}
	
	public void setRemp(int id_remp) {
		
	}
	
	public void setAbsent(boolean absent) {
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}