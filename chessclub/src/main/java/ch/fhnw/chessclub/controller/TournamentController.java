package ch.fhnw.chessclub.controller;

import ch.fhnw.chessclub.business.service.TournamentService;
import ch.fhnw.chessclub.data.domain.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    // CREATE
    @PostMapping
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        Tournament created = tournamentService.addTournament(tournament);
        return ResponseEntity.ok(created);
    }

    // READ ALL
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament tournament) {
        Tournament updated = tournamentService.updateTournament(id, tournament);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTournament(@PathVariable Long id) {
        try {
            tournamentService.deleteTournament(id);
            return ResponseEntity.ok("Tournament deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Tournament not found");
        }
    }
}
