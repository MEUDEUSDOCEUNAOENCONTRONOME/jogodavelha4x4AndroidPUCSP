package br.pucsp.rodri.jogo_da_velha.game.context.play;


import br.pucsp.rodri.jogo_da_velha.game.context.Judge;
import br.pucsp.rodri.jogo_da_velha.game.context.Piece;
import br.pucsp.rodri.jogo_da_velha.game.context.Table;
import br.pucsp.rodri.jogo_da_velha.game.context.User;

public class Move {
    private Piece _piece;
    private String _position;
    private Table _table;
    private User _owner;
    private Judge _judge;

    public Move(final Piece piece, final String position, final Table table, final User owner, final Judge judge)
    {
        _judge = judge;
        if(table.verifyPosition(position) && judge.getMessage().equals("Ok"))
        {
            _piece = piece;
            _position = position;
            _table = table;
            _owner = owner;


            this._table.putPiece(piece,position);
            _judge.setMessage("Ok");
        }
        else
        {
            _judge.setMessage("Cannot make this move");
        }
    }
    public Judge getJudge()
    {
        return _judge;
    }
    public String getJudgeMessage()
    {
        return _judge.getMessage();
    }
    public Piece getPiece()
    {
        return _piece;
    }
    public Table getTable()
    {
        return _table;
    }
    public User getOwner()
    {
        return _owner;
    }
    public String getPosition()
    {
        return _position;
    }
}
