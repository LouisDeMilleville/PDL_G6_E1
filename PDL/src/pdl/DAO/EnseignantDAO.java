package pdl.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pdl.model.CompteModel;
import pdl.model.EnseignantModel;

public class EnseignantDAO extends ConnectionDAO{

	/**
	 * Constructor
	 * 
	 */
	public EnseignantDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(EnseignantModel enseignant) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("INSERT INTO enseignant(ens_numero, ens_matiere, com_nom, com_prenom, com_mail, com_mdp) VALUES(?, ?, ?, ?)");
			ps.setString(1, enseignant.getNumero());
			ps.setString(2, enseignant.getMatiere());
			ps.setString(3, enseignant.getNom());
			ps.setString(4, enseignant.getPrenom());
			ps.setString(5, enseignant.getMail());
			ps.setString(6, enseignant.getMdp());

			// Execution de la requete
			
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			closeConnection();
		}
		return returnValue;
	}

	/**
	 * Permet de modifier un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param supplier le fournisseur a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	
	
	public int update(EnseignantModel enseignant) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("UPDATE enseignant set com_nom = ?, com_prenom = ?, com_mail = ?, com_mdp = ? WHERE ens_id = ?");
			ps.setString(1, enseignant.getNom());
			ps.setString(2, enseignant.getPrenom());
			ps.setString(3, enseignant.getMail());
			ps.setString(4, enseignant.getMdp());
			ps.setInt(5, enseignant.getId());

			// Execution de la requete
			
			returnValue = ps.executeUpdate();

			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			// fermeture du preparedStatement et de la connexion
			
			
			closeConnection();
		}
		return returnValue;
	}

	/**
	 * Permet de supprimer un fournisseur par id dans la table supplier.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param id l'id du supplier à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	
	public int delete(int id) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			
			ps = connect.prepareStatement("DELETE FROM enseignant WHERE ens_id = ?");
			ps.setInt(1, id);

			// Execution de la requete
			
			returnValue = ps.executeUpdate();
			
			ps.close();
			
		} 
		
		catch (Exception e) {
			e.printStackTrace();

		} 
		
		finally {
			 
			// fermeture du preparedStatement et de la connexion
			 
			closeConnection();
		}
		return returnValue;
	}


	/**
	 * Permet de recuperer un fournisseur a partir de sa reference
	 * 
	 * @param reference la reference du fournisseur a recuperer
	 * @return le fournisseur trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	
	
	public EnseignantModel get(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		EnseignantModel returnValue = null;

		// connexion a la base de donnees
		try {
			 openConnection();

			ps = connect.prepareStatement("SELECT * FROM enseignant WHERE ens_id = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new EnseignantModel(rs .getString("numero"),
						                   rs.getString("matiere"),
						                   rs.getString("nom"),
									       rs.getString("prenom"),
									       rs.getString("mail"),
									       rs.getString("mdp"));
			}
			ps.close();
		} 
		
		catch (Exception ee) {
			ee.printStackTrace();
		} 
		
		finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			
			
             closeConnection();
			
			
		}
		
		return returnValue;
	}

	/**
	 * Permet de recuperer tous les fournisseurs stockes dans la table fournisseur
	 * 
	 * @return une ArrayList de fournisseur
	 */
	public ArrayList<EnseignantModel> getList() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<EnseignantModel> returnValue = new ArrayList<>();

		// connexion a la base de donnees
		try {
			openConnection();
			
			ps = connect.prepareStatement("SELECT * FROM enseignant ORDER BY ens_id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new EnseignantModel(rs.getString("numero"),
						                     rs.getString("matiere"),
					                       	 rs.getString("nom"),
						                     rs.getString("prenom"),
						                     rs.getString("mail"),
						                     rs.getString("mdp")));
			}
			ps.close();
		} 
		
		catch (Exception ee) {
			ee.printStackTrace();
		} 
		
		finally {
			
			// fermeture du rs, du preparedStatement et de la connexion
			
			closeConnection();
		}
		return returnValue;
	}

	
	/**
	 * ATTENTION : Cette méthode n'a pas vocation à être executée lors d'une utilisation normale du programme !
	 * Elle existe uniquement pour TESTER les méthodes écrites au-dessus !
	 * 
	 * @param args non utilisés
	 * @throws SQLException si une erreur se produit lors de la communication avec la BDD
	 */
	
	public static void main(String[] args) throws SQLException {
		int returnValue;
		
		EnseignantDAO enseignantDAO = new EnseignantDAO();
		
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		
		int[] ids = {424242, 424243, 424244};
		
		// test du constructeur
		
		
		EnseignantModel s1 = new EnseignantModel("+33 6 77 89 89 43", "maths", "SERY", "Dorcas", "sery.dorcas@mail.com", "mdp");
		EnseignantModel s2 = new EnseignantModel("+33 6 77 89 89 45", "ATS", "TOURVILLE", "Paul", "tourville.paul@mail.com", "mdp");
		EnseignantModel s3 = new EnseignantModel("+33 6 77 89 89 49", "electromag", "MAKOSSO", "Camille", "makosso.camille@mail.com", "mdp");
		
		
		// test de la methode add
		
		
		returnValue = enseignantDAO.add(s1);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = enseignantDAO.add(s2);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = enseignantDAO.add(s3);
		System.out.println(returnValue + " utilisateur ajoute");
		System.out.println();
		
		// test de la methode get
		
		EnseignantModel sg = enseignantDAO.get(1);
		
		// appel implicite de la methode toString de la classe Object (a eviter)
		
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		
		ArrayList<EnseignantModel> list = enseignantDAO.getList();
		for (EnseignantModel en : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			
			
			System.out.println(en.toString());
		}
		
		System.out.println();
		
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		
		
		returnValue = 0;
		for (int id : ids) {
//			returnValue = enseignantDAO.delete(id);
			System.out.println(returnValue + " utilisateur supprime");
		}
		
		System.out.println();
	}
}
