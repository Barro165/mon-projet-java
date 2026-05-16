package gui;
import javax.swing.JPanel;
import javax.swing.JButton;


public class Gestion extends JPanel {
      private MainApp mainApp;
    JButton dom;
			JButton camp;
			JButton sess;
            JButton retour;
    public Gestion(MainApp mainApp) {
        
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
       dom=new JButton("Créer dominante");
 camp=new JButton("Créer campagne");
 sess=new JButton("Créer session");
 retour=new JButton("Retour");

			dom.setBounds(200,50,150,20);
			camp.setBounds(200,100,150,20);
			sess.setBounds(200,150,150,20);
            retour.setBounds(1,1,100,20);
			add (dom);
			add(camp);
			add(sess);
            add(retour);

            	retour.addActionListener(e->{
         mainApp.changerPanel(new Admin(mainApp));
			});
dom.addActionListener(e->{
         mainApp.changerPanel(new GererDom(mainApp));
			});
sess.addActionListener(e->{
         mainApp.changerPanel(new GererSess(mainApp));
});
camp.addActionListener(e->{
         mainApp.changerPanel(new GererCampagne(mainApp));
			});
} 
}

