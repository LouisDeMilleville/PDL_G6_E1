
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
	
	public void setDebut(DateEtHeure debut)
	{
		this.debut=debut;
	}
	
	public void setFin (DateEtHeure fin)
	{
		this.fin=fin;
	}
	
	public void setRaison(String raison)
	{
		this.raison=raison;
	}
	
	public int getIdAbs()
	{
		return idAbs;
	}
	
	public int getIdEns()
	{
		return idEns;
	}
	
	public DateEtHeure getDebut()
	{
		return debut;
	}
	
	public DateEtHeure getFin()
	{
		return fin;
	}
	
	public String getRaison()
	{
		return raison;
	}
	
	

}



