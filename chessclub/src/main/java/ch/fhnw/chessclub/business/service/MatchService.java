package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Match;
import ch.fhnw.chessclub.data.domain.Player;
import ch.fhnw.chessclub.data.repository.MatchRepository;
import ch.fhnw.chessclub.data.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // CREATE
    public Match addMatch(Match match) {
        return matchRepository.save(match);
    }

    // READ ALL
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // READ BY ID
    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    // READ BY PLAYER (as player1 or player2)
    public List<Match> getMatchesByPlayer(Player player) {
        return matchRepository.findByPlayer1OrPlayer2(player, player);
    }

    // READ BY RESULT
    public List<Match> getMatchesByResult(String result) {
        return matchRepository.findByResult(result);
    }

    // READ BY PLAYER1
    public List<Match> getMatchesByPlayer1(Player player) {
        return matchRepository.findByPlayer1(player);
    }

    // READ BY PLAYER2
    public List<Match> getMatchesByPlayer2(Player player) {
        return matchRepository.findByPlayer2(player);
    }

    // UPDATE
    public Match updateMatch(Long id, Match updatedMatch) {
        return matchRepository.findById(id).map(existingMatch -> {
            Player player1 = playerRepository.findById(updatedMatch.getPlayer1().getId()).orElse(null);
            Player player2 = playerRepository.findById(updatedMatch.getPlayer2().getId()).orElse(null);
            if (player1 == null || player2 == null) {
                throw new IllegalArgumentException("One or both players do not exist.");
            }
            existingMatch.setPlayer1(player1);
            existingMatch.setPlayer2(player2);
            existingMatch.setResult(updatedMatch.getResult());
            return matchRepository.save(existingMatch);
        }).orElse(null);
    }

    // DELETE
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    // EXISTS
    public boolean existsById(Long id) {
        return matchRepository.existsById(id);
    }

    public boolean existsByPlayerId(Long playerId) {
        return matchRepository.existsByPlayer1Id(playerId) || matchRepository.existsByPlayer2Id(playerId);
    }
}
