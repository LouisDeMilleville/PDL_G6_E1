package pdl.model;

public class EleveModel extends CompteModel {
	
	private String filiere;
	
	private int annee;
	

	public EleveModel(String filiere, int annee, String nom, String prenom, String mail, String mdp) {
		
		super(nom, prenom, mail, mdp);
		
		this.annee = annee;
		this.filiere = filiere;
		
	}
	public int getAnnee() {
		return annee;
		
	}
	public String getFiliere() {
		return filiere;
		
	}
	public void setAnnee(int annee) {
		this.annee = annee;
		
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
		
	}
	
}
