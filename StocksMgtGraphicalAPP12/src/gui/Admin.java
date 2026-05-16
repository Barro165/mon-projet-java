package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import dao.AdministrateurDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Admin extends JPanel {
      private MainApp mainApp;
    JTextField mailadminTxt;
		 JTextField motdepasseadmintTxt;
		 JButton btnNewButton;
		 JLabel lblLabel;
    public Admin(MainApp mainApp) {
        
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
       lblLabel=new JLabel("Mail");
			lblLabel.setBounds(244, 0, 92, 20);
			add(lblLabel);
			JLabel lblLabel_1 = new JLabel("Mot de passe");
			lblLabel_1.setBounds(244, 42, 92, 20);
			add(lblLabel_1);
		mailadminTxt = new JTextField();
		mailadminTxt.setBounds(400, 0, 150, 20);
		add(mailadminTxt);
		mailadminTxt.setColumns(10);
		
		motdepasseadmintTxt = new JTextField();
		motdepasseadmintTxt.setBounds(400, 42, 150, 20);
		add(motdepasseadmintTxt);
		motdepasseadmintTxt.setColumns(10);
			
	
			JButton Button_1=new JButton("Retour");
			Button_1.setBounds(1,1,100,20);
			add(Button_1);
			 Button_1.addActionListener(e->{
            	 
                mainApp.changerPanel(new Rang(mainApp));
			});
	
		/**
		 * Lorsqu'on appuie sur le bouton "Connecter", leprogramme va chercher si cette personn existe ou pas
		 */
		btnNewButton = new JButton("Se connecter");
		btnNewButton.setBounds(349, 119, 113, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(e->{
			AdministrateurDAO dao=new AdministrateurDAO();
			String mail=mailadminTxt.getText();
			String motDePasse=motdepasseadmintTxt.getText();
			boolean existe=dao.Conn(mail,motDePasse);
			if(existe) {
				JOptionPane.showMessageDialog(null,"Carré" );
                    mainApp.changerPanel(new Gestion(mainApp));
			}else {
				JOptionPane.showMessageDialog(null,"Nope" );
			}
		});
	}
	


}
