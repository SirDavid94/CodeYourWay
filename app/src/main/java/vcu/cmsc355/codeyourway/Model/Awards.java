package vcu.cmsc355.codeyourway.Model;

public class Awards {
    private static String User;
    private int awardCount;
    private int Module;
    private int Level;


    public Awards() {
    }

    public Awards(String user, int awardCount, int module, int level) {
        this.User = user;
        this.awardCount = awardCount;
        Module = module;
        Level = level;
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

    public int getModule() {
        return Module;
    }

    public void setModule(int module) {
        Module = module;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }
}

