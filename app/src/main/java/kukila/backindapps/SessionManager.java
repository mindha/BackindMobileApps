package kukila.backindapps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import kukila.backindapps.Activity.LoginActivity;

/**
 * Created by Mindha on 15/10/2017.
 */

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "BackindApps";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_ACCESS_TOKEN = "access_token";

    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String accesstoken){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_ACCESS_TOKEN, accesstoken);
        editor.commit();
    }

    public String getKeyAccessToken(){
        return pref.getString(KEY_ACCESS_TOKEN, "");
    }

    public void checkLogin(){
        if(this.isLoggedIn()){
            Intent i = new Intent(_context, BottomMenu.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }

    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
