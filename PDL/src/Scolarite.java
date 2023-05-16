
public class Scolarite extends Compte{
	
	private boolean estGestionnaire;
	
	public Scolarite (int identifiant, String nom, String prenom, String mail, String mdp, boolean estGestionnaire){
		super(identifiant, nom, prenom, mail,mdp);
		this.estGestionnaire = estGestionnaire;
		}
	
	public boolean getGestionnaire() {
		return estGestionnaire;
	}
	
	public void setGestionnaire(boolean estGestionnaire) {
		this.estGestionnaire = estGestionnaire;
	}
}	
