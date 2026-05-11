package model;


public class Session {
	private int id;
	private String heureDebut;
	private String heureFin;
	private int capaciteMax;
	private String salle;
	private String nomDom;
	
	public Session(int id,String heureDebut, String heureFin, int capaciteMax, String salle,String nomDom) {
		this.id=id;
		this.heureDebut=heureDebut;
		this.heureFin=heureFin;
		this.capaciteMax=capaciteMax;
		this.salle=salle;
		this.nomDom=nomDom;
	}
	public int getId() {
		return id;
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
	public String getSalle() {
		return salle;
	}
	public String getNomDom() {
		return nomDom;
	}


}

