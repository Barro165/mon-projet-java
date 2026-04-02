package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table DOMINANTE
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class CampagneDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public CampagneDAO() {
		super();
	}

	/**
	 * Permet de créer une campagne dans la table campagne.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param Campagne la campagne a créer
	 * @return retourne 1 si la dominante est créée et 0 dans le cas contraire
	 */
	public int add(Campagne campagne) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO CAMPAGNE (DATEDEBUT) VALUES(?)");
			
			ps.setString(1, campagne.getDateDebut());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Une campagne est déjà créée !");
			else
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

}
