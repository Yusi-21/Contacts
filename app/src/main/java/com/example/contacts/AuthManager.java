package com.example.contacts;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthManager {
    private static final String PREFS_NAME = "AuthPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";

    private final SharedPreferences sharedPref;

    public AuthManager(Context context) {
        sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // Save the User's data
    public void login(String username, String phone) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PHONE, phone);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear(); // when you logout, it's clear all data
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public String getUsername() {
        return sharedPref.getString(KEY_USERNAME, "");
    }

    public String getPhone() {
        return sharedPref.getString(KEY_PHONE, "");
    }
}