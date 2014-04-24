package com.example.projectmockup.fridge;

import com.example.projectmockup.R;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class FridgeFragment extends Fragment{

	ListView FridgeList;
	Context mContext;
	FridgeAdapter mAdapter;	
    EditText fridgeItemName , fridgeItemQuantity;
		
   
	
	public FridgeFragment(){
			
		
		}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	   
		mContext = getActivity().getApplicationContext();
		mAdapter = new FridgeAdapter(mContext);
		
      View rootView = inflater.inflate(R.layout.fridge_fragment, container, false);
	  FridgeList = (ListView) rootView.findViewById(R.id.FridgeItemsList);
      FridgeList.setAdapter(mAdapter);
        
   Toast.makeText(getActivity().getApplicationContext(), "Its Empty Here..Add Something",Toast.LENGTH_LONG).show();
      
       
         setHasOptionsMenu(true);
       
         
        
	 return rootView;
		
	}

	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		
		inflater.inflate(R.menu.fridge, menu);
		
		super.onCreateOptionsMenu(menu, inflater);
	}



	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == R.id.action_create){
			
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			
			View fridgeItemView = View.inflate(getActivity(), R.layout.fridge_item_dialog_layout, null);
			fridgeItemName = (EditText) fridgeItemView.findViewById(R.id.fridgeItemName);
			
			builder.setTitle("Add an Item");
			builder.setIcon(R.drawable.ic_item);
			builder.setView(fridgeItemView)
			   
			           .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
			             
			        	   @Override
			               public void onClick(DialogInterface dialog, int id) {
			                   
			            	  String name = fridgeItemName.getEditableText().toString();
			        		  Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.recipe);
			        		  FridgeItem item = new FridgeItem(name, mBitmap);
			        		  mAdapter.add(item);
			        		  
			            	   
			               }
			           })
			           .setNegativeButton(R.string.action_cancel, new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int id) {
			                  
			            	  dialog.cancel(); 
			            	   
			               }
			           }).show(); 
			
			
			
		}
		
		return super.onOptionsItemSelected(item);
	}


	
	
	
	
	
	
	
	

}
