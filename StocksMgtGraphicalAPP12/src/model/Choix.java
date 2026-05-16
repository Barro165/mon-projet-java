package model;
import java.util.ArrayList;
public class Choix {
	private String idEtudiant;
	private String idSession;
	private String statut;
	private ArrayList<Session>listeSession=new ArrayList();
	
	public Choix (String idEtudiant, String idSession, String statut){
		this.idEtudiant=idEtudiant;
		this.idSession=idSession;
		this.statut=statut;
	}
	public String getIdEtudiant(){
		return idEtudiant;
	}
	public String getIdSession(){
		return idSession;
	}
	public String getStatut(){
		return statut;
	}
		

}
