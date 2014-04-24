package com.example.projectmockup.main;



import com.example.projectmockup.R;
import com.example.projectmockup.createNewRecipe.CreateNewRecipeFragment;
import com.example.projectmockup.findRecipes.FindRecipesFragment;
import com.example.projectmockup.fridge.FridgeFragment;
import com.example.projectmockup.friends.FriendsFragment;
import com.example.projectmockup.home.HomeFragment;
import com.example.projectmockup.shop.ShopFragment;
import com.example.projectmockup.statistics.StatisticsFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends Activity {

	private int[] drawables = {R.drawable.ic_home, R.drawable.ic_find_recipe, R.drawable.ic_shop,R.drawable.ic_fridge,
			                   R.drawable.ic_create_new_recipe, R.drawable.ic_statistics, R.drawable.ic_action_social_group	};	
	
	private String[] menus = {"Home", "Find Recipes" , "Shop" ,"Fridge" ,"Create New Recipe", "Statistics","Friends" };
	private DrawerLayout menuDrawer;
	private ListView menuDrawerList;
	private ActionBarDrawerToggle menuDrawerToggle;
	DrawerAdapter mAdapter;
	
	public static int currPosition = 0;
	
	
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_potrait);
        
        
        
        initializeDrawer_Adapter();
        
        menuDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        menuDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        menuDrawerList.setAdapter(mAdapter);
        menuDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
        
        menuDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                menuDrawer,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.open,  /* "open drawer" description */
                R.string.close  /* "close drawer" description */
                ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
            	invalidateOptionsMenu();
                
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
            	invalidateOptionsMenu();
                
            }
        };

        // Set the drawer toggle as the DrawerListener
        menuDrawer.setDrawerListener(menuDrawerToggle);
        
        
        if(savedInstanceState == null){
        	
        	FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			Fragment HomeFrag= new HomeFragment();
			ft.replace(R.id.content_frame, HomeFrag);
            ft.commit();
		    menuDrawerList.setItemChecked(0, true);
			getActionBar().setTitle(menus[0]);
        	
        }
        
        
    
    }

    
   
	 
	 private void initializeDrawer_Adapter() {
		
		 
		 mAdapter = new DrawerAdapter(getApplicationContext());
		
		 for(int i = 0 ; i < 7 ; i++){
			 
			 Drawable drawableImage = getResources().getDrawable(drawables[i]);
			 String name = menus[i];
			 NavDrawerItem item = new NavDrawerItem(drawableImage, name);
			 
			 mAdapter.add(item);
			 
			 
			 
		 }
		 
		
	}




	private class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			
			
			FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			
			currPosition = position;
			
			switch(position){
			
			case 0:
				Fragment HomeFrag= new HomeFragment();
				ft.replace(R.id.content_frame, HomeFrag);
				break;
			
			case 1:
				Fragment FindRecipesFrag= new FindRecipesFragment();
				ft.replace(R.id.content_frame,FindRecipesFrag );
				
				break;
			
			case 2:
				Fragment ShopFrag= new ShopFragment();
				ft.replace(R.id.content_frame, ShopFrag);
				
				break;
				
			case 3:
				Fragment FridgeFrag= new FridgeFragment();
				ft.replace(R.id.content_frame, FridgeFrag);
				
				break;
				
			
			case 4:
				Fragment CreateNewRecipeFrag= new CreateNewRecipeFragment();
				ft.replace(R.id.content_frame, CreateNewRecipeFrag);
				break;
				
			case 5:
				Fragment StatisticsFrag= new StatisticsFragment();
				ft.replace(R.id.content_frame, StatisticsFrag);
				break;
				
			case 6:
				Fragment FriendsFrag= new FriendsFragment();
				ft.replace(R.id.content_frame, FriendsFrag);
				break;
				
			
				
			default:
				break;
			
			
			}
		
			ft.commit();
			
			menuDrawerList.setItemChecked(position, true);
			getActionBar().setTitle(menus[position]);
		    menuDrawer.closeDrawer(menuDrawerList);
			
			
		}
	 }
		   
	 
    
	 @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        menuDrawerToggle.syncState();
	    }

	 
	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        menuDrawerToggle.onConfigurationChanged(newConfig);
	    }

	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Pass the event to ActionBarDrawerToggle, if it returns
	        // true, then it has handled the app icon touch event
	        if (menuDrawerToggle.onOptionsItemSelected(item)) {
	          return true;
	        }
	      
	        // Handle action buttons
	       
	            return super.onOptionsItemSelected(item);
	        
	        
	        
	    }

	 


}








