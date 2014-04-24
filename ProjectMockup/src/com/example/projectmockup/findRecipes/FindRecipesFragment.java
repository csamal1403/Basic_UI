package com.example.projectmockup.findRecipes;

import com.example.projectmockup.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FindRecipesFragment extends Fragment{


		public FindRecipesFragment(){
			
			
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
       View rootView = inflater.inflate(R.layout.find_recipes_fragment, container, false);
		
		setHasOptionsMenu(true);
       
		 return rootView;
		
	}
	
	
	
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		inflater.inflate(R.menu.find_recipe_menu, menu);
		
		super.onCreateOptionsMenu(menu, inflater);
	}



	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == R.id.action_search){
			
			Intent intent = new Intent(getActivity(), RecipeListActivity.class);
			startActivity(intent);
			
		}
		
		return super.onOptionsItemSelected(item);
	}


	
	
	
	
	
	
	
	
	

}
