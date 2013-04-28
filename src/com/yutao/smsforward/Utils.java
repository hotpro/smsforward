package com.yutao.smsforward;

import android.content.Context;
import android.content.SharedPreferences;

public class Utils {

	public static SharedPreferences prefs(Context context) {
		return context.getSharedPreferences("config", Context.MODE_PRIVATE);
	}

}
