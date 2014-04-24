package com.example.projectmockup.friends;

import com.example.projectmockup.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendsFragment extends Fragment{


		public FriendsFragment(){
			
			
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
       View rootView = inflater.inflate(R.layout.friends_fragment, container, false);
		
		
		 return rootView;
		
	}
	
	
	
	

}
