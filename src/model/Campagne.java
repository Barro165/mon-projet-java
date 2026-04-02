package model;
import java.sql.Date;
import java.time.LocalDate;

public class Campagne {
	private Date dateDebut;
	private Date dateFin;
	private int nombreChoixMax;
	private String etat;
	
	public Campagne(Date dateDebut, Date dateFin, int nombreChoixMax,String etat) {
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.nombreChoixMax=nombreChoixMax;
		this.etat=etat;
	}
	public Campagne(int id, String dateDebut2, String dateFin2, int nombreChoixMax2, String etat2) {
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public int getNombreChoixMax() {
		return nombreChoixMax;
	}
	public String getEtat() {
		return etat;
	}

}
