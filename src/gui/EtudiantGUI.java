package gui;

import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import dao.EtudiantDAO;


public class EtudiantGUI extends JPanel {
    private MainApp mainApp;
	private JTextField mailetudiantTxt;
	private JTextField motdepasseetudiantTxt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	

    public EtudiantGUI(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
        mailetudiantTxt = new JTextField();
		mailetudiantTxt.setBounds(400, 0, 150, 20);
		add(mailetudiantTxt);
		mailetudiantTxt.setColumns(10);
		
		 motdepasseetudiantTxt = new JTextField();
		motdepasseetudiantTxt.setBounds(400, 42, 150, 20);
		add(motdepasseetudiantTxt);
		motdepasseetudiantTxt.setColumns(10);
		
		JButton Button_1=new JButton("Retour");
			Button_1.setBounds(1,1,100,20);
			add(Button_1);
			 Button_1.addActionListener(e->{
            	 mainApp.changerPanel(new Rang(mainApp));
			});
		
		/**
		 * Lorsqu'on appuie sur le bouton "Connecter", le programme va chercher si cette personn existe ou pas
		 */
		btnNewButton = new JButton("Se connecter");
		btnNewButton.setBounds(349, 119, 113, 23);
		add(btnNewButton);
		btnNewButton.addActionListener(e->{
			EtudiantDAO dao=new EtudiantDAO();
			String mail=mailetudiantTxt.getText();
			String motDePasse=motdepasseetudiantTxt.getText();
			boolean existe=dao.Con(mail,motDePasse);
			
			if(existe) {
				JOptionPane.showMessageDialog(null,"Carré" );
				mainApp.changerPanel(new EtudiantPanel(mainApp));
			}else {
				JOptionPane.showMessageDialog(null,"Nope" );
			}
		});
		
		btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.setBounds(349, 219, 113, 23);
		add(btnNewButton_1);
		
		/**
		 * Lorsqu'on appuie sur le bouton inscrire, on  est renvoyé vers la fenetre inscrire
		 */
	     btnNewButton_1.addActionListener(e -> {
		 mainApp.changerPanel(new Inscrire(mainApp));
	     });
		
		JLabel lblNewJgoodiesLabel = new JLabel("Email");
		lblNewJgoodiesLabel.setBounds(244, 3, 92, 14);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = new JLabel("Mot de passe");
		lblNewJgoodiesLabel_1.setBounds(244, 45, 92, 14);
		add(lblNewJgoodiesLabel_1);
    
        
    
        
} 
}
