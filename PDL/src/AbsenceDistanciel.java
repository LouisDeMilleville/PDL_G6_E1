
public class AbsenceDistanciel {
	
	private int id;
	private int id_eleve;
	private int duree;
	private String justificatif;
	private int etat;
	private String matiere;
	
	public AbsenceDistanciel(int id, int id_eleve, int duree, String justificatif, int etat, String matiere)
	{
		this.id = id;
		this.id_eleve = id_eleve;
		this.duree = duree;
		this.justificatif = justificatif;
		this.etat = etat;
		this.matiere = matiere;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getIdEleve()
	{
		return id_eleve;
	}
	
	public int getDuree()
	{
		return duree;
	}
	
	public String getJustificatif()
	{
		return justificatif;
	}
	
	public int getEtat()
	{
		return etat;
	}
	
	public String getMatiere()
	{
		return matiere;
	}
	
	public void setDuree(int duree)
	{
		this.duree = duree;
	}
	
	public void setJustificatif(String justificatif)
	{
		this.justificatif = justificatif;
	}
	
	public void setEtat(int etat)
	{
		this.etat = etat;
	}
	
	public void setMatiere(String matiere)
	{
		this.matiere = matiere;
	}

}
