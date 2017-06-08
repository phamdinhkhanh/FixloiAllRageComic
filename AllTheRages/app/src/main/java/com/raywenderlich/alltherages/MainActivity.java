package com.raywenderlich.alltherages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.raywenderlich.alltherages.utils.CircleTransform;
import com.raywenderlich.alltherages.utils.FragmentListener;
import com.raywenderlich.alltherages.utils.SharedPref;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,FragmentListener, SearchView.OnQueryTextListener{
  public static String TAG = MainActivity.class.toString();
  ActionBarDrawerToggle toggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setItemIconTintList(null);
    navigationView.setNavigationItemSelectedListener(this);

    View header = navigationView.getHeaderView(0);
    CircleImageView civ_user = (CircleImageView) header.findViewById(R.id.civ_user);
    TextView tv_username = (TextView) header.findViewById(R.id.tv_username);
    TextView tv_email_facebook = (TextView) header.findViewById(R.id.tv_email_facebook);
    TextView tv_mobile = (TextView) header.findViewById(R.id.tv_mobile);

    //Lấy nội dung bắn từ LoginActivity sang
    Intent i = getIntent();
    Log.d(TAG,String.format("Name: %s; User: %s; Url_avatar: %s; Facebook: %s; Email: %s; Phone: %s",i.getStringExtra("name"),i.getStringExtra("user"),
            i.getStringExtra("url_avatar"), i.getStringExtra("facebook"), i.getStringExtra("email"),i.getStringExtra("phone_number")));
    tv_username.setText(i.getStringExtra("name"));

    if(i.getStringExtra("url_avatar") != null){
      Picasso.with(this).load(i.getStringExtra("url_avatar"))
              .transform(new CircleTransform()).into(civ_user);
    }

    tv_email_facebook.setText(i.getStringExtra("email"));
    tv_mobile.setText(i.getStringExtra("phone_number"));

    if (savedInstanceState == null) {
      RageComicListFragment rageComicListFragment = new RageComicListFragment();
      onChangeFragment(rageComicListFragment,false);
    }

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();
    //
    getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
      @Override
      public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
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
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.cart_menu,menu);
    final MenuItem searchItem = menu.findItem(R.id.sv_search);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem menuItem){
    switch (menuItem.getItemId()) {
      case R.id.action_cart: {
        Log.d(TAG, "onOptionsItemSelected: ");
        break;
      }
    }
    return super.onOptionsItemSelected(menuItem);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_person) {
        onChangeFragment(new CustomerFragment(), true);
    } else if (id == R.id.nav_schedule) {
        onChangeFragment(new ScheduleFragment(), true);
    } else if (id == R.id.nav_chat) {
        onChangeFragment(new ChatFragment(), true);
    } else if (id == R.id.nav_phonecall) {
        onChangeFragment(new BuyFragment(), true);
    } else if (id == R.id.nav_favorite) {
        onChangeFragment(new ScheduleFragment(), true);
    } else if (id == R.id.nav_signout){
        finish();
        Intent intent = new Intent(this,LoginActivity.class);
        SharedPref.instance.cleanAll();
        startActivity(intent);
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

  @Override
  public boolean onQueryTextSubmit(String query) {
      return false;
  }

  @Override
  public boolean onQueryTextChange(String newText) {
      return false;
  }

}
