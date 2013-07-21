package jp.andsys.android.intentsample1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_b);

		//ボタンオブジェクト取得、リスナー設定
		Button closeButton = (Button) findViewById(R.id.button_close);
		closeButton.setOnClickListener(this);
		Intent intent = getIntent();
		String selectedAnimal = intent.getStringExtra("SELECTED_ITEM");
		TextView textAnimal = (TextView) findViewById(R.id.label_animal);
		textAnimal.setText(selectedAnimal);
	}

	public void onClick(View v) {
		Intent intent = getIntent();
		EditText textDetail = (EditText) findViewById(R.id.text_detail);
		intent.putExtra("INPUT_DETAIL", textDetail.getText().toString());
		if (textDetail.getText().toString().equals("")) {
			setResult(RESULT_CANCELED, intent);
		} else {
			setResult(RESULT_OK, intent);
		}
		finish();
	}

}
