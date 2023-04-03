import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InteractionBDD {

	// À utiliser si sur une machine de l'école :
	//final static String URL_BDD = "jdbc:oracle:thin:@//srvoracledb.intranet.int:1521/orcl.intranet.int";
	
	// À utiliser si sur une machine personelle
	final static String URL_BDD = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";
	final static String LOGIN_BDD = "C##BDD6_7"; 
	final static String PASS_BDD  = "BDD67";
	private String identifiant;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String filiere;
	private String numero;
	private String matiere;
	private int annee;
	private boolean estGestionnaire;
	
	public InteractionBDD() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
	
	public DateEtHeure getDebutFermeture() { //Methode pour recup le debut d'une période de fermeture, à modifier
		DateEtHeure debut_fermeture = new DateEtHeure(2023, 03, 28, 18, 00);
		return debut_fermeture;
	}
	
	public DateEtHeure getFinFermeture() { //Methode pour recup la fin d'une période de fermeture, à modifier
		DateEtHeure fin_fermeture = new DateEtHeure(2023, 03, 28, 18, 00);
		return fin_fermeture;
	}
	
	public boolean verificationConnexion(int type, String Identifiant, String MotDePasse) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean returnValue = false;

		// connexion a la base de donnees
		if(type == 0) {
			try {

				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("SELECT * FROM Eleve WHERE ele_id = ? AND ele_mdp = ?");
				ps.setString(1, Identifiant);
				ps.setString(2, MotDePasse);

				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
				// passe a la premiere (et unique) ligne retournee
				if (rs.next()) {
					returnValue = true;
					identifiant = rs.getString("ele_id");
					nom = rs.getString("ele_nom");
					prenom = rs.getString("ele_prenom");
					mail = rs.getString("ele_mail");
					mdp = rs.getString("ele_mdp");
					filiere = rs.getString("ele_filiere");
					annee = rs.getInt("ele_annee");
					
					System.out.println("Identifiant : "+ identifiant);
					System.out.println("Nom : "+ nom);
					System.out.println("Prenom : "+ prenom);
					System.out.println("Mail : "+ mail);
					System.out.println("Mdp : "+ mdp);
					System.out.println("Filiere : "+ filiere);
					System.out.println("Annee : "+ annee);
					
					Etudiant etudiant = new Etudiant(Integer.parseInt(identifiant), nom, prenom, mail, mdp, filiere, annee);
					
					InterfaceEleve inter = new InterfaceEleve("EsigServices", 800, 800, etudiant);
					//Ajouter création d'un objet Eleve
				}
				else {
					returnValue = false;
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception ignore) {
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (Exception ignore) {
				}
				
				
			}
		}
		if(type == 1) {
			try {

				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("SELECT * FROM Enseignant WHERE ens_id = ? AND ens_mdp = ?");
				ps.setString(1, Identifiant);
				ps.setString(2, MotDePasse);

				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
				// passe a la premiere (et unique) ligne retournee
				if (rs.next()) {
					returnValue = true;
					identifiant = rs.getString("ens_id");
					nom = rs.getString("ens_nom");
					prenom = rs.getString("ens_prenom");
					mail = rs.getString("ens_mail");
					mdp = rs.getString("ens_mdp");
					numero = rs.getString("ens_numero");
					matiere = rs.getString("ens_matiere");
				
					
					System.out.println("Identifiant : "+ identifiant);
					System.out.println("Nom : "+ nom);
					System.out.println("Prenom : "+ prenom);
					System.out.println("Mail : "+ mail);
					System.out.println("Numero : "+ numero);
					System.out.println("Matiere : "+matiere);
					Enseignant enseignant = new Enseignant(Integer.parseInt(identifiant), nom, prenom, mail, mdp, numero, matiere);
					
					InterfaceEnseignant inter = new InterfaceEnseignant("EsigServices", 800, 800, enseignant/*identifiant*/);
					//public void addAbsence(int abs_ens_id,int identiant,DateEtHeure abs_ens_debut,DateEtHeure abs_ens_fin,String abs_ens_raison){
				   //Recuperer l identifiant du professeur 
					//Creer une id aleatoire a l absence
					//Recuper les text de la date de debut , fin , raison
					//Joindre au bouton inserer une absence
				//}
				}
				else {
					returnValue = false;
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception ignore) {
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (Exception ignore) {
				}
				
				
			}
		}
		if(type == 2) {
			try {

				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("SELECT * FROM Scolarite WHERE sco_id = ? AND sco_mdp = ?");
				ps.setString(1, Identifiant);
				ps.setString(2, MotDePasse);

				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
				// passe a la premiere (et unique) ligne retournee
				if (rs.next()) {
					returnValue = true;
					identifiant = rs.getString("sco_id");
					nom = rs.getString("sco_nom");
					prenom = rs.getString("sco_prenom");
					mail = rs.getString("sco_mail");
					int gestInt = rs.getInt("sco_estGest");
					if(gestInt == 1)
					{
						estGestionnaire = true;
					}
					else {
						estGestionnaire = false;
					}
					System.out.println("Identifiant : "+ identifiant);
					System.out.println("Nom : "+ nom);
					System.out.println("Prenom : "+ prenom);
					System.out.println("Mail : "+ mail);
					System.out.println("Est gestionnaire : "+ estGestionnaire);
					
					//Ajouter création d'un objet Enseignant
				}
				else {
					returnValue = false;
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (Exception ignore) {
				}
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (Exception ignore) {
				}
				try {
					if (con != null) {
						con.close();
					}
				} catch (Exception ignore) {
				}
				
				
			}
		}
		
		return returnValue;
	}
	

}
