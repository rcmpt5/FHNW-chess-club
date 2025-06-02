package ch.fhnw.chessclub.controller;

import ch.fhnw.chessclub.business.service.PlayerService;
import ch.fhnw.chessclub.data.domain.Player;
import ch.fhnw.chessclub.data.dto.CreatePlayerRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // CREATE
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addPlayer(@RequestBody CreatePlayerRequest request) {
        try {
            Player player = new Player();
            player.setUsername(request.getUsername());
            player.setFullName(request.getFullName());
            player.setRating(request.getRating());
            Player created = playerService.addPlayer(player);
            return ResponseEntity.ok(created);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Player already exists with given username");
        }
    }

    // READ ALL
    @GetMapping(produces = "application/json")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // READ BY USERNAME
    @GetMapping(path = "/by-username/{username}", produces = "application/json")
    public ResponseEntity<?> getPlayerByUsername(@PathVariable String username) {
        try {
            Player player = playerService.getPlayerByUsername(username);
            return ResponseEntity.ok(player);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No player found with given username");
        }
    }

    // UPDATE
    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestBody CreatePlayerRequest request) {
        try {
            Player player = playerService.getPlayerById(id);
            if (player == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No player found with given id");
            }
            player.setUsername(request.getUsername());
            player.setFullName(request.getFullName());
            player.setRating(request.getRating());
            Player updated = playerService.savePlayer(player);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Could not update player");
        }
    }

    // DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.ok("Player with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
        }
    }

    @DeleteMapping(path = "/by-username/{username}")
    public ResponseEntity<String> deletePlayerByUsername(@PathVariable String username) {
        try {
            playerService.deletePlayerByUsername(username);
            return ResponseEntity.ok("Player with username " + username + " deleted");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found");
        }
    }
}
