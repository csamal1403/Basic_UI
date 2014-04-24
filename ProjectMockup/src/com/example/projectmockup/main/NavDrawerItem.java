package com.example.projectmockup.main;

import android.graphics.drawable.Drawable;

public class NavDrawerItem {
	
	private Drawable image;
	private String menuName;
	
	
	public NavDrawerItem(Drawable image, String menuName) {
		super();
		this.image = image;
		this.menuName = menuName;
	}


	public Drawable getImage() {
		return image;
	}


	public void setImage(Drawable image) {
		this.image = image;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	
	
	
	

}
