package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import dao.SessionDAO;
import model.Session;


public class GererSess extends JPanel {
      private MainApp mainApp;
      
			JLabel Label_1;
			JLabel Label_2;
			JLabel Label_3;
			JLabel Label_4;
			JLabel Label_5;
			
			JTextField TextField_1Txt;
			JTextField TextField_2Txt;
			JTextField TextField_3Txt;
			JTextField TextField_4Txt;
			JTextField TextField_5Txt;
			
			JButton Button_1;
			JButton Button;
    
    public GererSess(MainApp mainApp) {
        
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
		
  Label_1=new JLabel("Heure de début");
  Label_2=new JLabel("Heure de fin");
  Label_3=new JLabel("Capacité maximale");
   Label_4=new JLabel("Salle");
   Label_5=new JLabel("Dominante");
   
   TextField_1Txt =new JTextField();
    TextField_2Txt =new JTextField();
    TextField_3Txt =new JTextField();
    TextField_4Txt =new JTextField();
	TextField_5Txt =new JTextField();
    
    Button_1=new JButton("Retour");
    Button=new JButton("Créer Session");
    Label_1.setBounds(100,100,350,20);
		
			Label_2.setBounds(100,150,350,20);
			Label_3.setBounds(100,200,350,20);
			Label_4.setBounds(100,250,350,20);
			Label_5.setBounds(100,300,350,20);
			
			TextField_1Txt.setBounds(350,100,150,20);
			TextField_2Txt.setBounds(350,150,150,20);
			TextField_3Txt.setBounds(350,200,150,20);
			TextField_4Txt.setBounds(350,250,150,20);
			TextField_5Txt.setBounds(350,300,150,20);
			
			Button.setBounds(200,400,150,20);
			Button_1.setBounds(1,1,100,20);
			
			add (Label_1);
			add (Label_2);
			add (Label_3);
			add (Label_4);
			add (Label_5);
			
			add(TextField_1Txt);
			add(TextField_2Txt);
			add(TextField_3Txt);
			add(TextField_4Txt);
			add(TextField_5Txt);

			add(Button);
			add(Button_1);
			 Button_1.addActionListener(e->{
                mainApp.changerPanel(new Gestion(mainApp));
			});
			Button.addActionListener(e->{
				
				SessionDAO dao=new SessionDAO();
				
				String heureDebut=TextField_1Txt.getText();
				String heureFin=TextField_2Txt.getText();
				String texte_3=TextField_3Txt.getText();
				int capacitéMax=Integer.parseInt(texte_3);
				String salle=TextField_4Txt.getText();
				String nomDom=TextField_5Txt.getText();
				Session sess=new Session(heureDebut,heureFin,capacitéMax,salle,nomDom);
				int existe=dao.add(sess);
				if(existe==1) {
					JOptionPane.showMessageDialog(null,"Session créée" );
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
				
			});


} 
}
