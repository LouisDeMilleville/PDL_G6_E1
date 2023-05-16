package pdl.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pdl.model.CompteModel;
import pdl.model.ScolariteModel;

public class ScolariteDAO extends ConnectionDAO{

	/**
	 * Constructor
	 * 
	 */
	public ScolariteDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(ScolariteModel scolarite) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("INSERT INTO scolarite(sco_estGest, com_nom, com_prenom, com_mail, com_mdp) VALUES(?, ?, ?, ?)");
			ps.setInt(1, scolarite.getId());
			ps.setString(1, scolarite.getNom());
			ps.setString(2, scolarite.getPrenom());
			ps.setString(3, scolarite.getMail());
			ps.setString(4, scolarite.getMdp());
			ps.setBoolean(5, false);

			// Execution de la requete
			
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant existe déjà. Ajout impossible !");
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
	
	
	public int update(ScolariteModel scolarite) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("UPDATE compte set sco_estGest = ?, com_nom = ?, com_prenom = ?,com_mail = ?, com_mdp = ? WHERE sco_id = ?");
			if(scolarite.getGestionnaire())
			{
				ps.setInt(1, 1);
			}
			else {
				ps.setInt(1, 0);
			}
			ps.setString(2, scolarite.getNom());
			ps.setString(3, scolarite.getPrenom());
			ps.setString(4, scolarite.getMail());
			ps.setString(5, scolarite.getMdp());
			ps.setInt(6, scolarite.getId());
			
			

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
			
			ps = connect.prepareStatement("DELETE FROM scolarite WHERE sco_id = ?");
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
	
	
	public ScolariteModel get(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ScolariteModel returnValue = null;

		// connexion a la base de donnees
		try {
			 openConnection();

			ps = connect.prepareStatement("SELECT * FROM scolarite WHERE sco_id = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				
				var number = rs.getInt("estGest");
				boolean bitValue = number == 1;
				
				returnValue = new ScolariteModel(bitValue,
						                   rs.getInt("sco_id"),
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
	public ArrayList<ScolariteModel> getList() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<ScolariteModel> returnValue = new ArrayList<>();

		// connexion a la base de donnees
		try {
			openConnection();
			
			ps = connect.prepareStatement("SELECT * FROM scolarite ORDER BY sco_id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				var number = rs.getInt("estGest");
				boolean bitValue = number == 1;
				
				returnValue.add(new ScolariteModel(bitValue,
		                                  rs.getInt("sco_id"),
		                                  rs.getString("nom"),
					                      rs.getString("prenom"),
					                      rs.getString("mail"),
					                      rs.getString("mdp")))  ;
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
		
		ScolariteDAO scolariteDAO = new ScolariteDAO();
		
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		
		int[] ids = {424242, 424243, 424244};
		
		// test du constructeur
		
		
		ScolariteModel s1 = new ScolariteModel(true, 1,"RACHAD", "Yassine", "rachad.yassine@mail.com", "mdp");
		ScolariteModel s2 = new ScolariteModel(false, 2,"OBIN", "Kévin", "obin.kevin@mail.com", "mdp");
		ScolariteModel s3 = new ScolariteModel(true, 3,"KAMAL", "Farah", "kamal.farah@mail.com", "mdp");
		
		
		// test de la methode add
		
		
		returnValue = scolariteDAO.add(s1);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = scolariteDAO.add(s2);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = scolariteDAO.add(s3);
		System.out.println(returnValue + " utilisateur ajoute");
		System.out.println();
		
		// test de la methode get
		
		ScolariteModel sg = scolariteDAO.get(1);
		
		// appel implicite de la methode toString de la classe Object (a eviter)
		
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		
		ArrayList<ScolariteModel> list = scolariteDAO.getList();
		for (ScolariteModel sc : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			
			
			System.out.println(sc.toString());
		}
		
		System.out.println();
		
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		
		
		returnValue = 0;
		for (int id : ids) {
//			returnValue = scolariteDAO.delete(id);
			System.out.println(returnValue + " utilisateur supprime");
		}
		
		System.out.println();
	}
}
