package tn.esprit.spring.entities;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.spring.persistence.entities.Evenement;
import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.repositories.EvenementRepository;
import tn.esprit.spring.persistence.repositories.ParticipantRepository;
import tn.esprit.spring.service.classes.EvenementServiceImpl;

class EvenementServiceImplTestMockito {

    @InjectMocks
    private EvenementServiceImpl evenementService;

    @Mock
    private EvenementRepository evenRep;

    @Mock
    private ParticipantRepository partRep;

    private Evenement event;
    private Participant participant;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        participant = new Participant();
        participant.setIdPart(1);
        participant.setNom("Ali");

        event = new Evenement();
        event.setId(10);
        event.setDescription("Conférence");
        event.setParticipants(new ArrayList<>());
    }

    @Test
    void testAjoutAffectEvenParticip_WithIdParticip() {
        // Simulation des repositories
        when(partRep.findById(1)).thenReturn(Optional.of(participant));
        when(evenRep.findById(10)).thenReturn(Optional.of(event));
        when(evenRep.save(any(Evenement.class))).thenReturn(event);

        // Appel de la méthode
        Evenement result = evenementService.ajoutAffectEvenParticip(event, 1);

        // Vérifications
        assertNotNull(result);
        assertEquals(1, result.getParticipants().size());
        assertTrue(result.getParticipants().contains(participant));

        // Vérifier que les méthodes des mocks ont été appelées
        verify(partRep, times(1)).findById(1);
        verify(evenRep, times(1)).findById(10);
        verify(evenRep, times(1)).save(event);
    }

    @Test
    void testAjoutAffectEvenParticip_WithoutIdParticip() {
        // Simulation du repository
        when(evenRep.save(any(Evenement.class))).thenReturn(event);

        // Appel de la méthode
        Evenement result = evenementService.ajoutAffectEvenParticip(event);

        // Vérifications
        assertNotNull(result);
        assertEquals(event, result);

        verify(evenRep, times(1)).save(event);
    }
}