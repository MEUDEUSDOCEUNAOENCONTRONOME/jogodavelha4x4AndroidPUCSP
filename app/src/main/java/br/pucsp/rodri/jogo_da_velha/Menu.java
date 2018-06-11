package br.pucsp.rodri.jogo_da_velha;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;



public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnx1 = findViewById(R.id.btnx1);
        Button btnx2 = findViewById(R.id.btnx2);

        btnx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGameView("x1");
            }
        });
        btnx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGameView("x2");
            }
        });
    }
    public void showGameView(String mode)
    {
        Intent intent = new Intent(this, Game.class);

        intent.putExtra("mode", mode);

        intent.putExtra("playerone_email", "");
        intent.putExtra("playerone_name", "");
        intent.putExtra("playerone_type", "");
        intent.putExtra("playerone_piece", "O");

        if(mode.equals("x1")){
            intent.putExtra("machine_email", "");
            intent.putExtra("machine_name", "");
            intent.putExtra("machine_type", "");
            intent.putExtra("machine_piece", "X");
        }
        else
            {
                intent.putExtra("playertwo_email", "");
                intent.putExtra("playertwo_name", "");
                intent.putExtra("playertwo_type", "");
                intent.putExtra("playertwo_piece", "X");
            }


        startActivity(intent);
    }



}
