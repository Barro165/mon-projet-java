package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.EtudiantDAO;
import model.Etudiant;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class EtudiantGUI {

	private JFrame mainFrame;
	private JTextField mailetudiantTxt;
	private JTextField motdepasseetudiantTxt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtudiantGUI window = new EtudiantGUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EtudiantGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Connexion à l'application");
		mainFrame.setBounds(100, 100,800 , 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel choicePnl = new JPanel();
		mainFrame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		mailetudiantTxt = new JTextField();
		mailetudiantTxt.setBounds(400, 0, 150, 20);
		choicePnl.add(mailetudiantTxt);
		mailetudiantTxt.setColumns(10);
		
		 motdepasseetudiantTxt = new JTextField();
		motdepasseetudiantTxt.setBounds(400, 42, 150, 20);
		choicePnl.add(motdepasseetudiantTxt);
		motdepasseetudiantTxt.setColumns(10);
		
		btnNewButton = new JButton("Se connecter");
		btnNewButton.setBounds(349, 119, 113, 23);
		choicePnl.add(btnNewButton);
		
		btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.setBounds(361, 164, 89, 23);
		choicePnl.add(btnNewButton_1);
		/**
		 * .
		 */
		
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Email");
		lblNewJgoodiesLabel.setBounds(244, 3, 92, 14);
		choicePnl.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Mot de passe");
		lblNewJgoodiesLabel_1.setBounds(244, 45, 92, 14);
		choicePnl.add(lblNewJgoodiesLabel_1);
	}
	
	public void displaySupplier(int id) {
		// On r�cup�re le fournisseur en BDD
		EtudiantDAO etudDao = new EtudiantDAO();
		Etudiant etud = etudDao.get(id);
		
		if ((mailetudiantTxt).equals(etud.getNom())) {
			
			btnNewButton.addActionListener(e->{
				NouvelleFenetre fenetre=new NouvelleFenetre();
				fenetre.setVisible(true);
			}
			
			
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Cet étudiant n'existe pas", "Dialog",
					JOptionPane.ERROR_MESSAGE);
			
	}
}
