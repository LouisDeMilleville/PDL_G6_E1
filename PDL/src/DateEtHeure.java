
public class DateEtHeure {

	private int annee;
	private int mois;
	private int jour;
	private int heure;
	private int minute;
	
	public DateEtHeure( int annee, int mois , int jour, int heure, int minute)
	{
		this.annee=annee;
		this.mois=mois;
		this.jour=jour;
		this.heure=heure;
		this.minute=minute;
	}
	
	public DateEtHeure( int annee, int mois , int jour)
	{
		this.annee=annee;
		this.mois=mois;
		this.jour=jour;
		
	}
	public void setAnnee(int annee)
	{
		this.annee=annee;
	}
	public void setMois(int mois)
	{
		this.mois=mois;
	}
	public void setJour(int jour)
	{
		this.jour=jour;
	}
	
	
	public int getAnnee ()
	{
		return annee;
	}
	
	public int getMois()
	{
		return mois;
	}
	
	public int getJour()
	{
		return jour;
	}
	
	public int getHeure()
	{
		return heure;
	}
	
	public int getMinute()
	{
		return minute;
	}
	
}


