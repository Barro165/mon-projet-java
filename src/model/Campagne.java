package model;
import java.sql.Date;
import java.time.LocalDate;

public class Campagne {
	private Date dateDebut;
	private Date dateFin;
	private int nombreChoixMax;
	private Boolean etat;
	
	public Campagne(Date dateDebut, Date dateFin, int nombreChoixMax,Boolean etat) {
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.nombreChoixMax=nombreChoixMax;
		this.etat=etat;
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
	public Boolean getEtat() {
		return etat;
	}

}
