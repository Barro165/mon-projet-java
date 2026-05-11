package model;


public class Session {

	private String heureDebut;
	private String heureFin;
	private int capaciteMax;
	private String salle;
	private String nomDom;
	
	
	public Session(String heureDebut, String heureFin, int capaciteMax, String salle, String nomDom) {
		
		this.heureDebut=heureDebut;
		this.heureFin=heureFin;
		this.capaciteMax=capaciteMax;
		this.salle=salle;
		this.nomDom=nomDom;
		
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
	public String display(){
		String lala=String.valueOf(capaciteMax);
		String texte="Début :"+"  "+heureDebut+"  "+"Fin :"+"  "+heureFin+"  "+"Capacité :"+"  "+lala+"  "+"Salle:"+"  "+salle+"  "+"Dominante :"+"  "+nomDom+"\n";
		return texte;
	}


}

