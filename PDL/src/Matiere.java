
public class Matiere {

	private String nom;
	private int masseCM;
	private int masseTD;
	private int masseTP;
	
	public Matiere (String nom, int masseCM, int masseTD, int masseTP)
	{
		this.nom=nom;
		this.masseCM=masseCM;
		this.masseTD=masseTD;
		this.masseTP=masseTP;
	}
	
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	public void setMasseCM(int masseCM)
	{
		this.masseCM=masseCM;
	}
	
	public void setMasseTD(int masseTD)
	{
		this.masseTD=masseTD;
	}
	
	public void setMasseTP(int masseTP)
	{
		this.masseTP=masseTP;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public int getMasseCM()
	{
		return masseCM;
	}
	
	public int getMasseTD()
	{
		return masseTD;
	}
	
	public int getMasseTP()
	{
		return masseTP;
	}
	
	public int getMasseHoraire()
	{
		int masseHoraire=0;
		masseHoraire= masseCM + masseTD + masseTP;
		return masseHoraire;
	}
}



