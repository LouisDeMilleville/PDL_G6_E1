import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
//>>>>>>> branch 'master' of https://github.com/LouisDeMilleville/PDL_G6_E1.git

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
	
	public int getCountAbsenceDistanciel()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;
		try {
			System.out.println("Recuperation nb absences dist dans la bdd...");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("SELECT COUNT(*) AS nb FROM AbsenceDistanciel");
			rs = ps.executeQuery();
			if(rs.next())
			{
				returnValue = rs.getInt("nb");
			}
			System.out.println("Il y a : "+ returnValue);
			return returnValue;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insertAbsenceDistanciel(int idAbs, int idEle, int duree, String raison, int etat, String matiere)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			System.out.println("Insertion dans la bdd...");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("INSERT INTO AbsenceDistanciel (abs_dist_id, abs_dist_id_eleve, abs_dist_duree, abs_dist_justif, abs_dist_etat_justif, abs_dist_matiere) VALUES (?, ?, ?, ?, ?, ?)");
			System.out.println("Step 1");
			ps.setInt(1, idAbs);
			System.out.println("Step 2");
			ps.setInt(2, idEle);
			System.out.println("Step 3");
			ps.setInt(3, duree);
			System.out.println("Step 4");
			ps.setString(4, raison);
			System.out.println("Step 5");
			ps.setInt(5, etat);
			System.out.println("Step 6");
			ps.setString(6, matiere);
			System.out.println("Step 7");
			rs = ps.executeQuery();
			System.out.println("Valeur insérée");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public int addAbsenceEnseignant(AbsenceEnseignant absEnsei) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 int returnValue = 0;
		 // connexion a la base de donnees
		 try {
		 // tentative de connexion
		 con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
		 // preparation de l'instruction SQL, chaque ? represente une valeur
		 // a communiquer dans l'insertion.
		 // les getters permettent de recuperer les valeurs des attributs
		//souhaites
		 SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		 DateEtHeure deh = absEnsei.getDebut();
		 Date date= sdf.parse(deh.getJour()+"/"+deh.getMois()+"/"+deh.getAnnee());
		 java.sql.Date dates= new java.sql.Date(date.getTime());
		 
		 DateEtHeure deh2 = absEnsei.getFin();
		 Date date2= sdf.parse(deh2.getJour()+"/"+deh2.getMois()+"/"+deh2.getAnnee());
		 java.sql.Date dates2= new java.sql.Date(date2.getTime());
		 
		 ps = con.prepareStatement("INSERT INTO AbsenceEnseignant ( abs_ens_id, abs_ens_id_ens ,  abs_ens_debut, abs_ens_fin, abs_ens_raison  ) VALUES (?, ?, ?, ?,?)");
		 ps.setInt(1, absEnsei.getIdAbs());
		 ps.setInt(2, absEnsei.getIdEns());
		 ps.setDate(3,dates );
		 ps.setDate(4, dates2);
		 ps.setString(5, absEnsei.getRaison());
		
		 
		 // Execution de la requete
		 returnValue = ps.executeUpdate();
		 }
		 catch (Exception e) {
		 if (e.getMessage().contains("20230405"))
		 System.out.println("Cette absence est déjà présente dans la table .Ajout impossible !");
		 else
		 e.printStackTrace();
		 } 
		 finally {
		 // fermeture du preparedStatement et de la connexion
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
		 return returnValue;
		 }
	public int addJustificatifProf(Justificatifabsence justifProf) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 int returnValue = 0;
		 // connexion a la base de donnees
		 try {
		 // tentative de connexion
		 con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
		 // preparation de l'instruction SQL, chaque ? represente une valeur
		 // a communiquer dans l'insertion.
		 // les getters permettent de recuperer les valeurs des attributs
		//souhaites
		 SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		 DateEtHeure deh = justifProf.getDateJustif();
		 Date date= sdf.parse(deh.getJour()+"/"+deh.getMois()+"/"+deh.getAnnee());
		 java.sql.Date dates= new java.sql.Date(date.getTime());
		 
		 
		 ps = con.prepareStatement("INSERT INTO Justificatif (just_id,just_date,just_type_justificatif,just_raison,just_nom_compte,just_prenom_compte) VALUES (?, ?, ?, ?,?,?)");
		 ps.setInt(1, justifProf.getIdJustif());
		 ps.setDate(2,dates );
		 ps.setString(3, justifProf.getTypeJustificatif());
		 ps.setString(4, justifProf.getRaison());
		 ps.setString(5, justifProf.getNomAbsent());
		 ps.setString(6,justifProf.getPrenomAbsent());
		
		 
		 // Execution de la requete
		 returnValue = ps.executeUpdate();
		 }
		 catch (Exception e) {
		 if (e.getMessage().contains("20230405"))
		 System.out.println("Cette absence est déjà présente dans la table .Ajout impossible !");
		 else
		 e.printStackTrace();
		 } 
		 finally {
		 // fermeture du preparedStatement et de la connexion
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
		 return returnValue;
		 }
	

}
