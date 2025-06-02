package ch.fhnw.chessclub.data.dto;

public class CreatePlayerRequest {
    private String username;
    private String fullName;
    private int rating;

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}