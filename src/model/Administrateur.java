package model;

public class Administrateur {

private String nom;
private String prenom;
private String mail;
private String motDePasse;

public Administrateur(String nom, String prenom, String mail,String motDePasse){

	this.nom=nom;
	this.prenom=prenom;
	this.mail=mail;
	this.motDePasse=motDePasse;
}
    public String getNom() {
	return nom;
    }public String getPrenom() {
	return prenom;
    }public String getMail() {
	return mail;
    }public String getMotDePasse() {
	return motDePasse;
    }
	
	
	
	public void Campagne(String dateDebut, String dateFin, int nbreChoixMax) {
		Campagne campagne=new Campagne(dateDebut, dateFin, nbreChoixMax);
	}

}

