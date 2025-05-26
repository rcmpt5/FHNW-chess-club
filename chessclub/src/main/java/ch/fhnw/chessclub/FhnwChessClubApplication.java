package ch.fhnw.chessclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import ch.fhnw.chessclub.business.service.PlayerService;
import ch.fhnw.chessclub.business.service.MatchService;
import ch.fhnw.chessclub.business.service.TournamentService;
import ch.fhnw.chessclub.data.domain.Player;
import ch.fhnw.chessclub.data.domain.Match;
import ch.fhnw.chessclub.data.domain.Tournament;

@SpringBootApplication
public class FhnwChessClubApplication {

  @Autowired
  private PlayerService playerService;

  @Autowired
  private MatchService matchService;

  @Autowired
  private TournamentService tournamentService;

  public static void main(String[] args) {
    SpringApplication.run(FhnwChessClubApplication.class, args);
  }

  @PostConstruct
  private void initPlaceholderData() {
    if (!playerService.getAllPlayers().isEmpty() || !matchService.getAllMatches().isEmpty() || !tournamentService.getAllTournaments().isEmpty()) {
      System.out.println("Players, matches, or tournaments already initialized, skipping demo data.");
      return;
    }

    // Create demo players
    Player alice = new Player();
    alice.setUsername("alice");
    alice.setFullName("Alice Example");
    alice.setRating(1500);
    playerService.addPlayer(alice);

    Player bob = new Player();
    bob.setUsername("bob");
    bob.setFullName("Bob Example");
    bob.setRating(1450);
    playerService.addPlayer(bob);

    // Create a demo tournament
    Tournament tournament = new Tournament();
    tournament.setName("Spring Open");
    tournament.setDate("2025-06-01");
    tournament.setLocation("FHNW Campus");
    tournamentService.addTournament(tournament);

    // Create a demo match between Alice and Bob (not linked to tournament for now)
    Match match = new Match();
    match.setPlayer1(alice);
    match.setPlayer2(bob);
    match.setResult("1-0");
    matchService.addMatch(match);

    System.out.println("Demo tournament with one match between Alice and Bob initialized.");
  }
}
