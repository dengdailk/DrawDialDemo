package com.study.drawdialdemo.oilview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
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
public class Circleview extends View implements Runnable  {
	
	private Bitmap mHourBitmap;	
	
	private boolean bInitComplete = false;
	float Angel = -90.0f;
	Matrix matx = new Matrix();
	Paint paint;
	public Circleview(Context context,AttributeSet attrs) {
		super(context,attrs);
		init();
		new Thread(this).start();
	}
	
	

	public void init(){
		
		
		mHourBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pointer);
		bInitComplete = true;
		
		
	}
	public void setRotate_degree(float degree)
	{
		Angel = degree;
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		matx.reset();
		canvas.drawColor(0x00);
		
		if (!bInitComplete){
			return ;
		}
		matx.setTranslate(mHourBitmap.getHeight(), 200);
		
		
//		matx.preRotate(Angel,mHourBitmap.getWidth()/2,mHourBitmap.getHeight()*4/5);
		matx.preRotate(Angel, mHourBitmap.getWidth() >> 1, mHourBitmap.getHeight() >> 2);
		
		canvas.drawBitmap(mHourBitmap, matx, null);
		
	}
	


	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted())
		{
			      try
			      {
			    	Thread.sleep(300);
			    	Angel+=10;
			     
			      }
			      catch(InterruptedException e)
			      {
			    	  Thread.currentThread().interrupt();
			      }
			      postInvalidate();
		}
		
	}
	
	
	
}