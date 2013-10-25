package com.example.testeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity {
	private Button btnVoltar;
	private EditText txtParametroEnviar, txtParametroReceber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);

		txtParametroReceber = (EditText) findViewById(R.id.txtParametroReceberActivity1);
		Bundle extras = getIntent().getExtras();
		String paramRecebidoPelaActivity1 = extras.getString("PARAM_ACTIVITY1");
		txtParametroReceber.setText(paramRecebidoPelaActivity1);

		txtParametroEnviar = (EditText) findViewById(R.id.txtParametroEnviarActivity1);
		btnVoltar = (Button) findViewById(R.id.btnVoltar);
		btnVoltar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	@Override
	public void onBackPressed() {
		Intent it = new Intent();
		it.putExtra("PARAM_ACTIVITY2", txtParametroEnviar.getText().toString());
		setResult(1, it);
		super.onBackPressed();
	}
}
