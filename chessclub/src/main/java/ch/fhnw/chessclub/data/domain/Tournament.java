package ch.fhnw.chessclub.data.domain;

public class Tournament {
    private Long id;
    private String name;
    private String date; // Simplified for now (e.g., "2025-04-06")
    private String location;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
