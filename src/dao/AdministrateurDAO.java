package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

	/**
	 * Classe d'acces aux donnees contenues dans la table ADMINISTRATEUR
	 * 
	 * @author ESIGELEC - TIC Department
	 * @version 2.0
	 * */
	public class AdministrateurDAO extends ConnectionDAO {
		/**
		 * Constructor
		 * 
		 */
		public AdministrateurDAO() {
			super();
		}

		/**
		 * Permet d'ajouter un fournisseur dans la table supplier.
		 * Le mode est auto-commit par defaut : chaque insertion est validee
		 * 
		 * @param dom la  dominante a ajouter
		 * @return retourne 1 si la dominante est ajoutée et 0 si ce n'est oas le cas
		 */
		public int add(Dominante dom) {
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
				ps = con.prepareStatement("INSERT INTO DOMINANATE (NOM) VALUES(?)");
				
				ps.setString(1, dom.getNom());
			

				// Execution de la requete
				returnValue = ps.executeUpdate();

			} catch (Exception e) {
				if (e.getMessage().contains("ORA-00001"))
					System.out.println("Cette dominanate existe déjà. Ajout impossible !");
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
 * Classe qui permet à l'administrateur de se connecter
 * @param mail le mail entré par l'utilisateur
 * @param motDePasse le mot de passe entré par l'utilisateur
 * @return retourne true si le mail et le mot de passe tapés correspondent àcelui de l'administrateur et false dans le cas contraire
 */

		
		
		public boolean  Conn(String mail,String motDePasse) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
	       boolean returnValue=false;
			// connexion a la base de donnees
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				ps = con.prepareStatement("SELECT * FROM ADMINISTRATEUR WHERE( MAIL = ? AND MOTDEPASSE= ? )");
				ps.setString(1, mail);
				ps.setString(2, motDePasse);
				

				// on execute la requete
				// rs contient un pointeur situe juste avant la premiere ligne retournee
				rs = ps.executeQuery();
				// passe a la premiere (et unique) ligne retournee
				if (rs.next()) {
					System.out.println("Mail et mot de passe correct");
					returnValue= true;
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
			return returnValue;
		}


}
