package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Tournament;
import ch.fhnw.chessclub.data.domain.repository.TournamentRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    // @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    // CREATE
    public Tournament addTournament(Tournament tournament) {
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
                    existing.setLeaderboardEntries(updatedTournament.getLeaderboardEntries());
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
