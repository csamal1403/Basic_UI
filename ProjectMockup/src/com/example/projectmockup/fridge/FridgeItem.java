package com.example.projectmockup.fridge;

import android.graphics.Bitmap;

public class FridgeItem {
	
	private String Name;
	private Bitmap mBitmap;
	private int mProgress;
	
	
	public int getmProgress() {
		return mProgress;
	}



	public void setmProgress(int mProgress) {
		this.mProgress = mProgress;
	}



	public FridgeItem(String name, Bitmap mBitmap) {
		super();
		Name = name;
		this.mBitmap = mBitmap;
		mProgress = 100;
		
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public Bitmap getmBitmap() {
		return mBitmap;
	}



	public void setmBitmap(Bitmap mBitmap) {
		this.mBitmap = mBitmap;
	}
	
	

	
	
	

}
