package br.pucsp.rodri.jogo_da_velha.game.context.AI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.pucsp.rodri.jogo_da_velha.game.context.AI.DB.Init;
import br.pucsp.rodri.jogo_da_velha.game.context.AI.Models.MemoryTable;

public class Memory {
    private SQLiteDatabase db;
    private Init banco;

    public Memory(Context context){
        banco = new Init(context);
    }

    public String insereDado(MemoryTable memoryTable){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();


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

        db.execSQL("INSERT INTO " + "situacoes" + "(position11, position12, position13, position14, position21, position22, position23, position24,position31, position32, position33, position34, position41, position42, position43, position44, environment, movePosition, pieceType  ) VALUES ('"+memoryTable.position11 + "','"+ memoryTable.position12+"','" +memoryTable.position13+"','" +memoryTable.position14+"','"+ memoryTable.position21+"','"+ memoryTable.position22+"','" +memoryTable.position23+"','" +memoryTable.position24+"','"+memoryTable.position31+"','" +memoryTable.position32+"','" +memoryTable.position33+"','" +memoryTable.position34+"','" +memoryTable.position41+"','" +memoryTable.position42+"','" +memoryTable.position43+"','" +memoryTable.position44+"','"+memoryTable.environment+"','"+memoryTable.movePosition+"','"+memoryTable.pieceType+"')");

        db.close();

        return "Registro Inserido com sucesso";

    }


    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.movePosition, banco.pieceType,banco.position11};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.tabela, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
