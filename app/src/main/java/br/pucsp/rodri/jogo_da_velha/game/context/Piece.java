package br.pucsp.rodri.jogo_da_velha.game.context;

public class Piece {
    private String _type = "";

    public Piece(final String type)
    {
        if(type.equals("X") || type.equals("O"))
            this._type = type;
    }
    public String getType()
    {
        return _type;
    }
    public String getInverseType()
    {
        if(_type.equals("X")) return "O";
        else return "X";
    }
}
