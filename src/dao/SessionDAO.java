package dao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table SESSIONS
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class SessionDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public SessionDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param campagne la session a ajouter
	 * @return retourne 1  si la session est ajoutee et 0 dans le cas  contraire
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
			ps = con.prepareStatement("INSERT INTO SESSIONS (ID,HEUREDEBUT,HEUREFIN,CAPACITEMAX,SALLE,NOMDOM) VALUES(?,?,?,?,?,?)");
			
			
			ps.setInt(1, campagne.getId());
			ps.setString(2, campagne.getHeureDebut());
			ps.setString(3, campagne.getHeureFin());
			ps.setInt(4, campagne.getCapaciteMax());
			ps.setString(5, campagne.getSalle());
			ps.setString(6, campagne.getNomDom());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette session existe déjà. Ajout impossible !");
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

    public int add(Session sess) {
        return 0;
    }

}