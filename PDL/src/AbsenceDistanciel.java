/**
 * AbsenceDistanciel est une classe destinée à représenter une absence en présentiel d'un élève qui pourra donner suite ou non
 * à sa mise en distanciel suite à la vérification par un membre de la scolarité
 * 
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */
public class AbsenceDistanciel {
	
	private int id;
	private int id_eleve;
	private int duree;
	private String justificatif;
	private int etat;
	private String matiere;
	private String nom;
	private String prenom;
	
	public AbsenceDistanciel(int id, int id_eleve, int duree, String justificatif, int etat, String matiere)
	{
		this.id = id;
		this.id_eleve = id_eleve;
		this.duree = duree;
		this.justificatif = justificatif;
		this.etat = etat;
		this.matiere = matiere;
	}
	
	
	//Constructeur alternatif pour pouvoir integrer le nom des eleves directement dans une ArrayList d'absences Distanciel
	public AbsenceDistanciel(int id, int duree, String justificatif, String matiere, String nom, String prenom)
	{
		this.id = id;
		this.duree = duree;
		this.justificatif = justificatif;
		this.matiere = matiere;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Retourne l'id de l'absence dans la base de données
	 * @return id absence (int)
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Retourne l'id de l'élève concerné par l'absence
	 * @return id élève (int)
	 */
	public int getIdEleve()
	{
		return id_eleve;
	}
	
	/**
	 * Retourne la durée de l'absence ( en minutes )
	 * @return durée absence en minutes (int)
	 */
	public int getDuree()
	{
		return duree;
	}
	
	/**
	 * Retourne la raison pour laquelle l'élève ne pourra pas être présent en présentiel
	 * @return raison de l'absence (String)
	 */
	public String getJustificatif()
	{
		return justificatif;
	}
	
	/**
	 * Retourne l'état de validation de l'absence par un membre de la scolarité
	 * 0 : Absence pas encore traitée
	 * 1 : Absence acceptée, l'élève devra suivre le cours en distanciel via un lien
	 * 2 : Absence refusée, l'élève devra être présent au cours et sera compté absent s'il ne l'est pas
	 * @return état de validation de l'absence par un membre de la scolarité (int)
	 */
	public int getEtat()
	{
		return etat;
	}
	
	/**
	 * Retourne la matière du cours durant laquelle l'absence est prévue
	 * @return matière cours (String)
	 */
	public String getMatiere()
	{
		return matiere;
	}
	
	/**
	 * Retourne le nom de l'élève
	 * @return Nom de l'élève (String)
	 */
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Retourne le prenom de l'élève
	 * @return Prenom de l'élève (String)
	 */
	public String getPrenom()
	{
		return prenom;
	}
	
	/**
	 * Change la durée de l'absence
	 * @param duree de l'absence
	 */
	public void setDuree(int duree)
	{
		this.duree = duree;
	}
	
	/**
	 * Change la raison de l'absence
	 * @param nouvelle raison de l'absence
	 */
	public void setJustificatif(String justificatif)
	{
		this.justificatif = justificatif;
	}
	
	/**
	 * Change l'état de validation de l'absence
	 * @param nouvel état de validation
	 */
	public void setEtat(int etat)
	{
		this.etat = etat;
	}
	
	/**
	 * Change la matière de l'absence
	 * @param Nouveau nom de la matière
	 */
	public void setMatiere(String matiere)
	{
		this.matiere = matiere;
	}

}
