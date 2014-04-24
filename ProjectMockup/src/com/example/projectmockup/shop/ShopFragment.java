package com.example.projectmockup.shop;

import com.example.projectmockup.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShopFragment extends Fragment{


		public ShopFragment(){
			
			
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
       View rootView = inflater.inflate(R.layout.shop_fragment, container, false);
		
		
		 return rootView;
		
	}
	
	
	
	

}
