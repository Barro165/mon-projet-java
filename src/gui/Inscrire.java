package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dao.EtudiantDAO;
import model.Etudiant;

import javax.swing.JPasswordField;


public class Inscrire extends JPanel {
    private MainApp mainApp;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JTextField mailTxt;
	

    public Inscrire(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
       
        nomTxt = new JTextField();
		nomTxt.setBounds(400, 3, 150, 20);
		add(nomTxt);
		nomTxt.setColumns(10);
		
		 prenomTxt = new JTextField();
		prenomTxt.setBounds(400, 45, 150, 20);
		add(prenomTxt);
		prenomTxt.setColumns(10);
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Nom");
		lblNewJgoodiesLabel.setBounds(244, 3, 92, 14);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Prénom");
		lblNewJgoodiesLabel_1.setBounds(244, 45, 92, 14);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewLabel = new JLabel("Mot de passe");
		lblNewLabel.setBounds(243, 121, 93, 14);
		add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(400, 121, 140, 20);
		add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setBounds(244, 76, 46, 14);
	   add(lblNewLabel_2);
		
		mailTxt = new JTextField();
		mailTxt.setBounds(400, 76, 140, 20);
		add(mailTxt);
		
		btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.setBounds(361, 164, 89, 23);
		add(btnNewButton_1);
		
			

			JButton Button_1=new JButton("Retour");
			
			
			Button_1.setBounds(1,1,100,20);
			
			add(Button_1);
			 Button_1.addActionListener(e->{
                mainApp.changerPanel(new EtudiantGUI(mainApp));
			});


		/**
		 * Lorsqu'on appuie sur le bouton "S'inscrire", un étudiant est inscrit à la base de donnée"
		 */
		btnNewButton_1.addActionListener(e->{
			EtudiantDAO dao=new EtudiantDAO();
			
			 String nom=nomTxt.getText();
				String prenom=prenomTxt.getText();
				String mail=mailTxt.getText();
				String motDePasse=new String(passwordField.getPassword());
				Etudiant etud=new Etudiant(nom,prenom,mail,motDePasse);
				int resultat=dao.add(etud);
				if(resultat==1) {
					JOptionPane.showMessageDialog(null,"Etudiant ajouté avec succés");
					mainApp.changerPanel(new EtudiantGUI(mainApp));
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
		});	
	}
    
        
} 

