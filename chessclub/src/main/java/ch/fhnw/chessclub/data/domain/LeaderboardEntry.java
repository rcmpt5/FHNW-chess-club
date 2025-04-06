package ch.fhnw.chessclub.data.domain;

public class LeaderboardEntry {
    private String playerName;
    private int rating;
    private int wins;

    // Getters & Setters
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }
}
