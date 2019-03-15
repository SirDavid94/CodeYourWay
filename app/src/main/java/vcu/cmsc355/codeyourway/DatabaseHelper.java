package vcu.cmsc355.codeyourway;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//variable Declarations
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String COL_1="ID";
    public static final String COL_2= "email";
    public static final String COL_3="username";
    public static final String COL_4="password";
    public static final String COL_5="firstName";
    public static final String COL_6="lastName";
    public static final String COL_7="expertise";

    public DatabaseHelper( Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, " +
                "username TEXT, password TEXT, firstName TEXT, lastName TEXT, expertise TEXT)");

    }

    //Verifies if a previous table exists with the same name and drops them from the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Function to add user data to database during registration
     * @param email
     * @param user
     * @param password
     * @param firstName
     * @param lastName
     * @param expertise
     * @return res of type long to note if data is succesffully added to database ( res <=0 for error, res >0 for success )
     */
    public long addUser(String email, String user, String password, String firstName, String lastName, String expertise) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("username", user);
        contentValues.put("password", password);
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("expertise", expertise);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;

    }

    /**
     * checks for Multiple user entries during registration using username and email
     * @param username
     * @param email
     * @return boolean true if multiple values exist and otherwise if not
     */
    public boolean MultipleUser (String username, String email) {
        String[] columns = {COL_3};
        String[] emailColumns = {COL_2};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_3 + "=?";
        String emailSelection = COL_2 + "=?";
        String[] selectionArgs = {username};
        String[] emailArgs = {email};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        Cursor cursor2 = db.query(TABLE_NAME, emailColumns, emailSelection, emailArgs, null, null, null);
        int count = cursor.getCount();
        int mail = cursor2.getCount();
        cursor.close();
        cursor2.close();
        db.close();

        if ((count > 0) || (mail > 0)) {
            return true;
        } else
            return false;
    }

    /**
     * validates a user credentials for login purposes. uses email or username password combo
     * provided by user at login
     * @param username
     * @param password
     * @return boolean true if user account exists and otherwise if not
     */
    public boolean checkUser(String username, String password) {
        String[] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_3 + "=?" + " and " + COL_4 + "=?";
        String mailID = COL_2 + "=?" + " and " + COL_4 + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        Cursor cursor2 = db.query(TABLE_NAME, columns, mailID, selectionArgs, null, null, null);
        int count = cursor.getCount();
        int mailCount =cursor2.getCount();
        cursor.close();
        db.close();

        if (count == 1 || mailCount==1)
            return true;
        else
            return false;
    }


}

