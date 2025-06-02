package ch.fhnw.chessclub.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private int rating;

    // JSON ignore maybe needed
    @JsonIgnore
    @OneToMany(mappedBy = "player",
             cascade = CascadeType.ALL,
             orphanRemoval = true)
    private List<LeaderboardEntry> leaderboardEntries;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public List<LeaderboardEntry> getLeaderboardEntries() { return leaderboardEntries; }
    public void setLeaderboardEntries(List<LeaderboardEntry> leaderboardEntries) {
        this.leaderboardEntries = leaderboardEntries;
    }
}
