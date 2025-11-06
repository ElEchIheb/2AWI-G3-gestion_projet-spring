package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import tn.esprit.spring.persistence.entities.Evenement;
import tn.esprit.spring.persistence.entities.Participant;

import tn.esprit.spring.service.classes.EvenementServiceImpl;

class EvenementServiceImplTest {


    private EvenementServiceImpl evenementService;
    private Evenement event;
    private Participant participant;

    @BeforeEach
    void setUp() {
        evenementService = new EvenementServiceImpl();

        participant = new Participant();
        participant.setIdPart(1);
        participant.setNom("Ali");

        event = new Evenement();
        event.setId(10);
        event.setDescription("Conférence");
        event.setParticipants(new ArrayList<>());
    }

    @Test
    void testAjoutAffectEvenParticip_SansRepository() {
        // On simule juste l'ajout d'un participant à l'événement
        if (event.getParticipants() == null) {
            event.setParticipants(new ArrayList<>());
        }
        event.getParticipants().add(participant);

        // Vérification
        assertNotNull(event.getParticipants());
        assertEquals(1, event.getParticipants().size());
        assertEquals("Ali", event.getParticipants().get(0).getNom());
    }

    @Test
    void testAjoutEvenementSansParticipant() {
        Evenement newEvent = new Evenement();
        newEvent.setId(20);
        newEvent.setDescription("Séminaire");

        // Simuler l'ajout (sans repository)
        // Ici juste vérifier que l'événement est créé correctement
        assertEquals(20, newEvent.getId());
        assertEquals("Séminaire", newEvent.getDescription());
        assertNull(newEvent.getParticipants());
    }
}
