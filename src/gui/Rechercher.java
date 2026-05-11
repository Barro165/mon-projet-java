package gui;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
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

    public Rechercher(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
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
         
         affichage.setText("");
         if(d!=null){

            affichage.append(d.display());
         }
			});
} 
}
