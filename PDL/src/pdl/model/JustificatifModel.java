package pdl.model;



public class JustificatifModel extends DateEtHeureModel {

	private String typeJustificatif;
	private DateEtHeureModel a = new DateEtHeureModel (1900,1,1,7,0);

	public JustificatifModel(String typeJustif, int annee, int mois, int jour, int heure, int minute) {
		super(annee, mois, jour, heure, minute);
		// TODO Auto-generated constructor stub
		this.typeJustificatif = typeJustif;
	}
	
	public String getTypeJustificatif() {
		return typeJustificatif;
	
	}
	
	public void getDateEtHeure() {
	
		System.out.print("Date: " +a.getJour()+"/"+a.getMois()+"/"+a.getAnnee());
		System.out.print("Heure: "+ a.getHeure()+"H"+ a.getMinute());
	}
	
}
