package gui;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CampagneDAO;
import model.Campagne;
import java.time.LocalDate;


public class GererCampagne extends JPanel {
      private MainApp mainApp;
    JLabel Label=new JLabel("Id");
			JLabel Label_1;
			JLabel Label_2;
			JLabel Label_3;
			JLabel Label_4;
			JTextField TextFieldTxt;
			JTextField TextField_1Txt;
			JTextField TextField_2Txt;
			JTextField TextField_3Txt;
			JTextField TextField_4Txt;
			JButton Button_1;
			JButton Button;

    public GererCampagne(MainApp mainApp) {
        
        this.mainApp = mainApp;
        setLayout(null);
        initialize();
    }
    private void initialize() {
        Label=new JLabel("Id");
      Label_1=new JLabel("Date début");
      Label_2=new JLabel("Date de fin");
      Label_3=new JLabel("Nombre de choix maximum");
      Label_4=new JLabel("Etat");
      TextFieldTxt =new JTextField();
      TextField_1Txt =new JTextField();
      TextField_2Txt =new JTextField();
      TextField_3Txt =new JTextField();
      TextField_4Txt =new JTextField();
       Button_1=new JButton("Retour");
       Button=new JButton("Créer Campagne");
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
                mainApp.changerPanel(new Gestion(mainApp));
			});
			Button.addActionListener(e->{
				
				CampagneDAO dao=new CampagneDAO();
				String texte=TextFieldTxt.getText();
				int id=Integer.parseInt(texte);
				String texte_1=TextField_1Txt.getText();
				LocalDate dateDebut=LocalDate.parse(texte_1);
				String texte_2=TextField_2Txt.getText();
				LocalDate dateFin=LocalDate.parse(texte_2);
				String texte_3=TextField_3Txt.getText();
	
				int nombreChoixMax=Integer.parseInt(texte_3);
				String etat=TextField_4Txt.getText();
				Campagne campagne=new Campagne(id,dateDebut,dateFin,nombreChoixMax,etat);
				int existe=dao.add(campagne);
				if(existe==1) {
					JOptionPane.showMessageDialog(null,"Campagne créée" );
				}else {
					JOptionPane.showMessageDialog(null,"Ajout impossible");
				}
				
			});

} 
}
