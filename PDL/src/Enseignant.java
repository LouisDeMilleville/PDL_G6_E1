import java.util.ArrayList;
public class Enseignant extends Compte{
	
	private String numero;
	private ArrayList<Matiere> listeDesMatieres=new ArrayList<>();
	
	
	public Enseignant (int identifiant, String nom, String prenom, String mail, String mdp, String numero, ArrayList<Matiere> lesMatieres)
	{
		super(identifiant, nom, prenom, mail,mdp);
		this.numero=numero;
		Matiere matiere;
		for(int i=0; i< lesMatieres.size(); i++)
		{
			matiere= lesMatieres.get(i);
			listeDesMatieres.add(matiere);
		}
	}
	
	public String getNumero()
	{
		return numero;
	}
	
	public ArrayList<Matiere> getMatiere()
	{
		return listeDesMatieres;
	}
	
	public void setNumero(String num)
	{
		numero=num;
	}
	
	public void setMatiere (ArrayList<Matiere> listeModifMatieres)
	{
		for(int i=0; i< listeDesMatieres.size(); i++)
		{
			listeDesMatieres.remove(i);
		}
		Matiere matiere;
		for(int i=0; i< listeModifMatieres.size(); i++)
		{
			matiere= listeModifMatieres.get(i);
			listeDesMatieres.add(i,matiere);
		}
	}
	
	public void addMatiere (ArrayList<Matiere> listeNouvellesMatieres)
	{
		Matiere matiere;
		for(int i=0; i< listeNouvellesMatieres.size(); i++)
		{
			matiere= listeNouvellesMatieres.get(i);
			listeDesMatieres.add(matiere);
		}
	}

}
