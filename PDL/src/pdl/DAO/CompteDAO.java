package pdl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Supplier;

import pdl.model.CompteModel;

/**
 * Classe d'acces aux donnees contenues dans la table supplier
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class CompteDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public CompteDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(CompteModel compte) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("INSERT INTO compte(com_nom, com_prenom, com_mail, com_mdp) VALUES(?, ?, ?, ?)");
			ps.setString(1, compte.getNom());
			ps.setString(2, compte.getPrenom());
			ps.setString(3, compte.getMail());
			ps.setString(4,compte.getMdp());

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
	
	
	public int update(CompteModel compte) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("UPDATE compte set com_nom = ?, com_prenom = ?, com_mail = ?, com_mdp = ? WHERE com_id = ?");
			ps.setString(1, compte.getNom());
			ps.setString(2, compte.getPrenom());
			ps.setString(3, compte.getMail());
			ps.setString(4, compte.getMdp());
			ps.setInt(5, compte.getId());

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
			
			ps = connect.prepareStatement("DELETE FROM compte WHERE com_id = ?");
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
	
	
	public CompteModel get(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		CompteModel returnValue = null;

		// connexion a la base de donnees
		try {
			 openConnection();

			ps = connect.prepareStatement("SELECT * FROM compte WHERE com_id = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new CompteModel(rs.getString("nom"),
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
	public ArrayList<CompteModel> getList() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<CompteModel> returnValue = new ArrayList<>();

		// connexion a la base de donnees
		try {
			openConnection();
			
			ps = connect.prepareStatement("SELECT * FROM compte ORDER BY com_id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new CompteModel(rs.getString("nom"),
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
		
		CompteDAO compteDAO = new CompteDAO();
		
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		
		int[] ids = {424242, 424243, 424244};
		
		// test du constructeur
		
		
		CompteModel s1 = new CompteModel("DUPONT", "André", "dupont.andre@mail.com", "mdp");
		CompteModel s2 = new CompteModel("KERMAREC", "Joel", "kermarec.joel@mail.com", "mdp");
		CompteModel s3 = new CompteModel("TIPIAC", "Jeanne", "tipiac.jeanne@mail.com", "mdp");
		
		
		// test de la methode add
		
		
		returnValue = compteDAO.add(s1);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = compteDAO.add(s2);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = compteDAO.add(s3);
		System.out.println(returnValue + " utilisateur ajoute");
		System.out.println();
		
		// test de la methode get
		
		CompteModel sg = compteDAO.get(1);
		
		// appel implicite de la methode toString de la classe Object (a eviter)
		
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		
		ArrayList<CompteModel> list = compteDAO.getList();
		for (CompteModel c : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			
			
			System.out.println(c.toString());
		}
		
		System.out.println();
		
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		
		
		returnValue = 0;
		for (int id : ids) {
			
        // returnValue = supplierDAO.delete(id);
			
			System.out.println(returnValue + " utilisateur supprime");
		}
		
		System.out.println();
	}
}