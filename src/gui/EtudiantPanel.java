package gui;
import javax.swing.JPanel;
import javax.swing.JButton;


public class EtudiantPanel extends JPanel {
    private MainApp mainApp;
    private JButton Button;
    private JButton Button_1;
     

    public EtudiantPanel(MainApp mainApp) {
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
        
        JButton Button_2=new JButton("Retour");
			Button_2.setBounds(1,1,100,20);
			add(Button_2);
			 Button_2.addActionListener(e->{
            	 mainApp.changerPanel(new EtudiantGUI(mainApp));
			});

        Button = new JButton("Rechercher des sessions");
        Button.setBounds(400, 0, 300, 20);
        add(Button);

        Button.addActionListener(e->{

				mainApp.changerPanel(new Rechercher(mainApp));

        
} );
 Button_1 = new JButton("Voir ses choix");
        Button_1.setBounds(400, 50, 150, 20);
        add(Button_1);


    }
}