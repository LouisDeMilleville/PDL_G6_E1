public class DateEtHeure {

	private int annee;
	private int mois;
	private int jour;
	private int heure;
	private int minute;
	private int seconde;
	
	public DateEtHeure( int annee, int mois , int jour, int heure, int minute,int seconde)
	{
		this.annee=annee;
		this.mois=mois;
		this.jour=jour;
		this.heure=heure;
		this.minute=minute;
		this.seconde=seconde;
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
	public void setHeure(int heure)
	{
		this.heure=heure;
	}
	public void setMinute(int minute)
	{
		this.minute=minute;
	}
	public void setSeconde(int seconde)
	{
		this.seconde=seconde;
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
	public int getSeconde()
	{
		return seconde;
	}
	
	public void afficher () {
		System.out.println("Date: "+jour+"/"+mois+"/"+annee);
		System.out.println("Heure: "+ heure+":"+minute+":"+seconde);
	}
	
	/*
	 * Ce main n'est pas destinee a etre executee dans le projet, il sert a tester individuellement les methodes de la classe DateEtHeure
	 */
	/*
	public static void main(String[] args) {
		DateEtHeure deh = new DateEtHeure(0,0,0,0,0,0);
		deh.afficher();
		int j=deh.getJour();
		int m=deh.getMois();
		int a=deh.getAnnee();
		int h=deh.getHeure();
		int mi=deh.getMinute();
		int s=deh.getSeconde();
		System.out.println(j+" "+m+" "+a+" "+h+" "+mi+" "+s);
		deh.setJour(1);
		deh.setMois(2);
		deh.setAnnee(3);
		deh.setHeure(1);
		deh.setMinute(2);
		deh.setSeconde(4);
		j=deh.getJour();
		m=deh.getMois();
		a=deh.getAnnee();
		h=deh.getHeure();
		mi=deh.getMinute();
		s=deh.getSeconde();
		System.out.println(j+" "+m+" "+a+" "+h+" "+mi+" "+s);
	}
	*/
}

