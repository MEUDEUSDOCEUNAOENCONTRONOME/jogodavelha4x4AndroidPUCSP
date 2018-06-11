package br.pucsp.rodri.jogo_da_velha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.KeyPair;
import java.util.List;
import java.util.Map;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        User playerOne;
        User playerTwo = new User("","","");
        String mode = retrieveExtra("mode");

        _machineMove = findViewById(R.id.machineMove);

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
            List<String> freePositions = _gameContext.getTable().getFreePositions();
            String positionCode = freePositions.get(0);
            //============================================================================

            User user = _gameContext.getCurrentTurnOwner();
            Piece piece = new Piece(user.getPiece());
            Move move = _gameContext.MakeMove(piece,positionCode,_gameContext.getTable(),user);
            if(!move.getJudgeMessage().equals("Ok"))
            {
                Toast.makeText(this,move.getJudgeMessage(),Toast.LENGTH_SHORT);
            }
            syncTable();
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

        checkPoints();
    }

    private void checkPoints() {
        if (_gameContext.getTable().getFreePositions().size() == 0)
        {
            Toast.makeText(this,"Game is over", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,"No one won yet", Toast.LENGTH_SHORT).show();

        return;
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
