package tn.esprit.spring.gestion_projet.service.interfaces;


import tn.esprit.spring.gestion_projet.persistence.entities.Participant;

import java.util.List;

public interface IParticipantService {
/*	Participant ajouterParticipant(Participant p);

	Participant updateParticipant(Participant p);

	void deleteParticipant(Integer id);

	Participant getParticipantById(Integer id);

	List<Participant> getAllParticipants();

	List<Participant> getParticipantsByTache(tn.esprit.spring.persistence.entities.Tache tache);

	List<Participant> getParReservLogis();

	void calculCout();

 */

    Participant create(Participant p);

    List<Participant> getAll();

    Participant getById(int id);

    Participant update(int id, Participant participant);

    boolean delete(int id);



}