package model;
import java.util.ArrayList;
public class Dominante {
	private String nom;
	ArrayList<Session>listeSessions=new ArrayList();
	private ArrayList<Session>listeSession=new ArrayList();
	
	public Dominante(String nom) {
		this.nom=nom;
	}
	public String getDateDebut() {
		return nom;
	}
	public void ajouterSession(Session session) {
		listeSession.add(session);
	}
	public void supprimerSession(Session session) {
		listeSession.remove(session);
	}
	

}

