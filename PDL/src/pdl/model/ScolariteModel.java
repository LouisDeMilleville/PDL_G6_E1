/**
 * @author Shadé
 * @version 1.0
 * @param identifiant l'identifiant du gestionnaire
 * @param estGestionnaire notifie que la personne est gestionnaire
 * @param nom le nom du gestionnaire
 * @param prenom le prénom du gestionnaie
 * @param mail l'adresse mail du gestionnaire 
 * @param mdp mot de passe du gestionnaire
 */
package pdl.model;

public class ScolariteModel  extends CompteModel{
	
	private boolean estGestionnaire;


	public ScolariteModel(boolean estGestionnaire, int identifiant, String nom, String prenom, String mail, String mdp) {
		super(nom, prenom, mail, mdp);

		this.estGestionnaire = estGestionnaire;
	}
	/**
	 * 
	 * @return estGestionnaire
	 */
	public boolean getGestionnaire() {
		return estGestionnaire;
	}
	/**
	 * 
	 * @param estGest le gestionnaire modifié
	 * @return estGest
	 */
	public void setGestionnaire(boolean estGest) {
		this.estGestionnaire = estGest;
	}
	
	

}
