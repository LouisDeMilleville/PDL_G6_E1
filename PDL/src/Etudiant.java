/**
 * Cette classe représente un Etudiant
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

public class Etudiant extends Compte{
	
	private String filiere;
	private int annee;
	
	
	public Etudiant (int identifiant, String nom, String prenom, String mail, String mdp, String filiere,int annee)
	{
		super(identifiant, nom, prenom, mail,mdp);
		this.filiere=filiere;
		this.annee=annee;
		}
	
	/**
	 * Renvoie l'annee de la promotion de l'etudiant
	 * @return annee promotion
	 */
	public int getAnnee()
	{
		return annee;
	}
	
	/**
	 * Renvoie la filiere de l'etudiant
	 * @return filiere de l'etudiant
	 */
	public String getFiliere()
	{
		return filiere;
	}
	
	/**
	 * Affecte une nouvelle annee de promotion
	 * @param annee Nouvelle annee de promotion
	 */
	public void setAnnee(int annee)
	{
		this.annee = annee;
	}
	
	/**
	 * Affecte une nouvelle filiere à l'etudiant
	 * @param filiere Nouvelle filiere
	 */
	public void setFiliere(String filiere)
	{
		this.filiere = filiere;
	}
	
	
	

}
