package ch.fhnw.chessclub.data.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String date; // Simplified for now (e.g., "2025-04-06")

    @Column(nullable = false)
    private String location;

    // Assuming a one-to-many relationship with LeaderboardEntry
    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaderboardEntry> leaderboardEntries;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<LeaderboardEntry> getLeaderboardEntries() { return leaderboardEntries; }
    public void setLeaderboardEntries(List<LeaderboardEntry> leaderboardEntries) {
        this.leaderboardEntries = leaderboardEntries;
    }
}
