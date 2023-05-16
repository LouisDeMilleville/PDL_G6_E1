/**
 * @author allagbeolushade
 * @version 1.0
 * @param identifiant l'identifiant de l'utilisateur 
 * @param nom le nom de l'utilisateur
 * @param prenom le prénom de l'utilisateur
 * @param mail l'adresse mail de l'utilisateur
 * @param mdp le mot de passe de l'utilisateur
 */
package pdl.model;

public class CompteModel {
	
	private int identifiant;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	private String mdp;
	/**
	 * le constructeur CompteModel
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param mdp
	 */
	public CompteModel(String nom, String prenom, String mail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	/**
	 * 
	 * @return identifiant
	 */
	public int getId() {
		return identifiant;
	}
	/**
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * 
	 * @return mail 
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 
	 * @return mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * 
	 * @param newMdp le mot de passe modifié
	 * @return newMdp
	 */
	public void setMdp(String newMdp) {
		this.mdp = newMdp;
	}
	
	

}
