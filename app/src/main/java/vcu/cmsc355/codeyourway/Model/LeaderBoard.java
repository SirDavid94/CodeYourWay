package vcu.cmsc355.codeyourway.Model;

public class LeaderBoard {
    private String username;
    private long score;

    public LeaderBoard() {
    }

    public LeaderBoard(String username, long score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
