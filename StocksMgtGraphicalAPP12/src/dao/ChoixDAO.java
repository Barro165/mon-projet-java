package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Session;

public class ChoixDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public ChoixDAO() {
		super();
	}


    public void ajouterChoix(int idEtudiant, int idSession) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);

            String sql = "INSERT INTO CHOIX (IDETUDIANT, IDSESSION, STATUT) VALUES (?, ?, ?)";

            ps = con.prepareStatement(sql);

            ps.setInt(1, idEtudiant);
            ps.setInt(2, idSession);
             ps.setString(3, "EN ATTENTE");

            ps.executeUpdate();

            System.out.println("Choix ajouté");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception ignore) {}
            try { if (con != null) con.close(); } catch (Exception ignore) {}
        }
    }
    /**
     * Permet de récupererles sessionchoisies par l'étudiant
     * @param idEtudiant
     * @return
     */
    public ArrayList<Session> getSessionsChoisies(int idEtudiant) {

    ArrayList<Session> liste = new ArrayList<>();

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = DriverManager.getConnection(URL, LOGIN, PASS);

        String sql =
            "SELECT s.ID, s.HEUREDEBUT, s.HEUREFIN, s.CAPACITEMAX, s.SALLE, s.NOMDOM, c.STATUT " +
            "FROM CHOIX c " +
            "JOIN SESSIONS s ON c.IDSESSION= s.ID " +
            "WHERE c.IDETUDIANT = ?";

        ps = con.prepareStatement(sql);
        ps.setInt(1, idEtudiant);

        rs = ps.executeQuery();

        while (rs.next()) {
            Session s = new Session(
                rs.getInt("ID"),
                rs.getString("HEUREDEBUT"),
                rs.getString("HEUREFIN"),
                rs.getInt("CAPACITEMAX"),
                rs.getString("SALLE"),
                rs.getString("NOMDOM")
        
            );
            s.setStatut(rs.getString("STATUT"));

            liste.add(s);
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception ignore) {}
        try { if (ps != null) ps.close(); } catch (Exception ignore) {}
        try { if (con != null) con.close(); } catch (Exception ignore) {}
    }

    return liste;
}
/**
 * Classe qui permet de valider ou non le choix de l'étudiant
 * @param idEtudiant
 * @param idSession
 */
public void validerChoix(int idEtudiant, int idSession) {

    Connection con = null;
    
    String sqlPlaces =
        "SELECT CAPACITEMAX FROM SESSIONS WHERE ID = ?";

    String sqlValidation =
        
        "UPDATE CHOIX SET STATUT = 'VALIDEE' WHERE IDETUDIANT = ? AND IDSESSION = ?"
        ;

    String sqlUpdatePlaces =
        
        "UPDATE SESSIONS SET CAPACITEMAX = CAPACITEMAX - 1 WHERE ID = ?"
        ;

    try {

         con = DriverManager.getConnection(URL, LOGIN, PASS);

        // Vérifier les places
        PreparedStatement psPlaces =
            con.prepareStatement(sqlPlaces);

        psPlaces.setInt(1, idSession);

         ResultSet rs = psPlaces.executeQuery();

        if (rs.next()) {

            int places = rs.getInt("CAPACITEMAX");

            if (places > 0) {

                // Mettre le choix en VALIDEE
                PreparedStatement psValider =
                    con.prepareStatement(sqlValidation);

                psValider.setInt(1, idEtudiant);
                psValider.setInt(2, idSession);

                psValider.executeUpdate();

                // Diminuer les places
                PreparedStatement psUpdate =
                    con.prepareStatement(sqlUpdatePlaces);

                psUpdate.setInt(1, idSession);

                psUpdate.executeUpdate();

            } else {

                 String sqlRefus =
        "UPDATE CHOIX SET STATUT = 'REFUSEE' " +
        "WHERE IDETUDIANT = ? AND IDSESSION = ?";

    PreparedStatement psRefus =
        con.prepareStatement(sqlRefus);

    psRefus.setInt(1, idEtudiant);
    psRefus.setInt(2, idSession);

    psRefus.executeUpdate();

            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void traiterChoix() {
     Connection con = null;
 

    String sql =
        "SELECT IDETUDIANT, IDSESSION " +
        "FROM CHOIX " +
        "WHERE STATUT = 'EN ATTENTE'";

    try {
        

 con = DriverManager.getConnection(URL, LOGIN, PASS);

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int idEtudiant = rs.getInt("IDETUDIANT");
            int idSession = rs.getInt("IDSESSION");

            validerChoix(idEtudiant, idSession);
        }

        JOptionPane.showMessageDialog(null, "Traitement des choix terminé.");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}