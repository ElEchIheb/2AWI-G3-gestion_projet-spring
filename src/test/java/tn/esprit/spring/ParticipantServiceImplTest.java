package tn.esprit.spring;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.entities.Tache;
import tn.esprit.spring.service.classes.ParticipantServiceImpl;

@SpringBootTest
public class ParticipantServiceImplTest {

    @Autowired
    private ParticipantServiceImpl participantService;

    @Test
    public void testAjouterParticipant() {
        Participant p = new Participant();
        p.setNom("Testeur");
        p.setPrenom("JUnit");
        p.setTache(Tache.ORGANISATEUR);

        Participant saved = participantService.ajouterParticipant(p);
        assertNotNull(saved);
        assertEquals("Testeur", saved.getNom());
    }

    @Test
    public void testGetAllParticipants() {
        List<Participant> participants = participantService.getAllParticipants();
        assertNotNull(participants);
    }

    @Test
    public void testUpdateParticipant() {
        Participant p = new Participant();
        p.setNom("AvantUpdate");
        p.setPrenom("Test");
        p.setTache(Tache.ORGANISATEUR);

        Participant saved = participantService.ajouterParticipant(p);
        saved.setNom("ApresUpdate");
        Participant updated = participantService.updateParticipant(saved);

        assertEquals("ApresUpdate", updated.getNom());
    }

    @Test
    public void testDeleteParticipant() {
        Participant p = new Participant();
        p.setNom("A Supprimer");
        p.setPrenom("Test");
        p.setTache(Tache.ORGANISATEUR);
        Participant saved = participantService.ajouterParticipant(p);

        participantService.deleteParticipant(saved.getIdPart());
        Participant found = participantService.getParticipantById(saved.getIdPart());
        assertNull(found);
    }
}
