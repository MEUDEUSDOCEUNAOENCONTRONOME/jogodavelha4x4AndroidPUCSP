package br.pucsp.rodri.jogo_da_velha.game.context;

public class Judge {

    private GameConfiguration _configuration;
    private String _message = "Ok";
    public Judge(final String mode, final User playerOne, final User playerTwo)
    {
        _configuration = new GameConfiguration(mode, playerOne, playerTwo);
    }

    public void setMessage(final String message){
        this._message = message;
    }
    public String getMessage()
    {
        return _message;
    }

    public GameConfiguration getGameConfiguration()
    {
        return _configuration;
    }
}
