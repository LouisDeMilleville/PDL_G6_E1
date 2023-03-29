public class Etudiant extends Compte{
	
	private String filiere;
	private int annee;
	
	
	public Etudiant (int identifiant, String nom, String prenom, String mail, String mdp, String filiere,int annee)
	{
		super(identifiant, nom, prenom, mail,mdp);
		this.filiere=filiere;
		this.annee=annee;
		}
	
	public int getAnnee()
	{
		return annee;
	}
	
	public String getFiliere()
	{
		return filiere;
	}
	
	public void setAnnee(String annee)
	{
	}
	
	public void setFiliere(int filiere)
	{
	}
	
	
	

}
