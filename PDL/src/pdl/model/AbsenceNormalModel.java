package pdl.model;

public class AbsenceNormalModel extends DateEtHeureModel {
	
	private int id;
	
	private int etatJustificatif;
	
	private String matiere;
	
	private int duree;
	
	private int nbCours;
	
	private DateEtHeureModel dateHeure = new DateEtHeureModel(1990, 4, 5, 2, 7);
	
	public AbsenceNormalModel(int id, int etatJustificatif, String matiere, int duree, int nbCours, int annee, int mois, int jour, int heure, int minute) 
	{
		super(annee, mois, jour, heure, minute);
		
		this.id = id;
		this.etatJustificatif = etatJustificatif;
		this.matiere = matiere;
		this.duree = duree;
		this.nbCours = nbCours;
		
		
	    
	}
	
	public int getId() {
		return id;
	}
	
	public int getEtat() {
		return etatJustificatif;
	}
	
	public String getMatiere() {
		return matiere;
	}
	
	public int getDuree() {
		return duree;
	}
	
	public int getNbCours() {
		return nbCours;
	}
	
	/*public int getAnnee() {
		return annee;
	}*/
	
	public void setEtatJustificatif(int etat) {
		this.etatJustificatif = etat;
	}
	
	public void afficher()
	{
		System.out.println("la date en jj/mm/aaaa:" + dateHeure.getJour()+"/"+ dateHeure.getMois()+"/"+ dateHeure.getAnnee());
	}

}
