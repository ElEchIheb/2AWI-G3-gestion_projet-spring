package tn.esprit.spring;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.repositories.EvenementRepository;
import tn.esprit.spring.persistence.repositories.LogistiqueRepository;
import tn.esprit.spring.persistence.repositories.ParticipantRepository;
import tn.esprit.spring.service.classes.ParticipantServiceImpl;

public class ParticipantServiceImplTestMock {

    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private EvenementRepository evenementRepository;

    @Mock
    private LogistiqueRepository logistiqueRepository;

    @InjectMocks
    private ParticipantServiceImpl participantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAjouterParticipant() {
        Participant p = new Participant();
        p.setNom("Mockito");
        when(participantRepository.save(p)).thenReturn(p);

        Participant result = participantService.ajouterParticipant(p);

        assertNotNull(result);
        assertEquals("Mockito", result.getNom());
        verify(participantRepository, times(1)).save(p);
    }

    @Test
    public void testGetParticipantById() {
        Participant p = new Participant();
        p.setIdPart(1);
        when(participantRepository.findById(1)).thenReturn(Optional.of(p));

        Participant result = participantService.getParticipantById(1);
        assertNotNull(result);
        assertEquals(1, result.getIdPart());
    }

    @Test
    public void testUpdateParticipant() {
        Participant p = new Participant();
        p.setIdPart(2);
        p.setNom("AvantUpdate");

        when(participantRepository.existsById(2)).thenReturn(true);
        when(participantRepository.save(p)).thenReturn(p);

        Participant result = participantService.updateParticipant(p);
        assertNotNull(result);
        verify(participantRepository, times(1)).save(p);
    }

    @Test
    public void testDeleteParticipant() {
        participantService.deleteParticipant(3);
        verify(participantRepository, times(1)).deleteById(3);
    }

    @Test
    public void testGetAllParticipants() {
        Participant p1 = new Participant();
        Participant p2 = new Participant();
        when(participantRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Participant> list = participantService.getAllParticipants();
        assertEquals(2, list.size());
    }
}