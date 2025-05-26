package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Player;
import ch.fhnw.chessclub.data.domain.repository.PlayerRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    // @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Create
    public Player addPlayer(Player player) {
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
    public boolean removePlayer(String username) {
        if (playerRepository.existsByUsername(username)) {
            playerRepository.deleteByUsername(username);
            return true;
        }
        return false;
    }
}
