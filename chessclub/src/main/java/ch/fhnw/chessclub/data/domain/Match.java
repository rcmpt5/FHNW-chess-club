package ch.fhnw.chessclub.data.domain;

public class Match {
    private Long id;
    private String player1;
    private String player2;
    private String result; // "1-0", "0-1", "½-½"

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlayer1() { return player1; }
    public void setPlayer1(String player1) { this.player1 = player1; }

    public String getPlayer2() { return player2; }
    public void setPlayer2(String player2) { this.player2 = player2; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
