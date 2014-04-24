package com.example.projectmockup.createNewRecipe;

import com.example.projectmockup.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CreateNewRecipeFragment extends Fragment{


		public CreateNewRecipeFragment(){
			
			
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
       View rootView = inflater.inflate(R.layout.create_new_recipe_fragment, container, false);
		
		
		 return rootView;
		
	}
	
	
	
	

}
