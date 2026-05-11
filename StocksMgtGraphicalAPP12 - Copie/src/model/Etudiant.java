package model;
import java.util.ArrayList;

public class Etudiant {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String promo;
	private ArrayList<Choix>listchoix=new ArrayList();
	
	
	public Etudiant(int id, String nom, String mail, String prenom, String promo) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom; 
		this.mail=mail;
		this.promo=promo;
		
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getMail() {
		return mail;
	}
	public String getPromo() {
		return promo;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPromo(String Promo) {
		this.promo = promo;
	}

}
