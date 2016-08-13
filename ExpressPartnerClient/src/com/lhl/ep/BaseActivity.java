package com.lhl.ep;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

/**
 * 实现侵入式状态栏(兼容4.4和5.0以上)
 * 
 * @author luhailong
 * 
 */
public class BaseActivity extends Activity {

	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.KITKAT)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// 4.4版本及以上
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			getWindow().setFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
		// 5.0版本及以上
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow()
					.clearFlags(
							WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
									| WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			getWindow().getDecorView().setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			getWindow()
					.addFlags(
							WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			getWindow().setStatusBarColor(Color.TRANSPARENT);
			getWindow().setNavigationBarColor(Color.TRANSPARENT);
		}
	}

}
