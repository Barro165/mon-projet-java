package model;

public class Administrateur {
private int id;
private String nom;
private String prenom;

public Administrateur(int id, String prenom, String nom, String mail){
	this.id=id;
	this.nom=nom;
	this.prenom=prenom;
}
	public Dominante creerDominante(String nom) {
		Dominante dominante=new Dominante(nom);
		return dominante;
	}
	
	public Session creerSession(String heureDebut, String heureFin, int capaciteMax, String salle) {
		Session session=new Session(heureDebut, heureFin, capaciteMax, salle);
		return session;
	}
	public void Campagne(String dateDebut, String dateFin, int nbreChoixMax) {
		Campagne campagne=new Campagne(dateDebut, dateFin, nbreChoixMax);
	}

}

