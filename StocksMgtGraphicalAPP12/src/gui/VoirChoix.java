package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.util.ArrayList;

import dao.ChoixDAO;
import model.Etudiant;
import model.Session;

public class VoirChoix extends JPanel {

    private MainApp mainApp;
    private Etudiant etudiantConnecte;

    private JTextArea textArea;
    private JButton btnRetour;

    public VoirChoix(MainApp mainApp, Etudiant etudiantConnecte) {
        this.mainApp = mainApp;
        this.etudiantConnecte = etudiantConnecte;

        setLayout(null);
        initialize();
        afficherChoix();
    }

    private void initialize() {
        btnRetour = new JButton("Retour");
        btnRetour.setBounds(1, 1, 100, 20);
        add(btnRetour);

        btnRetour.addActionListener(e -> {
            mainApp.changerPanel(new EtudiantPanel(mainApp, etudiantConnecte));
        });

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 50, 700, 400);
        add(scrollPane);
    }

    private void afficherChoix() {
        ChoixDAO choixDAO = new ChoixDAO();

        ArrayList<Session> sessions =
            choixDAO.getSessionsChoisies(etudiantConnecte.getIdEtudiant());

        if (sessions.isEmpty()) {
            textArea.setText("Vous n'avez encore fait aucun choix.");
            return;
        }

        for (Session s : sessions) {
            textArea.append(s.display());
            textArea.append("Statut : "+s.getStatut()+"\n");
        }
    }
}