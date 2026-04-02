package model;
import java.time.LocalDate;

public class Campagne {
	private String dateDebut;
	private String dateFin;
	private int nbreChoixMax;
	private String etat;
	
	public Campagne(String dateDebut, String dateFin, int nbreChoixMax,String etat) {
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.nbreChoixMax=nbreChoixMax;
		this.etat=etat;
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
	public String getEtat() {
		return etat;
	}

}
