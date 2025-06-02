package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Player;
import ch.fhnw.chessclub.data.domain.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    // Create
    public Player addPlayer(Player player) {
        if (playerRepository.existsByUsername(player.getUsername())) {
            throw new IllegalArgumentException("Username already exists: " + player.getUsername());
        }
        return playerRepository.save(player);
    }

    // Read all
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Read by username
    public Player getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    // Read by id
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    // Update
    public Player updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id)
                .map(existingPlayer -> {
                    existingPlayer.setUsername(updatedPlayer.getUsername());
                    existingPlayer.setFullName(updatedPlayer.getFullName());
                    existingPlayer.setRating(updatedPlayer.getRating());
                    return playerRepository.save(existingPlayer);
                })
                .orElse(null);
    }

    // Delete
    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }
}
