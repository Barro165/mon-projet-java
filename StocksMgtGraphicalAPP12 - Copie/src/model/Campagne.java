package model;

public class Campagne {
	private String dateDebut;
	private String dateFin;
	private int nbreChoixMax;
	
	public Campagne(String dateDebut, String dateFin, int nbreChoixMax) {
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.nbreChoixMax=nbreChoixMax;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public int getNbreChoixMax() {
		return nbreChoixMax;
	}
}
