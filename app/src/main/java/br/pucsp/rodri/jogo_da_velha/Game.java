package br.pucsp.rodri.jogo_da_velha;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.pucsp.rodri.jogo_da_velha.game.context.AI.Memory;
import br.pucsp.rodri.jogo_da_velha.game.context.AI.Models.MemoryTable;
import br.pucsp.rodri.jogo_da_velha.game.context.GameConfiguration;
import br.pucsp.rodri.jogo_da_velha.game.context.Judge;
import br.pucsp.rodri.jogo_da_velha.game.context.Piece;
import br.pucsp.rodri.jogo_da_velha.game.context.User;
import br.pucsp.rodri.jogo_da_velha.game.context.play.GameContext;
import br.pucsp.rodri.jogo_da_velha.game.context.play.Move;

public class Game extends AppCompatActivity {

    GameContext _gameContext;

    Button _btn11;
    Button _btn12;
    Button _btn13;
    Button _btn14;

    Button _btn21;
    Button _btn22;
    Button _btn23;
    Button _btn24;

    Button _btn31;
    Button _btn32;
    Button _btn33;
    Button _btn34;

    Button _btn41;
    Button _btn42;
    Button _btn43;
    Button _btn44;

    Button _machineMove;
    Button _playerOnePoints;
    Button _playerTwoPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        User playerOne;
        User playerTwo = new User("","","");
        String mode = retrieveExtra("mode");

        _machineMove = findViewById(R.id.machineMove);
        _playerOnePoints = findViewById(R.id.pointsPlayerOne);
        _playerTwoPoints = findViewById(R.id.pointsPlayerTwo);

        if(mode.equals("x1"))
        {
            _machineMove.setVisibility(View.VISIBLE);
            playerOne = new User(retrieveExtra("playerone_name"),retrieveExtra("playerone_email"),retrieveExtra("playerone_piece"));
            playerTwo = new User(true,1,retrieveExtra("machine_piece"));
        }
        else
        {
            _machineMove.setVisibility(View.INVISIBLE);
            playerOne = new User(retrieveExtra("playerone_name"),retrieveExtra("playerone_email"),retrieveExtra("playerone_piece"));
            playerTwo = new User(retrieveExtra("playertwo_name"),retrieveExtra("playertwo_email"),retrieveExtra("playertwo_piece"));
            playerTwo.setId(2);
        }

        Judge _judge = new Judge(mode, playerOne,playerTwo);

        _gameContext = _judge.getGameConfiguration().StartGame();

        syncButtons();

        _playerOnePoints.setText(Integer.toString(_gameContext.getPlayerOne().getPoints()));
        _playerTwoPoints.setText(Integer.toString(_gameContext.getPlayerTwo().getPoints()));

