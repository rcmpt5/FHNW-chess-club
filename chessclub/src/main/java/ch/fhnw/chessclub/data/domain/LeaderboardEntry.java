package ch.fhnw.chessclub.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard_entries")
public class LeaderboardEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private int wins;

    // point at Profile, not Player
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnore // Add this to prevent recursion
    private Player player;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false) // or nullable = true if optional
    private Tournament tournament;

    public Tournament getTournament() { return tournament; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }
}


