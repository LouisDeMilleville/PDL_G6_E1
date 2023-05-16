package pdl.model;

public class ScolariteModel  extends CompteModel{
	
	private boolean estGestionnaire;


	public ScolariteModel(boolean estGestionnaire, int identifiant, String nom, String prenom, String mail, String mdp) {
		super(nom, prenom, mail, mdp);

		this.estGestionnaire = estGestionnaire;
	}
	
	public boolean getGestionnaire() {
		return estGestionnaire;
	}
	public void setGestionnaire(boolean estGest) {
		this.estGestionnaire = estGest;
	}
	
	

}
