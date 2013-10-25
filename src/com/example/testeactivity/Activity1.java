package com.example.testeactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity {
	private EditText txtParamReceberActivity2, txtParamEnviarActivity2;
	private Button btActivity2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_1);
		txtParamReceberActivity2 = (EditText) findViewById(R.id.txtParamRecebidoActivity2);

		txtParamEnviarActivity2 = (EditText) findViewById(R.id.txtParamEnviarActivity2);
		btActivity2 = (Button) findViewById(R.id.btActivity2);
		btActivity2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(Activity1.this, Activity2.class);
				it.putExtra("PARAM_ACTIVITY1", txtParamEnviarActivity2
						.getText().toString());
				startActivityForResult(it, 1);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			txtParamReceberActivity2.setText(data.getExtras().getString(
					"PARAM_ACTIVITY2"));
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
