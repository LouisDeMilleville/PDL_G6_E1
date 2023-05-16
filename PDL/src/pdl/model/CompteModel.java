package pdl.model;

public class CompteModel {
	
	private int identifiant;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	private String mdp;
	
	public CompteModel(String nom, String prenom, String mail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	
	public int getId() {
		return identifiant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String newMdp) {
		this.mdp = newMdp;
	}
	
	

}
