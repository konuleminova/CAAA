package com.crocusoft.androidarch.utilities;

import retrofit2.http.PUT;

/**
 * Created by Asus on 2/16/2018.
 */

public class Constants {
    //API
    public static final String BASE_URL = "http://94.130.226.167/rsabackend/api/user/";
    public static int SPLASH_TIME_OUT = 1000;
    public static String API_KEY = "987654";
    //Error Cases
    public static String SUCCESSFULL = "Succesfull";
    public static String AUTHENTICATION_ISSUE = "Authentication issue";
    public static String AUTHORIZATION_ISSUE = "Authorization issue";
    public static String DATABASE_EXCEPTION = "Database exception  ";
    public static String DALC_EXCEPTION = "Dalc_exception";
    public static String WRONG_USERNAME_PASSWORD = "Wrong username password";
    public static String WRONG_API_KEY = "Wrong api key";
    public static String NOT_VALIDATED_DATA = "Not validated dat";
    public static String COULD_NOT_DELETE_SELF = "Could not delete self";
    public static String VIOLATION_FOREIGN_KEY = "Violation foreign key";
    public static String WRONG_OLD_PASSWORD = "Wrong old password";
    public static String DATA_NOT_FOUND = "Data not found";
    public static String VIOLATION_UNIQUE_KEY = "Violation unique key";
    //Shared preference
    public static String SHARED_PREF_NAME = "caa_preference";
    public static String KEY_ID = "transaction_ID";
    public static String KEY_TOKEN = "token";
    public static String DEFAULT_VALUE = "null";
    //fragments
    public static String KEY_ITEM_NAME = "item_name";
    public static String KEY_ITEM_CONTENT = "item_content";
    public static String  TAG_FRAGMENT = "tag";

}
