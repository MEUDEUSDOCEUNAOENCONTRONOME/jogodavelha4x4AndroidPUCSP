package br.pucsp.rodri.jogo_da_velha.game.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    Map<String, Piece> table = new HashMap<String,Piece>();
    List<String> positions = new ArrayList<String>();;

    public Table()
    {

        positions.add("11");
        positions.add("12");
        positions.add("13");
        positions.add("14");
        positions.add("21");
        positions.add("22");
        positions.add("23");
        positions.add("24");
        positions.add("31");
        positions.add("32");
        positions.add("33");
        positions.add("34");
        positions.add("41");
        positions.add("42");
        positions.add("43");
        positions.add("44");
    }

    public void putPiece(final Piece piece,final String position)
    {
        if(verifyPosition(position))
        {
            this.table.put(position, piece);
        }
    }

    public boolean verifyPosition(final String position)
    {
        if(positions.contains(position) && !table.containsKey(position))
        {
            return true;
        }
        return false;
    }
    public Map<String, Piece> getGame()
    {
        return table;
    }
    public List<String> getPositions()
    {
        return positions;
    }
    public List<String> getFreePositions()
    {
        List<String> notUsedPositions = new ArrayList<String>();
        for (String position: positions )
        {
            if(!table.containsKey(position))
            {
                notUsedPositions.add(position);
            }
        }
        return notUsedPositions;
    }
}
