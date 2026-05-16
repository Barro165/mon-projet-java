package model;

public class Session {

    private int idSession;

    private String heureDebut;
    private String heureFin;
    private int capaciteMax;
    private String salle;
    private String nomDom;
	private String statut;

    // Constructeur sans id (avant insertion)
    public Session(String heureDebut, String heureFin,
                   int capaciteMax, String salle, String nomDom) {

        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.capaciteMax = capaciteMax;
        this.salle = salle;
        this.nomDom = nomDom;
    }

    // Constructeur avec id (quand on récupère depuis la BDD)
    public Session(int idSession, String heureDebut, String heureFin,
                   int capaciteMax, String salle, String nomDom) {

        this.idSession = idSession;

        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.capaciteMax = capaciteMax;
        this.salle = salle;
        this.nomDom = nomDom;
		
    }

    public int getIdSession() {
        return idSession;
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
	public String getStatut() {
         return statut;
    }

	public void setStatut(String statut) {
         this.statut=statut;
    }
	
    


    public String display() {

        String lala = String.valueOf(capaciteMax);

        String texte =
            "Début : " + heureDebut +
            "  Fin : " + heureFin +
            "  Capacité : " + lala +
            "  Salle : " + salle +
            "  Dominante : " + nomDom + " ";

        return texte;
    }

    @Override
    public String toString() {
        return display();
    }
}