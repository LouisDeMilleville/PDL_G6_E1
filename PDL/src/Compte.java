
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
	
	public void setMotDePasse(String nouveau_mdp)
	{
		mot_de_passe=nouveau_mdp;
	}
	
	public int getId()
	{
		return identifiant;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	
	public String getMail()
	{
		return mail;
	}
	
	public String getMotDePasse()
	{
		return mot_de_passe;
	}
	
}
