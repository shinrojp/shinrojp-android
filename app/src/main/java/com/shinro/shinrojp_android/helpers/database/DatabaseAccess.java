package com.shinro.shinrojp_android.helpers.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.shinro.shinrojp_android.helpers.DatabaseOpenHelper;
import com.shinro.shinrojp_android.models.Grammar.Example;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the databases connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the databases connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    /**
     * Read all grammar from the databases.
     *
     * @return a List of quotes
     */

    public List<Example> getExample() {
        List<Example> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM 'EXAMPLE'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Example examples = new Example();
            examples.setId(cursor.getInt(0));
            examples.setSentence(cursor.getString(1));
            examples.setVi(cursor.getString(2));
            examples.setFurigana(cursor.getString(3));
            examples.setFurigana(cursor.getString(4));
            examples.setGrammar_id(cursor.getInt(5));
            list.add(examples);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}