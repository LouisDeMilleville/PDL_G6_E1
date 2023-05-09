/**
 * AbsenceEnseignant est une classe destinée à représenter une absence d'un enseignant 
 * 
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

public class AbsenceEnseignant {

	private int idAbs;
	private int idEns;
	private DateEtHeure debut;
	private DateEtHeure fin;
	private String raison;
	
	
	public AbsenceEnseignant(int idAbs, int idEns, DateEtHeure debut, DateEtHeure fin, String raison)
	{
		this.idAbs=idAbs;
		this.idEns=idEns;
		this.debut=debut;
		this.fin=fin;
		this.raison=raison;
	}
	
	/**
	 * Affecte une nouvelle date de début d'absence
	 * @param debut de l'absence
	 */
	public void setDebut(DateEtHeure debut)
	{
		this.debut=debut;
	}
	
	/**
	 * Affecte une nouvelle date de fin d'absence
	 * @param fin de l'absence
	 */
	public void setFin (DateEtHeure fin)
	{
		this.fin=fin;
	}
	
	/**
	 * Affecte une nouvelle raison d'absence
	 * @param raison de l'absence
	 */
	public void setRaison(String raison)
	{
		this.raison=raison;
	}
	
	/**
	 * Affecte un nouvel id d'enseignant absent
	 * @param nouvel id enseignant absent
	 */
	public void setIdEns(int idEns)
	{
		this.idEns=idEns;
	}
	
	/**
	 * Renvoie l'id de l'absence dans la base de données
	 * @return id de l'absence dans la BDD
	 */
	public int getIdAbs()
	{
		return idAbs;
	}
	
	/**
	 * Renvoie l'id de l'enseignant absent
	 * @return id de l'enseignant absent
	 */
	public int getIdEns()
	{
		return idEns;
	}
	
	/**
	 * Renvoie la date de début de l'absence
	 * @return date de début de l'absence
	 */
	public DateEtHeure getDebut()
	{
		return debut;
	}
	
	/**
	 * Renvoie la date de fin de l'absence
	 * @return date de fin de l'absence
	 */
	public DateEtHeure getFin()
	{
		return fin;
	}
	
	/**
	 * Renvoie la raison de l'absence
	 * @return la raison de l'absence
	 */
	public String getRaison()
	{
		return raison;
	}
	
	/**
	 * Affiche les détails de l'absence dans la console
	 */
	public void display() {
		System.out.println("L'absence durera du"+debut+ "au" +fin+  " et a pour id" +idAbs+ ".L'identifiant du professeur est" +idEns+ " et la raison de son absence est " +raison);
	}
}







