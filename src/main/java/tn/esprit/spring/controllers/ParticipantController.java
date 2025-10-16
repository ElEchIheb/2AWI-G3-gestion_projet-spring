package tn.esprit.spring.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.persistence.entities.Participant;
import tn.esprit.spring.persistence.entities.Tache;
import tn.esprit.spring.service.interfaces.IParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private IParticipantService participantService;

    @PostMapping
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant) {
        Participant savedParticipant = participantService.ajouterParticipant(participant);
        System.out.println("cet endpoint est créé par Abdelkader");
        return new ResponseEntity<>(savedParticipant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Integer id,
            @RequestBody Participant participant) {
        System.out.println("cet endpoint est créé par Abdelkader");
        participant.setIdPart(id);
        Participant updatedParticipant = participantService.updateParticipant(participant);
        if (updatedParticipant != null) {
            return new ResponseEntity<>(updatedParticipant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Integer id) {
        participantService.deleteParticipant(id);
        System.out.println("cet endpoint est créé par Abdelkader");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Integer id) {
        System.out.println("cet endpoint est créé par Abdelkader");
        Participant participant = participantService.getParticipantById(id);
        if (participant != null) {
            return new ResponseEntity<>(participant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Participant>> getAllParticipants() {
        List<Participant> participants = participantService.getAllParticipants();
        System.out.println("cet endpoint est créé par Abdelkader");
        return new ResponseEntity<>(participants, HttpStatus.OK);
    }

    @GetMapping("/tache/{tache}")
    public ResponseEntity<List<Participant>> getParticipantsByTache(@PathVariable Tache tache) {
        List<Participant> participants = participantService.getParticipantsByTache(tache);
        System.out.println("cet endpoint est créé par Abdelkader");
        return new ResponseEntity<>(participants, HttpStatus.OK);
    }

    @GetMapping("/reserved-logistics")
    public ResponseEntity<List<Participant>> getParticipantsWithReservedLogistics() {
        List<Participant> participants = participantService.getParReservLogis();
        System.out.println("cet endpoint est créé par Abdelkader");
        return new ResponseEntity<>(participants, HttpStatus.OK);
    }

    @PostMapping("/calculate-cost")
    public ResponseEntity<Void> calculateCost() {
        participantService.calculCout();
        System.out.println("cet endpoint est créé par Abdelkader");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}