        _machineMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machineMove();
            }
        });
    }

    private void syncButtons() {
        _btn11 = (Button)findViewById(R.id.btn11);
        _btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("11");
            }
        });
        _btn12 = (Button)findViewById(R.id.btn12);
        _btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("12");
            }
        });
        _btn13 = (Button)findViewById(R.id.btn13);
        _btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("13");
            }
        });
        _btn14 = (Button)findViewById(R.id.btn14);
        _btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("14");
            }
        });

        _btn21 = (Button)findViewById(R.id.btn21);
        _btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("21");
            }
        });
        _btn22 = (Button)findViewById(R.id.btn22);
        _btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("22");
            }
        });
        _btn23 = (Button)findViewById(R.id.btn23);
        _btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("23");
            }
        });
        _btn24 = (Button)findViewById(R.id.btn24);
        _btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("24");
            }
        });

        _btn31 = (Button)findViewById(R.id.btn31);
        _btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("31");
            }
        });
        _btn32 = (Button)findViewById(R.id.btn32);
        _btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("32");
            }
        });
        _btn33 = (Button)findViewById(R.id.btn33);
        _btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("33");
            }
        });
        _btn34 = (Button)findViewById(R.id.btn34);
        _btn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("34");
            }
        });

        _btn41 = (Button)findViewById(R.id.btn41);
        _btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("41");
            }
        });
        _btn42 = (Button)findViewById(R.id.btn42);
        _btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("42");
            }
        });
        _btn43 = (Button)findViewById(R.id.btn43);
        _btn43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("43");
            }
        });
        _btn44 = (Button)findViewById(R.id.btn44);
        _btn44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move("44");
            }
        });
    }

    private void move(String positionCode) {
        if (_gameContext.getTable().getFreePositions().contains(positionCode))
        {
            if(!_gameContext.getCurrentTurnOwner().isMachine())
            {
                User user = _gameContext.getCurrentTurnOwner();
                Piece piece = new Piece(user.getPiece());
                Move move = _gameContext.MakeMove(piece,positionCode,_gameContext.getTable(),user);
                if(!move.getJudgeMessage().equals("Ok"))
                {
                    Toast.makeText(this,move.getJudgeMessage(),Toast.LENGTH_SHORT).show();
                }
                syncTable();
                if(move.getJudgeMessage().equals("Ok")) {
                    int points = verifyPoint(move.getPosition(), move.getPiece(), move.getTable().getGame());
                    if (points > 0) {
                        _gameContext.getNextTurnOwner().sumPoint(points);

                        MemoryTable memoryTable = new MemoryTable(move.getTable(),move);
                        Memory memory = new Memory(getBaseContext());
                        String resultado = memory.insereDado(memoryTable);

                        //Toast.makeText(getApplicationContext(), newPosition, Toast.LENGTH_LONG).show();


                        _playerOnePoints.setText(Integer.toString(_gameContext.getPlayerOne().getPoints()));
                        _playerTwoPoints.setText(Integer.toString(_gameContext.getPlayerTwo().getPoints()));
                    }
                    if (_gameContext.getTable().getFreePositions().size() == 0)
                    {
                        User winner;
                        if(_gameContext.getPlayerOne().getPoints() > _gameContext.getPlayerTwo().getPoints())
                            winner = _gameContext.getPlayerOne();
                        else if (_gameContext.getPlayerOne().getPoints() == _gameContext.getPlayerTwo().getPoints())
                            winner = null;
                        else
                            winner = _gameContext.getPlayerTwo();
                        if(!(winner == null))
                            Toast.makeText(this,"Game is over. Player "+winner.getPiece()+" won!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this,"Game is over. It's a draw!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }
    }
    private void machineMove()
    {
        if(_gameContext.getCurrentTurnOwner().isMachine())
        {
            // ===========================================================================
            //| TODO: definir um código de posição recomendado com base nas jogadas.      |
            // ===========================================================================
            Memory memory = new Memory(getBaseContext());

            Move newMove = memory.getMove(_gameContext.getPlayerTwo().getPiece(),_gameContext.getTable(),_gameContext.getNextTurnOwner(), _gameContext.GetJudge());

            String newPosition = "";

            List<String> freePositions = _gameContext.getTable().getFreePositions();

            String positionCode = "";
            if(newMove != null)
            {
                newPosition = newMove.getPosition();
                positionCode = newPosition;
            }
            else
            {
                Random seed = new Random();
                Integer size = freePositions.size()-1;
                if(size >= 0) {
                    if (size == 0) {
                        positionCode = freePositions.get(0);
                    } else {
                        positionCode = freePositions.get(seed.nextInt(size));
                    }
                }
            }

            //============================================================================

            User user = _gameContext.getCurrentTurnOwner();
            Piece piece = new Piece(user.getPiece());
            Move move = _gameContext.MakeMove(piece,positionCode,_gameContext.getTable(),user);
            if(!move.getJudgeMessage().equals("Ok"))
            {
                Toast.makeText(this,move.getJudgeMessage(),Toast.LENGTH_SHORT);
            }
            syncTable();

            if(move.getJudgeMessage().equals("Ok")) {

                int points = verifyPoint(move.getPosition(), move.getPiece(), move.getTable().getGame());
                if(points > 0)
                {
                    _gameContext.getNextTurnOwner().sumPoint(points);

                    _playerOnePoints.setText(Integer.toString(_gameContext.getPlayerOne().getPoints()));
                    _playerTwoPoints.setText(Integer.toString(_gameContext.getPlayerTwo().getPoints()));
                }

                if (_gameContext.getTable().getFreePositions().size() == 0)
                {
                    User winner;
                    if(_gameContext.getPlayerOne().getPoints() > _gameContext.getPlayerTwo().getPoints())
                        winner = _gameContext.getPlayerOne();
                    else if (_gameContext.getPlayerOne().getPoints() == _gameContext.getPlayerTwo().getPoints())
                        winner = null;
                    else
                        winner = _gameContext.getPlayerTwo();
                    if(!(winner == null))
                        Toast.makeText(this,"Game is over. Player "+winner.getPiece()+" won!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this,"Game is over. It's a draw!", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
    private String retrieveExtra(String extra) {
        Intent intent = getIntent();
        String mode = intent.getStringExtra(extra);
        return mode;
    }
    private void syncTable()
    {
        Map<String, Piece> ocupiedPieces = _gameContext.getTable().getGame();
        syncFirstLine(ocupiedPieces);
        syncSecondLine(ocupiedPieces);
        syncThirdLine(ocupiedPieces);
        syncFourthLine(ocupiedPieces);
    }

    private int verifyPoint(String position, Piece piece, Map<String, Piece> ocupiedPieces)
    {
        int pontos = 0;

        int y = Integer.parseInt(position.substring(0,1));
        int x = Integer.parseInt(position.substring(1,2));
        int previousX = 0;
        int previousY = 0;
        int nextY = 0;
        int nextX = 0;

        if(y > 1)
        {
            previousY = y-1;
            if(ocupiedPieces.containsKey(Integer.toString(previousY) + Integer.toString(x))) {
                if (ocupiedPieces.get(Integer.toString(previousY) + Integer.toString(x)).getType().equals(piece.getType()))
                {
                    if(previousY > 1){
                        int prevprev = previousY-1;
                        if(ocupiedPieces.containsKey(Integer.toString(prevprev) +Integer.toString(x)))
                            if(ocupiedPieces.get(Integer.toString(prevprev) +Integer.toString(x)).getType().equals(piece.getType()))
                            {
                                pontos++;
                            }
                    }
                }
            }

        }
        if(y < 4)
        {
            nextY = y+1;
            if(ocupiedPieces.containsKey(Integer.toString(nextY) + Integer.toString(x))) {
                if (ocupiedPieces.get(Integer.toString(nextY) + Integer.toString(x)).getType().equals(piece.getType()))
                {
                    if(nextY > 1){
                        int nextnext = (nextY+1);
                        if(ocupiedPieces.containsKey(Integer.toString(nextnext) + Integer.toString(x)))
                            if(ocupiedPieces.get(Integer.toString(nextnext) + Integer.toString(x)).getType().equals(piece.getType()))
                            {
                                pontos++;
                            }
                    }
                }
            }

        }

        if(y > 1 && y < 4)
        {
            int inextY = 0;
            int ipreviousY = 0;

            inextY = y+1;
            ipreviousY = y-1;

                if(ocupiedPieces.containsKey(Integer.toString(inextY) + Integer.toString(x))) {
                    if (ocupiedPieces.get(Integer.toString(inextY) + Integer.toString(x)).getType().equals(piece.getType()))
                    {

                            if(ocupiedPieces.containsKey(Integer.toString(ipreviousY) + Integer.toString(x)))
                                if(ocupiedPieces.get(Integer.toString(ipreviousY) + Integer.toString(x)).getType().equals(piece.getType()))
                                {
                                    pontos++;
                                }

                    }
                }

        }


        if(x > 1)
        {
            previousX= x-1;

            if(ocupiedPieces.containsKey( Integer.toString(y) + Integer.toString(previousX))) {
                if (ocupiedPieces.get(Integer.toString(y) + Integer.toString(previousX)).getType().equals(piece.getType()))
                {
                    if(previousX > 1){
                        int prevprev = previousX-1;
                        if(ocupiedPieces.containsKey(Integer.toString(y) + Integer.toString(prevprev)))
                            if(ocupiedPieces.get(Integer.toString(y) + Integer.toString(prevprev)).getType().equals(piece.getType()))
                            {
                                pontos++;
                            }
                    }
                }
            }
        }

        if(x < 4)
        {
            nextX = x+1;

            if(ocupiedPieces.containsKey( Integer.toString(y) + Integer.toString(nextX))) {
                if (ocupiedPieces.get(Integer.toString(y) + Integer.toString(nextX)).getType().equals(piece.getType()))
                {
                    if(nextX > 1){
                        int nextnext = nextX+1;
                        if(ocupiedPieces.containsKey(Integer.toString(y) + Integer.toString(nextnext)))
                            if(ocupiedPieces.get(Integer.toString(y) + Integer.toString(nextnext)).getType().equals(piece.getType()))
                            {
                                pontos++;
                            }
                    }
                }
            }

        }

        if(x < 4 && x > 1)
        {
            int inextX = x+1;
            int ipreviousX = x-1;

                if(ocupiedPieces.containsKey( Integer.toString(y) + Integer.toString(inextX))) {
                    if (ocupiedPieces.get(Integer.toString(y) + Integer.toString(inextX)).getType().equals(piece.getType()))
                    {
                            if(ocupiedPieces.containsKey(Integer.toString(y) + Integer.toString(ipreviousX)))
                                if(ocupiedPieces.get(Integer.toString(y) + Integer.toString(ipreviousX)).getType().equals(piece.getType()))
                                {
                                    pontos++;
                                }
                    }
                }

        }

        return pontos;
    }
    public void syncFirstLine(Map<String, Piece> ocupiedPieces)
    {
        if(ocupiedPieces.containsKey("11"))
        {
            Piece piece = ocupiedPieces.get("11");
            _btn11.setText(piece.getType());
        }
        else
        {
            _btn11.setText("");
        }

        if(ocupiedPieces.containsKey("12"))
        {
            Piece piece = ocupiedPieces.get("12");
            _btn12.setText(piece.getType());
        }
        else
        {
            _btn12.setText("");
        }

        if(ocupiedPieces.containsKey("13"))
        {
            Piece piece = ocupiedPieces.get("13");
            _btn13.setText(piece.getType());
        }
        else
        {
            _btn13.setText("");
        }

        if(ocupiedPieces.containsKey("14"))
        {
            Piece piece = ocupiedPieces.get("14");
            _btn14.setText(piece.getType());
        }
        else
        {
            _btn14.setText("");
        }
    }

    public void syncSecondLine(Map<String, Piece> ocupiedPieces)
    {
        if(ocupiedPieces.containsKey("21"))
        {
            Piece piece = ocupiedPieces.get("21");
            _btn21.setText(piece.getType());
        }
        else
        {
            _btn21.setText("");
        }

        if(ocupiedPieces.containsKey("22"))
        {
            Piece piece = ocupiedPieces.get("22");
            _btn22.setText(piece.getType());
        }
        else
        {
            _btn22.setText("");
        }

        if(ocupiedPieces.containsKey("23"))
        {
            Piece piece = ocupiedPieces.get("23");
            _btn23.setText(piece.getType());
        }
        else
        {
            _btn23.setText("");
        }

        if(ocupiedPieces.containsKey("24"))
        {
            Piece piece = ocupiedPieces.get("24");
            _btn24.setText(piece.getType());
        }
        else
        {
            _btn24.setText("");
        }
    }

    public void syncThirdLine(Map<String, Piece> ocupiedPieces)
    {
        if(ocupiedPieces.containsKey("31"))
        {
            Piece piece = ocupiedPieces.get("31");
            _btn31.setText(piece.getType());
        }
        else
        {
            _btn31.setText("");
        }

        if(ocupiedPieces.containsKey("32"))
        {
            Piece piece = ocupiedPieces.get("32");
            _btn32.setText(piece.getType());
        }
        else
        {
            _btn32.setText("");
        }

        if(ocupiedPieces.containsKey("33"))
        {
            Piece piece = ocupiedPieces.get("33");
            _btn33.setText(piece.getType());
        }
        else
        {
            _btn33.setText("");
        }

        if(ocupiedPieces.containsKey("34"))
        {
            Piece piece = ocupiedPieces.get("34");
            _btn34.setText(piece.getType());
        }
        else
        {
            _btn34.setText("");
        }
    }

    public void syncFourthLine(Map<String, Piece> ocupiedPieces)
    {
        if(ocupiedPieces.containsKey("41"))
        {
            Piece piece = ocupiedPieces.get("41");
            _btn41.setText(piece.getType());
        }
        else
        {
            _btn41.setText("");
        }

        if(ocupiedPieces.containsKey("42"))
        {
            Piece piece = ocupiedPieces.get("42");
            _btn42.setText(piece.getType());
        }
        else
        {
            _btn42.setText("");
        }

        if(ocupiedPieces.containsKey("43"))
        {
            Piece piece = ocupiedPieces.get("43");
            _btn43.setText(piece.getType());
        }
        else
        {
            _btn43.setText("");
        }

        if(ocupiedPieces.containsKey("44"))
        {
            Piece piece = ocupiedPieces.get("44");
            _btn44.setText(piece.getType());
        }
        else
        {
            _btn44.setText("");
        }
    }
}
