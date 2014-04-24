package com.example.projectmockup.findRecipes;

import com.example.projectmockup.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class RecipeListActivity extends FragmentActivity{
	
	

	@Override
	protected void onCreate(Bundle args) {
		// TODO Auto-generated method stub
		super.onCreate(args);
	
		setContentView(R.layout.recipe_list);
		
	   }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		
		getActionBar().setTitle("Recipes");
		
		return super.onCreateOptionsMenu(menu);
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return super.onOptionsItemSelected(item);
	}

	
	
	

}
