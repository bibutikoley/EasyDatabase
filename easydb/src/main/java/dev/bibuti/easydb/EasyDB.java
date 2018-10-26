package dev.bibuti.easydb;
/*
 *
 * EasyDatabase
 * Developed By - Bibuti Koley
 * All Rights Reserved. © 2017
 * Created at - 01-NOV-17 October 2017 (18:30)
 *
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

public class EasyDB {

    private static EasyDB easyDB;
    private SharedPreferences sp;

    public static void init(Context context) {
        easyDB = new EasyDB();
        if (easyDB.sp == null && context != null) {
            easyDB.sp = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static void init(Context context, @NonNull String preferencesName) {
        easyDB = new EasyDB();
        if (easyDB.sp == null && context != null) {
            easyDB.sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        }
    }

    private static void checkForNull() {
        if (easyDB == null) {
            throw new NullPointerException("Call init() method from your Application class");
        }
    }

    //Saving Values...

    //Save String..
    public static void put(String key, String value) {
        checkForNull();
        try {
            easyDB.sp.edit().putString(key, value).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save StringSet
    public static void put(String key, Set<String> value) {
        checkForNull();
        try {
            easyDB.sp.edit().putStringSet(key, value).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save Int
    public static void put(String key, int value) {
        checkForNull();
        try {
            easyDB.sp.edit().putInt(key, value).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save Long
    public static void put(String key, long value) {
        checkForNull();
        try {
            easyDB.sp.edit().putLong(key, value).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save Float
    public static void put(String key, float value) {
        checkForNull();
        try {
            easyDB.sp.edit().putFloat(key, value).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save Boolean
    public static void put(String key, boolean value) {
        checkForNull();
        try {
            easyDB.sp.edit().putBoolean(key, value).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Save Object or arrayList
    public static void put(String key, Object value) {
        checkForNull();
        try {
            Gson gson = new GsonBuilder().create();
            easyDB.sp.edit().putString(key, gson.toJson(value)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Reading Values...


    //Read String
    public static String getString(String key, String defaultvalue) {
        checkForNull();
        try {
            return easyDB.sp.getString(key, defaultvalue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultvalue;
        }
    }

    //Read String
    public static String getString(String key) {
        return getString(key, "");
    }


    //Read StringSet
    public static Set<String> getStringSet(String key, Set<String> defaultvalue) {
        checkForNull();
        try {
            return easyDB.sp.getStringSet(key, defaultvalue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultvalue;
        }
    }

    //Read StringSet
    public static Set<String> getStringSet(String key) {
        return getStringSet(key, null);
    }

    //Read Int
    public static int getInt(String key, int defaultvalue) {
        checkForNull();
        try {
            return easyDB.sp.getInt(key, defaultvalue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultvalue;
        }
    }

    //Read Int
    public static int getInt(String key) {
        return getInt(key, 0);
    }

    //getLong
    public static long getLong(String key, long defaultvalue) {
        checkForNull();
        try {
            return easyDB.sp.getLong(key, defaultvalue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultvalue;
        }
    }

    public static long getLong(String key) {
        return getLong(key, (long) 0);
    }

    //getFloat
    public static float getFloat(String key, float defaultvalue) {
        checkForNull();
        try {
            return easyDB.sp.getFloat(key, defaultvalue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultvalue;
        }
    }

    public static float getFloat(String key) {
        return getFloat(key, 0.0f);
    }

    //getBoolean
    public static boolean getBoolean(String key, boolean defaultvalue) {
        checkForNull();
        try {
            return easyDB.sp.getBoolean(key, defaultvalue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultvalue;
        }
    }

    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    //getObject
    public static Object getObject(String key, Class<?> tClass) {
        checkForNull();
        try {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(easyDB.sp.getString(key, ""), tClass);
        } catch (Exception e) {
            return "";
        }
    }

    //getArrayList
    public static <T> ArrayList<T> getArrayList(String key, Class<?> genericClass) {
        Gson gson = new Gson();
        String data = easyDB.sp.getString(key, "");
        if (!data.trim().isEmpty()) {
            Type type = new GenericType(genericClass);
            return (ArrayList<T>) gson.fromJson(data, type);
        }
        return new ArrayList<>();
    }

    //clear single value
    public static void clear(String key) {
        checkForNull();
        try {
            easyDB.sp.edit().remove(key).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //clear all preference
    public static void clearAll() {
        checkForNull();
        try {
            easyDB.sp.edit().clear().apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class GenericType implements ParameterizedType {

        private Type type;

        GenericType(Type type) {
            this.type = type;
        }

        @NonNull
        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{type};
        }

        @NonNull
        @Override
        public Type getRawType() {
            return ArrayList.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

    }

}
