package tn.esprit.spring.gestion_projet.persistence.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPart;      // OK
	private String nom;
	private String prenom;
	private Tache tache;

	@JsonIgnore
	private List<String> evenements;

	// ----- Getters -----
	public Integer getIdPart() {
		return idPart;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Tache getTache() {
		return tache;
	}

	public List<String> getEvenements() {
		return evenements;
	}

	// ----- Setters -----
	public void setIdPart(Integer idPart) {
		this.idPart = idPart;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	public void setEvenements(List<String> evenements) {
		this.evenements = evenements;
	}

	// ----- Constructeurs -----
	public Participant() {
	}

	public Participant(Integer idPart, String nom, String prenom, Tache tache, List<String> evenements) {
		this.idPart = idPart;
		this.nom = nom;
		this.prenom = prenom;
		this.tache = tache;
		this.evenements = evenements;
	}
}
