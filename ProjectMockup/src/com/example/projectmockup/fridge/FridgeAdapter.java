package com.example.projectmockup.fridge;

import java.util.ArrayList;
import java.util.List;
import com.example.projectmockup.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FridgeAdapter extends BaseAdapter{

	
private List<FridgeItem> mItems = new ArrayList<FridgeItem>();
	
	
    private final Context mContext;
   
	public FridgeAdapter(Context context) {
	
		 mContext = context;
		 
		
	}

	
	public void add(FridgeItem item) {
         
		Log.i("Project", "add() in FridgeAdapter called..");
		mItems.add(item);
		notifyDataSetChanged();
		Log.i("Project", "Added to Adapter..");
		

	}
	
	
	
	
	
	@Override
	public int getCount() {
		
		return mItems.size();
	}

	@Override
	public FridgeItem getItem(int position) {
		
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Log.i("Project", "getView of Adapter is called..");
	
		 FridgeItem item = mItems.get(position);
		
		  if(convertView == null){
			  
			  Log.i("Project", "Inflating FridgeItem Layout..");
			   
			  LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			  convertView = mInflater.inflate(R.layout.fridge_item, null);
		      
			 
			   }
			   
		
		     FridgeItemView view = (FridgeItemView) convertView.findViewById(R.id.customfridgeItem);
		     view.setFoodItem(item.getName(), item.getmBitmap());
		     view.setProgress(item.getmProgress());
		  
		return convertView;

	
	}

}
