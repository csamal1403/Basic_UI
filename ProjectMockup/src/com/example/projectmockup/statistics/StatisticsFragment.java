package com.example.projectmockup.statistics;

import com.example.projectmockup.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StatisticsFragment extends Fragment{


		public StatisticsFragment(){
			
			
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
       View rootView = inflater.inflate(R.layout.statistics_fragment, container, false);
		
		
		 return rootView;
		
	}
	
	
	
	

}
