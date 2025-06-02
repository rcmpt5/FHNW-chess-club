package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.LeaderboardEntry;
import ch.fhnw.chessclub.data.domain.Player;
import ch.fhnw.chessclub.data.domain.Tournament;
import ch.fhnw.chessclub.data.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private PlayerRepository playerRepository;

    public void updateEntriesWithTournamentInfo(Tournament tournament) {
        List<LeaderboardEntry> entries = tournament.getLeaderboardEntries();
        if (entries == null) return;
        for (LeaderboardEntry entry : entries) {
            System.out.println("DEBUG: Processing entry: " + entry);
            if (entry.getPlayer() != null && entry.getPlayer().getId() != null) {
                Player player = playerRepository.findById(entry.getPlayer().getId())
                    .orElseThrow(() -> new RuntimeException("Player not found"));
                entry.setPlayer(player);
            } else {
                throw new RuntimeException("LeaderboardEntry must have a player with an id.");
            }
            entry.setTournament(tournament);
        }
    }
}
