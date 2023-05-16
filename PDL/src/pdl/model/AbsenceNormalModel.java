/**
 * @author allagbeolushade
 * @version 1.0
 * @param id l'identifiant de l'utilisateur absent
 * @param etatJustificatif le caractère envoyé et reçu du justificatif
 * @param matiere la matière dont l'utilisateur voudrait s'absenter
 * @param duree  la durée de l'absence de l'utilisateur
 * @param nbCours le nombre de cours que l'utilisateur devra rater
 */
package pdl.model;

public class AbsenceNormalModel extends DateEtHeureModel {
	
	private int id;
	
	private int etatJustificatif;
	
	private String matiere;
	
	private int duree;
	
	private int nbCours;
	
	private DateEtHeureModel dateHeure = new DateEtHeureModel(1990, 4, 5, 2, 7);
	/**
	 * 
	 * @param id
	 * @param etatJustificatif
	 * @param matiere
	 * @param duree
	 * @param nbCours
	 * @param annee
	 * @param mois
	 * @param jour
	 * @param heure
	 * @param minute
	 */
	public AbsenceNormalModel(int id, int etatJustificatif, String matiere, int duree, int nbCours, int annee, int mois, int jour, int heure, int minute) 
	{
		super(annee, mois, jour, heure, minute);
		
		this.id = id;
		this.etatJustificatif = etatJustificatif;
		this.matiere = matiere;
		this.duree = duree;
		this.nbCours = nbCours;
		
		
	    
	}
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @return etatJustificatif
	 */
	public int getEtat() {
		return etatJustificatif;
	}
	/**
	 * 
	 * @return matiere
	 */
	public String getMatiere() {
		return matiere;
	}
	/**
	 * 
	 * @return duree
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * 
	 * @return nbCours
	 */
	public int getNbCours() {
		return nbCours;
	}
	
	/*public int getAnnee() {
		return annee;
	}*/
	/**
	 * 
	 * @param etat l'état modifié du justificatif
	 * @return etat
	 */
	public void setEtatJustificatif(int etat) {
		this.etatJustificatif = etat;
	}
	
	public void afficher()
	{
		System.out.println("la date en jj/mm/aaaa:" + dateHeure.getJour()+"/"+ dateHeure.getMois()+"/"+ dateHeure.getAnnee());
	}

}
