package space.java.test3t;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "boardgame.db";

    public static final String TABLE_GAME = "game";
    public static final String COL_GAME_NAME = "game_name";
    public static final String COL_SEAT_MIN = "seat_min";
    public static final String COL_SEAT_MAX = "seat_max";
    public static final String COL_LENG_MIN = "length_min";
    public static final String COL_LENG_MAX = "length_max";
    public static final String COL_DIFF = "difficulty";
    public static final String COL_LEARN_DIFF = "learn_diff";
    public static final String COL_PUBLISHER = "publisher";
    public static final String COL_RATE = "rating";

    public static final String TABLE_PLAYER = "player";
    public static final String COL_PLAYER_ID = "player_id";
    public static final String COL_PLAYER_NAME = "player_name";
    public static final String COL_WIN = "win";
    public static final String COL_TOTAL_PLAYS = "total_plays";

    public static final String TABLE_PARTY = "party";
    public static final String COL_PARTY_ID = "party_id";
    //public static final String COL_PLAYER_ID
    public static final String CONS_PK_PARTY = "PK_party";

    public static final String TABLE_SITTING = "sitting";
    public static final String COL_SIT_ID = "sit_id";
    public static final String COL_DATE = "day";
    //public static final String COL_GAME_ID
    public static final String COL_SIT_PARTY = "sit_party";
    public static final String COL_WIN_PARTY = "win_party";
    public static final String COL_DURATION = "duration";

    public static final String TABLE_EXPANSION = "expansion";
    //public static final String COL_GAME_NAME
    public static final String COL_EXPAN_NAME = "expansion_name";
    //public static final String COL__RATE

    public static final String TABLE_TYPE = "type";
    //public static final String COL_GAME_ID
    public static final String COL_TYPE_NAME = "type_name";
    public static final String CONS_PK_TYPE = "PK_gametype";

    public static final String TABLE_CATEGORY = "category";
    //public static final String COL_GAME_ID
    public static final String COL_CAT_NAME = "category_name";
    public static final String CONS_PK_CATEGORY = "PK_gamecategory";

    public static final String TABLE_MECHANISM = "mechanism";
    //public static final String COL_GAME_ID
    public static final String COL_MECH_NAME = "mechanism_name";
    public static final String CONS_PK_MECHANISM = "PK_gamemechanism";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create tables in boardgameDB
        db.execSQL("CREATE TABLE "
                + TABLE_GAME + " (" + COL_GAME_NAME + " TEXT PRIMARY KEY, "
                + COL_SEAT_MIN + " INTEGER, " + COL_SEAT_MAX + " INTEGER, "
                + COL_LENG_MIN + " INTEGER, " + COL_LENG_MAX + " INTEGER, "
                + COL_DIFF + " INTEGER, " + COL_LEARN_DIFF + " INTEGER, "
                + COL_PUBLISHER + " TEXT, " + COL_RATE + " INTEGER);");

        db.execSQL("CREATE TABLE "
                + TABLE_PLAYER + " (" + COL_PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_PLAYER_NAME + " TEXT NOT NULL, "
                + COL_WIN + " INTEGER, " + COL_TOTAL_PLAYS + " INTEGER);");

        db.execSQL("CREATE TABLE " + TABLE_PARTY
                + " (" + COL_PARTY_ID + " INTEGER NOT NULL, " + COL_PLAYER_ID + " INTEGER NOT NULL, "
                + "FOREIGN KEY (" + COL_PLAYER_ID + ") REFERENCES " + TABLE_PLAYER + "(" + COL_PLAYER_ID + ") ON DELETE NO ACTION, "
                + "CONSTRAINT " + CONS_PK_PARTY + " PRIMARY KEY (" + COL_PARTY_ID + ", " + COL_PLAYER_ID + "));");

        db.execSQL("CREATE TABLE "
                + TABLE_SITTING + " (" + COL_SIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_DATE + " TEXT, " + COL_GAME_NAME + " TEXT NOT NULL, "
                + COL_SIT_PARTY + " INTEGER, " + COL_WIN_PARTY + " INTEGER, " + COL_DURATION + " INTEGER, "
                + "FOREIGN KEY (" + COL_GAME_NAME + ") REFERENCES " + TABLE_GAME + " (" + COL_GAME_NAME + ") ON DELETE NO ACTION, "
                + "FOREIGN KEY (" + COL_SIT_PARTY + ") REFERENCES " + TABLE_PARTY + " (" + COL_PARTY_ID + ") ON DELETE NO ACTION, "
                + "FOREIGN KEY (" + COL_WIN_PARTY + ") REFERENCES " + TABLE_PARTY + " (" + COL_PARTY_ID + ") ON DELETE NO ACTION);");

        db.execSQL("CREATE TABLE " + TABLE_EXPANSION
                + " (" + COL_GAME_NAME + " TEXT NOT NULL, " + COL_EXPAN_NAME + " TEXT NOT NULL, " + COL_RATE + " INTEGER, "
                + "FOREIGN KEY (" + COL_GAME_NAME + ") REFERENCES " + TABLE_GAME + "(" + COL_GAME_NAME + "), "
                + "PRIMARY KEY (" + COL_GAME_NAME + ", " + COL_EXPAN_NAME + "));");

        db.execSQL("CREATE TABLE " + TABLE_TYPE + " (" + COL_GAME_NAME + " TEXT NOT NULL, "
                + COL_TYPE_NAME + " TEXT NOT NULL, "
                + "FOREIGN KEY (" + COL_GAME_NAME + ") REFERENCES " + TABLE_GAME + " (" + COL_GAME_NAME + ") ON DELETE CASCADE, "
                + "CONSTRAINT " + CONS_PK_TYPE + " PRIMARY KEY (" + COL_GAME_NAME + ", " + COL_TYPE_NAME + "));");

        db.execSQL("CREATE TABLE " + TABLE_CATEGORY + " (" + COL_GAME_NAME + " TEXT NOT NULL, "
                + COL_CAT_NAME + " TEXT NOT NULL, "
                + "FOREIGN KEY (" + COL_GAME_NAME + ") REFERENCES " + TABLE_GAME + "(" + COL_GAME_NAME + ") ON DELETE CASCADE, "
                + "CONSTRAINT " + CONS_PK_CATEGORY + " PRIMARY KEY (" + COL_GAME_NAME + ", " + COL_CAT_NAME + "));");

        db.execSQL("CREATE TABLE " + TABLE_MECHANISM + " (" + COL_GAME_NAME + " TEXT NOT NULL, "
                + COL_MECH_NAME + " TEXT NOT NULL, "
                + "FOREIGN KEY (" + COL_GAME_NAME + ") REFERENCES " + TABLE_GAME + "(" + COL_GAME_NAME + ") ON DELETE CASCADE, "
                + "CONSTRAINT " + CONS_PK_MECHANISM + " PRIMARY KEY (" + COL_GAME_NAME + ", " + COL_MECH_NAME + "));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARTY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SITTING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPANSION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MECHANISM);
        onCreate(db);
    }

    public boolean insertGameData(String name, String seatMin, String seatMax, String lenMin, String lenMax, String difficutly, String learnDiff, String publisher, String rating){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_GAME_NAME,name);
        contentValues.put(COL_SEAT_MIN,seatMin);
        contentValues.put(COL_SEAT_MAX,seatMax);
        contentValues.put(COL_LENG_MIN,lenMin);
        contentValues.put(COL_LENG_MAX,lenMax);
        contentValues.put(COL_DIFF,difficutly);
        contentValues.put(COL_LEARN_DIFF,learnDiff);
        contentValues.put(COL_PUBLISHER,publisher);
        contentValues.put(COL_RATE,rating);
        long result = db.insert(TABLE_GAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertPlayerData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PLAYER_NAME,name);
        long result = db.insert(TABLE_PLAYER, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getGameData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+COL_GAME_NAME+" FROM "+TABLE_GAME,null);
        return res;
    }
}
