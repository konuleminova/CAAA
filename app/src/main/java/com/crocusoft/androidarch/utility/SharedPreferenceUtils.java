package com.crocusoft.androidarch.utility;

import android.content.Context;
import android.content.SharedPreferences;
import static com.crocusoft.androidarch.utility.Constants.SHARED_PREF_NAME;

/**
 * Created by Asus on 2/16/2018.
 */

public class SharedPreferenceUtils {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPreferenceUtils(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setStringData(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void setIntegerData(String key, Integer value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public Integer getIntegerData(String key, Integer defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public String getStringData(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }
    public void clear(){
        editor.clear();
        editor.commit();
    }
}
