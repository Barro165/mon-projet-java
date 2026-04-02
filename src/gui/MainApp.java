package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.AdministrateurDAO;
import dao.DominanteDAO;
import dao.EtudiantDAO;
import model.Etudiant;
import model.Dominante;
import dao.SessionDAO;
import model.Session;
import dao.CampagneDAO;
import model.Campagne;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MainApp extends JFrame{
	
	public MainApp() {
		setTitle("Connexion à l'application");
		setBounds(100, 100,800 , 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Rang(this));
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public class EtudiantGUI extends JPanel {

	private MainApp mainApp;
	private JTextField mailetudiantTxt;
	private JTextField motdepasseetudiantTxt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	
	public EtudiantGUI(MainApp mainApp) {
		setLayout(null);
		this.mainApp=mainApp;
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
			}else {
				JOptionPane.showMessageDialog(null,"Nope" );
			}
		});
		
		btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.setBounds(349, 219, 113, 23);
		add(btnNewButton_1);
		
		/**
		 * Lorsqu'on appuie sur le bouton inscrire,on  est renvoyé vers la fenetre inscrire
		 */
	     btnNewButton_1.addActionListener(e -> {
		 mainApp.setContentPane(new inscrire(mainApp));
		    mainApp.revalidate();
		    mainApp.repaint();
	     });
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Email");
		lblNewJgoodiesLabel.setBounds(244, 3, 92, 14);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Mot de passe");
		lblNewJgoodiesLabel_1.setBounds(244, 45, 92, 14);
		add(lblNewJgoodiesLabel_1);
	}}

	/**
	 * Classe pour inscrire un étudiant
	 */
public class inscrire extends  JPanel {

	private MainApp mainApp;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JTextField mailTxt;
	

	public inscrire(MainApp mainApp) {
		this.mainApp=mainApp;
		initialize();
		setLayout(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
					 mainApp.setContentPane(new EtudiantGUI(mainApp));
					    mainApp.revalidate();
					    mainApp.repaint();
					
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
		});	
	}
}


/**
 * Classe d'accueil de l'administrateur
 */
public class Admin extends JPanel{
	private MainApp mainApp;
	public Admin(MainApp mainApp) {
		
		this.mainApp=mainApp;
		setLayout(null);
		
		 JTextField mailadminTxt;
		 JTextField motdepasseadmintTxt;
		 JButton btnNewButton;
		 
		 JLabel lblLabel = new JLabel("Mail");
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
				 mainApp.setContentPane(new Gestion(mainApp));
				    mainApp.revalidate();
				    mainApp.repaint();
			}else {
				JOptionPane.showMessageDialog(null,"Nope" );
			}
		});
	}
	
}


