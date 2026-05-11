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
public class DominanteDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public DominanteDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param dom la  dominante a ajouter
	 * @return retourne 1 si la dominante est ajoutée et 0 si ce n'est oas le cas
	 */
	public int add(Dominante dominante) {
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
			ps = con.prepareStatement("INSERT INTO DOMINANTE (NOM) VALUES(?)");
			
			ps.setString(1, dominante.getNom());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette dominante existe déjà. Ajout impossible !");
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