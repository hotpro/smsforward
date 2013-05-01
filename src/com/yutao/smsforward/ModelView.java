package com.yutao.smsforward;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ModelView extends LinearLayout implements OnClickListener {

	private TextView hint;
	private View btnAdd;
	private ArrayList<EditText> edits;
	private LayoutInflater inflater;

	public ModelView(Context context) {
		super(context);
		inflater = LayoutInflater.from(context);
		edits = new ArrayList<EditText>();
	}

	public ModelView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflater = LayoutInflater.from(context);
		edits = new ArrayList<EditText>();
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

		hint = (TextView) findViewById(R.id.hint);
		btnAdd = findViewById(R.id.btn_add);
		btnAdd.setOnClickListener(this);

	}

	public EditText add() {
		EditText edit = (EditText) inflater.inflate(R.layout.item, this, false);
		edits.add(edit);
		addView(edit);
		return edit;
	}
	
	public void setHint(String hint) {
		this.hint.setText(hint);
	}

	public void init(String[] strings) {
		if (strings == null) {
			return;
		}
		
		int length = strings.length;
		if (length == 0) {
			add();
			return;
		}
		
		for (int i = 0; i < length; i++) {
			add().setText(strings[i]);
		}
		
	}

	public String[] getStrings() {
		ArrayList<String> strings = new ArrayList<String>();
		
		for (EditText editText : edits) {
			String s = editText.getText().toString().trim();
			if (!TextUtils.isEmpty(s)) {
				strings.add(s);
			}
		}
		
		return strings.toArray(new String[strings.size()]);
	}

	@Override
	public void onClick(View v) {
		add();
	}
}
