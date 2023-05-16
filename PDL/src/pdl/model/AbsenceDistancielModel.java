/**
 * @author allagbeolushade
 * @version 1.0
 * @param id l'identifiant de l'utilisateur
 * @param etatJustificatif justifie le caractère envoyé du justificatif
 * @param matiere la matiere pour laquelle l'on voudrait s'absenter 
 * @param duree la durée de la matière
 * @param nbCours le nombre de cours que l'on devrait rater si l'on est absent
 * @param link le lien d'accès au cours en distanciel
 */
package pdl.model;

public class AbsenceDistancielModel extends JustificatifModel {

private int id;
	
	private int etatJustificatif;
	
	private String matiere;
	
	private int duree;
	
	private int nbCours;
	
	private String link;
	/**
	 * le constructeur
	 * @param id
	 * @param etatJustificatif
	 * @param matiere
	 * @param duree
	 * @param nbCours
	 * @param typeJustif
	 * @param link
	 * @param annee
	 * @param mois
	 * @param jour
	 * @param heure
	 * @param minute
	 */
	public AbsenceDistancielModel(int id, int etatJustificatif, String matiere, int duree, int nbCours, String typeJustif, String link, int annee, int mois, int jour, int heure, int minute) {
		super(typeJustif, annee, mois, jour, heure, minute);
		// TODO Auto-generated constructor stub
		
		this.etatJustificatif = etatJustificatif;
		this.id = id;
		this.matiere= matiere;
		this.duree = duree;
		this.nbCours = nbCours;
		this.link = link;
			
	}
	/**
	 * 
	 * @param lien le lien modifié
	 * @erturn lien 
	 * 
	 */
	public void setLink(String lien) {
		this.link = lien;
	
	}
	/**
	 * 
	 * @return nbCours
	 */

	public int getNbCours() {
		return nbCours;
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
	 * @return matiere
	 */

	public String getMatiere() {
		return matiere;
	}
	/**
	 * 
	 * @return etatJustificatif
	 */

	public int getEtatJustificatif() {
		return etatJustificatif;
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
	 * @param etat l'état du justificatif modifié
	 * @return etat
	 * 
	 */
	
	public void setEtatJustificatif(int etat) {
		this.etatJustificatif = etat;
	}
}

	

