package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.LeaderboardEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderboardService {

    private List<LeaderboardEntry> leaderboard = new ArrayList<>();

    public List<LeaderboardEntry> getLeaderboard() {
        return leaderboard;
    }

    public LeaderboardEntry addEntry(LeaderboardEntry entry) {
        leaderboard.add(entry);
        return entry;
    }
}
