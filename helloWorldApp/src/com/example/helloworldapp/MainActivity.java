package com.example.helloworldapp;

import com.example.helloworldapp.Models.Peca;
import com.example.helloworldapp.Models.Tabuleiro;
import com.example.helloworldapp.Models.Usuario;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnA1;
	Button btnA2;
	Button btnA3;
	Button btnA4;
	Button btnB1;
	Button btnB2;
	Button btnB3;
	Button btnB4;
	Button btnC1;
	Button btnC2;
	Button btnC3;
	Button btnC4;
	Button btnD1;
	Button btnD2;
	Button btnD3;
	Button btnD4;
	Tabuleiro table = new Tabuleiro();
	Usuario usuario = new Usuario("","","O");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usuario._tipoPeca = "O";
		
		btnA1 = (Button) findViewById(R.id.btnA1);
		btnA2 = (Button) findViewById(R.id.btnA2);
		btnA3 = (Button) findViewById(R.id.btnA3);
		btnA4 = (Button) findViewById(R.id.btnA4);
		btnB1 = (Button) findViewById(R.id.BtnB1);
		btnB2 = (Button) findViewById(R.id.BtnB2);
		btnB3 = (Button) findViewById(R.id.BtnB3);
		btnB4 = (Button) findViewById(R.id.BtnB4);
		btnC1 = (Button) findViewById(R.id.C1);
		btnC2 = (Button) findViewById(R.id.C2);
		btnC3 = (Button) findViewById(R.id.C3);
		btnC4 = (Button) findViewById(R.id.C4);
		btnD1 = (Button) findViewById(R.id.D1);
		btnD2 = (Button) findViewById(R.id.D2);
		btnD3 = (Button) findViewById(R.id.D3);
		btnD4 = (Button) findViewById(R.id.D4);

		btnA1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("A1");
			}
		});
		btnA2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("A2");
			}
		});
		btnA3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("A3");
			}
		});
		btnA4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("A4");
			}
		});
		btnB1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("B1");
			}
		});
		btnB2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("B2");
			}
		});
		btnB3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("B3");
			}
		});
		btnB4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("B4");
			}
		});
		btnC1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("C1");
			}
		});
		btnC2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("C2");
			}
		});
		btnC3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("C3");
			}
		});
		btnC4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("C4");
			}
		});
		btnD1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("D1");
			}
		});
		btnD2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("D2");
			}
		});
		btnD3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("D3");
			}
		});
		btnD4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PutUserPiece("D4");
			}
		});

	}
	
	public void PutUserPiece(String position) 
	{
		Peca p = new Peca(usuario._tipoPeca);
		table.tabla.put(p, position);
		btnA1.setText(usuario._tipoPeca);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
