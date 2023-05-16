/**
 * @author allagbeolushade
 * @version 1.0
 * @param num_cours le numéro du cours
 * @param matiere la matière en question
 * @param duree la durée du cours
 * @param salle la salle de cours en question
 * @param type_de_cours le type de cours (CM TD TP)
 * @param id_ens l'identifiant de l'enseignant
 * @param id_grp l'identifiant du groupe
 * @param id_ens_remp identifiant du remplaçant
 * @param estAbsent notifie l'absence
 * @param distanciel notifie le caractère distanciel du cours 
 */
package pdl.model;

import java.util.Date;

public class CoursModel {
    private int num_cours;
    
    private Date laDate;
	
	private String matiere;
	
	private int duree;
	
	private String salle;
	
	private int type_de_cours;
	
	private int id_ens;
	
	private int id_grp;
	
	private int id_ens_remp;
	
	private boolean estAbsent;
	
	private boolean distanciel;
	
	public CoursModel(int num_cours, Date laDate, String matiere, int duree, String salle, int type_de_cours, int id_ens, int id_grp) {
	
	
		this.num_cours = num_cours;
		this.laDate = laDate;
		this.matiere = matiere;
		this.duree = duree;
		this.salle = salle;
		this.type_de_cours = type_de_cours;
		this.id_ens = id_ens;
		this.id_grp = id_grp;
	}
	/**
	 * 
	 * @return num_cours
	 */
	public int getNumCours() {
		return num_cours;
	}
	/**
	 * 
	 * @return laDate
	 */
	public Date getLaDate() {
		return laDate;
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
	 * @return salle
	 */
	public String getSalle() {
		return salle;
	}
	/**
	 * 
	 * @return type_de_cours
	 */
	public int getTypeCours() {
		return type_de_cours;
	}
	/**
	 * 
	 * @return
	 */
	public int getEns() {
		return id_ens;
	}
	/**
	 * 
	 * @return
	 */
	public int getGrp() {
		return id_grp;
	}
	/**
	 * 
	 * @return id_ens_remp
	 */
	public int getRemp() {
		return id_ens_remp;
	}
	/**
	 * 
	 * @return estAbsent
	 */
	public boolean getAbsent() {
		return estAbsent;
	}
	/**
	 * 
	 * @return distanciel
	 */
	public boolean getDistanciel() {
		return distanciel;
	}
	/**
	 * 
	 * @param newDate la nouvelle date de cours
	 * @return newDate
	 */
	public void setLaDate(Date newDate) {
		this.laDate = newDate;
	}
	/**
	 * 
	 * @param duree
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}
	/**
	 * 
	 * @param salle
	 */
	public void setSalle(String salle) {
		this.salle = salle;
	}
	/**
	 * 
	 * @param id_remp
	 */
	public void setRemp(int id_remp) {
		this.id_ens_remp = id_remp;
	}
	/**
	 * 
	 * @param absent
	 */
	public void setAbsent(boolean absent) {
		this.estAbsent = absent;
	}
	/**
	 * 
	 * @param distanciel
	 */
	public void setDistanciel(boolean distanciel) {
		this.distanciel = distanciel;
	}
}
