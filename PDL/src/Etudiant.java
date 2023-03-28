public class Etudiant extends Compte{
	
	private String filiere;
	private int annee;
	
	
	public Etudiant (int identifiant, String nom, String prenom, String mail, String mdp, String filiere,int annee)
	{
		super(identifiant, nom, prenom, mail,mdp);
		this.filiere=filiere;
		this.annee=annee;
		}
	
	public String getAnnee()
	{
		return annee;
	}
	
	public String geFiliere()
	{
		return filiere;
	}
	
	public void setAnnee(String annee)
	{
	}
	
	public void seFiliere(int filiere)
	{
	}
	
	
	

}
