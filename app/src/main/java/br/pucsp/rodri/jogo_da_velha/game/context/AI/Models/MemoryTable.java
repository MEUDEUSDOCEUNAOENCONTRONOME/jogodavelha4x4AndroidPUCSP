package br.pucsp.rodri.jogo_da_velha.game.context.AI.Models;

import android.support.design.widget.TabLayout;

import java.util.Map;

import br.pucsp.rodri.jogo_da_velha.game.context.Piece;
import br.pucsp.rodri.jogo_da_velha.game.context.Table;
import br.pucsp.rodri.jogo_da_velha.game.context.play.Move;

public class MemoryTable {

    public String position11 = "";
    public String position12 = "";
    public String position13 = "";
    public String position14 = "";

    public String position21 = "";
    public String position22 = "";
    public String position23 = "";
    public String position24 = "";

    public String position31 = "";
    public String position32 = "";
    public String position33 = "";
    public String position34 = "";

    public String position41 = "";
    public String position42 = "";
    public String position43 = "";
    public String position44 = "";

    public String movePosition = "";
    public String pieceType = "";

    public String environment = "";

    public int differencePoints = 0;

    public MemoryTable(Table table, Move move)
    {
        pieceType = move.getPiece().getInverseType();
        movePosition = move.getPosition();

        Map<String,Piece> ocupiedPositions =  table.getGame();
        if(ocupiedPositions.containsKey("11"))
            position11 = ocupiedPositions.get("11").getInverseType();
        if(ocupiedPositions.containsKey("12"))
            position12 = ocupiedPositions.get("12").getInverseType();
        if(ocupiedPositions.containsKey("13"))
            position13 = ocupiedPositions.get("13").getInverseType();
        if(ocupiedPositions.containsKey("14"))
            position14 = ocupiedPositions.get("14").getInverseType();

        if(ocupiedPositions.containsKey("21"))
            position21 = ocupiedPositions.get("21").getInverseType();
        if(ocupiedPositions.containsKey("22"))
            position22 = ocupiedPositions.get("22").getInverseType();
        if(ocupiedPositions.containsKey("23"))
            position23 = ocupiedPositions.get("23").getInverseType();
        if(ocupiedPositions.containsKey("24"))
            position24 = ocupiedPositions.get("24").getInverseType();

        if(ocupiedPositions.containsKey("31"))
            position31 = ocupiedPositions.get("31").getInverseType();
        if(ocupiedPositions.containsKey("32"))
            position32 = ocupiedPositions.get("32").getInverseType();
        if(ocupiedPositions.containsKey("33"))
            position33 = ocupiedPositions.get("33").getInverseType();
        if(ocupiedPositions.containsKey("34"))
            position34 = ocupiedPositions.get("34").getInverseType();

        if(ocupiedPositions.containsKey("41"))
            position41 = ocupiedPositions.get("41").getInverseType();
        if(ocupiedPositions.containsKey("42"))
            position42 = ocupiedPositions.get("42").getInverseType();
        if(ocupiedPositions.containsKey("43"))
            position43 = ocupiedPositions.get("43").getInverseType();
        if(ocupiedPositions.containsKey("44"))
            position44 = ocupiedPositions.get("44").getInverseType();
    }
}
