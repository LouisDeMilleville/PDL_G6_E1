package pdl.model;

public class EnseignantModel extends CompteModel{
	
	private String numero;
	
	private String matiere; 
	

	public EnseignantModel(String numero, String matiere, String nom, String prenom, String mail, String mdp) {
		super(nom, prenom, mail, mdp);
		
		this.matiere = matiere;
		this.numero = numero;
	}


	public String getNumero() {
		return numero;
	}
	
	public String getMatiere() {
		return matiere;
	}
	
	
	
	

}
