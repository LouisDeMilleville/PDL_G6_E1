package pdl.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pdl.model.CompteModel;
import pdl.model.JustificatifModel;

public class JustificatifDAO  extends ConnectionDAO{
	
	/**
	 * Constructor
	 * 
	 */
	public JustificatifDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(JustificatifModel justificatif) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			connect = DriverManager.getConnection(URL, LOGIN, PASS);

			//openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("INSERT INTO justificatif(justif_id, justif_date, justif_type_justificatif, etat_justif) VALUES(?, ?, ?, ?)");
			ps.setString(1, justificatif.getTypeJustificatif());
			ps.setInt(2, justificatif.getAnnee());
			ps.setInt(3, justificatif.getMois());
			ps.setInt(4,justificatif.getJour());
			ps.setInt(2, justificatif.getHeure());
			ps.setInt(3, justificatif.getMinute());
			
			

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
	
	
	public int update(JustificatifModel justificatif) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("UPDATE justificatif set justif_id = ?, justif_date = ?, justif_type_justificatif = ?, etat_justif = ?  WHERE justif_id = ?");
			ps.setString(1, justificatif.getTypeJustificatif());
			ps.setInt(2, justificatif.getAnnee());
			ps.setInt(3, justificatif.getMois());
			ps.setInt(4,justificatif.getJour());
			ps.setInt(2, justificatif.getHeure());
			ps.setInt(3, justificatif.getMinute());
			
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
			
			ps = connect.prepareStatement("DELETE FROM justificatif WHERE justif_id = ?");
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
	
	
	public JustificatifModel get(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		JustificatifModel returnValue = null;

		// connexion a la base de donnees
		try {
			 openConnection();

			ps = connect.prepareStatement("SELECT * FROM justificatif WHERE justif_id = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new JustificatifModel(rs.getString("type de justificatif"),
                                             rs.getInt("annee"),
						                     rs.getInt("mois"),
									         rs.getInt("jour"),
									         rs.getInt("heure"),
									         rs.getInt("minute"));
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
	public ArrayList<JustificatifModel> getList() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<JustificatifModel> returnValue = new ArrayList<>();

		// connexion a la base de donnees
		try {
			openConnection();
			
			ps = connect.prepareStatement("SELECT * FROM justificatif ORDER BY justif_id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new JustificatifModel(rs.getString("type de justificatif"),
                                                      rs.getInt("annee"),
	                                                  rs.getInt("mois"),
				                                      rs.getInt("jour"),
				                                      rs.getInt("heure"),
				                                      rs.getInt("minute")));
						                     
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
		
		JustificatifDAO justificatifDAO = new JustificatifDAO();
		
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		
		int[] ids = {424242, 424243, 424244};
		
		// test du constructeur
		
		
		JustificatifModel s1 = new JustificatifModel("medical", 1999, 01, 25, 1, 0);
		JustificatifModel s2 = new JustificatifModel("covid", 2000, 04, 23, 1, 0);
		JustificatifModel s3 = new JustificatifModel("maladie", 2022, 06, 23, 1, 0);
		
		
		// test de la methode add
		
		
		returnValue = justificatifDAO.add(s1);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = justificatifDAO.add(s2);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = justificatifDAO.add(s3);
		System.out.println(returnValue + " utilisateur ajoute");
		System.out.println();
		
		// test de la methode get
		
		JustificatifModel sg = justificatifDAO.get(1);
		
		// appel implicite de la methode toString de la classe Object (a eviter)
		
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		
		ArrayList<JustificatifModel> list = justificatifDAO.getList();
		for (JustificatifModel j: list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			
			
			System.out.println(j.toString());
		}
		
		System.out.println();
		
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		
		
		returnValue = 0;
		for (int id : ids) {
//			returnValue = justificatifDAO.delete(id);
			System.out.println(returnValue + " utilisateur supprime");
		}
		
		System.out.println();
	}

}

