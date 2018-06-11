package br.pucsp.rodri.jogo_da_velha.game.context;

import br.pucsp.rodri.jogo_da_velha.game.context.play.GameContext;

public class GameConfiguration {
    String _mode = "";
    User _playerOne;
    User _playerTwo;

    public GameConfiguration(final String mode, final User playerOne, final User playerTwo){
            this._mode = mode;
            this._playerOne = playerOne;
            this._playerTwo = playerTwo;
    }

    public GameContext StartGame(){
        return new GameContext(_playerOne, _playerTwo,this);
    }
    public String getMode()
    {
        return _mode;
    }
}
