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
        valores = new ContentValues();

        valores.put(Init.position11, memoryTable.position11);
        valores.put(Init.position12, memoryTable.position12);
        valores.put(Init.position13, memoryTable.position13);
        valores.put(Init.position14, memoryTable.position14);

        valores.put(Init.position21, memoryTable.position21);
        valores.put(Init.position22, memoryTable.position22);
        valores.put(Init.position23, memoryTable.position23);
        valores.put(Init.position24, memoryTable.position24);

        valores.put(Init.position31, memoryTable.position31);
        valores.put(Init.position32, memoryTable.position32);
        valores.put(Init.position33, memoryTable.position33);
        valores.put(Init.position34, memoryTable.position34);

        valores.put(Init.position41, memoryTable.position41);
        valores.put(Init.position42, memoryTable.position42);
        valores.put(Init.position43, memoryTable.position43);
        valores.put(Init.position44, memoryTable.position44);

        valores.put(Init.environment, memoryTable.environment);

        valores.put(Init.movePosition, memoryTable.movePosition);
        valores.put(Init.pieceType, memoryTable.pieceType);

        resultado = db.insert("situacoes", null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";

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
