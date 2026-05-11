package dao;
import java.sql.*;

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
	 * @param session la session a ajouter
	 * @return retourne 1  si la session est ajoutee et 0 dans le cas  contraire
	 */
	public int add(Session session) {
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
			ps = con.prepareStatement("INSERT INTO SESSIONS (HEUREDEBUT,HEUREFIN,CAPACITEMAX,SALLE,NOMDOM) VALUES(?,?,?,?,?)");
			
			
	
			ps.setString(1, session.getHeureDebut());
			ps.setString(2, session.getHeureFin());
			ps.setInt(3, session.getCapaciteMax());
			ps.setString(4, session.getSalle());
		ps.setString(5, session.getNomDom());
		
			
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
/**
	 * Permet de rechercher une session
	 * 
	 * @param reference la reference de l'étudiant a recuperer
	 * @return l'étudiant trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	public Dominante get(String nom) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		 Dominante dom=new Dominante(nom);


		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM SESSIONS WHERE NOMDOM = ?");
			ps.setString(1, nom);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			while (rs.next()) {
				Session s = new Session(
									
										   rs.getString("HEUREDEBUT"),
									       rs.getString("HEUREFIN"),
									       rs.getInt("CAPACITEMAX"),
										   rs.getString("SALLE"),
										   rs.getString("NOMDOM")
				                           );
										  
										   dom.ajouterSession(s);

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
		return dom;
	}
    

}