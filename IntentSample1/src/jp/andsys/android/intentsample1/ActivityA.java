package jp.andsys.android.intentsample1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityA extends Activity implements OnClickListener {
	private static final int REQUEST_ACTIVITY_B = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button openButton = (Button) findViewById(R.id.button_open);
        openButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    	Spinner animalsSpinner = (Spinner) findViewById(R.id.spinner_animals);
    	String selectedItem = animalsSpinner.getSelectedItem().toString();

    	//クラス名を指定して明示インテントを作成
    	Intent intent = new Intent(this, ActivityB.class);
    	intent.putExtra("SELECTED_ITEM", selectedItem);
    	//画面Ｂを起動
    	startActivityForResult(intent, REQUEST_ACTIVITY_B);
    }

    /* 呼び出し元のアクティビティが終了した時に呼ばれるコールバックメソッド*/
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
    	if (requestCode == REQUEST_ACTIVITY_B) {
    		if (resultCode == RESULT_OK) {
    			TextView detail = (TextView) findViewById(R.id.label_detail);
    			detail.setText(data.getStringExtra("INPUT_DETAIL"));
    		} else {
    			Toast.makeText(this, "キャンセルされました", Toast.LENGTH_LONG).show();
    		}
    	}
    }
}
