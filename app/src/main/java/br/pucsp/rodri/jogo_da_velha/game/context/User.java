package br.pucsp.rodri.jogo_da_velha.game.context;

public class User {
    String _name = "";
    String _email = "";
    String _tipoPeca = "";
    int _dificultLevel = 0;
    int _id = 0;
    int _points = 0;
    boolean _Machine = false;

    public User(final boolean Machine, final int dificultLevel, final String tipoPeca)
    {
        this._dificultLevel = dificultLevel;
        this._Machine = Machine;
        this._id = 0;
        this._name = "Machine";
        this._email = "Machine";
        this._tipoPeca = tipoPeca;
    }
    public User(final String name, final String email, final String tipoPeca)
    {
        this._id = 1;
        this._name = name;
        this._email = email;
        this._tipoPeca = tipoPeca;
    }

    public String getPiece()
    {
        return _tipoPeca;
    }
    public String getName()
    {
        return _name;
    }
    public String getEmail()
    {
        return _email;
    }
    public String getId()
    {
        return _email;
    }
    public void setId(int Id)
    {
        this._id = Id;
    }
    public boolean isMachine()
    {
        return _Machine;
    }
    public void sumPoint(int points)
    {
        this._points = this._points + points;
    }
    public int getPoints()
    {
        return this._points;
    }
}
