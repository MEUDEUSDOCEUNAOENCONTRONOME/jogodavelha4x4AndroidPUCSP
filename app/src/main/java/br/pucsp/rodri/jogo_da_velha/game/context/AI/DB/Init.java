package br.pucsp.rodri.jogo_da_velha.game.context.AI.DB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Init extends SQLiteOpenHelper {

    public static String ID = "_id";
    public static String position11 = "position11";
    public static String position12 = "position12";
    public static String position13 = "position13";
    public static String position14 = "position14";

    public static String position21 = "position21";
    public static String position22 = "position22";
    public static String position23 = "position23";
    public static String position24 = "position24";

    public static String position31 = "position31";
    public static String position32 = "position32";
    public static String position33 = "position33";
    public static String position34 = "position34";

    public static String position41 = "position41";
    public static String position42 = "position42";
    public static String position43 = "position43";
    public static String position44 = "position44";

    public static String environment = "environment";
    public static String movePosition = "movePosition";
    public static String pieceType = "pieceType";

    public boolean isBiggerPoints;
    public int differencePoints = 0;
    public String tabela = "situacoes";

    public Init(Context context) {
        super(context, "database.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

