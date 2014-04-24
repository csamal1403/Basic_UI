package com.example.projectmockup.main;

import java.util.ArrayList;
import java.util.List;

import com.example.projectmockup.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter{

	
private List<NavDrawerItem> mItems = new ArrayList<NavDrawerItem>();
	
	
    private final Context mContext;
   
	public DrawerAdapter(Context context) {
	
		 mContext = context;
		 
		
	}

	
	public void add(NavDrawerItem item) {

		mItems.add(item);
		notifyDataSetChanged();

	}
	
	

	
	@Override
	public int getCount() {
		
		return mItems.size();
	}

	@Override
	public NavDrawerItem getItem(int position) {
		
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		  if(convertView == null){
			   
			    LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    convertView = mInflater.inflate(R.layout.menu_list_item, null, true);
				
			   }
			   
			   
		       NavDrawerItem item = mItems.get(position);
		       Drawable iconImage = item.getImage();
		       String menuName = item.getMenuName();
		       
			   TextView menu = (TextView) convertView.findViewById(R.id.menuItemText);
               menu.setText(menuName);
               menu.setCompoundDrawablesWithIntrinsicBounds(iconImage, null, null, null);
				
			 return convertView;

	
	}

	

}
