/**
 * Cette classe représente un compte utilisateur
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

public class Compte {

	private int identifiant;
	private String nom;
	private String prenom;
	private String mail;
	private String mot_de_passe;
	
	protected Compte (int identifiant, String nom, String prenom, String mail, String mdp)
	{
		this.identifiant=identifiant;
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;
		mot_de_passe=mdp;
	}
	
	/**
	 * Affecte une nouveau mot de passe au compte
	 * @param nouveau mot de passe du compte
	 */
	public void setMotDePasse(String nouveau_mdp)
	{
		mot_de_passe=nouveau_mdp;
	}
	
	/**
	 * Retourne l'identifiant du compte
	 * @return l'identifiant
	 */
	public int getId()
	{
		return identifiant;
	}
	
	/**
	 * Retourne le nom du compte
	 * @return le nom du compte
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Retourne le prénom du compte
	 * @return le prénom du compte
	 */
	public String getPrenom()
	{
		return prenom;
	}
	
	/**
	 * Retourne le mail du compte
	 * @return L'addresse e-mail du compte
	 */
	public String getMail()
	{
		return mail;
	}
	
	/**
	 * Retourne le mot de passe du compte
	 * @return Le mot de passe du compte
	 */
	public String getMotDePasse()
	{
		return mot_de_passe;
	}
	
}