package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Match;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService {

    private Map<Long, Match> matches = new HashMap<>();
    private long nextId = 1;

    public List<Match> getAllMatches() {
        return new ArrayList<>(matches.values());
    }

    public Match addMatch(Match match) {
        match.setId(nextId++);
        matches.put(match.getId(), match);
        return match;
    }

    public Match updateMatch(Long id, Match updated) {
        updated.setId(id);
        matches.put(id, updated);
        return updated;
    }

    public void deleteMatch(Long id) {
        matches.remove(id);
    }
}
