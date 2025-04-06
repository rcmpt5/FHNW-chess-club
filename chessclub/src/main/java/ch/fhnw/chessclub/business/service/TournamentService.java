package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Tournament;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TournamentService {

    private Map<Long, Tournament> tournamentMap = new HashMap<>();
    private long nextId = 1;

    public List<Tournament> getAllTournaments() {
        return new ArrayList<>(tournamentMap.values());
    }

    public Tournament addTournament(Tournament tournament) {
        tournament.setId(nextId++);
        tournamentMap.put(tournament.getId(), tournament);
        return tournament;
    }

    public Tournament updateTournament(Long id, Tournament updated) {
        updated.setId(id);
        tournamentMap.put(id, updated);
        return updated;
    }

    public void deleteTournament(Long id) {
        tournamentMap.remove(id);
    }
}
