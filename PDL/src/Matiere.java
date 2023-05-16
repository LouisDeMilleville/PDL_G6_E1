/**
 * Cette classe represente une matiere
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */
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
	
	/**
	 * Affecte un nouveau nom à la matiere
	 * @param nom Nouveau nom de la matiere
	 */
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	/**
	 * Affecte une nouvelle masse horaire de CM
	 * @param masseCM Nouvelle masse horaire de CM 
	 */
	public void setMasseCM(int masseCM)
	{
		this.masseCM=masseCM;
	}
	
	/**
	 * Affecte une nouvelle masse horaire de TD
	 * @param masseTD Nouvelle masse horaire de TD
	 */
	public void setMasseTD(int masseTD)
	{
		this.masseTD=masseTD;
	}
	
	/**
	 * Affecte une nouvelle masse horaire de TP
	 * @param masseTP Nouvelle masse horaire de TP
	 */
	public void setMasseTP(int masseTP)
	{
		this.masseTP=masseTP;
	}
	
	/**
	 * Renvoie le nom de la matiere
	 * @return Le nom de la matiere
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Renvoie la masse
	 * @return
	 */
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