/**
 * Classe d'accueil de l'application
 */
	public class Rang extends JPanel{
		private MainApp mainApp;
		public Rang(MainApp mainApp) {
			
			this.mainApp=mainApp;
			setLayout(null);
			JButton admin=new JButton("Administrateur");
			JButton etudiant=new JButton("Etudiant");
			admin.setBounds(100,120,150,20);
			etudiant.setBounds(100,200,150,20);
			add (admin);
			add(etudiant);
			etudiant.addActionListener(e -> {
			    mainApp.setContentPane(new EtudiantGUI(mainApp));
			    mainApp.revalidate();
			    mainApp.repaint();
			});
			admin.addActionListener(e -> {
			    mainApp.setContentPane(new Admin(mainApp));
			    mainApp.revalidate();
			    mainApp.repaint();
			});
		}
	}
	
	
	/**
	 * Classe d'accueil de l'administrateur
	 */
	public class Gestion extends JPanel{
		private MainApp mainApp;
		public Gestion(MainApp mainApp) {
			
			this.mainApp=mainApp;
			setLayout(null);
			JButton dom=new JButton("Créer dominante");
			JButton camp=new JButton("Créer campagne");
			JButton sess=new JButton("Créer session");
			dom.setBounds(200,50,150,20);
			camp.setBounds(200,100,150,20);
			sess.setBounds(200,150,150,20);
			add (dom);
			add(camp);
			add(sess);	
dom.addActionListener(e->{
	 mainApp.setContentPane(new GererDom(mainApp));
	    mainApp.revalidate();
	    mainApp.repaint();
			});
sess.addActionListener(e->{
	 mainApp.setContentPane(new GererSess(mainApp));
	    mainApp.revalidate();
	    mainApp.repaint();
});
		}
	}
	
	
	/**
	 * Classe de création de dominante
	 */
	public class GererDom extends JPanel{
		private MainApp mainApp;
		public GererDom(MainApp mainApp) {
			
			this.mainApp=mainApp;
			setLayout(null);
			JLabel Label=new JLabel("Mettez le nom de votre dominante");
			JTextField TextFieldTxt =new JTextField();
			JButton Button_1=new JButton("Retour");
			JButton Button=new JButton("Créer dominante");
			Label.setBounds(200,50,350,20);
			TextFieldTxt.setBounds(200,100,150,20);
			Button.setBounds(200,200,150,20);
			Button_1.setBounds(1,1,100,20);
			add (Label);
			add(TextFieldTxt);
			add(Button);
			add(Button_1);
			 Button_1.addActionListener(e->{
            	 mainApp.setContentPane(new Gestion(mainApp));
         	    mainApp.revalidate();
         	    mainApp.repaint();
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
	/**
	 * Classe qui permet à l'administrateur de gérer des  sessions
	 */
	 
	public class GererSess extends JPanel{
		private MainApp mainApp;
		public GererSess(MainApp mainApp) {
			
			this.mainApp=mainApp;
			setLayout(null);
			JLabel Label=new JLabel("Id");
			JLabel Label_1=new JLabel("Heure de début");
			JLabel Label_2=new JLabel("Heure de fin");
			JLabel Label_3=new JLabel("Capacité maximale");
			JLabel Label_4=new JLabel("Salle");
			JLabel Label_5=new JLabel("Dominante");
			JTextField TextFieldTxt =new JTextField();
			JTextField TextField_1Txt =new JTextField();
			JTextField TextField_2Txt =new JTextField();
			JTextField TextField_3Txt =new JTextField();
			JTextField TextField_4Txt =new JTextField();
			JTextField TextField_5Txt =new JTextField();
			JButton Button_1=new JButton("Retour");
			JButton Button=new JButton("Créer Session");
			Label.setBounds(100,50,350,20);
			Label_1.setBounds(100,100,350,20);
			Label_2.setBounds(100,150,350,20);
			Label_3.setBounds(100,200,350,20);
			Label_4.setBounds(100,250,350,20);
			Label_5.setBounds(100,300,350,20);
			TextFieldTxt.setBounds(350,50,150,20);
			TextField_1Txt.setBounds(350,100,150,20);
			TextField_2Txt.setBounds(350,150,150,20);
			TextField_3Txt.setBounds(350,200,150,20);
			TextField_4Txt.setBounds(350,250,150,20);
			TextField_5Txt.setBounds(350,300,150,20);
			Button.setBounds(200,400,150,20);
			Button_1.setBounds(1,1,100,20);
			add (Label);
			add (Label_1);
			add (Label_2);
			add (Label_3);
			add (Label_4);
			add (Label_5);
			add(TextFieldTxt);
			add(TextField_1Txt);
			add(TextField_2Txt);
			add(TextField_3Txt);
			add(TextField_4Txt);
			add(TextField_5Txt);
			add(Button);
			add(Button_1);
			 Button_1.addActionListener(e->{
	        	 mainApp.setContentPane(new Gestion(mainApp));
	     	    mainApp.revalidate();
	     	    mainApp.repaint();
			});
			Button.addActionListener(e->{
				
				SessionDAO dao=new SessionDAO();
				String texte=TextFieldTxt.getText();
				int id=Integer.parseInt(texte);
				String heureDebut=TextField_1Txt.getText();
				String heureFin=TextField_2Txt.getText();
				String texte_3=TextField_3Txt.getText();
				int capacitéMax=Integer.parseInt(texte_3);
				String salle=TextField_4Txt.getText();
				String nom=TextField_5Txt.getText();
				Session sess=new Session(id,heureDebut,heureFin,capacitéMax,salle,nom);
				int existe=dao.add(sess);
				if(existe==1) {
					JOptionPane.showMessageDialog(null,"Session créée" );
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
				
			});
		}
		
	}

	/**
	 * Classe qui permet à l'administrateur de gérer la campagne
	 */
	 
	public class GererCampagne extends JPanel{
		private MainApp mainApp;
		public GererCampagne(MainApp mainApp) {
			
			this.mainApp=mainApp;
			setLayout(null);
			JLabel Label=new JLabel("Id");
			JLabel Label_1=new JLabel("Date début");
			JLabel Label_2=new JLabel("Date de fin");
			JLabel Label_3=new JLabel("Nombre de choix maximum");
			JLabel Label_4=new JLabel("Etat");
			JTextField TextFieldTxt =new JTextField();
			JTextField TextField_1Txt =new JTextField();
			JTextField TextField_2Txt =new JTextField();
			JTextField TextField_3Txt =new JTextField();
			JTextField TextField_4Txt =new JTextField();
			JButton Button_1=new JButton("Retour");
			JButton Button=new JButton("Créer Session");
			Label.setBounds(100,50,350,20);
			Label_1.setBounds(100,100,350,20);
			Label_2.setBounds(100,150,350,20);
			Label_3.setBounds(100,200,350,20);
			Label_4.setBounds(100,250,350,20);
			TextFieldTxt.setBounds(350,50,150,20);
			TextField_1Txt.setBounds(350,100,150,20);
			TextField_2Txt.setBounds(350,150,150,20);
			TextField_3Txt.setBounds(350,200,150,20);
			TextField_4Txt.setBounds(350,250,150,20);
			Button.setBounds(200,400,150,20);
			Button_1.setBounds(1,1,100,20);
			add (Label);
			add (Label_1);
			add (Label_2);
			add (Label_3);
			add (Label_4);
			add(TextFieldTxt);
			add(TextField_1Txt);
			add(TextField_2Txt);
			add(TextField_3Txt);
			add(TextField_4Txt);
			add(Button);
			add(Button_1);
			 Button_1.addActionListener(e->{
	        	 mainApp.setContentPane(new Gestion(mainApp));
	     	    mainApp.revalidate();
	     	    mainApp.repaint();
			});
			Button.addActionListener(e->{
				
				CampagneDAO dao=new CampagneDAO();
				String texte=TextFieldTxt.getText();
				int id=Integer.parseInt(texte);
				String dateDebut=TextField_1Txt.getText();
				String dateFin=TextField_2Txt.getText();
				String texte_3=TextField_3Txt.getText();
				int nombreChoixMax=Integer.parseInt(texte_3);
				String etat=TextField_4Txt.getText();
				Campagne campagne=new Campagne(id,dateDebut,dateFin,nombreChoixMax,etat);
				int existe=dao.add(campagne);
				if(existe==1) {
					JOptionPane.showMessageDialog(null,"Session créée" );
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
				
			});
		}
		
	}

	
}
