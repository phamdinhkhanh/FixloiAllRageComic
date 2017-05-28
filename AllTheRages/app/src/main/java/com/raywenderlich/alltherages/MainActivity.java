package com.raywenderlich.alltherages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.raywenderlich.alltherages.utils.FragmentListener;

public class MainActivity extends AppCompatActivity implements FragmentListener {
  public static String TAG = MainActivity.class.toString();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (savedInstanceState == null) {
      RageComicListFragment rageComicListFragment = new RageComicListFragment();
      onChangeFragment(rageComicListFragment,true);
    }
  }

  @Override
  public void onChangeFragment(Fragment fragment, boolean addToBackStack) {
    if(addToBackStack){
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.root_layout, fragment,"rageComicDetails")
              .addToBackStack(null)
              .commit();
    } else {
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.root_layout, fragment,"rageComicDetails")
              .commit();
    }
  }
}
