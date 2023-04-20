
public class Scolarite extends Compte{
	
	private Boolean estGestionnaire;
	
	public Scolarite (int identifiant, String nom, String prenom, String mail, String mdp, Boolean estGestionnaire){
		super(identifiant, nom, prenom, mail,mdp);
		}
	
	public Boolean getGestionnaire() {
		return true;
	}
	
	public void setGestionnaire(Boolean estGestionnaire) {
	}
}	
