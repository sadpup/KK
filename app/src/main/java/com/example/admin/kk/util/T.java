package com.example.admin.kk.util;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @see 系统toast优化工具类
 * @author ly-lihongliang
 */
public class T {

	private T() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static boolean isShow = true;

	private static Toast mToast;//勉强算是单例
	private static Handler mHandler = new Handler();
	private static Runnable r = new Runnable() {
		@Override
		public void run() {
			mToast.cancel();
		}
	};

	/**
	 * @param context
	 * @param text
	 */
	public static void show(Context context, String text) {
		mHandler.removeCallbacks(r);
		if (null != mToast) {
			mToast.setText(text);
		} else {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		}
		mHandler.postDelayed(r, 5000);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		if(isShow)
			mToast.show();
	}
	
	public static void cencle(){
		if (null != mToast) {
			mToast.cancel();
		}
	}

}
