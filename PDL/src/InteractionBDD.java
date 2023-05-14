import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette classe permet d'interagir avec la BDD depuis le programme
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */

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
	private DateEtHeure abs_ens_debut;
	private DateEtHeure abs_ens_fin;
    private String cou_id;
	private int cou_num_cours;
	private String cou_matiere;
	private int cou_duree;
	private DateEtHeure cou_date_heure;
	private String cou_salle;
	private int cou_type;
	private int cou_id_ens;
	private int cou_id_grp;
	private int cou_id_ens_remp;
	private int cou_absent;
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
	
	/**
	 * Renvoie la liste des AbsenceDistanciel d'un etudiant
	 * @param etudiant L'etudiant dont on souhaite recuperer les absences
	 * @return La liste des Absences distanciel de l'etudiant
	 */
	
	
	public ArrayList<AbsenceDistanciel> getListAbsenceDistanciel(Etudiant etudiant)
	{
		ArrayList<AbsenceDistanciel> listAbs = new ArrayList<AbsenceDistanciel>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			System.out.println("Recuperation des absences distanciel");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("SELECT * FROM AbsenceDistanciel WHERE abs_dist_id_eleve = ?");
			ps.setInt(1, etudiant.getId());
			rs = ps.executeQuery();
			while(rs.next())
			{
				int abs_dist_id = rs.getInt("abs_dist_id");
				int abs_dist_id_eleve = rs.getInt("abs_dist_id_eleve");
				int abs_dist_duree = rs.getInt("abs_dist_duree");
				String abs_dist_justif = rs.getString("abs_dist_justif");
				int abs_dist_etat_justif = rs.getInt("abs_dist_etat_justif");
				String abs_dist_matiere = rs.getString("abs_dist_matiere");
				AbsenceDistanciel absDist = new AbsenceDistanciel(abs_dist_id, abs_dist_id_eleve, abs_dist_duree, abs_dist_justif, abs_dist_etat_justif, abs_dist_matiere);
				listAbs.add(absDist);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAbs;
	}
	
	/**
	 * Retourne le nombre d'absences distanciel dans la BDD
	 * @return Nombre d'absences distanciel
	 */
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
	
	public void insertAccount(int typeCompte, Etudiant etudiant, Enseignant enseignant, Scolarite scolarite)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		switch(typeCompte)
		{
		case 0:
			try {
				System.out.println("Insertion compte etudiant");
				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("INSERT INTO Eleve (ele_id, ele_nom, ele_prenom, ele_mail, ele_mdp, ele_filiere, ele_annee) VALUES (?, ?, ?, ?, ?, ?, ?)");
				ps.setInt(1, etudiant.getId());
				ps.setString(2, etudiant.getNom());
				ps.setString(3, etudiant.getPrenom());
				ps.setString(4, etudiant.getMail());
				ps.setString(5, etudiant.getMotDePasse());
				ps.setString(6, etudiant.getFiliere());
				ps.setInt(7, etudiant.getAnnee());
				rs = ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				System.out.println("Insertion compte enseignant");
				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("INSERT INTO Enseignant (ens_id, ens_nom, ens_prenom, ens_mail, ens_mdp, ens_numero, ens_matiere) VALUES (?, ?, ?, ?, ?, ?, ?)");
				System.out.println("Test 1");
				ps.setInt(1, enseignant.getId());
				System.out.println("Test 2");
				ps.setString(2, enseignant.getNom());
				System.out.println("Test 3");
				ps.setString(3, enseignant.getPrenom());
				System.out.println("Test 4");
				ps.setString(4, enseignant.getMail());
				System.out.println("Test 5");
				ps.setString(5, enseignant.getMotDePasse());
				System.out.println("Test 6");
				ps.setString(6, enseignant.getNumero());
				System.out.println("Test 7");
				System.out.println("Matiere : "+ enseignant.getMatiere());
				ps.setString(7, enseignant.getMatiere().getNom());
				System.out.println("Test 8");
				rs = ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	/**
	 * Vérifie si un compte existe déjà dans la BDD
	 * @param typeCompte Le type de compte (0 = etudiant, 1 = enseignant, 2 = scolarité)
	 * @param id L'id du compte dont on souhaite vérifier l'existance
	 */
	public boolean idExist(int typeCompte, int id)
	{
		
		boolean returnValue = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		switch(typeCompte)
		{
		case 0:
			try {
				System.out.println("Check compte Etudiant existe");
				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("SELECT * FROM Eleve WHERE ele_id = ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if(rs.next())
				{
					returnValue = true;
				}
				else
				{
					returnValue = false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				System.out.println("Check compte Enseignant existe");
				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("SELECT * FROM Enseignant WHERE ens_id = ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if(rs.next())
				{
					returnValue = true;
				}
				else
				{
					returnValue = false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				System.out.println("Check compte Scolarite existe");
				con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
				ps = con.prepareStatement("SELECT * FROM Scolarite WHERE sco_id = ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if(rs.next())
				{
					returnValue = true;
				}
				else
				{
					returnValue = false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
				returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * Insere une nouvelle absence distanciel dans la BDD
	 * @param idAbs Id de la nouvelle absence
	 * @param idEle Id de l'eleve absent
	 * @param duree Duree de l'absence
	 * @param raison Raison de l'absence
	 * @param etat Etat de validation de l'absence
	 * @param matiere Matiere de l'absence
	 */
	public void insertAbsenceDistanciel(int idAbs, int idEle, int duree, String raison, int etat, String matiere)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			System.out.println("Insertion dans la bdd...");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("INSERT INTO AbsenceDistanciel (abs_dist_id, abs_dist_id_eleve, abs_dist_duree, abs_dist_justif, abs_dist_etat_justif, abs_dist_matiere) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, idAbs);
			ps.setInt(2, idEle);
			ps.setInt(3, duree);
			ps.setString(4, raison);
			ps.setInt(5, etat);
			ps.setString(6, matiere);
			rs = ps.executeQuery();
			System.out.println("Valeur inseree");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Renvoie le debut d'une période de fermeture
	 * @return DateEtHeure de debut d'une periode de fermeture
	 */
	public ArrayList<AbsenceEnseignant> getListAbsenceEnseignant(Enseignant enseignant)
	{
		ArrayList<AbsenceEnseignant> listAbs = new ArrayList<AbsenceEnseignant>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			System.out.println("Recuperation des absences enseignants");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("SELECT * FROM AbsenceEnseignant WHERE abs_ens_id_ens = ?");
			ps.setInt(1, enseignant.getId());
			rs = ps.executeQuery();
			while(rs.next())
			{
				int abs_ens_id = rs.getInt("abs_ens_id");
				int abs_ens_id_ens = rs.getInt("abs_ens_id_ens");
				String abs_ensd=rs.getString("abs_ens_debut");
				DateEtHeure abs_ens_debut = DateEtHeure.toDate(abs_ensd);
				String abs_ensf=rs.getString("abs_ens_fin");
				DateEtHeure abs_ens_fin = DateEtHeure.toDate(abs_ensf);
				String abs_ens_raison= rs.getString("abs_ens_raison");
				AbsenceEnseignant absEns = new AbsenceEnseignant(abs_ens_id, abs_ens_id_ens, abs_ens_debut, abs_ens_fin, abs_ens_raison);
				listAbs.add(absEns);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAbs;
	}
	public int getCountAbsenceEnseignant()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;
		try {
			System.out.println("Recuperation nb absences enseignant dans la bdd...");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("SELECT COUNT(*) AS nb FROM AbsenceEnseignant");
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
	
	public ArrayList<Justificatifabsence> getListJustificatifs(Enseignant enseignant)
	{
		ArrayList<Justificatifabsence> listJus = new ArrayList<Justificatifabsence>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			System.out.println("1");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("SELECT * FROM Justificatif WHERE just_nom_compte = ? AND just_prenom_compte=?");
			ps.setString(1, enseignant.getNom());
			ps.setString(2, enseignant.getPrenom());
			rs = ps.executeQuery();
			while(rs.next())
			{
				int just_id = rs.getInt("just_id");
				String fausse_date = rs.getString("just_date");// A modifier pour manipuler les types dates 
				System.out.println("2: "+ fausse_date);
				DateEtHeure jus_date= DateEtHeure.toDate(fausse_date);
				System.out.println("3");
				//jus_date.afficher();
				String just_type_justificatif= rs.getString("just_type_justificatif");
				String just_raison= rs.getString("just_raison");
				String just_nom_compte= rs.getString("just_nom_compte");
				String just_prenom_compte= rs.getString("just_prenom_compte");
				Justificatifabsence justifens = new Justificatifabsence(just_id,just_type_justificatif,jus_date,just_raison,just_nom_compte,just_prenom_compte);
				listJus.add(justifens);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listJus;
	}
	public int getCountJustifEnseignant()
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;
		try {
			System.out.println("Recuperation nb justif enseignant dans la bdd...");
			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			ps = con.prepareStatement("SELECT COUNT(*) AS nb FROM Justificatif");
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
	
	public DateEtHeure getDebutFermeture() { //Methode pour recup le debut d'une période de fermeture, à modifier
		DateEtHeure debut_fermeture = new DateEtHeure(2023, 03, 28, 18, 00,00);
		return debut_fermeture;
	}
	
	/**
	 * Renvoie la fin d'une période de fermeture
	 * @return DateEtHeure de fin d'une periode de fermeture
	 */
	public DateEtHeure getFinFermeture() { //Methode pour recup la fin d'une période de fermeture, à modifier
		DateEtHeure fin_fermeture = new DateEtHeure(2023, 03, 28, 18, 00,00);
		return fin_fermeture;
	}
	
	/**
	 * Dit si les identifiants rentrés sont correct ou non
	 * @param type Type du compte qui essaye de se connecter
	 * @param Identifiant L'identifiant du compte
	 * @param MotDePasse Le mot de passe du compte
	 * @return Un boolean qui indique si le combo identifiant / mot de passe est correct pour le type de compte choisi
	 */
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
					
					//InterfaceEleve inter = new InterfaceEleve("EsigServices", 800, 800, etudiant);
					new EtudiantGUI(etudiant).main(null, etudiant);
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
					
					//Adapter pour passer ca en array list et recuperer les details de la matiere en question
					//Les masses horaires ci-dessous sont arbitraires et ne correspondent pas necessairement à la réalité
					Matiere mat_obj = new Matiere(matiere, 10, 10, 10);
				
					
					System.out.println("Identifiant : "+ identifiant);
					System.out.println("Nom : "+ nom);
					System.out.println("Prenom : "+ prenom);
					System.out.println("Mail : "+ mail);
					System.out.println("Numero : "+ numero);
					System.out.println("Matiere : "+matiere);
					
					Enseignant enseignant = new Enseignant(Integer.parseInt(identifiant), nom, prenom, mail, mdp, numero, mat_obj);
					
					InterfaceEnseignant inter = new InterfaceEnseignant("EsigServices", 800, 800, enseignant);
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
					

					
					Scolarite sco = new Scolarite(Integer.parseInt(identifiant), nom, prenom, mail, " ", estGestionnaire);
					new InterfaceScolarite("EsigServices", 800, 800, sco);
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
  
	/**
	 * Insere une nouvelle absence enseignant dans la BDD
	 * @param absEnsei Absence à inserer
	 * @return
	 */
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
     
     //TODO MODIFIER LA METHODE PARCE QUE DEH EST NULL 
     public int addCours(Cours coursajout) {
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
		 SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		 DateEtHeure deh = new DateEtHeure(0,0,0,0,0,0);
		 deh = coursajout.getDateEtHeure();
		 System.out.println(deh.getJour());
		 Date dateC= sdf.parse(deh.getJour()+"/"+deh.getMois()+"/"+deh.getAnnee()+" "+deh.getHeure()+":"+deh.getMinute()+":"+deh.getSeconde());
		 java.sql.Date datesC= new java.sql.Date(dateC.getTime());
		 
		 ps = con.prepareStatement("INSERT INTO Cours (cou_num_cours,cou_matiere,cou_duree,cou_date_heure,cou_salle,cou_type,cou_id_ens,cou_id_ens_remp,cou_id_grp,cou_absent,cou_id) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)");
		 ps.setInt(1, coursajout.getNumCours());
		 ps.setString(2,coursajout.getMatiere());
		 ps.setInt(3,coursajout.getDuree());
		 ps.setDate(4,datesC);
		 ps.setString(5, coursajout.getSalle());
		 ps.setInt(6,coursajout.getTypeCours());
		 ps.setInt(7,coursajout.getEns());
		 ps.setInt(8,coursajout.getRemp());
		 ps.setInt(9,coursajout.getGrp());
		 ps.setInt(10,coursajout.getAbsent());
		 ps.setString(11,coursajout.getIdCours());
		
		 
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
     public Cours getCours(String idcoursmodif) {
    	 Connection con = null;
    	 PreparedStatement ps = null;
    	 ResultSet rs = null;
    	 boolean returnValue = false;
    	 DateEtHeure deh = new DateEtHeure(1,1,1,1,1,1);
    	 Cours coursmodif= new Cours (5,"PDL",1,deh,"C1225",1,2,1,1,1,"a");
    	 // connexion a la base de donnees
    	 try {
    	 con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
    	 ps = con.prepareStatement("SELECT * FROM Cours WHERE cou_id = ?");
    	 ps.setString(1, idcoursmodif);
    	 // on execute la requete
    	 // rs contient un pointeur situe juste avant la premiere ligne retournee
    	 rs = ps.executeQuery();
    	 
    	 // passe a la premiere (et unique) ligne retournee
    	 if (rs.next()) {
    		 //GERER LE TYPE DATE 
    		 
    		 String cours_date=rs.getString("cou_date_heure");
    		DateEtHeure cour_date_heure =DateEtHeure.toDateEtHeure(cours_date);
    	         returnValue = true;
    	         cou_num_cours = rs.getInt("cou_num_cours");
    			 cou_matiere=rs.getString("cou_matiere");
    			 cou_duree=rs.getInt("cou_duree");
    			cou_date_heure=cour_date_heure;
    			 cou_salle=rs.getString("cou_salle");
    			 cou_type=rs.getInt("cou_type");
    			 cou_id_ens=rs.getInt("cou_id_ens");
    			 cou_id_ens_remp=rs.getInt("cou_id_ens_remp");
    			 cou_id_grp=rs.getInt("cou_id_grp");
    	         cou_absent=rs.getInt("cou_absent");
    	         cou_id=rs.getString("cou_id");
    	         
   	                System.out.println("Nombre de cours : "+ cou_num_cours);
				    System.out.println("Matiere : "+ cou_matiere);
				    System.out.println("Duree: "+ cou_duree);
					System.out.println("Date Et Heure du cours: "+ cou_date_heure);
					System.out.println("Salle : "+ cou_salle);
					System.out.println("Type de cours : "+cou_type);
					System.out.println("Identifiant de l'enseignant : "+ cou_id_ens);
					System.out.println("Identifiant de l'enseignant remplaçant: "+ cou_id_ens_remp);
					System.out.println("Le professeur est absent?: "+ cou_absent);
					System.out.println("Identifiant du cours : "+ cou_id);
    	         Cours coursamodif= new Cours (cou_num_cours,cou_matiere,cou_duree,cou_date_heure,cou_salle,cou_type,cou_id_ens,cou_id_ens_remp,cou_id_grp,cou_absent,cou_id);
    	         coursmodif=coursamodif;
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
    
    	 return coursmodif;
    	 } 

     public int modifierCours(Cours coursamodif) {
    	 Connection con = null;
    	 PreparedStatement ps = null;
    	 int returnValue = 0;

    	 // connexion a la base de donnees
    	 try {
    	 // tentative de connexion
          con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
			//Recuperer le cours en lui meme 
			int idens=0,idensRemp=0;
			idens=coursamodif.getEns();
			idensRemp=coursamodif.getRemp();
    	 ps = con.prepareStatement("UPDATE Cours set cou_id_ens = ?, cou_id_ens_remp= ? WHERE cou_id = ?");
    	 
    	 ps.setInt(1, idensRemp);
    	 ps.setInt(2, idens);
    	 ps.setString(3,coursamodif.getIdCours());
  
    	 // Execution de la requete
    	 returnValue = ps.executeUpdate();
    	 } catch (Exception e) {
    	 e.printStackTrace();
    	 } finally {
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
     public int delete(Cours coursasupprimer) {
    	 Connection con = null;
    	 PreparedStatement ps = null;
    	 int returnValue = 0;
    	 // connexion a la base de donnees
    	 try {
    	 // tentative de connexion
    	 con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
    	 // preparation de l'instruction SQL, le ? represente la valeur de l'ID
    	 // a communiquer dans la suppression.
    	 // le getter permet de recuperer la valeur de l'ID du fournisseur
    	 ps = con.prepareStatement("DELETE FROM Cours WHERE cou_id = ?");
    	 ps.setString(1,coursasupprimer.getIdCours());
    	 // Execution de la requete
    	 returnValue = ps.executeUpdate();
    	 } catch (Exception e) {
    	 e.printStackTrace(); 
    	 } finally {
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
    	 
     
     /**
      * Renvoie la liste des absences distanciel non traitees par la scolarite (où l'etat de validation vaut 0)
      * @return La liste des absences distanciel non traitees
      */
     public ArrayList<AbsenceDistanciel> getListAbsenceDistanciel()
     {
    	 ArrayList<AbsenceDistanciel> returnValue = new ArrayList<>();
    	 Connection con = null;
 		 PreparedStatement ps = null;
 		 ResultSet rs = null;
 		 try {
 			System.out.println("Recuperation des absences distanciel non validee");
 			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
 			ps = con.prepareStatement("SELECT abs_dist_id, abs_dist_duree, abs_dist_justif, abs_dist_matiere, ele_nom, ele_prenom FROM AbsenceDistanciel INNER JOIN Eleve ON ele_id = absencedistanciel.abs_dist_id_eleve WHERE abs_dist_etat_justif = 0");
 			System.out.println("Here 1");
 			rs = ps.executeQuery();
 			while(rs.next())
 			{
 				int idAbsDist = Integer.parseInt(rs.getString("abs_dist_id"));
 				System.out.println("Here 2");
 				int dureeAbsDist = Integer.parseInt(rs.getString("abs_dist_duree"));
 				System.out.println("Here 3");
 				String justificatif = rs.getString("abs_dist_justif");
 				System.out.println("Here 4");
 				String matiere = rs.getString("abs_dist_matiere");
 				System.out.println("Here 5");
 				String nom = rs.getString("ele_nom");
 				System.out.println("Here 6");
 				String prenom = rs.getString("ele_prenom");
 				System.out.println("Here 7");
 				AbsenceDistanciel absDist = new AbsenceDistanciel(idAbsDist, dureeAbsDist, justificatif, matiere, nom, prenom);
 				returnValue.add(absDist);
 			}
 			System.out.println("Il y a : "+ returnValue.size());
 			return returnValue;
 		 } catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		 }
    	 
    	 
    	 return returnValue;
    	 
     }
     
     /**
      * Valide une absence distanciel
      * @param idAbsDist Id de l'absence distanciel à valider
      */
     public void validerAbsenceDist(int idAbsDist)
 	{
 		Connection con = null;
 		PreparedStatement ps = null;
 		ResultSet rs = null;
 		
 		try {
 			
 			System.out.println("Validation de l'absence...");
 			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
 			ps = con.prepareStatement("UPDATE AbsenceDistanciel SET abs_dist_etat_justif = 1 WHERE abs_dist_id = ?");
 			ps.setInt(1, idAbsDist);
 			rs = ps.executeQuery();
 			System.out.println("Absence validee");
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
     
     /**
      * Refuse une absence distanciel
      * @param idAbsDist Id de l'absence distanciel à refuser
      */
     public void refuserAbsenceDist(int idAbsDist)
  	 {
  		Connection con = null;
  		PreparedStatement ps = null;
  		ResultSet rs = null;
  		
  		try {
  			
  			System.out.println("Refus de l'absence...");
  			con = DriverManager.getConnection(URL_BDD, LOGIN_BDD, PASS_BDD);
  			ps = con.prepareStatement("UPDATE AbsenceDistanciel SET abs_dist_etat_justif = 2 WHERE abs_dist_id = ?");
  			ps.setInt(1, idAbsDist);
  			rs = ps.executeQuery();
  			System.out.println("Absence refusee");
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	 }
     /*
 	 * Ce main n'est pas destinee a etre executee dans le projet, il sert a tester indiciduellement les methodes de la classe InteractionBDD
 	 */
     
 	public static void main(String[] args) {
 		InteractionBDD moduleBDD= new InteractionBDD();
 		DateEtHeure deh = new DateEtHeure(1,1,1,1,1,1);

		Cours c1= new Cours(5,"PDL",1,deh,"C1225",1,2,1,1,1,"a");

		moduleBDD.addCours(c1);

		moduleBDD.getCours(c1.getIdCours());
		
 	}
 
	

}
