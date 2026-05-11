package model;
import java.util.ArrayList;

public class Etudiant {
	private String nom;
	private String prenom;
	private String mail;
	private String motDePasse;
	
	private String promo;
	private ArrayList<Choix>listchoix=new ArrayList();
	
	
	public Etudiant( String nom, String prenom, String mail, String motDePasse) {

		this.nom=nom;
		this.prenom=prenom; 
		this.mail=mail;
		this.motDePasse=motDePasse;
		
		
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
	public String getMotDePasse() {
		return motDePasse;
	}
	public void display() {
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(mail);
		System.out.println(motDePasse);
		
	}

}
