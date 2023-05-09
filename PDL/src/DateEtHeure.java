/**
 * Cette classe représente une date et une heure, elle peut être utilisee pour dater precisement un cours 
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

public class DateEtHeure {

	private int annee;
	private int mois;
	private int jour;
	private int heure;
	private int minute;
	private int seconde;
	
	/**
	 * Constructeur pour un objet comportant tous les paramètres incluant l'heure précise
	 * @param annee
	 * @param mois
	 * @param jour
	 * @param heure
	 * @param minute
	 * @param seconde
	 */
	public DateEtHeure( int annee, int mois , int jour, int heure, int minute,int seconde)
	{
		this.annee=annee;
		this.mois=mois;
		this.jour=jour;
		this.heure=heure;
		this.minute=minute;
		this.seconde=seconde;
	}
	
	/**
	 * Constructeur s'il n'est pas necessaire de preciser l'heure
	 * @param annee
	 * @param mois
	 * @param jour
	 */
	public DateEtHeure( int annee, int mois , int jour)
	{
		this.annee=annee;
		this.mois=mois;
		this.jour=jour;
		
	}
	
	/**
	 * Affecte une nouvelle annee
	 * @param annee nouvelle annee
	 */
	/*
	 * CONVERTI UN STRING EN UN TYPE DATEETHEURE
	 */
	public static DateEtHeure toDateEtHeure( String date)
	{
		String dateSplit1[]=date.split(" ");
		String dateSplit2[]=dateSplit1[0].split("-");
		String timeSplit[]=dateSplit1[1].split(":");
		
		int annee=Integer.parseInt(dateSplit2[2]);
		int mois=Integer.parseInt(dateSplit2[1]);
		int jour=Integer.parseInt(dateSplit2[0]);
		
		int heure=Integer.parseInt(timeSplit[0]);
		int minute=Integer.parseInt(timeSplit[1]);
		int seconde=Integer.parseInt(timeSplit[2]); 
				
		DateEtHeure dateEtHeure=new DateEtHeure(annee, mois, jour, heure, minute, seconde);
		
		return dateEtHeure;
	}
	
	public static DateEtHeure toDate( String date)
	{
		String dateSplit1[]=date.split(" ");
		String dateSplit2[]=dateSplit1[0].split("-");
		//String timeSplit[]=dateSplit1[1].split(":");
		
		int annee=Integer.parseInt(dateSplit2[2]);
		int mois=Integer.parseInt(dateSplit2[1]);
		int jour=Integer.parseInt(dateSplit2[0]);
		
		//int heure=Integer.parseInt(timeSplit[0]);
		//int minute=Integer.parseInt(timeSplit[1]);
		//int seconde=Integer.parseInt(timeSplit[2]); 
				
		DateEtHeure dateEtHeure=new DateEtHeure(annee, mois, jour);
		
		return dateEtHeure;
	}
	
	public String toString() {
		String stringDate=annee+"/"+mois+"/"+jour;
		return stringDate;
	}
	
	public void setAnnee(int annee)
	{
		this.annee=annee;
	}
	
	/**
	 * Affecte un nouveau mois
	 * @param mois Nouveau mois
	 */
	public void setMois(int mois)
	{
		this.mois=mois;
	}
	/**
	 * Affecte un nouveau jour
	 * @param jour Nouveau jour
	 */
	public void setJour(int jour)
	{
		this.jour=jour;
	}
	
	/**
	 * Affecte une nouvelle heure
	 * @param heure Nouvelle heure
	 */
	public void setHeure(int heure)
	{
		this.heure=heure;
	}
	
	/**
	 * Affecte une nouvelle minute
	 * @param minute Nouvelle minute
	 */
	public void setMinute(int minute)
	{
		this.minute=minute;
	}
	
	/**
	 * Affecte une nouvelle seconde
	 * @param seconde Nouvelle seconde
	 */
	public void setSeconde(int seconde)
	{
		this.seconde=seconde;
	}
	
	/**
	 * Renvoie l'annee
	 * @return l'annee
	 */
	public int getAnnee ()
	{
		return annee;
	}
	
	/**
	 * Renvoie le mois
	 * @return le mois
	 */
	public int getMois()
	{
		return mois;
	}
	
	/**
	 * Renvoie le jour
	 * @return Le jour
	 */
	public int getJour()
	{
		return jour;
	}
	
	/**
	 * Renvoie l'heure
	 * @return L'heure
	 */
	public int getHeure()
	{
		return heure;
	}
	
	/**
	 * Renvoie la minute
	 * @return La minute
	 */
	public int getMinute()
	{
		return minute;
	}
	
	/**
	 * Renvoie la seconde
	 * @return La seconde
	 */
	public int getSeconde()
	{
		return seconde;
	}
	
	/**
	 * Affiche la date et l'heure dans la console
	 */
	public void afficher () {
		System.out.println("Date: "+jour+"/"+mois+"/"+annee);
		System.out.println("Heure: "+ heure+":"+minute+":"+seconde);
	}
	
	
	/*
	 * Ce main n'est pas destinee a etre executee dans le projet, il sert a tester individuellement les methodes de la classe DateEtHeure
	 */
	
	public static void main(String[] args) {
		
//		DateEtHeure deh = new DateEtHeure(11,22,2023,0,0,0);
//		deh.afficher();
//		System.out.println(deh.toString());
//		int j=deh.getJour();
//		int m=deh.getMois();
//		int a=deh.getAnnee();
//		int h=deh.getHeure();
//		int mi=deh.getMinute();
//		int s=deh.getSeconde();
//		System.out.println(j+" "+m+" "+a+" "+h+" "+mi+" "+s);
//		deh.setJour(1);
//		deh.setMois(2);
//		deh.setAnnee(3);
//		deh.setHeure(1);
//		deh.setMinute(2);
//		deh.setSeconde(4);
//		j=deh.getJour();
//		m=deh.getMois();
//		a=deh.getAnnee();
//		h=deh.getHeure();
//		mi=deh.getMinute();
//		s=deh.getSeconde();
//		System.out.println(j+" "+m+" "+a+" "+h+" "+mi+" "+s);
		
		//String dateString="11/05/2023";
		//DateEtHeure.toDate(dateString).afficher();;
	}
	
}

