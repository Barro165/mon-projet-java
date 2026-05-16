package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.util.ArrayList;

import dao.SessionDAO;
import dao.DominanteDAO;
import dao.ChoixDAO;

import model.Session;
import model.Dominante;
import model.Etudiant;

public class Rechercher extends JPanel {

    private MainApp mainApp;
    private Etudiant etudiantConnecte;

    private JButton Button_1 = new JButton("Retour");
    private JButton Button = new JButton("Valider");

    private JComboBox<Dominante> choix1;
    private JComboBox<Dominante> choix2;
    private JComboBox<Dominante> choix3;

    private JComboBox<Session> choixSession1;
    private JComboBox<Session> choixSession2;
    private JComboBox<Session> choixSession3;

    public Rechercher(MainApp mainApp, Etudiant etudiantConnecte) {
        this.mainApp = mainApp;
        this.etudiantConnecte = etudiantConnecte;
        setLayout(null);
        initialize();
    }

    private void remplirSessions(JComboBox<Dominante> comboDom, JComboBox<Session> comboSession) {
        comboSession.removeAllItems();

        Dominante domSelectionnee = (Dominante) comboDom.getSelectedItem();

        if (domSelectionnee == null) {
            return;
        }

        SessionDAO sessionDAO = new SessionDAO();

        Dominante domAvecSessions = sessionDAO.get(domSelectionnee.getNom());

        for (Session s : domAvecSessions.getListeSession()) {
            comboSession.addItem(s);
        }
    }

    private void enregistrerChoix() {
        Session s1 = (Session) choixSession1.getSelectedItem();
        Session s2 = (Session) choixSession2.getSelectedItem();
        Session s3 = (Session) choixSession3.getSelectedItem();
         if (s1.getIdSession() == s2.getIdSession()
            || s1.getIdSession() == s3.getIdSession()
            || s2.getIdSession() == s3.getIdSession()) {

        JOptionPane.showMessageDialog(
            null,
            "Vous ne pouvez pas choisir deux fois la même session."
        );

        return;
    }

        if (s1 == null || s2 == null || s3 == null) {
            JOptionPane.showMessageDialog(null, "Veuillez choisir 3 sessions.");
            return;
        }

        ChoixDAO choixDAO = new ChoixDAO();

        choixDAO.ajouterChoix(etudiantConnecte.getIdEtudiant(), s1.getIdSession());
        choixDAO.ajouterChoix(etudiantConnecte.getIdEtudiant(), s2.getIdSession());
        choixDAO.ajouterChoix(etudiantConnecte.getIdEtudiant(), s3.getIdSession());

        JOptionPane.showMessageDialog(null, "Vos choix ont été enregistrés.");
    }

    private void initialize() {
        choix1 = new JComboBox<>();
        choix2 = new JComboBox<>();
        choix3 = new JComboBox<>();

        choixSession1 = new JComboBox<>();
        choixSession2 = new JComboBox<>();
        choixSession3 = new JComboBox<>();

        choix1.setBounds(50, 100, 200, 25);
        choixSession1.setBounds(300, 100, 350, 25);

        choix2.setBounds(50, 150, 200, 25);
        choixSession2.setBounds(300, 150, 350, 25);

        choix3.setBounds(50, 200, 200, 25);
        choixSession3.setBounds(300, 200, 350, 25);

        add(choix1);
        add(choixSession1);
        add(choix2);
        add(choixSession2);
        add(choix3);
        add(choixSession3);

        Button.setBounds(100, 500, 100, 20);
        add(Button);

        Button_1.setBounds(1, 1, 100, 20);
        add(Button_1);

        Button_1.addActionListener(e -> {
            mainApp.changerPanel(new EtudiantPanel(mainApp, etudiantConnecte));
        });

        DominanteDAO dominanteDAO = new DominanteDAO();
        ArrayList<Dominante> dominantes = dominanteDAO.getDominantes();

        for (Dominante dom : dominantes) {
            choix1.addItem(dom);
            choix2.addItem(dom);
            choix3.addItem(dom);
        }

        choix1.addActionListener(e -> remplirSessions(choix1, choixSession1));
        choix2.addActionListener(e -> remplirSessions(choix2, choixSession2));
        choix3.addActionListener(e -> remplirSessions(choix3, choixSession3));

        Button.addActionListener(e -> enregistrerChoix());
    }
}