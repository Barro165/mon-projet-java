package model;
import java.time.LocalTime;

public class Session {
	private int id;
	private LocalTime heureDebut;
	private LocalTime heureFin;
	private int capaciteMax;
	private String salle;
	private String nomDom;
	
	public Session(int id,LocalTime heureDebut, LocalTime heureFin, int capaciteMax, String salle,String nomDom) {
		this.heureDebut=heureDebut;
		this.heureFin=heureFin;
		this.capaciteMax=capaciteMax;
		this.salle=salle;
		this.nomDom=nomDom;
	}
	public int getId() {
		return id;
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public LocalTime getHeureFin() {
		return heureFin;
	}
	public int getCapaciteMax() {
		return capaciteMax;
	}
	public String getSalle() {
		return salle;
	}
	public String getNomDom() {
		return nomDom;
	}


}

