package br.pucsp.rodri.jogo_da_velha.game.context.AI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

import br.pucsp.rodri.jogo_da_velha.game.context.AI.DB.Init;
import br.pucsp.rodri.jogo_da_velha.game.context.AI.Models.MemoryTable;
import br.pucsp.rodri.jogo_da_velha.game.context.Judge;
import br.pucsp.rodri.jogo_da_velha.game.context.Piece;
import br.pucsp.rodri.jogo_da_velha.game.context.Table;
import br.pucsp.rodri.jogo_da_velha.game.context.User;
import br.pucsp.rodri.jogo_da_velha.game.context.play.Move;

public class Memory {
    private SQLiteDatabase db;
    private Init banco;

    public Memory(Context context){
        banco = new Init(context);
    }

    private void createIfNotExists()
    {
        String sql = "CREATE TABLE IF NOT EXISTS situacoes ("
                +"_id integer primary key autoincrement,"
                + banco.position11 + " text,"
                + banco.position12 + " text,"
                + banco.position13 + " text,"
                + banco.position14 + " text,"

                + banco.position21 + " text,"
                + banco.position22 + " text,"
                + banco.position23 + " text,"
                + banco.position24 + " text,"

                + banco.position31 + " text,"
                + banco.position32 + " text,"
                + banco.position33 + " text,"
                + banco.position34 + " text,"

                + banco.position41 + " text,"
                + banco.position42 + " text,"
                + banco.position43 + " text,"
                + banco.position44 + " text,"

                + banco.environment + " text,"
                + banco.movePosition + " text,"
                + banco.pieceType + " text"
                +")";

        db.execSQL(sql);
    }

    public String insereDado(MemoryTable memoryTable){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();

        createIfNotExists();

        db.execSQL("INSERT INTO " + "situacoes" + "(position11, position12, position13, position14, position21, position22, position23, position24,position31, position32, position33, position34, position41, position42, position43, position44, environment, movePosition, pieceType  ) VALUES ('"+memoryTable.position11 + "','"+ memoryTable.position12+"','" +memoryTable.position13+"','" +memoryTable.position14+"','"+ memoryTable.position21+"','"+ memoryTable.position22+"','" +memoryTable.position23+"','" +memoryTable.position24+"','"+memoryTable.position31+"','" +memoryTable.position32+"','" +memoryTable.position33+"','" +memoryTable.position34+"','" +memoryTable.position41+"','" +memoryTable.position42+"','" +memoryTable.position43+"','" +memoryTable.position44+"','"+memoryTable.environment+"','"+memoryTable.movePosition+"','"+memoryTable.pieceType+"')");

        db.close();

        return "Registro Inserido com sucesso";

    }

    public Move getMove(String piece, Table table, User owner, Judge judge)
    {
        String position11s = "";
        String position12s = "";
        String position13s = "";
        String position14s = "";

        String position21s = "";
        String position22s = "";
        String position23s = "";
        String position24s = "";

        String position31s = "";
        String position32s = "";
        String position33s = "";
        String position34s = "";

        String position41s = "";
        String position42s = "";
        String position43s = "";
        String position44s = "";

        if(table.getGame().containsKey("11"))
            position11s = table.getGame().get("11").getType();
        if(table.getGame().containsKey("12"))
            position12s = table.getGame().get("12").getType();
        if(table.getGame().containsKey("13"))
            position13s = table.getGame().get("13").getType();
        if(table.getGame().containsKey("14"))
            position14s = table.getGame().get("14").getType();

        if(table.getGame().containsKey("21"))
            position21s = table.getGame().get("21").getType();
        if(table.getGame().containsKey("22"))
            position22s = table.getGame().get("22").getType();
        if(table.getGame().containsKey("23"))
            position23s = table.getGame().get("23").getType();
        if(table.getGame().containsKey("24"))
            position24s = table.getGame().get("24").getType();

        if(table.getGame().containsKey("31"))
            position31s = table.getGame().get("31").getType();
        if(table.getGame().containsKey("32"))
            position32s = table.getGame().get("32").getType();
        if(table.getGame().containsKey("33"))
            position33s = table.getGame().get("33").getType();
        if(table.getGame().containsKey("34"))
            position34s = table.getGame().get("34").getType();

        if(table.getGame().containsKey("41"))
            position41s = table.getGame().get("41").getType();
        if(table.getGame().containsKey("42"))
            position42s = table.getGame().get("42").getType();
        if(table.getGame().containsKey("43"))
            position43s = table.getGame().get("43").getType();
        if(table.getGame().containsKey("44"))
            position44s = table.getGame().get("44").getType();

        String newPosition = "";
        db = banco.getReadableDatabase();

        createIfNotExists();

        Cursor c = db.rawQuery("SELECT position, MAX(count) FROM (SELECT movePosition AS position, COUNT(1)count FROM situacoes " +
                                    "WHERE position11 = '"+position11s+"' " +
                                    "AND position12 = '"+position12s+"'" +
                                    "AND position13 = '"+position13s+"'" +
                                    "AND position14 = '"+position14s+"'" +
                                    "AND position21 = '"+position21s+"'" +
                                    "AND position22 = '"+position22s+"'" +
                                    "AND position23 = '"+position23s+"'" +
                                    "AND position24 = '"+position24s+"'" +
                                    "AND position31 = '"+position31s+"'" +
                                    "AND position32 = '"+position32s+"'" +
                                    "AND position33 = '"+position33s+"'" +
                                    "AND position34 = '"+position34s+"'" +
                                    "AND position41 = '"+position41s+"'" +
                                    "AND position42 = '"+position42s+"'" +
                                    "AND position43 = '"+position43s+"'" +
                                    "AND position44 = '"+position44s+"'" +
                                    "AND pieceType = '"+piece+"'" +
                                    "AND movePosition != ''" +
                                    "GROUP BY movePosition)", null);

        if (c.moveToFirst()){
            do {
                // Passing values
                newPosition = c.getString(0);
                // Do something Here with values
            } while(c.moveToNext());
        }
        c.close();
        db.close();
        if(newPosition == null)
            return null;
        Move move = new Move(new Piece(piece),newPosition,table,owner,judge);
        return move;
    }


}
