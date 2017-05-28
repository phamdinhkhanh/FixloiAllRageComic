package com.raywenderlich.alltherages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.raywenderlich.alltherages.utils.FragmentListener;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,FragmentListener{
  public static String TAG = MainActivity.class.toString();
  ActionBarDrawerToggle toggle;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      RageComicListFragment rageComicListFragment = new RageComicListFragment();
      onChangeFragment(rageComicListFragment,true);
    }

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    //
    getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
      @Override
      public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
          // set toggle icon arrow
          toggle.setDrawerIndicatorEnabled(false);
          toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24px);
          toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onBackPressed();
            }
          });
        }else{
          toggle.setDrawerIndicatorEnabled(true);
          toggle.setToolbarNavigationClickListener(null);
        }
      }
    });
  ;}

  public boolean onCreateOptionMenu(Menu menu){
    return false;
  }

  public boolean onOptionsItemSelected(MenuItem menuItem){
    return false;
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_camera) {
      // Handle the camera action
    } else if (id == R.id.nav_gallery) {

    } else if (id == R.id.nav_slideshow) {

    } else if (id == R.id.nav_manage) {

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void onChangeFragment(Fragment fragment, boolean addToBackStack) {
    if(addToBackStack){
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.fl_main, fragment,"rageComicDetails")
              .addToBackStack(null)
              .commit();
    } else {
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.fl_main, fragment,"rageComicDetails")
              .commit();
    }
  }
}
