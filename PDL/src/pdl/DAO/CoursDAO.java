package pdl.DAO;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pdl.model.CompteModel;
import pdl.model.CoursModel;


public class CoursDAO  extends ConnectionDAO{
	
	/**
	 * Constructor
	 * 
	 */
	public CoursDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(CoursModel cours) {
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
			
			ps = connect.prepareStatement("INSERT INTO cours(cou_num_cours, cou_matiere, cou_duree, cou_salle, cou_type, cou_id_ens, cou_id_ens_remp, cou_id_grp, cou_absent) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, cours.getNumCours());
			ps.setString(2, cours.getMatiere());
			ps.setInt(3, cours.getDuree());
			ps.setString(4,cours.getSalle());
			ps.setInt(5, cours.getTypeCours());
			ps.setInt(6, cours.getEns());
			ps.setInt(7, cours.getGrp());
			ps.setInt(8, cours.getRemp());
			ps.setBoolean(9,cours.getAbsent());

			// Execution de la requete
			
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Ajout impossible !");
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
	
	
	public int update(CoursModel cours) {
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			
			openConnection();
			
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			
			ps = connect.prepareStatement("UPDATE eleve set cou_num_cours = ?, cou_matiere = ?,cou_duree = ?, cou_salle= ?, cou_type = ?, cou_id_ens = ?, cou_id_ens_remp = ?, cou_id_grp = ?, cou_id_abs = ? WHERE cou_num_cours = ?");
			ps.setInt(1, cours.getNumCours());
			ps.setString(2, cours.getMatiere());
			ps.setInt(3, cours.getDuree());
			ps.setString(4,cours.getSalle());
			ps.setInt(5, cours.getTypeCours());
			ps.setInt(6, cours.getEns());
			ps.setInt(7, cours.getGrp());
			ps.setInt(8, cours.getRemp());
			ps.setBoolean(9,cours.getAbsent());

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
			
			ps = connect.prepareStatement("DELETE FROM cours WHERE cou_num_cours = ?");
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
	
	
	public CoursModel get(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		CoursModel returnValue = null;

		// connexion a la base de donnees
		try {
			 openConnection();

			ps = connect.prepareStatement("SELECT * FROM cours WHERE cou_num_cours = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new CoursModel(rs.getInt("num_cours"),
                                             rs.getString("matiere"),
						                     rs.getInt("duree"),
									         rs.getString("salle"),
									         rs.getInt("type"),
									         rs.getInt("enseignant"),
									         rs.getInt("groupe"));
									         
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
	public ArrayList<CoursModel> getList() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<CoursModel> returnValue = new ArrayList<>();

		// connexion a la base de donnees
		try {
			openConnection();
			
			ps = connect.prepareStatement("SELECT * FROM cours ORDER BY cou_num_cours");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new CoursModel(rs.getInt("num_cours"),
                                               rs.getString("matiere"),
	                                           rs.getInt("duree"),
				                               rs.getString("salle"),
				                               rs.getInt("type"),
				                               rs.getInt("enseignant"),
				                               rs.getInt("groupe")));
				         
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
		
		CoursDAO coursDAO = new CoursDAO();
		
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		
		int[] ids = {424242, 424243, 424244};
		
		// test du constructeur
		
		
		CoursModel s1 = new CoursModel(1, "maths", 1, "charpak", 1, 1, 1);
		CoursModel s2 = new CoursModel(1, "ATS", 1, "charliat", 1, 1, 1);
		CoursModel s3 = new CoursModel(1, "java", 1, "D1430", 1, 1, 1);
		
		
		// test de la methode add
		
		
		returnValue = coursDAO.add(s1);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = coursDAO.add(s2);
		System.out.println(returnValue + " utilisateur ajoute");
		returnValue = coursDAO.add(s3);
		System.out.println(returnValue + " utilisateur ajoute");
		System.out.println();
		
		// test de la methode get
		
		CoursModel sg = coursDAO.get(1);
		
		// appel implicite de la methode toString de la classe Object (a eviter)
		
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		
		ArrayList<CoursModel> list = coursDAO.getList();
		for (CoursModel co: list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			
			
			System.out.println(co.toString());
		}
		
		System.out.println();
		
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		
		
		returnValue = 0;
		for (int id : ids) {
//			returnValue = eleveDAO.delete(id);
			System.out.println(returnValue + " utilisateur supprime");
		}
		
		System.out.println();
	}

}

