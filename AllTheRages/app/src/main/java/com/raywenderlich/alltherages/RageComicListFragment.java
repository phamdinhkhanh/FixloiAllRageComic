package com.raywenderlich.alltherages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raywenderlich.alltherages.adapter.RageComicAdapter;
import com.raywenderlich.alltherages.eventbus.RageComicReturn;
import com.raywenderlich.alltherages.utils.FragmentListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RageComicListFragment extends Fragment {
  private static String TAG = RageComicListFragment.class.toString();
  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;
  private FragmentListener fragmentListener;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_rage_comic_list, container, false);
    EventBus.getDefault().register(this);
    setupUI(view);
    return view;
  }

  public void onDestroy(){
    super.onDestroy();
    EventBus.getDefault().register(this);
  }

  private void setupUI(View view) {
    ButterKnife.bind(this,view);
    RageComicAdapter rageComicAdapter = new RageComicAdapter();
    if (recyclerView == null){
      Log.d(TAG,String.format("recyclerView is null"));
    }
    recyclerView.setAdapter(rageComicAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
  }
  @Subscribe
  public void onChageRageCOmicDetail(RageComicReturn rageComicReturn){
    RageComicDetailsFragment rageComicDetailsFragment = new RageComicDetailsFragment();
    rageComicDetailsFragment.setRageComic(rageComicReturn.getRageComic());
    fragmentListener.onChangeFragment(rageComicDetailsFragment,true);
  }
}
