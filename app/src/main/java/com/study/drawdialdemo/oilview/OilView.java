package com.study.drawdialdemo.oilview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.study.drawdialdemo.R;
/**
 * @author dengdai
 * @date 2020/2/29.
 * GitHub：
 * email：291996307@qq.com
 * description：
 */

public class OilView extends View implements Runnable {

	private float angel = 60,angelMax;
	private Matrix matrix;
	private Bitmap needleBm;

	private Bitmap oilBm;
	private Bitmap bootBm;

	public OilView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public OilView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public OilView(Context context) {
		super(context);
		init();
	}

	private void init() {
		matrix = new Matrix();

		needleBm = BitmapFactory.decodeResource(getResources(),
				R.mipmap.info_rt_base_needle_);
		bootBm = BitmapFactory.decodeResource(getResources(),
				R.mipmap.info_rt_base_needle_boot_);
		oilBm = BitmapFactory.decodeResource(getResources(),
				R.mipmap.info_rt_ins_oil_);
		new Thread(this).start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		matrix.reset();
		canvas.drawBitmap(oilBm, 0, 0, null);
		
		matrix.preTranslate((oilBm.getWidth() >> 1) - (bootBm.getWidth() >> 1) +3,
				(oilBm.getHeight() >> 1) - (bootBm.getHeight() >> 1));
		matrix.preRotate(angel, needleBm.getWidth() >> 1, needleBm.getHeight()/6);
		
		canvas.drawBitmap(needleBm, matrix, null);
		canvas.drawBitmap(bootBm, (oilBm.getWidth() >> 1) - (bootBm.getWidth() >> 1),
				(oilBm.getHeight() >> 1) - (bootBm.getHeight() >> 1), null);
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(300);
				if(angel<300 && angel<=angelMax)
				angel += 10;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			postInvalidate();
		}

	}

	public void setAngelMax(float angelMax) {
		this.angelMax = angelMax*240/20+60;
	}
}
