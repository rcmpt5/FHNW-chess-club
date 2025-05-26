package ch.fhnw.chessclub.controller;

import ch.fhnw.chessclub.business.service.MatchService;
import ch.fhnw.chessclub.data.domain.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // CREATE
    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        Match created = matchService.addMatch(match);
        return ResponseEntity.ok(created);
    }

    // READ ALL
    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Match> updateMatch(@PathVariable Long id, @RequestBody Match match) {
        Match updated = matchService.updateMatch(id, match);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok("Match deleted.");
    }
}
