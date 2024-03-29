package lib.initope.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import lib.user.User;

public class PrefConfig {
    private static final String LIST_KEY = "list_key";
    private static final String INT_KEY = "int_key";
    private static final String STRING_KEY = "string_key";
    private static final String BOOLEAN_KEY = "boolean_key";

    public static void setList(Context ctx, ArrayList<User> list) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<User> getList(Context ctx) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        String jsonString = pref.getString(LIST_KEY, "list");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();
        return gson.fromJson(jsonString, type);
    }

    public static void setInt(Context ctx, int num) {
        Gson gson = new Gson();
        int jsonInt = Integer.parseInt(gson.toJson(num));
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(INT_KEY, String.valueOf(jsonInt));
        editor.apply();
    }

    public static int getInt(Context ctx) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        int jsonInt = Integer.parseInt(pref.getString(INT_KEY, "int"));
        Gson gson = new Gson();
        Type type = new TypeToken<Integer>() {
        }.getType();
        return gson.fromJson(String.valueOf(jsonInt), type);
    }

    public static void setString(Context ctx, String text) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(text);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(STRING_KEY, jsonString);
        editor.apply();
    }

    public static int getString(Context ctx) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        String jsonInt = pref.getString(STRING_KEY, "string");
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        return gson.fromJson(jsonInt, type);
    }

    public static void setBoolean(Context ctx, boolean b) {
        Gson gson = new Gson();
        boolean jsonBoolean = Boolean.parseBoolean(gson.toJson(b));
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(BOOLEAN_KEY, String.valueOf(jsonBoolean));
        editor.apply();
    }

    public static int getBoolean(Context ctx) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        boolean jsonBoolean = Boolean.parseBoolean(pref.getString(BOOLEAN_KEY, "boolean"));
        Gson gson = new Gson();
        Type type = new TypeToken<Boolean>() {
        }.getType();
        return gson.fromJson(String.valueOf(jsonBoolean), type);
    }
}
