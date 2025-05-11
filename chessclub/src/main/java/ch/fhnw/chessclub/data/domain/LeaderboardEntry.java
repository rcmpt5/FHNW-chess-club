package ch.fhnw.chessclub.data.domain;

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

    // Assuming a foreign key relationship with a Player entity
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
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
}
