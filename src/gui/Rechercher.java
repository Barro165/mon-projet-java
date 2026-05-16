package gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import dao.SessionDAO;
import model.Session;
import dao.DominanteDAO;
import model.Dominante;

public class Rechercher extends JPanel {
    private MainApp mainApp;
    private JTextField textFieldTxt;
    private JButton Button;
    private JTextArea affichage=new JTextArea() ;
    JButton Button_1=new JButton("Retour");
    private JList<Session> listeSessionsAffichees;
private DefaultListModel<Session> modelSessions;

    public Rechercher(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
        modelSessions = new DefaultListModel<>();
listeSessionsAffichees = new JList<>(modelSessions);

listeSessionsAffichees.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

JScrollPane scrollPane = new JScrollPane(listeSessionsAffichees);
scrollPane.setBounds(500, 220, 300, 150);
add(scrollPane);
        Button_1.setBounds(1,1,100,20);
        add(Button_1);
         Button_1.addActionListener(e->{
                mainApp.changerPanel(new EtudiantPanel(mainApp));
			});

        Button = new JButton("Rechercher");
        Button.setBounds(350, 0, 150, 20);
        textFieldTxt = new JTextField();
        textFieldTxt.setBounds(350,100,150,20);
        add(textFieldTxt);
        add(Button);
        affichage.setBounds(500,100,1000,100);
        add(affichage);
        Button.addActionListener(e->{
            
         SessionDAO dao=new SessionDAO();
        String nomDom=textFieldTxt.getText();
         Dominante d=dao.get(nomDom);
          modelSessions.clear();

         affichage.setText("");
         if(d!=null){

            affichage.append(d.display());
             for (Session s : d.getListeSession()) {
            modelSessions.addElement(s);
        }
         }
			});
} 
}
