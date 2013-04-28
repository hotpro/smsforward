package com.yutao.smsforward;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editText1;
	EditText editText2;
	EditText editText3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);

		SharedPreferences prefs = Utils.prefs(this);
		String string1 = prefs.getString(Constant.SOURCE_MOBILE_NUMBER_KEY, "");
		String string2 = prefs.getString(Constant.SMS_BODY_KEYWOR_KEY, "");
		String string3 = prefs.getString(Constant.DEST_MOBILE_NUMBER_KEY, "");

		editText1.setText(string1);
		editText2.setText(string2);
		editText3.setText(string3);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		String string1 = editText1.getText().toString().trim();
		String string2 = editText2.getText().toString().trim();
		String string3 = editText3.getText().toString().trim();
		if (TextUtils.isEmpty(string1) || TextUtils.isEmpty(string2)
				|| TextUtils.isEmpty(string3)) {
			Toast.makeText(this, "设置失败!", Toast.LENGTH_SHORT).show();
			return;
		}
		
		SharedPreferences prefs = Utils.prefs(this);

		prefs.edit().putString(Constant.SOURCE_MOBILE_NUMBER_KEY, string1)
				.putString(Constant.SMS_BODY_KEYWOR_KEY, string2)
				.putString(Constant.DEST_MOBILE_NUMBER_KEY, string3).commit();
		Toast.makeText(this, "设置成功!", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

}
