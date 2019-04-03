package vcu.cmsc355.codeyourway.Model;

public class Awards {
    private static String User;
    private  int awardCount;
    private  String awardLabel;
    private  int Count;



    public Awards() {
    }

    public Awards(String user, int awardCount) {
        this.User = user;
        this.awardCount = awardCount;
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
    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getAwardLabel() {
        return awardLabel;
    }

    public void setAwardLabel(String awardLabel) {
        this.awardLabel = awardLabel;
    }


}



