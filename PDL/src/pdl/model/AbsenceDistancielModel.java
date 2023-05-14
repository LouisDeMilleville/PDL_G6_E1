package pdl.model;

public class AbsenceDistancielModel extends JustificatifModel {

private int id;
	
	private int etatJustificatif;
	
	private String matiere;
	
	private int duree;
	
	private int nbCours;
	
	private String link;
	
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
	
	public void setLink(String lien) {
		this.link = lien;
	
	}

	public int getNbCours() {
		return nbCours;
	}

	public int getDuree() {
		return duree;
	}

	public String getMatiere() {
		return matiere;
	}

	public int getEtatJustificatif() {
		return etatJustificatif;
	}

	public int getId() {
		return id;
	}
	
	public void setEtatJustificatif(int etat) {
		this.etatJustificatif = etat;
	}
}
