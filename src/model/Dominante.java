package model;
import java.util.ArrayList;
public class Dominante {
	private String nom;
	
	private ArrayList<Session>listeSession=new ArrayList<>();
	
	public Dominante(String nom) {
		this.nom=nom;
	}
	public String getNom() {
		return nom;
	}
	public String setNom(String nom) {
		return this.nom= nom;
	}
	
	public void ajouterSession(Session session) {
		listeSession.add(session);
	}
	public void supprimerSession(Session session) {
		listeSession.remove(session);
	}
	public String display() {
		String text="Nom:"+"\n";
		if(listeSession.size()!=0) {
			for(int i=0;i<listeSession.size();i++) {
				text+=listeSession.get(i).display();			}
		}
		return text;	}
	

}

