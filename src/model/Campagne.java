package model;
import java.sql.Date;
import java.time.LocalDate;

public class Campagne {
	private int id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int nombreChoixMax;
	private String etat;
	
	public Campagne(int id,LocalDate dateDebut, LocalDate dateFin, int nombreChoixMax,String etat) {
		this.id=id;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.nombreChoixMax=nombreChoixMax;
		this.etat=etat;
	}
	
	public int getId() {
		return id;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public int getNombreChoixMax() {
		return nombreChoixMax;
	}
	public String getEtat() {
		return etat;
	}

}
