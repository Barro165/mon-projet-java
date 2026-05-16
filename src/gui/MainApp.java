package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainApp extends JFrame{
	
	public MainApp() {
		setTitle("Connexion à l'application");
		setBounds(100, 100,800 , 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		changerPanel(new Rang(this));
	
	}
	public void changerPanel(JPanel panel) {
    setContentPane(panel);
    revalidate();
    repaint();
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

}
	


