import java.util.ArrayList;

/**
 * Cette classe représente un Enseignant
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */
public class Enseignant extends Compte{
	
	private String numero;
	private ArrayList<Matiere> listeDesMatieres=new ArrayList<>();
	
	/**
	 * Constructeur pour un enseignant avec plusieurs matieres
	 * @param identifiant
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param mdp
	 * @param numero
	 * @param lesMatieres
	 */
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
	
	/**
	 * Constructeur pour un enseignant avec une seule matiere
	 * @param identifiant
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param mdp
	 * @param numero
	 * @param matiere
	 */
	public Enseignant (int identifiant, String nom, String prenom, String mail, String mdp, String numero, Matiere matiere)
	{
		super(identifiant, nom, prenom, mail,mdp);
		this.numero=numero;
		listeDesMatieres.add(matiere);
	}
	
	/**
	 * Renvoie le numero de telephone de l'enseignant
	 * @return Numero de telephone
	 */
	public String getNumero()
	{
		return numero;
	}
	
	/**
	 * Renvoie la liste des matieres de l'enseignant
	 * @return Liste des matieres de l'enseignant
	 */
	public ArrayList<Matiere> getListMatiere()
	{
		return listeDesMatieres;
	}
	
	public Matiere getMatiere()
	{
		return listeDesMatieres.get(0);
	}
	
	/**
	 * Affecte un nouveau numero à l'enseignant
	 * @param num Nouveau numero de telephone
	 */
	public void setNumero(String num)
	{
		numero=num;
	}
	
	/**
	 * Affecte une nouvelle liste de matières à l'enseignant
	 * @param listeModifMatieres Liste de nouvelles matieres
	 */
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
	
	/**
	 * Ajoute une ou plusieurs matieres a la liste des matieres de l'enseignant
	 * @param listeNouvellesMatieres Liste des nouvelles matieres
	 */
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
