package com.example.projectmockup.fridge;

import com.example.projectmockup.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FridgeItemView extends View{

	    

	private Paint  labelPaint , imagePaint , circlePaint;
    float centerX, centerY;
    Bitmap sourceBitmap, scaledBitmap;
    String foodText;
    private int mProgress;
    
    
    public FridgeItemView(Context context , AttributeSet attrs) {
        super(context , attrs);
        Log.i("Project", "Inside Constructor...");
        
        setFocusable(true);
        setFocusableInTouchMode(true);
        
    
        new Paint(Paint.ANTI_ALIAS_FLAG);
        labelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        imagePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        
       
       
   }
    
    
    
    
    
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = 100;
        int desiredHeight = 100;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

    
        setMeasuredDimension(width, height);
    }
    
    
    
    
    
    

    @Override protected void onDraw(Canvas canvas) {
      
   	 Log.i("Project", "Inside onDraw()...");
	    
	      centerX = getWidth() / 2;
          centerY = getHeight() / 2;
          
          
          
          circlePaint.setStrokeWidth(20);
    	     // canvas.drawLine(getWidth()-20, 30 ,getWidth()-20 ,165 , circlePaint);  Total Height = 135 ..
    	      
    	      if(mProgress >75 && mProgress <= 100){
    	    	 
    	    	circlePaint.setColor(getResources().getColor(android.R.color.holo_green_dark));
    	        canvas.drawLine(getWidth()-20, 20 ,getWidth()-20 ,50 , circlePaint); 
    	        canvas.drawLine(getWidth()-20, 55 ,getWidth()-20 ,85 , circlePaint); 
    	        canvas.drawLine(getWidth()-20, 90 ,getWidth()-20 ,120 , circlePaint); 
    	        canvas.drawLine(getWidth()-20, 125 ,getWidth()-20 ,155 , circlePaint);
    	        
    	      }else if(mProgress >50 && mProgress <= 75){
    	    	  
    	    	circlePaint.setColor(getResources().getColor(android.R.color.holo_orange_light));
    	        canvas.drawLine(getWidth()-20, 55 ,getWidth()-20 ,85 , circlePaint); 
    	        canvas.drawLine(getWidth()-20, 90 ,getWidth()-20 ,120 , circlePaint); 
    	        canvas.drawLine(getWidth()-20, 125 ,getWidth()-20 ,155 , circlePaint);
    	    	  
    	    	  
    	      }else if(mProgress >25 && mProgress <= 50){
    	    	  
    	    
    	    	circlePaint.setColor(Color.YELLOW);
    	        canvas.drawLine(getWidth()-20, 90 ,getWidth()-20 ,120 , circlePaint); 
    	        canvas.drawLine(getWidth()-20, 125 ,getWidth()-20 ,155 , circlePaint);
    	    	  
    	    	  
    	      }else if(mProgress >=0 && mProgress <= 25){
    	    	  
    	    	circlePaint.setColor(getResources().getColor(android.R.color.holo_red_light));
    	        canvas.drawLine(getWidth()-20, 125 ,getWidth()-20 ,155 , circlePaint);
    	    	  
    	    	  
    	    	  
    	      }else{   }

          
    	    
	   
          labelPaint.setColor(getResources().getColor(android.R.color.white));
	      labelPaint.setStrokeWidth(5);       	 
	 
	
	 
	 if(foodText.length() > 13){
		
		 labelPaint.setTextSize(32);
	      
	 }else{
		
		 labelPaint.setTextSize(33);
		 
	 }
	
	  circlePaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
	  //circlePaint.setAlpha(150);
	  circlePaint.setStrokeWidth(10);
	  circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
      canvas.drawCircle(75, 80, 55, circlePaint);
      
    
	  canvas.drawText(foodText,160 ,105 , labelPaint);
      canvas.drawBitmap(scaledBitmap, 25, 30, imagePaint);
       
	 
	 super.onDraw(canvas);
    	 
    }

    
    
    
    public int getProgress(){
    	
    	return mProgress;
    	
     }
    
    
    
    
    public String getFoodText(){
    	
    	return foodText;
    	
    }
    
    
    public Bitmap getFoodImage(){
    	
    	return sourceBitmap;
    	
    }
    
    
    public void setProgress(int health){
    	
    	mProgress = health;
    	invalidate();
    	
    }
    
    
  
    public void setFoodItem(String text , Bitmap SourceBitmap){
    	
    	foodText = text;
    	

    	
    	  if(sourceBitmap ==  null){
            	
            	sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.recipe);
            	
            }
            
            scaledBitmap = getRoundedShape(sourceBitmap);
        	
            invalidate();
    	    	
    	
    }
    
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
    	  // TODO Auto-generated method stub
    	  int targetWidth = 100;
    	  int targetHeight = 100;
    	  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, 
    	                            targetHeight,Bitmap.Config.ARGB_8888);
    	  
    	                Canvas canvas = new Canvas(targetBitmap);
    	  Path path = new Path();
    	  path.addCircle(((float) targetWidth - 1) / 2,
    	  ((float) targetHeight - 1) / 2,
    	  (Math.min(((float) targetWidth), 
    	                ((float) targetHeight)) / 2),
    	          Path.Direction.CCW);
    	  
    	                canvas.clipPath(path);
    	  Bitmap sourceBitmap = scaleBitmapImage;
    	  canvas.drawBitmap(sourceBitmap, 
    	                                new Rect(0, 0, sourceBitmap.getWidth(),
    	    sourceBitmap.getHeight()), 
    	                                new Rect(0, 0, targetWidth,
    	    targetHeight), null);
    	  return targetBitmap;
    	 }


    
    
    
    
 
}
	        
	        

	
	
	

