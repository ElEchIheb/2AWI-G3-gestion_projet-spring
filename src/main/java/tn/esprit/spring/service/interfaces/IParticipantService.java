package tn.esprit.spring.service.interfaces;

import java.util.List;
import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.entities.Tache;

public interface IParticipantService {
	Participant ajouterParticipant(Participant p);

	Participant updateParticipant(Participant p);

	void deleteParticipant(Integer id);

	Participant getParticipantById(Integer id);

	List<Participant> getAllParticipants();

	List<Participant> getParticipantsByTache(Tache tache);

	List<Participant> getParReservLogis();

	void calculCout();
}