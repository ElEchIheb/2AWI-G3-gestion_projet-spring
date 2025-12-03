package tn.esprit.spring.gestion_projet.service.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.gestion_projet.persistence.entities.Participant;
import tn.esprit.spring.gestion_projet.service.interfaces.IParticipantService;


@Service

public class ParticipantServiceImpl implements IParticipantService {


/*	@Override
	public Participant ajouterParticipant(Participant p) {
		partRep.save(p);
		return p;
	}

	@Override
	public Participant updateParticipant(Participant p) {
		if (partRep.existsById(p.getIdPart())) {
			return partRep.save(p);
		}
		return null;
	}

	@Override
	public void deleteParticipant(Integer id) {
		partRep.deleteById(id);
	}

	@Override
	public Participant getParticipantById(Integer id) {
		return partRep.findById(id).orElse(null);
	}

	@Override
	public List<Participant> getAllParticipants() {
		return (List<Participant>) partRep.findAll();
	}

	@Override
	@Scheduled(fixedRate = 60000)
	public void calculCout() {
		float cout = 0;
		List<Evenement> evenements = (List<Evenement>) eventRep.findAll();
		for (Evenement ev : evenements) {
			cout = cout + logisRep.calculPrixLogistiquesReserves(true);
			ev.setCout(cout);
			eventRep.save(ev);
			log.info("le cout de l'evenement : " + ev + " est:" + cout +
					"il est mis à jour dans la base");
		}
	}

	@Override
	public List<Participant> getParReservLogis() {
		return partRep.participReservLogis(true, Tache.ORGANISATEUR);
	}

	@Override
	public List<Participant> getParticipantsByTache(Tache tache) {
		throw new UnsupportedOperationException("Unimplemented method 'getParticipantsByTache'");
	}

 */




	private final Map<Integer, Participant> fakeDb = new HashMap<>();
	private int currentId = 1;

	@Override
	public Participant create(Participant p) {
		p.setIdPart(currentId++);
		fakeDb.put(p.getIdPart(), p);
		return p;
	}

	@Override
	public List<Participant> getAll() {
		return new ArrayList<>(fakeDb.values());
	}

	@Override
	public Participant getById(int id) {
		return fakeDb.get(id);
	}

	@Override
	public Participant update(int id, Participant participant) {
		participant.setIdPart(id);
		fakeDb.put(id, participant);
		return participant;
	}

	@Override
	public boolean delete(int id) {
		return fakeDb.remove(id) != null;
	}




}