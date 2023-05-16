/**
 * @author allagbeolushade
 * @version 1.0
 * @param annee  l'année 
 * @param mois le mois 
 * @param jour le jour
 * @param heure l'heure
 * @param minute la minute
 */
package pdl.model;

public class DateEtHeureModel {

private int annee;
	
	private int mois;
	
	private int jour;
	
	private int heure;
	
	private int minute;
	/**
	 * le constructeur date et heure de l'application utilisable en extension
	 * @param annee
	 * @param mois
	 * @param jour
	 * @param heure
	 * @param minute
	 */
	public DateEtHeureModel (int annee, int mois, int jour , int heure, int minute) {
		
		this.annee = annee;
		this.mois = mois;
		this.jour = jour;
		this.heure = heure;
		this.minute = minute;
	}
	
/**
 * 
 * @return annee
 */
	public int getAnnee() {
		return annee;
	}
	/**
	 * 
	 * @return mois
	 */
	public int getMois() {
		return mois;
	}
	/**
	 * 
	 * @return jour
	 */
	public int getJour() {
		return jour;
	}
	/**
	 * 
	 * @return heure
	 */
	public int getHeure() {
		return heure;
	}
	/**
	 * 
	 * @return minute
	 */
	public int getMinute() {
		return minute;
	}
	/**
	 * 
	 * @param annee l'année modifiée
	 * @return annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	/**
	 * 
	 * @param mois le mois modifié
	 * @return mois
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}
	/**
	 * 
	 * @param jour le jour modifié
	 * @return jour
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}
	/**
	 * 
	 * @param heure l'heure modifiée
	 * @return heure
	 */
	public void setHeure(int heure) {
		this.heure = heure;
	}
	/**
	 * 
	 * @param minute la minute modifée
	 * @return minute
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}
	

}
