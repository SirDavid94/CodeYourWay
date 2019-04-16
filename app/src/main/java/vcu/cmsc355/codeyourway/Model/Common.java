package vcu.cmsc355.codeyourway.Model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static String currentUser;

    public static String CategoryID;
    public static List<Question> questionList = new ArrayList<>();

    public static String getCurrentUser() {
        return currentUser;
    }


    SharedPreferences displayMode;

    public  Common (Context context){
        displayMode = context.getSharedPreferences("changeStatus",Context.MODE_PRIVATE);

    }

    public void setNightMode (Boolean mode) {
        SharedPreferences.Editor editor = displayMode.edit();
        editor.putBoolean("NightMode",mode);
        editor.commit();
    }

    public Boolean getNightMode () {
        Boolean mode = displayMode.getBoolean("NightMode",false);
        return mode;
    }
}
