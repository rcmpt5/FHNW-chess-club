package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Tournament;
import ch.fhnw.chessclub.data.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final LeaderboardService leaderboardService;

    public TournamentService(TournamentRepository tournamentRepository, LeaderboardService leaderboardService) {
        this.tournamentRepository = tournamentRepository;
        this.leaderboardService = leaderboardService;
    }

    // CREATE
    public Tournament addTournament(Tournament tournament) {
        leaderboardService.updateEntriesWithTournamentInfo(tournament);
        return tournamentRepository.save(tournament);
    }

    // READ ALL
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // READ BY ID
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    // READ BY NAME
    public List<Tournament> getTournamentsByName(String name) {
        return tournamentRepository.findByName(name);
    }

    // READ BY LOCATION
    public List<Tournament> getTournamentsByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    // READ BY DATE
    public List<Tournament> getTournamentsByDate(String date) {
        return tournamentRepository.findByDate(date);
    }

    // UPDATE
    public Tournament updateTournament(Long id, Tournament updatedTournament) {
        return tournamentRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedTournament.getName());
                    existing.setDate(updatedTournament.getDate());
                    existing.setLocation(updatedTournament.getLocation());
                    // Clear old entries to avoid mixing with possibly invalid ones
                    existing.getLeaderboardEntries().clear();
                    if (updatedTournament.getLeaderboardEntries() != null) {
                        existing.getLeaderboardEntries().addAll(updatedTournament.getLeaderboardEntries());
                    }
                    leaderboardService.updateEntriesWithTournamentInfo(existing);
                    return tournamentRepository.save(existing);
                })
                .orElse(null);
    }

    // DELETE
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    // EXISTS
    public boolean existsById(Long id) {
        return tournamentRepository.existsById(id);
    }
}
