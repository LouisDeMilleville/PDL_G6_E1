package pdl.DAO;



	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

import pdl.model.AbsenceDistancielModel;
import pdl.model.CompteModel;
	

	public class AbsenceDistancielDAO  extends ConnectionDAO{
		
		/**
		 * Constructor
		 * 
		 */
		public AbsenceDistancielDAO() {
			super();
		}

		/**
		 * Permet d'ajouter un fournisseur dans la table supplier.
		 * Le mode est auto-commit par defaut : chaque insertion est validee
		 * 
		 * @param supplier le fournisseur a ajouter
		 * @return retourne le nombre de lignes ajoutees dans la table
		 */
		public int add(AbsenceDistancielModel absenceD) {
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
				
				ps = connect.prepareStatement("INSERT INTO eleve(abs_dist_id, abs_dist_id_eleve, abs_dist_duree, abs_dist_justif, abs_dist_etat_justif, abs_dist_matiere) VALUES(?, ?, ?, ?, ?, ?, ?)");
				ps.setInt(1, absenceD.getId());
				ps.setInt(2, absenceD.getEtatJustificatif());
				ps.setString(3, absenceD.getMatiere());
				ps.setInt(4, absenceD.getDuree());
				ps.setInt(5, absenceD.getNbCours());
				ps.setString(6, absenceD.getTypeJustificatif());
				ps.setInt(7, absenceD.getAnnee());
				ps.setInt(8, absenceD.getMois());
				ps.setInt(9, absenceD.getJour());
				ps.setInt(10, absenceD.getHeure());
				ps.setInt(11, absenceD.getMinute());

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
		
		
		public int update(AbsenceDistancielModel absenceD) {
			PreparedStatement ps = null;
			int returnValue = 0;

			// connexion a la base de donnees
			try {

				// tentative de connexion
				
				openConnection();
				
				// preparation de l'instruction SQL, chaque ? represente une valeur
				// a communiquer dans la modification.
				// les getters permettent de recuperer les valeurs des attributs souhaites
				
				ps = connect.prepareStatement("UPDATE absenceD set abs_dist_id_eleve = ?, abs_dist_duree = ?,abs_dist_justif = ?, abs_dist_etat_justif = ?, abs_dist_matiere = ?  WHERE abs_dist_id = ?");
				ps.setInt(1, absenceD.getId());
				ps.setInt(2, absenceD.getEtatJustificatif());
				ps.setString(3, absenceD.getMatiere());
				ps.setInt(4, absenceD.getDuree());
				ps.setInt(5, absenceD.getNbCours());
				ps.setString(6, absenceD.getTypeJustificatif());
				ps.setInt(7, absenceD.getAnnee());
				ps.setInt(8, absenceD.getMois());
				ps.setInt(9, absenceD.getJour());
				ps.setInt(10, absenceD.getHeure());
				ps.setInt(11, absenceD.getMinute());

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
				
				ps = connect.prepareStatement("DELETE FROM absenceD WHERE abs_dist_id = ?");
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
		
		
		public AbsenceDistancielModel get(int id) {
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			AbsenceDistancielModel returnValue = null;

			// connexion a la base de donnees
			try {
				 openConnection();

				ps = connect.prepareStatement("SELECT * FROM absenceD WHERE abs_dist_id = ?");
				ps.setInt(1, id);

				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
				// passe a la premiere (et unique) ligne retournee
				if (rs.next()) {
					returnValue = new AbsenceDistancielModel(rs.getInt("identifiant"),
	                                             rs.getInt("etatJustificatif"),
							                     rs.getString("matiere"),
										         rs.getInt("duree"),
										         rs.getInt("nbCours"),
										         rs.getString("typeJustificatif"),
										         rs.getInt("annee"),
					                             rs.getInt("mois"),
                                                 rs.getInt("heure"),
			                                     rs.getInt("minute"), id);
			                                     
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
		public ArrayList<AbsenceDistancielModel> getList() {

			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ArrayList<AbsenceDistancielModel> returnValue = new ArrayList<>();

			// connexion a la base de donnees
			try {
				openConnection();
				
				ps = connect.prepareStatement("SELECT * FROM absenceD ORDER BY abs_dist_id");

				// on execute la requete
				rs = ps.executeQuery();
				// on parcourt les lignes du resultat
				while (rs.next()) {
					returnValue.add(new AbsenceDistancielModel(rs.getInt("identifiant"),
                            rs.getInt("etatJustificatif"),
		                     rs.getString("matiere"),
					         rs.getInt("duree"),
					         rs.getInt("nbCours"),
					         rs.getString("typeJustificatif"),
					         rs.getInt("annee"),
                            rs.getInt("mois"),
                            rs.getInt("heure"),
                            rs.getInt("minute"), id);
							                     
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
			
			AbsenceDistancielDAO absenceDDAO = new AbsenceDistancielDAO();
			
			// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
			
			int[] ids = {424242, 424243, 424244};
			
			// test du constructeur
			
			
			AbsenceDistancielModel s1 = new AbsenceDistancielModel("finance", 1, "DUPONT", "André", "dupont.andre@mail.com", "mdp");
			AbsenceDistancielModel s2 = new AbsenceDistancielModel("assurance", 2, "KERMAREC", "Joel", "kermarec.joel@mail.com", "mdp");
			AbsenceDistancielModel s3 = new AbsenceDistancielModel("medecine", 7, "TIPIAC", "Jeanne", "tipiac.jeanne@mail.com", "mdp");
			
			
			// test de la methode add
			
			
			returnValue = absenceDDAO.add(s1);
			System.out.println(returnValue + " utilisateur ajoute");
			returnValue = absenceDDAO.add(s2);
			System.out.println(returnValue + " utilisateur ajoute");
			returnValue = absenceDDAO.add(s3);
			System.out.println(returnValue + " utilisateur ajoute");
			System.out.println();
			
			// test de la methode get
			
			AbsenceDistancielModel sg = absenceDDAO.get(1);
			
			// appel implicite de la methode toString de la classe Object (a eviter)
			
			System.out.println(sg);
			System.out.println();
			
			// test de la methode getList
			
			ArrayList<AbsenceDistancielModel> list = absenceDDAO.getList();
			for (AbsenceDistancielModel ad: list) {
				// appel explicite de la methode toString de la classe Object (a privilegier)
				
				
				System.out.println(ad.toString());
			}
			
			System.out.println();
			
			// test de la methode delete
			// On supprime les 3 articles qu'on a créé
			
			
			returnValue = 0;
			for (int id : ids) {
//				returnValue = eleveDAO.delete(id);
				System.out.println(returnValue + " utilisateur supprime");
			}
			
			System.out.println();
		}

	}


