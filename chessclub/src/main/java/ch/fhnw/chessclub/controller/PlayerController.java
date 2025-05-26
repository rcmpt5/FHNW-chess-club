package ch.fhnw.chessclub.controller;

import ch.fhnw.chessclub.business.service.PlayerService;
import ch.fhnw.chessclub.data.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // CREATE
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player created = playerService.addPlayer(player);
        return ResponseEntity.ok(created);
    }

    // READ ALL
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // READ BY USERNAME
    @GetMapping("/by-username/{username}")
    public ResponseEntity<Player> getPlayerByUsername(@PathVariable String username) {
        Player player = playerService.getPlayerByUsername(username);
        return player != null ? ResponseEntity.ok(player) : ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Player updated = playerService.updatePlayer(id, updatedPlayer);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/by-username/{username}")
    public ResponseEntity<String> deletePlayer(@PathVariable String username) {
        boolean removed = playerService.removePlayer(username);
        if (removed) {
            return ResponseEntity.ok("Player deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
