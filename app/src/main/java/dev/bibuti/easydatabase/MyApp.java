package dev.bibuti.easydatabase;

import android.app.Application;

import dev.bibuti.easydb.EasyDB;

/*
 *
 * EasyDatabase
 * Developed By - Bibuti Koley
 * All Rights Reserved. © 2018
 * Created at - 26-Oct-18 October 2018 (09:51)
 *
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EasyDB.init(this);
    }
}
