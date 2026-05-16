package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.DominanteDAO;


import model.Dominante;

public class GererDom extends JPanel {
      private MainApp mainApp;
      JLabel Label;
			JTextField TextFieldTxt;
			JButton Button_1;
			JButton Button;
    
    public GererDom(MainApp mainApp) {
        
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
      Label=new JLabel("Mettez le nom de votre dominante");
      TextFieldTxt =new JTextField();
      Button_1=new JButton("Retour");
      Button=new JButton("Créer dominante");
      Label.setBounds(200,50,350,20);
			TextFieldTxt.setBounds(200,100,150,20);
			Button.setBounds(200,200,150,20);
			Button_1.setBounds(1,1,100,20);
			add (Label);
			add(TextFieldTxt);
			add(Button);
			add(Button_1);
			 Button_1.addActionListener(e->{
                mainApp.changerPanel(new Gestion(mainApp));
			});
			Button.addActionListener(e->{
				
				DominanteDAO dao=new DominanteDAO();
				String nom=TextFieldTxt.getText();
				Dominante dom=new Dominante(nom);
				int existe=dao.add(dom);
				if(existe==1) {
					JOptionPane.showMessageDialog(null,"Dominante créée" );
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
				
			});





} 
}
