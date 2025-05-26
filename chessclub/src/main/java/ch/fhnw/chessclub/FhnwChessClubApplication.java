package ch.fhnw.chessclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import ch.fhnw.chessclub.business.service.PlayerService;
import ch.fhnw.chessclub.data.domain.Player;

@SpringBootApplication
public class FhnwChessClubApplication {

  @Autowired
  private PlayerService playerService;

  public static void main(String[] args) {
    SpringApplication.run(FhnwChessClubApplication.class, args);
  }

  @PostConstruct
  private void initPlaceholderData() {
    if (!playerService.getAllPlayers().isEmpty()) {
      System.out.println("Players already initialized, skipping demo data.");
      return;
    }

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

    System.out.println("Demo players initialized.");
  }
}
