/**
 * @author allagbeolushade
 * @version 1.0
 * @param filiere la dominante de l'étudiant
 * @param annee le niveau d'étude
 * @param nom le nom de l'étudiant
 * @param prenom le prenom de l'étudiant
 * @param mail l'adresse de l'étudiant
 * @param mdp le mot de passe de connexion de l'étudiant
 */
package pdl.model;

public class EleveModel extends CompteModel {
	
	private String filiere;
	
	private int annee;
	
/**
 * constructeurs venant de la classe compte
 * @param filiere
 * @param annee
 * @param nom
 * @param prenom
 * @param mail
 * @param mdp
 */
	public EleveModel(String filiere, int annee, String nom, String prenom, String mail, String mdp) {
		
		super(nom, prenom, mail, mdp);
		
		this.annee = annee;
		this.filiere = filiere;
		
	}
	
	/**
	 * 
	 * @return annee
	 */
	public int getAnnee() {
		return annee;
		
	}
	/**
	 * 
	 * @return filiere
	 */
	public String getFiliere() {
		return filiere;
		
	}
	/**
	 * 
	 * @param annee le niveau d'étude modifié
	 * @return la nouvelle année
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
		
	}
	/**
	 * 
	 * @param la filiere  modifiée
	 * @return filiere la nouvelle filière
	 */
	public void setFiliere(String filiere) {
		this.filiere = filiere;
		
	}
	
}
