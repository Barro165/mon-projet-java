package gui;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Rang extends JPanel {
      private MainApp mainApp;
    JButton admin;
			JButton etudiant;

    public Rang(MainApp mainApp) {
        
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
      admin=new JButton("Administrateur");
    etudiant=new JButton("Etudiant");
    admin.setBounds(100,120,150,20);
			etudiant.setBounds(100,200,150,20);
			add (admin);
			add(etudiant);
			etudiant.addActionListener(e -> {
		
                mainApp.changerPanel(new EtudiantGUI(mainApp));
			});
			admin.addActionListener(e -> {
			
                mainApp.changerPanel(new Admin(mainApp));
			});
} 
}
