package ch.fhnw.chessclub.data.domain.repository;

import ch.fhnw.chessclub.data.domain.Match;
import ch.fhnw.chessclub.data.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    // Find all matches for a given player as player1 or player2
    List<Match> findByPlayer1OrPlayer2(Player player1, Player player2);

    // Find all matches with a specific result
    List<Match> findByResult(String result);

    // Find all matches where a specific player was player1
    List<Match> findByPlayer1(Player player);

    // Find all matches where a specific player was player2
    List<Match> findByPlayer2(Player player);

    // Find all matches between two specific players
    List<Match> findByPlayer1AndPlayer2(Player player1, Player player2);

    // Find all matches where a player participated and the result was a draw
    List<Match> findByResultAndPlayer1OrPlayer2(String result, Player player1, Player player2);
}
