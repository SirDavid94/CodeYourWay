package vcu.cmsc355.codeyourway.Model;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static String currentUser;
    public static String CategoryID;
    public static List<Question> questionList = new ArrayList<>();

    public static String getCurrentUser() {
        return currentUser;
    }
}
