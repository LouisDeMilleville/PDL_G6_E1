package pdl.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe d'acces a la base de donnees
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class ConnectionDAO {
	/**
	 * Parametres de connexion a la base de donnees oracle
	 * URL, LOGIN et PASS sont des constantes
	 */
	// � utiliser si vous �tes sur une machine personnelle :
	//final static String URL   = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";
	
	// � utiliser si vous �tes sur une machine de l'�cole :
	
	final static String URL   = "jdbc:oracle:thin:@//oracle.esigelec.fr:1521/orcl.intranet.int";

	final static String LOGIN = "C##BDD6_2";   // remplacer les ********. Exemple C##BDD1_1
	final static String PASS  = "BDD62";   // remplacer les ********. Exemple BDD11
	
	public Connection connect = null;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public ConnectionDAO() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			
		}
	}
	
	public void openConnection() {
		if(connect == null) {
			try {
				connect = DriverManager.getConnection(URL, LOGIN, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	 public void closeConnection() {
		 if (connect != null) {
			 try {
				connect.close();
				connect = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	 }
}


