package br.pucsp.rodri.jogo_da_velha.game.context.play;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.pucsp.rodri.jogo_da_velha.game.context.GameConfiguration;
import br.pucsp.rodri.jogo_da_velha.game.context.Judge;
import br.pucsp.rodri.jogo_da_velha.game.context.Piece;
import br.pucsp.rodri.jogo_da_velha.game.context.Table;
import br.pucsp.rodri.jogo_da_velha.game.context.User;

public class GameContext {

    GameConfiguration _gameConfiguration;
    String mode = "";
    User _playerOne;
    User _playerTwo;
    Table _table;
    Judge _judge;

    List<User> turns;

    public GameContext(User playerOne, User playerTwo, GameConfiguration gameConfiguration) {
        this._gameConfiguration = gameConfiguration;
        this._table = new Table();

        this._judge = new Judge(this._gameConfiguration.getMode(),_playerOne,playerTwo);
        _playerOne = playerOne;
        _playerTwo = playerTwo;

        setUsers(playerOne, playerTwo);
        setTurn(playerTwo, playerOne);
    }

    public Move MakeMove(final Piece piece, final String position, final Table table, final User owner) {

        if (_playerOne.getId() == owner.getId())
            setTurn(owner, _playerTwo);
        else if (_playerTwo.getId() == owner.getId())
            setTurn(owner, _playerOne);
        else {
            Move move;
            _judge.setMessage("Cannot find correct user, id do not match");
            move = new Move(piece, position, _table, owner, _judge);
            return move;
        }

        return new Move(piece, position, _table, owner, _judge);
    }

    private void setTurn(final User previousTurnPlayer, final User newTurnPlayer) {
        turns = new ArrayList<User>();
        turns.add(newTurnPlayer);
        turns.add(previousTurnPlayer);
    }

    private void setUsers(User playerOne, User playerTwo) {
        this._playerOne = playerOne;
        this._playerTwo = playerTwo;
    }

    public User getCurrentTurnOwner()
    {
        return turns.get(0);
    }
    public User getNextTurnOwner()
    {
        return turns.get(1);
    }
    public User forceTurnOwner(User newOwner)
    {
        turns.set(1,turns.get(0));
        return turns.set(0,newOwner);
    }

    public Table getTable()
    {
        return _table;
    }
}
