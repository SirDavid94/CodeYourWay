package vcu.cmsc355.codeyourway.Model;

public class Awards {
    private static String User;
    private int awardCount;
    private String awardLabel;



    public Awards() {
    }

    public Awards(String user, int awardCount, String awardLabel) {
        this.User = user;
        this.awardCount = awardCount;
        this.awardLabel = awardLabel;
    }

    public static String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public int getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(int awardCount) {
        this.awardCount = awardCount;
    }

    public String getAwardLabel() {
        return awardLabel;
    }

    public void setAwardLabel(String awardLabel) {
        this.awardLabel = awardLabel;
    }
}

