package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table étudiant
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class EtudiantDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public EtudiantDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param supplier le fournisseur a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Etudiant etudiant) {
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
			ps = con.prepareStatement("INSERT INTO ETUDIANT (NOM, PRÉNOM, MAIL, MOTDEPASSE) VALUES(?, ?, ?, ?)");
			
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getMail());
			ps.setString(4, etudiant.getMotDePasse());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
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
	 * Permet de modifier un fournisseur dans la table supplier.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param supplier le fournisseur a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Etudiant etudiant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE etudiant set NOM = ?, PRÉNOM = ?, MAIL = ?, MOTDEPASSE = ? ");
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getMail());
			ps.setString(4, etudiant.getMotDePasse());
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
	 * Permet de supprimer un fournisseur par id dans la table supplier.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param id l'id du supplier à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			ps = con.prepareStatement("DELETE FROM supplier WHERE id = ?");
			ps.setInt(1, id);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Ce fournisseur possede des articles, suppression impossible !"
						         + " Supprimer d'abord ses articles ou utiiser la méthode de suppression avec articles.");
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
	 * Permet de recuperer un fournisseur a partir de sa reference
	 * 
	 * @param reference la reference du fournisseur a recuperer
	 * @return le fournisseur trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	public Etudiant get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Etudiant returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM etudiant WHERE id = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Etudiant(
									       rs.getString("NOM"),
									       rs.getString("PRÉNOM"),
									       rs.getString("MAIL"),
				                           rs.getString("MOTDEPASSE"));
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
	/**
	 * Méthode qui permet à un étudiant de se connecter à l'applicatio ou non
	 */
	public boolean Con(String mail, String motDePasse) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    boolean returnValue=false;

	    try {
	        con = DriverManager.getConnection(URL, LOGIN, PASS);
	        ps = con.prepareStatement("SELECT * FROM ETUDIANT WHERE (MAIL = ? AND MOTDEPASSE = ?)");

	        ps.setString(1, mail);
	        ps.setString(2, motDePasse);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("Utilisateur trouvé");
	            returnValue= true;
	        }
	        

	    } catch (Exception ee) {
	        ee.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (rs != null) rs.close();
	        } catch (Exception ignore) {}

	        try {
	            if (ps != null) ps.close();
	        } catch (Exception ignore) {}

	        try {
	            if (con != null) con.close();
	        } catch (Exception ignore) {}
	    }
	    return returnValue;
	}
	

	/**
	 * Permet de recuperer tous les étudiants stockes dans la table étudiant
	 * 
	 * @return une ArrayList d'étudiant
	 */
	public ArrayList<Etudiant> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Etudiant> returnValue = new ArrayList<Etudiant>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM ETUDIANT ORDER BY id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Etudiant(
						                     rs.getString("NOM"),
						                     rs.getString("PRÉNOM"),
						                     rs.getString("MAIL"),
						                     rs.getString("MOTDEPASSE")));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
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
		EtudiantDAO etudiantDAO = new EtudiantDAO();
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		int[] ids = {424242, 424243, 424244};
		// test du constructeur
		Etudiant e1 = new Etudiant("Amadou", "Mbodj", "monfournisseurprincipal@mail.com","1ère année");
		Etudiant e2 = new Etudiant( "Lala", "Diallo", "monfournisseursecondaire@mail.com","1ère année");
		Etudiant e3 = new Etudiant( "RORO", "Rety", "monfournisseursecours@mail.com","1 ère année");
		// test de la methode add
		returnValue = etudiantDAO.add(e1);
		System.out.println(returnValue + " etudiant ajoute");
		returnValue = etudiantDAO.add(e2);
		System.out.println(returnValue + " etudiant ajoute");
		returnValue = etudiantDAO.add(e3);
		System.out.println(returnValue + " etudiant ajoute");
		System.out.println();
		
		// test de la methode get
		Etudiant eg = etudiantDAO.get(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(eg);
		System.out.println();
		
		// test de la methode getList
		ArrayList<Etudiant> list = etudiantDAO.getList();
		for (Etudiant s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		returnValue = 0;
		for (int id : ids) {
//			returnValue = supplierDAO.delete(id);
			System.out.println(returnValue + " fournisseur supprime");
		}
		
		System.out.println();
	}
}