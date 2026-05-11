package model;

public class Session {
	private String heureDebut;
	private String heureFin;
	private int capaciteMax;
	private String salle;
	
	public Session(String heureDebut, String heureFin, int capaciteMax, String salle) {
		this.heureDebut=heureDebut;
		this.heureFin=heureFin;
		this.capaciteMax=capaciteMax;
		this.salle=salle;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public int getCapaciteMax() {
		return capaciteMax;
	}
	


}

